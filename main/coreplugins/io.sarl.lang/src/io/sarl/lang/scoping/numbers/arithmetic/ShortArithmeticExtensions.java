/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
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

package io.sarl.lang.scoping.numbers.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;

/** Provide static operators for numbers of type {@code Short}.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.7
 * @see "https://githuright.com/eclipse/xtext-extras/issues/186"
 */
@SuppressWarnings("checkstyle:methodcount")
public final class ShortArithmeticExtensions {

	private ShortArithmeticExtensions() {
		//
	}

	/** The unary {@code minus} operator. This is the equivalent to
	 * the Java's {@code -} function. This function is not null-safe.
	 *
	 * @param number a number.
	 * @return {@code -number}
	 */
	@Pure
	@Inline(value = "(-($1).intValue())", constantExpression = true)
	public static int operator_minus(Short number) {
		return -number.intValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() - $2)", constantExpression = true)
	public static long operator_minus(Short left, long right) {
		return left.longValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - $2)", constantExpression = true)
	public static int operator_minus(Short left, byte right) {
		return left.intValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - $2)", constantExpression = true)
	public static int operator_minus(Short left, int right) {
		return left.intValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - $2)", constantExpression = true)
	public static int operator_minus(Short left, short right) {
		return left.intValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() - $2)", constantExpression = true)
	public static double operator_minus(Short left, double right) {
		return left.doubleValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() - $2)", constantExpression = true)
	public static float operator_minus(Short left, float right) {
		return left.floatValue() - right;
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() - ($2).doubleValue())", constantExpression = true)
	public static double operator_minus(Short left, Number right) {
		return left.doubleValue() - right.doubleValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() - ($2).longValue())", constantExpression = true)
	public static long operator_minus(Short left, Long right) {
		return left.longValue() - right.longValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - ($2).intValue())", constantExpression = true)
	public static int operator_minus(Short left, Byte right) {
		return left.intValue() - right.intValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() - ($2).floatValue())", constantExpression = true)
	public static float operator_minus(Short left, Float right) {
		return left.floatValue() - right.floatValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - ($2).intValue())", constantExpression = true)
	public static int operator_minus(Short left, Integer right) {
		return left.intValue() - right.intValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).shortValue() - ($2).shortValue())", constantExpression = true)
	public static int operator_minus(Short left, Short right) {
		return left.shortValue() - right.shortValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() - ($2).intValue())", constantExpression = true)
	public static int operator_minus(Short left, AtomicInteger right) {
		return left.intValue() - right.intValue();
	}

	/** The binary {@code minus} operator. This is the equivalent to
	 * the Java {@code -} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left-right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() - ($2).longValue())", constantExpression = true)
	public static long operator_minus(Short left, AtomicLong right) {
		return left.longValue() - right.longValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() + $2)", constantExpression = true)
	public static long operator_plus(Short left, long right) {
		return left.longValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + $2)", constantExpression = true)
	public static int operator_plus(Short left, byte right) {
		return left.intValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + $2)", constantExpression = true)
	public static int operator_plus(Short left, int right) {
		return left.intValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + $2)", constantExpression = true)
	public static int operator_plus(Short left, short right) {
		return left.intValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() + $2)", constantExpression = true)
	public static double operator_plus(Short left, double right) {
		return left.doubleValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() + $2)", constantExpression = true)
	public static float operator_plus(Short left, float right) {
		return left.floatValue() + right;
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() + ($2).longValue())", constantExpression = true)
	public static long operator_plus(Short left, Long right) {
		return left.longValue() + right.longValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + ($2).intValue())", constantExpression = true)
	public static int operator_plus(Short left, Byte right) {
		return left.intValue() + right.intValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() + ($2).floatValue())", constantExpression = true)
	public static float operator_plus(Short left, Float right) {
		return left.floatValue() + right.floatValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + ($2).intValue())", constantExpression = true)
	public static int operator_plus(Short left, Integer right) {
		return left.intValue() + right.intValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).shortValue() + ($2).shortValue())", constantExpression = true)
	public static int operator_plus(Short left, Short right) {
		return left.shortValue() + right.shortValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() + ($2).intValue())", constantExpression = true)
	public static int operator_plus(Short left, AtomicInteger right) {
		return left.intValue() + right.intValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() + ($2).longValue())", constantExpression = true)
	public static long operator_plus(Short left, AtomicLong right) {
		return left.longValue() + right.longValue();
	}

	/** The binary {@code plus} operator. This is the equivalent to
	 * the Java {@code +} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left+right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() + ($2).doubleValue())", constantExpression = true)
	public static double operator_plus(Short left, Number right) {
		return left.doubleValue() + right.doubleValue();
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, long right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, byte right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, int right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, short right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, double right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), $2)", imported = Math.class)
	public static double operator_power(Short left, float right) {
		return Math.pow(left.doubleValue(), right);
	}

	/** The binary {@code power} operator. This is the equivalent to
	 * the Java's {@code Math.pow()} function. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code Math::pow(left, right)}
	 */
	@Pure
	@Inline(value = "$3.pow(($1).doubleValue(), ($2).doubleValue())", imported = Math.class)
	public static double operator_power(Short left, Number right) {
		return Math.pow(left.doubleValue(), right.doubleValue());
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() / $2)", constantExpression = true)
	public static long operator_divide(Short left, long right) {
		return left.longValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / $2)", constantExpression = true)
	public static int operator_divide(Short left, byte right) {
		return left.intValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / $2)", constantExpression = true)
	public static int operator_divide(Short left, int right) {
		return left.intValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / $2)", constantExpression = true)
	public static int operator_divide(Short left, short right) {
		return left.intValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() / $2)", constantExpression = true)
	public static double operator_divide(Short left, double right) {
		return left.doubleValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() / $2)", constantExpression = true)
	public static float operator_divide(Short left, float right) {
		return left.floatValue() / right;
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() / ($2).longValue())", constantExpression = true)
	public static long operator_divide(Short left, Long right) {
		return left.longValue() / right.longValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / ($2).intValue())", constantExpression = true)
	public static int operator_divide(Short left, Byte right) {
		return left.intValue() / right.intValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() / ($2).floatValue())", constantExpression = true)
	public static float operator_divide(Short left, Float right) {
		return left.floatValue() / right.floatValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / ($2).intValue())", constantExpression = true)
	public static int operator_divide(Short left, Integer right) {
		return left.intValue() / right.intValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() / ($2).doubleValue())", constantExpression = true)
	public static double operator_divide(Short left, Number right) {
		return left.doubleValue() / right.doubleValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / ($2).intValue())", constantExpression = true)
	public static int operator_divide(Short left, Short right) {
		return left.intValue() / right.intValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() / ($2).intValue())", constantExpression = true)
	public static int operator_divide(Short left, AtomicInteger right) {
		return left.intValue() / right.intValue();
	}

	/** The binary {@code divide} operator. This is the equivalent to
	 * the Java {@code /} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left/right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() / ($2).longValue())", constantExpression = true)
	public static long operator_divide(Short left, AtomicLong right) {
		return left.longValue() / right.longValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() * $2)", constantExpression = true)
	public static long operator_multiply(Short left, long right) {
		return left.longValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * $2)", constantExpression = true)
	public static int operator_multiply(Short left, byte right) {
		return left.intValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * $2)", constantExpression = true)
	public static int operator_multiply(Short left, int right) {
		return left.intValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * $2)", constantExpression = true)
	public static int operator_multiply(Short left, short right) {
		return left.intValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() * $2)", constantExpression = true)
	public static double operator_multiply(Short left, double right) {
		return left.doubleValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() * $2)", constantExpression = true)
	public static float operator_multiply(Short left, float right) {
		return left.floatValue() * right;
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() * ($2).longValue())", constantExpression = true)
	public static long operator_multiply(Short left, Long right) {
		return left.longValue() * right.longValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * ($2).intValue())", constantExpression = true)
	public static int operator_multiply(Short left, Byte right) {
		return left.intValue() * right.intValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() * ($2).floatValue())", constantExpression = true)
	public static float operator_multiply(Short left, Float right) {
		return left.floatValue() * right.floatValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * ($2).intValue())", constantExpression = true)
	public static int operator_multiply(Short left, Integer right) {
		return left.intValue() * right.intValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() * ($2).doubleValue())", constantExpression = true)
	public static double operator_multiply(Short left, Number right) {
		return left.doubleValue() * right.doubleValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * ($2).intValue())", constantExpression = true)
	public static int operator_multiply(Short left, Short right) {
		return left.intValue() * right.intValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() * ($2).intValue())", constantExpression = true)
	public static int operator_multiply(Short left, AtomicInteger right) {
		return left.intValue() * right.intValue();
	}

	/** The binary {@code multiply} operator. This is the equivalent to
	 * the Java {@code *} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left*right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() * ($2).longValue())", constantExpression = true)
	public static long operator_multiply(Short left, AtomicLong right) {
		return left.longValue() * right.longValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() % $2)", constantExpression = true)
	public static long operator_modulo(Short left, long right) {
		return left.longValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % $2)", constantExpression = true)
	public static int operator_modulo(Short left, byte right) {
		return left.intValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % $2)", constantExpression = true)
	public static int operator_modulo(Short left, int right) {
		return left.intValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % $2)", constantExpression = true)
	public static int operator_modulo(Short left, short right) {
		return left.intValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() % $2)", constantExpression = true)
	public static double operator_modulo(Short left, double right) {
		return left.doubleValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() % $2)", constantExpression = true)
	public static float operator_modulo(Short left, float right) {
		return left.floatValue() % right;
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() % ($2).longValue())", constantExpression = true)
	public static long operator_modulo(Short left, Long right) {
		return left.longValue() % right.longValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % ($2).byteValue())", constantExpression = true)
	public static int operator_modulo(Short left, Byte right) {
		return left.intValue() % right.byteValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).floatValue() % ($2).floatValue())", constantExpression = true)
	public static float operator_modulo(Short left, Float right) {
		return left.floatValue() % right.floatValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % ($2).intValue())", constantExpression = true)
	public static int operator_modulo(Short left, Integer right) {
		return left.intValue() % right.intValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).doubleValue() % ($2).doubleValue())", constantExpression = true)
	public static double operator_modulo(Short left, Number right) {
		return left.doubleValue() % right.doubleValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).shortValue() % ($2).shortValue())", constantExpression = true)
	public static int operator_modulo(Short left, Short right) {
		return left.shortValue() % right.shortValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).intValue() % ($2).intValue())", constantExpression = true)
	public static int operator_modulo(Short left, AtomicInteger right) {
		return left.intValue() % right.intValue();
	}

	/** The binary {@code modulo} operator. This is the equivalent to
	 * the Java {@code %} operator. This function is not null-safe.
	 *
	 * @param left a number.
	 * @param right a number.
	 * @return {@code left%right}
	 */
	@Pure
	@Inline(value = "(($1).longValue() % ($2).longValue())", constantExpression = true)
	public static long operator_modulo(Short left, AtomicLong right) {
		return left.longValue() % right.longValue();
	}

}
