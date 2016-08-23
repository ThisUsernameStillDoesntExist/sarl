/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright 2014-2016 the original authors and authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.codebuilder.builders;

import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.sarl.SarlInterface;
import io.sarl.lang.sarl.SarlScript;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlInterface.
 */
@SuppressWarnings("all")
public class SarlInterfaceBuilderImpl extends AbstractBuilder implements ISarlInterfaceBuilder {

	private SarlInterface sarlInterface;

	private EObject container;

	/** Initialize the Ecore element when inside a script.
	 */
	public void eInit(SarlScript script, String name) {
		if (this.sarlInterface == null) {
			this.container = script;
			this.sarlInterface = SarlFactory.eINSTANCE.createSarlInterface();
			script.getXtendTypes().add(this.sarlInterface);
			this.sarlInterface.setAnnotationInfo(XtendFactory.eINSTANCE.createXtendTypeDeclaration());
			if (!Strings.isEmpty(name)) {
				this.sarlInterface.setName(name);
			}
		}
	}

	/** Initialize the Ecore element when inner type declaration.
	 */
	public void eInit(XtendTypeDeclaration container, String name) {
		if (this.sarlInterface == null) {
			this.container = container;
			this.sarlInterface = SarlFactory.eINSTANCE.createSarlInterface();
			container.getMembers().add(this.sarlInterface);
			if (!Strings.isEmpty(name)) {
				this.sarlInterface.setName(name);
			}
		}
	}

	/** Replies the generated SarlInterface.
	 */
	@Pure
	public SarlInterface getSarlInterface() {
		return this.sarlInterface;
	}

	/** Replies the resource to which the SarlInterface is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlInterface().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlInterface().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlInterface(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlInterface().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Add the super type.
	 * @param superType - the qualified name of the super type.
	 */
	public void addExtends(String superType) {
		if (!Strings.isEmpty(superType)) {
			JvmParameterizedTypeReference superTypeRef = newTypeRef(this.container, superType);
			this.sarlInterface.getExtends().add(superTypeRef);
		}
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			this.sarlInterface.getModifiers().add(modifier);
		}
	}

	@Inject
	private Provider<ISarlFieldBuilder> iSarlFieldBuilderProvider;

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addVarSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlInterface(), name, "var");
		return builder;
	}

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addValSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlInterface(), name, "val");
		return builder;
	}

	/** Create a SarlField.	 *
	 * <p>This function is equivalent to {@link #addVarSarlField}.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addSarlField(String name) {
		return this.addVarSarlField(name);
	}

	@Inject
	private Provider<ISarlActionBuilder> iSarlActionBuilderProvider;

	/** Create a SarlAction.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	public ISarlActionBuilder addSarlAction(String name) {
		ISarlActionBuilder builder = this.iSarlActionBuilderProvider.get();
		builder.eInit(getSarlInterface(), name);
		return builder;
	}

	@Inject
	private Provider<ISarlClassBuilder> iSarlClassBuilderProvider;

	/** Create a SarlClass.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	public ISarlClassBuilder addSarlClass(String name) {
		ISarlClassBuilder builder = this.iSarlClassBuilderProvider.get();
		builder.eInit(getSarlInterface(), name);
		return builder;
	}

	@Inject
	private Provider<ISarlInterfaceBuilder> iSarlInterfaceBuilderProvider;

	/** Create a SarlInterface.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	public ISarlInterfaceBuilder addSarlInterface(String name) {
		ISarlInterfaceBuilder builder = this.iSarlInterfaceBuilderProvider.get();
		builder.eInit(getSarlInterface(), name);
		return builder;
	}

	@Inject
	private Provider<ISarlEnumerationBuilder> iSarlEnumerationBuilderProvider;

	/** Create a SarlEnumeration.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	public ISarlEnumerationBuilder addSarlEnumeration(String name) {
		ISarlEnumerationBuilder builder = this.iSarlEnumerationBuilderProvider.get();
		builder.eInit(getSarlInterface(), name);
		return builder;
	}

	@Inject
	private Provider<ISarlAnnotationTypeBuilder> iSarlAnnotationTypeBuilderProvider;

	/** Create a SarlAnnotationType.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	public ISarlAnnotationTypeBuilder addSarlAnnotationType(String name) {
		ISarlAnnotationTypeBuilder builder = this.iSarlAnnotationTypeBuilderProvider.get();
		builder.eInit(getSarlInterface(), name);
		return builder;
	}

}

