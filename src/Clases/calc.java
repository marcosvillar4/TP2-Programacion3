package Clases;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class calc {

    public static int[] calcMin(int[][] m, int[] cc, int[] centros, int puntero, Integer minU){
        if(puntero >= centros.length){
            return centros;
        } else {
            int c = calcC(m, cc, centros);
            int u = calcU(m, cc, centros);

            int[] branch1 = centros.clone();
            int[] branch2 = centros.clone();

            branch1[puntero] = 1;
            branch2[puntero] = -1;
            if (u < minU){
                if(calcC(m, cc, branch1) > calcC(m, cc, branch2)){
                    return calcMin(m, cc, branch2, puntero + 1, u);
                } else {
                    return calcMin(m, cc, branch1, puntero + 1, u);
                }
            } else {
                if(calcC(m, cc, branch1) > calcC(m, cc, branch2)){
                    return calcMin(m, cc, branch2, puntero + 1, minU);
                } else {
                    return calcMin(m, cc, branch1, puntero + 1, minU);
                }
            }
        }

//        int c = calcC(m, cc, centros);
//        int u = calcU(m, cc, centros);
//
//        if (c < u) {
//            int[] branch1 = centros;
//            int[] branch2 = centros;
//
//            branch1[puntero] = 1;
//            branch2[puntero] = -1;
//
//            if (branch1.length < puntero) {
//                centros = calcMin(m, cc, branch1, puntero + 1);
//                centros = calcMin(m, cc, branch2, puntero + 1);
//            }
//        }
//        return centros;
    }

    static int calcU(int[][] m, int[] cc, int[] centros){

        int u = 0;

        for (int[] ints : m) {
            int min = MAX_VALUE;
            for (int i = 0; i < ints.length; i++) {
                if (centros[i] == 1 && ints[i] < min){
                    min = ints[i];
                }
            }
            if (min != MAX_VALUE) {
                u = u + min;
            }
        }

        for (int i = 0; i < cc.length; i++) {
            if (centros[i] == 1){
                u = u + cc[i];
            }
        }

        if (u == 0){
            return MAX_VALUE;
        }

        return u;

    }

    static int calcC(int[][] m, int[] cc, int[] centros){

        int c = 0;

        for (int[] ints : m) {
            int min = MAX_VALUE;
            for (int i = 0; i < ints.length; i++) {
                if (centros[i] != -1 && ints[i] < min){
                    min = ints[i];
                }
            }
            if (min != MAX_VALUE) {
                c = c + min;
            }
        }

        for (int i = 0; i < cc.length; i++) {
            if (centros[i] == 1){
                c = c + cc[i];
            }
        }

        return c;

    }



}
