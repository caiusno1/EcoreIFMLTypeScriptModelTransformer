package de.kai_biermeier.ba.TypeScriptTransformer;

import java.io.PrintWriter;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class EcoreTypeScriptModelTemplate {
  public void generate(final String path) {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      Map<String, Object> _extensionToFactoryMap = rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("ecore", _xMIResourceFactoryImpl);
      final Resource res = rs.createResource(URI.createFileURI("input/IFML.ecore"));
      res.load(null);
      EObject _get = res.getContents().get(0);
      final EPackage metapackage = ((EPackage) _get);
      EObject _get_1 = res.getContents().get(1);
      final EPackage metapackage2 = ((EPackage) _get_1);
      final PrintWriter p = new PrintWriter((path + "/ifml.ts"));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("export type EInt = number;");
      _builder.newLine();
      _builder.append("export type EString = string;");
      _builder.newLine();
      _builder.append("export type EBoolean = boolean;");
      _builder.newLine();
      {
        EList<EPackage> _eSubpackages = metapackage.getESubpackages();
        for(final EPackage eSubpackage : _eSubpackages) {
          {
            EList<EClassifier> _eClassifiers = eSubpackage.getEClassifiers();
            for(final EClassifier eclass : _eClassifiers) {
              {
                if ((!(eclass instanceof EEnum))) {
                  _builder.append("export interface ");
                  String _name = eclass.getName();
                  _builder.append(_name);
                  _builder.append(" ");
                  {
                    int _length = ((Object[])Conversions.unwrapArray(((EClass) eclass).getESuperTypes(), Object.class)).length;
                    boolean _greaterThan = (_length > 0);
                    if (_greaterThan) {
                      _builder.append("extends ");
                      String _JoinSuperTypeNames = this.JoinSuperTypeNames(((EClass) eclass).getESuperTypes());
                      _builder.append(_JoinSuperTypeNames);
                      _builder.append(" ");
                    }
                  }
                  _builder.append("{");
                  _builder.newLineIfNotEmpty();
                  {
                    EList<EObject> _eContents = eclass.eContents();
                    for(final EObject eAttribute : _eContents) {
                      {
                        if ((eAttribute instanceof EStructuralFeature)) {
                          _builder.append("\t");
                          String _name_1 = ((EStructuralFeature) eAttribute).getName();
                          _builder.append(_name_1, "\t");
                          _builder.append(": ");
                          String _name_2 = ((EStructuralFeature) eAttribute).getEType().getName();
                          _builder.append(_name_2, "\t");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              {
                if ((eclass instanceof EEnum)) {
                  _builder.append("export enum ");
                  String _name_3 = ((EEnum)eclass).getName();
                  _builder.append(_name_3);
                  _builder.append(" {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _join = IterableExtensions.join(((EEnum) eclass).getELiterals(), ", ");
                  _builder.append(_join, "\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      {
        EList<EClassifier> _eClassifiers_1 = metapackage2.getEClassifiers();
        for(final EClassifier eclass_1 : _eClassifiers_1) {
          {
            if ((!(eclass_1 instanceof EEnum))) {
              _builder.append("export interface ");
              String _name_4 = eclass_1.getName();
              _builder.append(_name_4);
              _builder.append(" ");
              {
                int _length_1 = ((Object[])Conversions.unwrapArray(((EClass) eclass_1).getESuperTypes(), Object.class)).length;
                boolean _greaterThan_1 = (_length_1 > 0);
                if (_greaterThan_1) {
                  _builder.append("extends ");
                  String _JoinSuperTypeNames_1 = this.JoinSuperTypeNames(((EClass) eclass_1).getESuperTypes());
                  _builder.append(_JoinSuperTypeNames_1);
                  _builder.append(" ");
                }
              }
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              {
                EList<EObject> _eContents_1 = eclass_1.eContents();
                for(final EObject eAttribute_1 : _eContents_1) {
                  {
                    if ((eAttribute_1 instanceof EStructuralFeature)) {
                      _builder.append("\t");
                      String _name_5 = ((EStructuralFeature) eAttribute_1).getName();
                      _builder.append(_name_5, "\t");
                      _builder.append(": ");
                      String _name_6 = ((EStructuralFeature) eAttribute_1).getEType().getName();
                      _builder.append(_name_6, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder.append("}");
              _builder.newLine();
            }
          }
          {
            if ((eclass_1 instanceof EEnum)) {
              _builder.append("export enum ");
              String _name_7 = ((EEnum)eclass_1).getName();
              _builder.append(_name_7);
              _builder.append(" {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              String _join_1 = IterableExtensions.join(((EEnum) eclass_1).getELiterals(), ", ");
              _builder.append(_join_1, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      p.print(_builder);
      p.flush();
      p.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String JoinSuperTypeNames(final EList<EClass> supertypes) {
    final Function1<EClass, String> _function = (EClass t) -> {
      return t.getName();
    };
    return IterableExtensions.join(ListExtensions.<EClass, String>map(supertypes, _function), ", ");
  }
}
