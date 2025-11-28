import java.util.*;

public class FloydPrint {

    static final int INF = 1_000_000_000;

    static int[][] G = {
        {0,2,5,1,0,0,7,0},
        {2,0,0,3,6,0,0,0},
        {5,0,0,0,2,4,4,0},
        {1,3,0,0,5,4,9,0},
        {0,6,2,5,0,3,0,0},
        {0,0,4,4,3,0,0,1},
        {7,0,4,9,0,0,0,6},
        {0,0,0,0,0,1,6,0}
    };

    public static void main(String[] args) {
        floyd();
    }

    static void floyd() {
        int n = G.length;
        int[][] d = new int[n][n];

        // Ініціалізація
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                d[i][j] = (G[i][j] == 0 && i != j) ? INF : G[i][j];

        // Флойд
        for (int k = 0; k < n; k++) {
            System.out.println("k = " + (k + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] + d[k][j] < d[i][j])
                        d[i][j] = d[i][k] + d[k][j];
                }
            }
            printMatrix(d);
        }
    }

    static void printMatrix(int[][] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                if (d[i][j] >= INF) System.out.print("∞");
                else System.out.print(d[i][j]);
                if (j < n - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
