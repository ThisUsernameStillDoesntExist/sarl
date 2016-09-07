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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl XExpression.
 */
@SuppressWarnings("all")
public interface IExpressionBuilder {

	/** Replies the context for type resolution.
	 * @return the context or <code>null</code> if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Initialize the expression.
	 * @param context - the context of the expressions.
	 * @param setter - the object that permits to assign the expression to the context.
	 */
	void eInit(EObject context, Procedure1<XExpression> setter, IJvmTypeProvider typeContext);

	/** Replies the last created expression.
	 *
	 * @return the last created expression.
	 */
	@Pure
	XExpression getXExpression();

	/** Replies the resource to which the XExpression is attached.
	 */
	@Pure
	Resource eResource();

	/** Change the expression in the container.
	 *
	 * @param expression - the textual representation of the expression.
	 */
	void setExpression(String expression);

	/** Change the expression in the container.
	 *
	 * @param expression - the expression.
	 */
	void setXExpression(XExpression expression);


	/** Replies the XExpression for the default value associated to the given type.
	 * @param type - the type for which the default value should be determined.
	 * @return the default value.
	 */
	@Pure
	XExpression getDefaultXExpressionForType(String type);

	/** Replies the default value for the given type.
	 * @param type - the type for which the default value should be determined.
	 * @return the default value.
	 */
	@Pure
	String getDefaultValueForType(String type);

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	void setDocumentation(String doc);

	/** Create a reference to "this" object or to the current type.
	 *
	 * @return the reference.
	 */
	XFeatureCall createReferenceToThis();

	/** Create a reference to "super" object or to the super type.
	 *
	 * @return the reference.
	 */
	XFeatureCall createReferenceToSuper();

	/** Dispose the resource.
	 */
	void dispose();

}

