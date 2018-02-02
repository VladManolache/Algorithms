package algorithms.search.graph.knight_on_chess_board;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Priority: High
 * Difficulty: Medium-Hard
 * Companies: Goldman Sachs, Amazon
 *
 * Given any source point and destination point on a chess board, we need to find whether Knight can move
 *  to the destination or not.
 *
 * The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.
 *
 * If yes, then what would be the minimum number of steps for the knight to move to the said point.
 * If knight can not move from the source point to the destination point, then return -1
 *
 * Input:
 * N, M, x1, y1, x2, y2
 * where N and M are size of chess board
 * x1, y1  coordinates of source point
 * x2, y2  coordinates of destination point
 *
 * Output:
 * return Minimum moves or -1
 *
 * Example
 * Input : 8 8 1 1 8 8
 * Output :  6
 *
 * @author Vlad Manolache
 */
public class KnightOnChessBoard {

    class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A][B];

        int[] movementX = new int[] {-1, 1, 2, 2, 1, -1, -2, -2};
        int[] movementY = new int[] {-2, -2, -1, 1, 2, 2, 1, -1};

        Point source = new Point(C - 1, D - 1, 0);
        Point destination = new Point(E - 1, F - 1, Integer.MAX_VALUE);
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        visited[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.remove();

            for (int i = 0; i < 8; i++) {
                int newX = current.x + movementX[i];
                int newY = current.y + movementY[i];
                if (isValid(newX, newY, visited, A, B)) {
                    Point point = new Point(newX, newY, current.distance + 1);
                    if (point.x == destination.x && point.y == destination.y) {
                        return point.distance;
                    }
                    else {
                        visited[newX][newY] = true;
                        queue.add(point);
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] visited, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return !visited[x][y];
    }

}
