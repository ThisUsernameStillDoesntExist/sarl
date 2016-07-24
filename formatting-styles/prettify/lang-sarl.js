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
/* Style for SARL 0.4 */
PR['registerLangHandler'](
   PR['createSimpleLexer'](
      [
         [PR['PR_PLAIN'], /^[\t\n\r \xA0]+/, null, '\t\n\r \xA0'],
         [PR['PR_PUNCTUATION'], /^[!#%&()*+,\-./:;<=>?@\[\\\]^{|}]+/, null, '!#%&()*+,-./:;<=>?@[\\]^{|}'],
      ],
      [
         [PR['PR_STRING'], /^(?:"(?:[^\"\\]|\\.)*"|'(?!\'\')(?:[^\'\\]|\\.)*')/],
         [PR['PR_STRING'], /^'(?:[^\r\n\\']|\\(?:'|[^\r\n']+))'/],
         [PR['PR_LITERAL'], /^'[a-zA-Z_$][\w$]*(?!['$\w])/],
         [PR['PR_KEYWORD'], /^(?:abstract|agent|annotation|as|behavior|boolean|byte|capacity|case|catch|char|class|def|default|dispatch|do|double|else|enum|event|extends|extension|final|finally|fires|float|for|if|implements|import|instanceof|int|interface|long|native|new|on|override|package|private|protected|public|requires|return|short|skill|space|static|strictfp|super|switch|synchronized|throw|throws|transient|try|typeof|uses|val|var|void|volatile|while|with)\b/],
         [PR['PR_LITERAL'], /^(?:false|it|null|occurrence|this|true)\b/],
         [PR['PR_LITERAL'], /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         [PR['PR_TYPE'], /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'], /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'], /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/]
      ]),
   ['sarl']);
