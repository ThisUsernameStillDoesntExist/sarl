/*
 * $Id$
 *
 * SARL is an general-purpose event programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2018 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.ui.tests.outline;

import org.junit.Test;

/** Test the outline of the "event" statement.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class EventOutlineTest extends AbstractSARLOutlineTreeProviderTest {

	/**
	 * @throws Exception
	 */
	@Test
	public void empty() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 {}"); //$NON-NLS-1$
		asserts.numChildren(1);
		asserts.leaf(0, "E1"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test1Attribute() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 { var attr : boolean }"); //$NON-NLS-1$
		asserts.numChildren(1);
		asserts.child(0, "E1") //$NON-NLS-1$
			.leaf(0, "attr : boolean"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test2Attributes() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 { val xyz : float var attr : boolean }"); //$NON-NLS-1$
		asserts.numChildren(1);
		OutlineAsserts a;
		a = asserts.child(0, "E1"); //$NON-NLS-1$
		a.numChildren(2);
		a.leaf(0, "attr : boolean"); //$NON-NLS-1$
		a.leaf(1, "xyz : float"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test1Constructor_0() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 { new {} }"); //$NON-NLS-1$
		asserts.numChildren(1);
		OutlineAsserts a;
		a = asserts.child(0, "E1"); //$NON-NLS-1$
		a.numChildren(1);
		a.leaf(0, "new()"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test1Constructor_1() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 { new(a : float) {} }"); //$NON-NLS-1$
		asserts.numChildren(1);
		OutlineAsserts a;
		a = asserts.child(0, "E1"); //$NON-NLS-1$
		a.numChildren(1);
		a.leaf(0, "new(float)"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test2Constructors() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 { new {} new(z : float) {} }"); //$NON-NLS-1$
		asserts.numChildren(1);
		OutlineAsserts a;
		a = asserts.child(0, "E1"); //$NON-NLS-1$
		a.numChildren(2);
		a.leaf(0, "new()"); //$NON-NLS-1$
		a.leaf(1, "new(float)"); //$NON-NLS-1$
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testMany() throws Exception {
		OutlineAsserts asserts = newOutlineAsserts(
				"event E1 {\n" //$NON-NLS-1$
				+ "val attr : boolean\n" //$NON-NLS-1$
				+ "new(a : char) {}\n" //$NON-NLS-1$
				+ "val xyz = 5\n" //$NON-NLS-1$
				+ "new(z:int) {}\n" //$NON-NLS-1$
				+ "}"); //$NON-NLS-1$
		asserts.numChildren(1);
		OutlineAsserts a;
		a = asserts.child(0, "E1"); //$NON-NLS-1$
		a.numChildren(4);
		a.leaf(0, "attr : boolean"); //$NON-NLS-1$
		a.leaf(1, "xyz : int"); //$NON-NLS-1$
		a.leaf(2, "new(char)"); //$NON-NLS-1$
		a.leaf(3, "new(int)"); //$NON-NLS-1$
	}

}
