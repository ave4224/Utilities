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
public class Out {

    public static void flush() {
        System.out.flush();
    }

    public static enum Mode {
        DEBUG, LOG, ALERT, OUTPUT, SILENT;
    }

    public static Mode mode = Mode.OUTPUT;

    public static boolean debug(Object message) {
        return println(message, Mode.DEBUG);
    }

    public static boolean log(Object message) {
        return println(message, Mode.LOG);
    }

    public static boolean alert(Object message) {
        return println(message, Mode.ALERT);
    }

    public static boolean output(Object message) {
        return println(message, Mode.OUTPUT);
    }

    public static boolean debug(Supplier message) {
        return println(message, Mode.DEBUG);
    }

    public static boolean log(Supplier message) {
        return println(message, Mode.LOG);
    }

    public static boolean alert(Supplier message) {
        return println(message, Mode.ALERT);
    }

    public static boolean output(Supplier message) {
        return println(message, Mode.OUTPUT);
    }

    private static boolean println(Object message, Mode req) {
        if (req.compareTo(mode) <= 0) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    private static boolean println(Supplier message, Mode req) {
        if (req.compareTo(mode) <= 0) {
            System.out.println(message.get());
            return true;
        }
        return false;
    }
}
