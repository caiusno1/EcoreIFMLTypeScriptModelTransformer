export type EInt = number;
export type EString = string;
export type EBoolean = boolean;
export interface Form extends ViewComponent {
	submitEvent: SubmitEvent;
}
export interface Field extends ViewComponentPart {
}
export interface SelectionField extends Field {
	isMultiSelection: EBoolean;
}
export interface ValidationRule extends Constraint {
}
export interface Slot extends ViewComponentPart {
	parameter: Parameter;
}
export interface SortAttribute {
	order: SortOrderEnum;
}
export interface SelectEvent extends ViewElementEvent {
}
export interface List extends ViewComponent {
	selectEvent: SelectEvent;
	submitEvent: SubmitEvent;
}
export interface SimpleField extends Field {
}
export interface SubmitEvent extends ViewElementEvent {
}
export interface Selector extends Expression, ViewComponentPart {
}
export enum SortOrderEnum {
	ascending, descending
}
export interface Device extends ContextDimension {
}
export interface Position extends ContextDimension {
}
export interface UserRole extends ContextDimension {
}
export interface Details extends ViewComponent {
}
export interface Window extends ViewContainer {
	isXor: EBoolean;
	isModal: EBoolean;
	isNew: EBoolean;
}
export interface ViewPoint extends NamedElement {
	interactionFlowModelElements: InteractionFlowModelElement;
	context: Context;
}
export interface InteractionFlowElement extends NamedElement, InteractionFlowModelElement, TemplaetableElement {
	parameters: Parameter;
	inInteractionFlows: InteractionFlow;
	outInteractionFlows: InteractionFlow;
}
export interface NavigationFlow extends InteractionFlow {
	dataFlows: DataFlow;
}
export interface ActionEvent extends Event {
}
export interface InteractionFlowModel extends NamedElement {
	interactionFlowModelElements: InteractionFlowModelElement;
}
export interface ParameterBindingGroup extends InteractionFlowModelElement {
	parameterBindings: ParameterBinding;
}
export interface ParameterBinding extends InteractionFlowModelElement {
	sourceParameter: Parameter;
	targetParameter: Parameter;
}
export interface ContentModel extends NamedElement {
	elements: Element;
}
export interface ViewElement extends InteractionFlowElement {
	viewElementEvents: ViewElementEvent;
	activationExpression: ActivationExpression;
	viewContainer: ViewContainer;
}
export interface Action extends InteractionFlowElement {
	actionEvents: ActionEvent;
	dynamicBehavior: DynamicBehavior;
}
export interface Element {
	id: EString;
	constraints: Constraint;
	annotations: Annotation;
}
export interface DynamicBehavior extends ContentBinding {
	behavioralFeature: BehavioralFeature;
	behavior: Behavior;
}
export interface DataFlow extends InteractionFlow {
}
export interface InteractionFlow extends InteractionFlowModelElement {
	srcInteractionFlowElement: InteractionFlowElement;
	trgtInteractionFlowElement: InteractionFlowElement;
	parameterBindingGroup: ParameterBindingGroup;
}
export interface ViewElementEvent extends Event {
}
export interface InteractionFlowModelElement extends Element {
}
export interface NamedElement extends Element {
	name: EString;
}
export interface ExternalEvent extends Event {
}
export interface Constraint extends BooleanExpression {
}
export interface ViewComponentPart extends InteractionFlowElement {
	viewElementEvents: ViewElementEvent;
	activationExpression: ActivationExpression;
	subViewComponentParts: ViewComponentPart;
	parentViewComponentPart: ViewComponentPart;
}
export interface ViewContainer extends ViewElement {
	isLandMark: EBoolean;
	isDefault: EBoolean;
	viewElements: ViewElement;
}
export interface IFMLModel extends NamedElement {
	interactionFlowModel: InteractionFlowModel;
	contentModel: ContentModel;
	interactionFlowModelViewPoints: ViewPoint;
}
export interface Event extends InteractionFlowElement {
	activationExpression: ActivationExpression;
	navigationFlows: NavigationFlow;
	interactionFlowExpression: InteractionFlowExpression;
}
export interface ContentBinding extends ViewComponentPart {
	uniformResourceIdentifier: EString;
}
export interface InteractionFlowExpression extends Expression {
	interactionFlows: InteractionFlow;
}
export interface DataBinding extends ContentBinding {
	conditionalExpression: ConditionalExpression;
	visualizationAttributes: VisualizationAttribute;
	classifier: Classifier;
}
export interface ViewComponent extends ViewElement {
	viewComponentParts: ViewComponentPart;
}
export interface SystemEvent extends Event {
	triggeringExpressions: Expression;
	type: SystemEventTypeEnum;
}
export interface BooleanExpression extends Expression {
}
export interface ActivationExpression extends BooleanExpression {
}
export interface Expression extends InteractionFlowModelElement {
	language: EString;
	body: EString;
}
export interface Parameter extends InteractionFlowModelElement, MultiplicityElement, TypedElement, NamedElement {
	kind: ParameterKind;
}
export enum SystemEventTypeEnum {
	time, specialCondition
}
export interface ConditionalExpression extends Expression, ViewComponentPart {
}
export interface Context extends Element {
	contextDimensions: ContextDimension;
}
export interface ContextDimension extends NamedElement {
}
export interface VisualizationAttribute extends ViewComponentPart {
	structuralFeature: StructuralFeature;
}
export enum ParameterKind {
	ordinary, input, output, input_output
}
export interface Module extends InteractionFlowModelElement {
	inputPorts: Port;
	outputPorts: Port;
	interactionFlowModelElements: InteractionFlowModelElement;
}
export interface Port extends InteractionFlowElement {
}
export interface Annotation {
	text: EString;
}
export interface Association extends Element {
}
export interface Classifier extends Element {
}
export interface Element {
}
export interface BehavioralFeature {
}
export interface Behavior {
}
export interface TemplaetableElement extends Element {
}
export interface TypedElement extends Element {
}
export interface MultiplicityElement extends Element {
}
export interface StructuralFeature {
}
