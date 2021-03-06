# Extension Methods and Available Extensions

Extension methods allow you to add new methods to existing types without modifying them. This is really
helpful as they can greatly improve the readability. Extension methods use a simple syntactic trick:
the first parameter of a method can either be passed in after opening the parentheses or before the
method call. For example, given a method:

		[:Success:]
			package io.sarl.docs.reference.gsr
			agent X {
				[:On]
				def removeVowels (s : String) {
					s.replaceAll("[aeiouyAEIOUY]", "")
				}
				[:Off]
			}
		[:End:]

We can call this method either like in Java or C++ languages:

		[:Success:]
			package io.sarl.docs.reference.gsr
			agent X {
				def removeVowels (s : String) {
					s.replaceAll("[aeiouyAEIOUY]", "")
				}
				def action {
					[:On]
					removeVowels("Hello")
					[:Off]
				}
			}
		[:End:]


or as an extension method of String:

		[:Success:]
			package io.sarl.docs.reference.gsr
			agent X {
				def removeVowels (s : String) {
					s.replaceAll("[aeiouyAEIOUY]", "")
				}
				def action {
					[:On]
					"Hello".removeVowels
					[:Off]
				}
			}
		[:End:]


## Import static extension methods

You can import static methods as extensions, and directly call the imported static methods.

In the following example, the `[:sort!](List)` function is provided by the [:collections:] utility class.
This function is invoked with the extension method syntax.

		[:Success:]
			package io.sarl.docs.reference.gsr
			[:On]
			import static extension java.util.[:collections](Collections).*
			agent MyAgent {
				def example {
					val colors : String[] = #["red", "blue", "green"]
					colors.[:sort](sort) 
				}
			}
		[:End:]


## Local extension methods

All visible non-static methods of the current class and its super types are automatically available as extensions.

In the following example, the [:hasoneelement:] function is invoked with the extension method syntax.

		[:Success:]
			package io.sarl.docs.reference.gsr
			import java.util.List
			agent A {
				[:On]
				// Define an extension method for List
				def [:hasoneelement](hasOneElement)(list : List<?>) : boolean {
					list.size == 1
				}
				
				// Invoke the extension method
				def example : boolean {
					newArrayList("red").hasOneElement
				}
				[:Off]
			}
		[:End:]


## Extension Provider

By adding the [:extensionkw:] keyword to a field, a local variable, or a parameter declaration, its
instance methods become extension methods.

<caution>The [:extensionkw:] keyword must be always written just before the [:valkw:] or
[:varkw:] keywords for fields and local variables, or before the parameter's name.</caution>

<caution>In the case of an extension field, you must give the type of the field because the type resolved
of SARL cannot infer the type of the field.</caution>

In the following example, the extension provider is a field. The function `[:contains!](Object)`
is called with the extension method syntax. The extension provider is the field [:list:].
Because of the extension method, the call to [:contains:] is equivalent to `[:list!].[:contains!]([:value!])`.


		[:Success:]
			package io.sarl.docs.reference.gsr
			import java.util.ArrayList
			[:On]
			class ExtensionProviderExamples {
				[:extensionkw](extension) [:varkw](var) [:list](list) : ArrayList<String> = newArrayList
				
				def extensionFieldExample(value : String) : boolean {
					[:value](value).[:contains](contains)
				}
			}
		[:End:]

In the following example, the extension provider is the formal parameter [:o:].
Because of the extension method, the call to [:contains:] is equivalent to `[:o!].[:contains!]([:value!])`.

		[:Success:]
			package io.sarl.docs.reference.gsr
			import java.util.ArrayList
			[:On]
			class ExtensionProviderExamples {
				[:On]
				def extensionParameterExample(value : String, extension [:o](o) : ArrayList<String>) : boolean {
					[:value!].[:contains!]
				}
				[:Off]
			}
		[:End:]


In the following example, the extension provider is the local variable [:o:].
Because of the extension method, the call to [:contains:] is equivalent to `[:o!].[:contains!]([:value!])`.

		[:Success:]
			package io.sarl.docs.reference.gsr
			import java.util.ArrayList
			class ExtensionProviderExamples {
				[:On]
				def extensionLocalVariableExample(value : String) : boolean {
					extension [:valkw](val) [:o!] : ArrayList<String> = newArrayList
					[:value!].[:contains!]
				}
				[:Off]
			}
		[:End:]


## Imported Extensions

The following sections describe the extensions (in alphabetical order) that are automatically imported in a SARL script.
The extensions are described into categories.


### Collection Category

The following functions are provided for extended the standard collection API:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		org.eclipse.xtext.xbase.lib.ArrayExtensions,
		org.eclipse.xtext.xbase.lib.CollectionExtensions,
		org.eclipse.xtext.xbase.lib.IterableExtensions,
		org.eclipse.xtext.xbase.lib.IteratorExtensions,
		org.eclipse.xtext.xbase.lib.ListExtensions,
		org.eclipse.xtext.xbase.lib.MapExtensions)}


### Number Category

The following functions are provided for extended the standard number API:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		org.eclipse.xtext.xbase.lib.BigDecimalExtensions,
		org.eclipse.xtext.xbase.lib.BigIntegerExtensions,
		org.eclipse.xtext.xbase.lib.ByteExtensions,
		org.eclipse.xtext.xbase.lib.DoubleExtensions,
		org.eclipse.xtext.xbase.lib.FloatExtensions,
		org.eclipse.xtext.xbase.lib.IntegerExtensions,
		org.eclipse.xtext.xbase.lib.LongExtensions,
		org.eclipse.xtext.xbase.lib.ShortExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.AtomicIntegerArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.AtomicLongArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.ByteArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.DoubleArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.FloatArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.IntegerArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.LongArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.NumberArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveByteArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveDoubleArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveFloatArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveIntArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveLongArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.PrimitiveShortArithmeticExtensions,
		io.sarl.lang.scoping.numbers.arithmetic.ShortArithmeticExtensions,
		io.sarl.lang.scoping.numbers.comparison.AtomicIntegerComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.AtomicLongComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.ByteComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.DoubleComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.FloatComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.IntegerComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.LongComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.NumberComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveByteComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveDoubleComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveFloatComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveIntComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveLongComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.PrimitiveShortComparisonExtensions,
		io.sarl.lang.scoping.numbers.comparison.ShortComparisonExtensions,
		io.sarl.lang.scoping.numbers.casts.AtomicIntegerCastExtensions,
		io.sarl.lang.scoping.numbers.casts.AtomicLongCastExtensions,
		io.sarl.lang.scoping.numbers.casts.NumberCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveByteCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveDoubleCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveFloatCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveIntCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveLongCastExtensions,
		io.sarl.lang.scoping.numbers.casts.PrimitiveShortCastExtensions
	)}


### Primitive Type Category

The following functions are provided for extended the standard primitive type  API:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		org.eclipse.xtext.xbase.lib.BooleanExtensions,
		org.eclipse.xtext.xbase.lib.CharacterExtensions)}


### Object Type Category

The following functions are provided for extended the Object types:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		org.eclipse.xtext.xbase.lib.ComparableExtensions,
		org.eclipse.xtext.xbase.lib.ObjectExtensions,
		org.eclipse.xtext.xbase.lib.StringExtensions)}


### Functions and Procedure Category

The following functions are provided for extended the standard Lambda expression API:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		org.eclipse.xtext.xbase.lib.FunctionExtensions,
		org.eclipse.xtext.xbase.lib.ProcedureExtensions)}


### Time Category

The following functions are provided for extended the standard time API:

[:DynamicCode:]{io.sarl.maven.docs.testing.ReflectExtensions.getPublicMethods(
		io.sarl.lang.scoping.batch.SARLTimeExtensions)}




[:Include:](../generalsyntaxref.inc)

[:Include:](../../legal.inc)
