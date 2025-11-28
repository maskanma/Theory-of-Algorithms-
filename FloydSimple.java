import java.util.Arrays;

public class FloydSimple {

    static final int INF = 1_000_000_000;

    public static void floyd(int[][] g) {
        int n = g.length;

        int[][] dist = new int[n][n];

        // Копіюємо матрицю
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0 && i != j)
                    dist[i][j] = INF;
                else
                    dist[i][j] = g[i][j];
            }
        }

        // Основні цикли Флойда
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Вивід
        for (int[] row : dist) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] G = {
            {0,8,1,5,3,0,0,0},
            {8,0,0,0,6,1,0,0},
            {1,0,0,6,0,7,0,3},
            {5,0,6,0,0,0,0,0},
            {3,6,0,0,0,0,9,0},
            {0,1,7,0,0,0,3,1},
            {0,0,0,0,9,3,0,4},
            {0,0,3,0,0,1,4,0}
        };

        floyd(G);
    }
}
