import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Count of matrix = ");
        int countMatrix = scanner.nextInt();

        int[] d = new int[countMatrix + 1];
        int[][] p = new int[countMatrix + 1][countMatrix + 1];

        System.out.println("Enter Dimension of matrix :");

        for (int i = 0; i < countMatrix + 1; i++) {
            d[i] = scanner.nextInt();
        }

        minmult(countMatrix, d, p);

        for (int i = 1; i < countMatrix + 1; i++) {
            System.out.println(Arrays.toString(p[i]));
        }

    }

    static void minmult(int n, int[] d, int[][] p) {
        int[][] m = new int[n + 1][n + 1];
        int i, j, k, diagonal;
        for (i = 1; i <= n; i++) m[i][i] = 0;
        for (diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (i = 1; i <= n - diagonal; i++) {
                j = i + diagonal;
                m[i][j] = getMin(i, j, p, d, m);
            }
        }
    }

    static int getMin(int i, int j, int[][] p, int[] d, int[][] m){
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            if (m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j] < min) {
                min = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
                p[i][j] = k;
            }
        }
        return min;
    }

}
