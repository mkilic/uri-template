/*
 * Copyright (c) 2012, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eel.kitchen.uritemplate.expression;

import org.eel.kitchen.uritemplate.InvalidTemplateException;

import java.nio.CharBuffer;

public final class ExpressionParser
{
    private ExpressionParser()
    {
    }

    public static Expression parse(final String input)
        throws InvalidTemplateException
    {
        final CharBuffer buf = CharBuffer.wrap(input.toCharArray());
        final ExpressionBuilder builder = new ExpressionBuilder();

        TokenParser parser = new VarSpecTokenParser(buf, 0, builder,
            new StringBuilder());

        while (parser.parse())
            parser = parser.next();

        return new Expression(builder);
    }
}