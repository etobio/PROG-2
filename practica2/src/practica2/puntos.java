package practica2;

import java.util.Arrays;
import java.util.Random;

public class puntos {

    public static void main(String[] args) {

        Random r = new Random();

        int[][] puntos = new int[25][2];

        for (int i = 0; i < 25; i++) {
            puntos[i][0] = r.nextInt(10) - 5;
            puntos[i][1] = r.nextInt(10) - 5;
        }

        System.out.println("Tabla de puntos en array:");
        System.out.println();
        for (int i = 0; i < puntos.length; i++) {
            for (int k = 0; k < puntos.length; k++) {
                if (k != i && Arrays.equals(puntos[i], puntos[k])) {
                    System.out.print("*");
                    break;
                }
            }

            System.out.print("(" + puntos[i][0] + "," + puntos[i][1] + ") ");
            if ((i + 1) % 5 == 0)
                System.out.print("\n");
        }

        int cuandrante1 = 0;
        int cuandrante2 = 0;
        int cuandrante3 = 0;
        int cuandrante4 = 0;

        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i][0] > 0 && puntos[i][1] > 0)
                cuandrante1++;
            else if (puntos[i][0] < 0 && puntos[i][1] > 0)
                cuandrante2++;
            else if (puntos[i][0] < 0 && puntos[i][1] < 0)
                cuandrante3++;
            else if (puntos[i][0] > 0 && puntos[i][1] < 0)
                cuandrante4++;
        }
        System.out.println();
        System.out.println("Número de puntos en cuandrantes:" + " (1)" + cuandrante1 + " (2)" + cuandrante2 + " (3)" + cuandrante3 + " (4)" + cuandrante4);
        ;
        System.out.println();
        System.out.println("Representación gráfica:");
        System.out.println();
        // System.out.println(Arrays.deepToString(puntos));

        for (int y = 5; y > -6; y--) {
            for (int x = -5; x < 6; x++) {
                if (hayPunto(x, y, puntos)) {
                    System.out.print(" o ");
                } else if (x == 0 || y == 0)
                    System.out.print(" . ");
                else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }
    }

    // Esto nose que es pero ordena los puntos
    // Arrays.sort(puntos, Comparator.comparingInt(temp -> temp[1]));
    // Arrays.sort(puntos, Comparator.comparingInt(temp -> temp[0]));


    public static boolean hayPunto(int x, int y, int[][] puntos) {

        for (int i = 0; i < puntos.length; i++)
            if (puntos[i][0] == x && puntos[i][1] == y)
                return true;
        return false;

    }
}