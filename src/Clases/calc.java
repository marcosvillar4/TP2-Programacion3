package Clases;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class calc {

    public static int[] calcMin(int[][] m, int[] cc, int[] centros, int puntero){


        int c = calcC(m, cc, centros);
        int u = calcU(m, cc, centros);

        if (c < u) {
            int[] branch1 = centros.clone();
            int[] branch2 = centros.clone();

            branch1[puntero] = 1;
            branch2[puntero] = -1;

            calcMin(m, cc, branch1, puntero+1);
            calcMin(m, cc, branch2, puntero+1);
        }


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
            u = u + 1;
        }

        for (int i = 0; i < cc.length; i++) {
            if (centros[i] == 1){
                u = u + cc[i];
            }
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
            c = c + 1;
        }

        for (int i = 0; i < cc.length; i++) {
            if (centros[i] == 1){
                c = c + cc[i];
            }
        }

        return c;

    }



}
