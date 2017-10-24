/*
 * The MIT License
 *
 * Copyright 2017 averycowan.
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

/**
 *
 * @author averycowan
 */
public class Tensor {

    public static double randfill(double[] f, double max) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += (f[i] = (double) Math.random() * max);
        }
        return sum;
    }

    public static double randfill(double[] f) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += (f[i] = (double) Math.random());
        }
        return sum;
    }

    public static double randfill(double[][] f, double max) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += randfill(f[i], max);
        }
        return sum;
    }

    public static double randfill(double[][] f) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += randfill(f[i]);
        }
        return sum;
    }

    public static double randfill(double[][][] f, double max) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += randfill(f[i], max);
        }
        return sum;
    }

    public static double randfill(double[][][] f) {
        double sum = 0f;
        for (int i = 0; i < f.length; i++) {
            sum += randfill(f[i]);
        }
        return sum;
    }

    public static double[] exp(double[] f) {
        for (int i = 0; i < f.length; i++) {
            f[i] = (double) Math.exp(f[i]);
        }
        return f;
    }

    public static double[] normalize(double[] f) {
        double sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum += f[i];
        }
        for (int i = 0; i < f.length; i++) {
            f[i] /= sum;
        }
        return f;
    }

    public static double[] scale(double[] a, double s) {
        for (int i = 0; i < a.length; i++) {
            a[i] *= s;
        }
        return a;
    }

    public static double[][] scale(double[][] a, double s) {
        for (int i = 0; i < a.length; i++) {
            scale(a[i], s);
        }
        return a;
    }

    public static double[][][] scale(double[][][] a, double s) {
        for (int i = 0; i < a.length; i++) {
            scale(a[i], s);
        }
        return a;
    }

    public static double sigmoid(double f) {
        return (double) (1f / (1f + Math.exp(-f)));
    }

    public static double[] sigmoid(double[] f) {
        for (int i = 0; i < f.length; i++) {
            f[i] = (double) (1f / (1f + Math.exp(-f[i])));
        }
        return f;
    }

    public static double[][] sigmoid(double[][] f) {
        for (int i = 0; i < f.length; i++) {
            sigmoid(f[i]);
        }
        return f;
    }

    public static double[] log(double[] f) {
        for (int i = 0; i < f.length; i++) {
            f[i] = (double) Math.log(f[i]);
        }
        return f;
    }

    public static double dotProduct(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    public static int greatest(double[] d) {
        int ind = 0;
        double max = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                ind = i;
                max = d[i];
            }
        }
        return ind;
    }
}
