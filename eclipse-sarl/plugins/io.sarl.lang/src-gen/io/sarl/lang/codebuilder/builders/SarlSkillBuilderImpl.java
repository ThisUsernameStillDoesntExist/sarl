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

import io.sarl.lang.core.Skill;
import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.lang.sarl.SarlSkill;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlSkill.
 */
@SuppressWarnings("all")
public class SarlSkillBuilderImpl extends AbstractBuilder implements ISarlSkillBuilder {

	private SarlSkill sarlSkill;

	/** Initialize the Ecore element when inside a script.
	 */
	public void eInit(SarlScript script, String name) {
		if (this.sarlSkill == null) {
			this.sarlSkill = SarlFactory.eINSTANCE.createSarlSkill();
			script.getXtendTypes().add(this.sarlSkill);
			this.sarlSkill.setAnnotationInfo(XtendFactory.eINSTANCE.createXtendTypeDeclaration());
			if (!Strings.isEmpty(name)) {
				this.sarlSkill.setName(name);
			}
		}
	}

	/** Replies the generated SarlSkill.
	 */
	@Pure
	public SarlSkill getSarlSkill() {
		return this.sarlSkill;
	}

	/** Replies the resource to which the SarlSkill is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlSkill().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlSkill().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlSkill(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlSkill().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Change the super type.
	 * @param superType - the qualified name of the super type,
	 *     or <code>null</code> if the default type.
	 */
	public void setExtends(String superType) {
		if (!Strings.isEmpty(superType)
				&& !Skill.class.getName().equals(superType)) {
			JvmParameterizedTypeReference superTypeRef = newTypeRef(this.sarlSkill, superType);
			JvmTypeReference baseTypeRef = newTypeRef(this.sarlSkill, Skill.class);
			if (isSubTypeOf(this.sarlSkill, superTypeRef, baseTypeRef)) {
				this.sarlSkill.setExtends(superTypeRef);
				return;
			}
		}
		this.sarlSkill.setExtends(null);
	}

	/** Add an implemented type.
	 * @param type - the qualified name of the implemented type.
	 */
	public void addImplements(String type) {
		if (!Strings.isEmpty(type)) {
			this.sarlSkill.getImplements().add(newTypeRef(this.sarlSkill, type));
		}
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			this.sarlSkill.getModifiers().add(modifier);
		}
	}

	@Inject
	private Provider<ISarlConstructorBuilder> iSarlConstructorBuilderProvider;

	/** Create a SarlConstructor.
	 * @return the builder.
	 */
	public ISarlConstructorBuilder addSarlConstructor() {
		ISarlConstructorBuilder builder = this.iSarlConstructorBuilderProvider.get();
		builder.eInit(getSarlSkill());
		return builder;
	}

	@Inject
	private Provider<ISarlBehaviorUnitBuilder> iSarlBehaviorUnitBuilderProvider;

	/** Create a SarlBehaviorUnit.
	 * @param name - the typename of the SarlBehaviorUnit.
	 * @return the builder.
	 */
	public ISarlBehaviorUnitBuilder addSarlBehaviorUnit(String name) {
		ISarlBehaviorUnitBuilder builder = this.iSarlBehaviorUnitBuilderProvider.get();
		builder.eInit(getSarlSkill(), name);
		return builder;
	}

	@Inject
	private Provider<ISarlFieldBuilder> iSarlFieldBuilderProvider;

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addVarSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlSkill(), name, "var");
		return builder;
	}

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addValSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlSkill(), name, "val");
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
		builder.eInit(getSarlSkill(), name);
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
		builder.eInit(getSarlSkill(), name);
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
		builder.eInit(getSarlSkill(), name);
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
		builder.eInit(getSarlSkill(), name);
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
		builder.eInit(getSarlSkill(), name);
		return builder;
	}

}

