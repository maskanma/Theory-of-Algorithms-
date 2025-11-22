public class Prim {

    private static final int V = 8;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static final int[][] G = {
            {INF, 2,   5,   1,   INF, INF, 7,   INF},
            {2,   INF, INF, 3,   6,   INF, INF, INF},
            {5,   INF, INF, INF, 2,   4,   4,   INF},
            {1,   3,   INF, INF, 5,   4,   9,   INF},
            {INF, 6,   2,   5,   INF, 3,   INF, INF},
            {INF, INF, 4,   4,   3,   INF, INF, 1  },
            {7,   INF, 4,   9,   INF, INF, INF, 6  },
            {INF, INF, INF, INF, INF, 1,   6,   INF}
    };

    public static void main(String[] args) {

        boolean[] selected = new boolean[V];
        selected[0] = true; // start from vertex 1

        int edgesUsed = 0;
        int totalWeight = 0;

        System.out.println("Ребра МКД (Прім):");

        while (edgesUsed < V - 1) {
            int min = INF;
            int x = -1, y = -1;

            // find smallest edge from selected -> not selected
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] < min) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.printf("%d - %d : %d%n", x + 1, y + 1, G[x][y]);
            selected[y] = true;
            totalWeight += G[x][y];
            edgesUsed++;
        }

        System.out.println("Загальна вага МКД (Прім) = " + totalWeight);
    }
}
