package de.kai_biermeier.ba.TypeScriptTransformer

import java.io.PrintWriter
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

class EcoreTypeScriptModelTemplate {
	def generate(String path){
		val rs = new ResourceSetImpl();
	    // the usual file extension registration
	    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
	    // we then create the URI (note that creating the resource does
	    // not mean it's overwritten or anything). 
	    val res = rs.createResource( URI.createFileURI( "input/IFML.ecore" ));
	    // finally, we load the resource.
	    res.load(null);
	    val metapackage = res.getContents().get(0) as EPackage;
	    val metapackage2 = res.getContents().get(1) as EPackage;
	    val p = new PrintWriter(path+"/ifml.ts");
	    p.print(
		'''
			export type EInt = number;
			export type EString = string;
			export type EBoolean = boolean;
			«FOR eSubpackage: metapackage.ESubpackages»
				«FOR eclass : eSubpackage.EClassifiers» 
					«IF !(eclass instanceof EEnum)»
					export interface «eclass.name» «IF (eclass as EClass).ESuperTypes.length>0»extends «JoinSuperTypeNames((eclass as EClass).ESuperTypes)» «ENDIF»{
						«FOR eAttribute: eclass.eContents»
							«IF eAttribute instanceof EStructuralFeature»
							«(eAttribute as EStructuralFeature).name»: «(eAttribute as EStructuralFeature).EType.name»;
							«ENDIF»
						«ENDFOR»
					}
					«ENDIF»
					«IF (eclass instanceof EEnum)»
					export enum «eclass.name» {
						«(eclass as EEnum).ELiterals.join(", ")»
					}
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			«FOR eclass : metapackage2.EClassifiers» 
				«IF !(eclass instanceof EEnum)»
				export interface «eclass.name» «IF (eclass as EClass).ESuperTypes.length>0»extends «JoinSuperTypeNames((eclass as EClass).ESuperTypes)» «ENDIF»{
					«FOR eAttribute: eclass.eContents»
						«IF eAttribute instanceof EStructuralFeature»
						«(eAttribute as EStructuralFeature).name»: «(eAttribute as EStructuralFeature).EType.name»;
						«ENDIF»
					«ENDFOR»
				}
				«ENDIF»
				«IF (eclass instanceof EEnum)»
				export enum «eclass.name» {
					«(eclass as EEnum).ELiterals.join(", ")»
				}
				«ENDIF»
			«ENDFOR»
		'''	
		)
		p.flush();
		p.close();	
	}
	def JoinSuperTypeNames(EList<EClass> supertypes){
		return supertypes.map[ t | return t.name].join(", ");
	}
}