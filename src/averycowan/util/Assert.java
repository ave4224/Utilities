/*
 * The MIT License
 *
 * Copyright 2018 averycowan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package averycowan.util;

import java.util.function.Supplier;

/**
 *
 * @author averycowan
 */
public class Assert {

    public static void that(boolean b, String s) {
        if (!b) {
            throw new AssertionFailureException(s);
        }
    }

    public static void that(boolean b, Object s) {
        if (!b) {
            throw new AssertionFailureException(s.toString());
        }
    }

    public static void that(boolean b, Supplier<String> s) {
        if (!b) {
            throw new AssertionFailureException(s.get());
        }
    }

    public static void that(boolean b) {
        Assert.that(b, "Assertion failed");
    }

    private static class AssertionFailureException extends RuntimeException {

        private AssertionFailureException(String s) {
            super(s);
            Out.flush();
        }

        private AssertionFailureException() {
            this("Assertion failed");
        }
    }
}
