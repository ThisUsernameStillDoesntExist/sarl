/*
 * Copyright 2014-2015 Sebastian RODRIGUEZ, Nicolas GAUD, Stéphane GALLAND.
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
package io.sarl.lang.tests.bugs.to00399;

import static io.sarl.tests.api.AbstractSarlTest.assertContains;
import static io.sarl.tests.api.AbstractSarlTest.multilineString;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.sarl.lang.SARLVersion;
import io.sarl.lang.sarl.SarlPackage;
import io.sarl.lang.sarl.SarlScript;
import io.sarl.lang.sarl.actionprototype.ActionPrototype;
import io.sarl.tests.api.AbstractSarlTest;

/** Test for the issue: Obtain agent ID from space.
 *
 * @author $Author: sgalland$
 * @version $Name$ $Revision$ $Date$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @see "https://github.com/sarl/sarl/issues/291"
 */
@SuppressWarnings("all")
public class Bug291 extends AbstractSarlTest {

	private static final String SOURCE_01 = multilineString(
			"package io.sarl.lang.tests.bug291",
			"capacity C1 {",
			"  def myfct : int",
			"}",
			"skill S1 implements C1 {",
			"  def myfct : int {",
			"    if (caller === null) {",
			"    }",
			"    return 0",
			"  }",
			"}");
	
	private static final String EXPECTED_01 = multilineString(
			"package io.sarl.lang.tests.bug291;",
			"",
			"import io.sarl.lang.annotation.SarlElementType;",
			"import io.sarl.lang.annotation.SarlSpecification;",
			"import io.sarl.lang.annotation.SyntheticMember;",
			"import io.sarl.lang.core.Agent;",
			"import io.sarl.lang.core.AgentTrait;",
			"import io.sarl.lang.core.Capacities;",
			"import io.sarl.lang.core.Skill;",
			"import io.sarl.lang.tests.bug291.C1;",
			"",
			"@SarlSpecification(\"" + SARLVersion.SPECIFICATION_RELEASE_VERSION_STRING + "\")",
			"@SarlElementType(" + SarlPackage.SARL_SKILL + ")",
			"@SuppressWarnings(\"all\")",
			"public class S1 extends Skill implements C1 {",
			"  public int myfct() {",
			"    AgentTrait _caller = Capacities.getCaller();",
			"    boolean _tripleEquals = (_caller == null);",
			"    if (_tripleEquals) {",
			"    }",
			"    return 0;",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public S1() {",
			"    super();",
			"  }",
			"  ",
			"  @SyntheticMember",
			"  public S1(final Agent arg0) {",
			"    super(arg0);",
			"  }",
			"}",
			"");

	@Inject
	private CompilationTestHelper compiler;

	@Test
	public void testParser() throws Exception {
		SarlScript script = file(SOURCE_01);
		validate(script).assertNoIssues();
	}

	@Test
	public void testCompiler() throws Exception {
		this.compiler.compile(SOURCE_01, (r) -> {
			assertEquals(EXPECTED_01, r.getGeneratedCode("io.sarl.lang.tests.bug291.S1"));
		});
	}

}
