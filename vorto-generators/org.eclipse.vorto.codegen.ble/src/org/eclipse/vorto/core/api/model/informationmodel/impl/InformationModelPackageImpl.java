/**
 */
package org.eclipse.vorto.core.api.model.informationmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.vorto.codegen.ble.model.blegatt.impl.ModelPackageImpl;

import org.eclipse.vorto.core.api.model.datatype.DatatypePackage;

import org.eclipse.vorto.core.api.model.functionblock.FunctionblockPackage;

import org.eclipse.vorto.core.api.model.informationmodel.FunctionblockProperty;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModelFactory;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModelPackage;

import org.eclipse.vorto.core.api.model.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InformationModelPackageImpl extends EPackageImpl implements InformationModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionblockPropertyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.vorto.core.api.model.informationmodel.InformationModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InformationModelPackageImpl() {
		super(eNS_URI, InformationModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link InformationModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InformationModelPackage init() {
		if (isInited) return (InformationModelPackage)EPackage.Registry.INSTANCE.getEPackage(InformationModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredInformationModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		InformationModelPackageImpl theInformationModelPackage = registeredInformationModelPackage instanceof InformationModelPackageImpl ? (InformationModelPackageImpl)registeredInformationModelPackage : new InformationModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DatatypePackage.eINSTANCE.eClass();
		FunctionblockPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(org.eclipse.vorto.codegen.ble.model.blegatt.ModelPackage.eNS_URI);
		ModelPackageImpl theModelPackage_1 = (ModelPackageImpl)(registeredPackage instanceof ModelPackageImpl ? registeredPackage : org.eclipse.vorto.codegen.ble.model.blegatt.ModelPackage.eINSTANCE);

		// Create package meta-data objects
		theInformationModelPackage.createPackageContents();
		theModelPackage_1.createPackageContents();

		// Initialize created meta-data
		theInformationModelPackage.initializePackageContents();
		theModelPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInformationModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InformationModelPackage.eNS_URI, theInformationModelPackage);
		return theInformationModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInformationModel() {
		return informationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInformationModel_Properties() {
		return (EReference)informationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionblockProperty() {
		return functionblockPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionblockProperty_Name() {
		return (EAttribute)functionblockPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionblockProperty_Description() {
		return (EAttribute)functionblockPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionblockProperty_Type() {
		return (EReference)functionblockPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionblockProperty_Presence() {
		return (EReference)functionblockPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionblockProperty_Multiplicity() {
		return (EAttribute)functionblockPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionblockProperty_ExtendedFunctionBlock() {
		return (EReference)functionblockPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InformationModelFactory getInformationModelFactory() {
		return (InformationModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		informationModelEClass = createEClass(INFORMATION_MODEL);
		createEReference(informationModelEClass, INFORMATION_MODEL__PROPERTIES);

		functionblockPropertyEClass = createEClass(FUNCTIONBLOCK_PROPERTY);
		createEAttribute(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__NAME);
		createEAttribute(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__DESCRIPTION);
		createEReference(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__TYPE);
		createEReference(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__PRESENCE);
		createEAttribute(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__MULTIPLICITY);
		createEReference(functionblockPropertyEClass, FUNCTIONBLOCK_PROPERTY__EXTENDED_FUNCTION_BLOCK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		FunctionblockPackage theFunctionblockPackage = (FunctionblockPackage)EPackage.Registry.INSTANCE.getEPackage(FunctionblockPackage.eNS_URI);
		DatatypePackage theDatatypePackage = (DatatypePackage)EPackage.Registry.INSTANCE.getEPackage(DatatypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		informationModelEClass.getESuperTypes().add(theModelPackage.getModel());

		// Initialize classes, features, and operations; add parameters
		initEClass(informationModelEClass, InformationModel.class, "InformationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInformationModel_Properties(), this.getFunctionblockProperty(), null, "properties", null, 0, -1, InformationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionblockPropertyEClass, FunctionblockProperty.class, "FunctionblockProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionblockProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionblockProperty_Description(), ecorePackage.getEString(), "description", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionblockProperty_Type(), theFunctionblockPackage.getFunctionblockModel(), null, "type", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionblockProperty_Presence(), theDatatypePackage.getPresence(), null, "presence", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionblockProperty_Multiplicity(), ecorePackage.getEBoolean(), "multiplicity", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionblockProperty_ExtendedFunctionBlock(), theFunctionblockPackage.getFunctionBlock(), null, "extendedFunctionBlock", null, 0, 1, FunctionblockProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InformationModelPackageImpl
