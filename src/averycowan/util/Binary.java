/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
