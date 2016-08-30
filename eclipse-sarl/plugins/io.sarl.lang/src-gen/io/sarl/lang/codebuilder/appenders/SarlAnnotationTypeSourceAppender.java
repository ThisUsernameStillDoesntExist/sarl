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
package io.sarl.lang.codebuilder.appenders;

import io.sarl.lang.codebuilder.builders.ISarlAnnotationTypeBuilder;
import io.sarl.lang.codebuilder.builders.ISarlClassBuilder;
import io.sarl.lang.codebuilder.builders.ISarlEnumerationBuilder;
import io.sarl.lang.codebuilder.builders.ISarlFieldBuilder;
import io.sarl.lang.codebuilder.builders.ISarlInterfaceBuilder;
import io.sarl.lang.sarl.SarlAnnotationType;
import io.sarl.lang.sarl.SarlScript;
import java.io.IOException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;

/** Source adapter of a Sarl SarlAnnotationType.
 */
@SuppressWarnings("all")
public class SarlAnnotationTypeSourceAppender extends AbstractSourceAppender implements ISarlAnnotationTypeBuilder {

	private final ISarlAnnotationTypeBuilder builder;

	public SarlAnnotationTypeSourceAppender(ISarlAnnotationTypeBuilder builder) {
		this.builder = builder;
	}

	public void build(ISourceAppender appender) throws IOException {
		build(this.builder.getSarlAnnotationType(), appender);
	}

	public IJvmTypeProvider getTypeResolutionContext() {
		return this.builder.getTypeResolutionContext();
	}

	@Override
	@Pure
	public String toString() {
		return this.builder.toString();
	}

	/** Initialize the Ecore element when inside a script.
	 */
	public void eInit(SarlScript script, String name, IJvmTypeProvider context) {
		this.builder.eInit(script, name, context);
	}

	/** Initialize the Ecore element when inner type declaration.
	 */
	public void eInit(XtendTypeDeclaration container, String name, IJvmTypeProvider context) {
		this.builder.eInit(container, name, context);
	}

	/** Replies the generated SarlAnnotationType.
	 */
	@Pure
	public SarlAnnotationType getSarlAnnotationType() {
		return this.builder.getSarlAnnotationType();
	}

	/** Replies the resource to which the SarlAnnotationType is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlAnnotationType().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		this.builder.setDocumentation(doc);
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		this.builder.addModifier(modifier);
	}

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addVarSarlField(String name) {
		return this.builder.addVarSarlField(name);
	}

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addValSarlField(String name) {
		return this.builder.addValSarlField(name);
	}

	/** Create a SarlField.	 *
	 * <p>This function is equivalent to {@link #addVarSarlField}.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addSarlField(String name) {
		return this.builder.addSarlField(name);
	}

	/** Create a SarlClass.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	public ISarlClassBuilder addSarlClass(String name) {
		return this.builder.addSarlClass(name);
	}

	/** Create a SarlInterface.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	public ISarlInterfaceBuilder addSarlInterface(String name) {
		return this.builder.addSarlInterface(name);
	}

	/** Create a SarlEnumeration.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	public ISarlEnumerationBuilder addSarlEnumeration(String name) {
		return this.builder.addSarlEnumeration(name);
	}

	/** Create a SarlAnnotationType.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	public ISarlAnnotationTypeBuilder addSarlAnnotationType(String name) {
		return this.builder.addSarlAnnotationType(name);
	}

}

