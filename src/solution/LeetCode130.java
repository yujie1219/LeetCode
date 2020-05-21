package solution;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class LeetCode130 {

    public void solve(char[][] board) {
        Set<Coordinate> coordinates = new HashSet<>();
        Stack<Coordinate> coordinateStack = new Stack<>();

        int y = board.length;
        if (y == 0) {
            return;
        }

        int x = board[0].length;
        if (x == 0) {
            return;
        }

        initSetAndStack(board, coordinates, coordinateStack, y, x);

        while (!coordinateStack.isEmpty()) {
            Coordinate placeO = coordinateStack.pop();

            if ((placeO.y == 0 && (placeO.x == 0 || placeO.x == x - 1)) || (placeO.y == y - 1 && (placeO.x == 0 || placeO.x == x - 1))) {
                continue;
            }

            if (placeO.y == 0) {
                if (1 < y - 1 && board[1][placeO.x] == 'O') {
                    Coordinate current = new Coordinate(1, placeO.x);
                    verifyAndAdd(coordinates, coordinateStack, current);
                }
                continue;
            } else if (placeO.y == y - 1) {
                if (y - 2 > 0 && board[y - 2][placeO.x] == 'O') {
                    Coordinate current = new Coordinate(y - 2, placeO.x);
                    verifyAndAdd(coordinates, coordinateStack, current);
                }
                continue;
            }

            if (placeO.x == 0) {
                if (1 < x - 1 && board[placeO.y][1] == 'O') {
                    Coordinate current = new Coordinate(placeO.y, 1);
                    verifyAndAdd(coordinates, coordinateStack, current);
                }
                continue;
            } else if (placeO.x == x - 1) {
                if (x - 2 > 0 && board[placeO.y][x - 2] == 'O') {
                    Coordinate current = new Coordinate(placeO.y, x - 2);
                    verifyAndAdd(coordinates, coordinateStack, current);
                }
                continue;
            }

            if (placeO.y - 1 > 0 && board[placeO.y - 1][placeO.x] == 'O') {
                Coordinate current = new Coordinate(placeO.y - 1, placeO.x);
                verifyAndAdd(coordinates, coordinateStack, current);
            }

            if (placeO.y + 1 < y - 1 && board[placeO.y + 1][placeO.x] == 'O') {
                Coordinate current = new Coordinate(placeO.y + 1, placeO.x);
                verifyAndAdd(coordinates, coordinateStack, current);
            }

            if (placeO.x - 1 > 0 && board[placeO.y][placeO.x - 1] == 'O') {
                Coordinate current = new Coordinate(placeO.y, placeO.x - 1);
                verifyAndAdd(coordinates, coordinateStack, current);
            }

            if (placeO.x + 1 < x - 1 && board[placeO.y][placeO.x + 1] == 'O') {
                Coordinate current = new Coordinate(placeO.y, placeO.x + 1);
                verifyAndAdd(coordinates, coordinateStack, current);
            }
        }

        for (int i = 1; i < y - 1; i++) {
            for (int j = 1; j < x - 1; j++) {
                Coordinate current = new Coordinate(i, j);

                if (board[i][j] == 'O' && !coordinates.contains(current)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void verifyAndAdd(Set<Coordinate> coordinates, Stack<Coordinate> coordinateStack, Coordinate current) {
        if (!coordinates.contains(current)) {
            coordinates.add(current);
            coordinateStack.push(current);
        }
    }

    private void initSetAndStack(char[][] board, Set<Coordinate> coordinates, Stack<Coordinate> coordinateStack, int y, int x) {
        for (int i = 0; i < y; i++) {
            if (board[i][0] == 'O') {
                Coordinate coordinate = new Coordinate(i, 0);
                coordinates.add(coordinate);
                coordinateStack.push(coordinate);
            }

            if (board[i][x - 1] == 'O') {
                Coordinate coordinate = new Coordinate(i, x - 1);
                coordinates.add(coordinate);
                coordinateStack.push(coordinate);
            }
        }

        for (int i = 1; i < x - 1; i++) {
            if (board[0][i] == 'O') {
                Coordinate coordinate = new Coordinate(0, i);
                coordinates.add(coordinate);
                coordinateStack.push(coordinate);
            }

            if (board[y - 1][i] == 'O') {
                Coordinate coordinate = new Coordinate(y - 1, i);
                coordinates.add(coordinate);
                coordinateStack.push(coordinate);
            }
        }
    }

    private class Coordinate {
        public int y;
        public int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return y == that.y &&
                    x == that.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
