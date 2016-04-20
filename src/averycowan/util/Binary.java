/*
 * Copyright 2016 Avery Cowan.
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package averycowan.util;

/**
 *
 * @author avecowa
 */
public final class Binary {
    public static int mergeBytes(byte[] b, int offset) {
        int o = truecast(b[offset]);
        o = o << 8;
        o = o | truecast(b[offset + 1]);
        o = o << 8;
        o = o | truecast(b[offset + 2]);
        o = o << 8;
        o = o | truecast(b[offset + 3]);
        return o;
    }
    public static int truecast(byte b) {
        return ((int) (b & 127)) + (128 * ((b >> 7) & 1));
    }
    public static String getBits(byte b) {
        return getBits((int) b, 8);
    }
    public static String getBits(int b) {
        return getBits(b, 32);
    }
    public static String getBits(int b, int s) {
        String o = "";
        for (s--; s >= 0; s--) {
            o += ((b >> s) & 1);
        }
        return o;
    }
    public static int flipbits(int i) {
        int o = 0;
        for (byte b = 0; b < 32; b++) {
            o = o << 1;
            o |= (i >> b) & 1;
        }
        return o;
    }
}
