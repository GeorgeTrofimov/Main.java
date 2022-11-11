import java.util.Arrays;
import java.util.List;

public class Chess_horse {
    int[][] board;

    public List<List<String>> solveNHorse(int N) {
        board = new int[N][N];
        return null;
    }

    public static int N = 6;

    public static int[] row = {2, 1, -1, -2, -2, -1, 1, 2, 2};
    public static int[] col = {1, 2, 2, 1, -1, -2, -2, -1, 1};

    public static boolean Movement(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        return true;
    }

    private static void print(int[][] visited) {
        for (var r : visited) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }

    public static void horse(int[][] visited, int x, int y, int pos) {
        visited[x][y] = pos;

        if (pos >= N * N) {
            print(visited);

            visited[x][y] = 0;
            return;
        }
        for (int k = 0; k < 8; k++) {
            int newX = x + row[k];
            int newY = y + col[k];
            if (Movement(newX, newY) && visited[newX][newY] == 0) {
                horse(visited, newX, newY, pos + 1);
            }
        }
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        int[][] visited = new int[N][N];
        int pos = 1;
        horse(visited, 0, 0, pos);
    }
}