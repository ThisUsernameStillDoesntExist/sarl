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

import io.sarl.lang.sarl.SarlScript;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of Sarl scripts.
 *
 * <p>This builder is provided for helping to create Sarl Ecore elements.
 *
 * <p>Do not forget to invoke {@link #finalizeScript()} for creating imports, etc.
 */
@SuppressWarnings("all")
public interface IScriptBuilder {

	/** Replies the context for type resolution.
	 * @return the context or <code>null</code> if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Create the internal Sarl script.
	 */
	void eInit(Resource resource, String packageName, IJvmTypeProvider context);

	/** Replies the Sarl script.
	 */
	@Pure
	SarlScript getScript();

	/** Replies the resource to which the script is attached.
	 */
	@Pure
	Resource eResource();

	/** Finalize the script.
	 *
	 * <p>The finalization includes: <ul>
	 * <li>The import section is created.</li>
	 * </ul>
	 */
	void finalizeScript();

	/** Replies if the script was finalized.
	 */
	boolean isFinalized();

	/** Create a SarlEvent builder.
	 * @param name - the name of the SarlEvent.
	 * @return the builder.
	 */
	ISarlEventBuilder addSarlEvent(String name);

	/** Create a SarlCapacity builder.
	 * @param name - the name of the SarlCapacity.
	 * @return the builder.
	 */
	ISarlCapacityBuilder addSarlCapacity(String name);

	/** Create a SarlAgent builder.
	 * @param name - the name of the SarlAgent.
	 * @return the builder.
	 */
	ISarlAgentBuilder addSarlAgent(String name);

	/** Create a SarlBehavior builder.
	 * @param name - the name of the SarlBehavior.
	 * @return the builder.
	 */
	ISarlBehaviorBuilder addSarlBehavior(String name);

	/** Create a SarlSkill builder.
	 * @param name - the name of the SarlSkill.
	 * @return the builder.
	 */
	ISarlSkillBuilder addSarlSkill(String name);

	/** Create a SarlSpace builder.
	 * @param name - the name of the SarlSpace.
	 * @return the builder.
	 */
	ISarlSpaceBuilder addSarlSpace(String name);

	/** Create a SarlClass builder.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	ISarlClassBuilder addSarlClass(String name);

	/** Create a SarlInterface builder.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	ISarlInterfaceBuilder addSarlInterface(String name);

	/** Create a SarlEnumeration builder.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	ISarlEnumerationBuilder addSarlEnumeration(String name);

	/** Create a SarlAnnotationType builder.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	ISarlAnnotationTypeBuilder addSarlAnnotationType(String name);

}

