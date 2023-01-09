/*
    Aufgabe 4) Zweidimensionale Arrays und Rekursion - Labyrinth
*/
public class Aufgabe4 {

    public static void main(String[] args) {
        int mazeType = 1;
        int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //EAST,NORTH,WEST,SOUTH
//        int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; //NORTH,WEST,SOUTH,EAST
//        int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//WEST,SOUTH,EAST,NORTH
//        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//SOUTH,EAST,NORTH,WEST

        char[][] myMaze = null;
        if (mazeType == 0) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * *********".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 1) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 2) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   *".toCharArray(),
                    "***** *   * * *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* *********   *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "E   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* *************".toCharArray(),
                    "* *      *    *".toCharArray(),
                    "*    *       S*".toCharArray(),
                    "***************".toCharArray()
            };
        }

        // Dieser Teil darf (muss aber nicht) verändert werden!!****************
        printMaze(myMaze);
        System.out.println();
        int[] startPoint = getStartPoint(myMaze);
        if (startPoint[0] == 0 && startPoint[1] == 0) {
            System.out.println("STARTPOINT MISSING!");
        } else {
            if (existsPathToExit(myMaze, startPoint[0], startPoint[1], direction)) {
                System.out.println("EXIT FOUND!");
                System.out.println();
            } else {
                System.out.println("EXIT NOT FOUND!");
                System.out.println();
            }
        }
        myMaze[startPoint[0]][startPoint[1]] = 'S';
        printMaze(myMaze);
        //**********************************************************************
    }

    private static int[] getStartPoint(char[][] maze) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[] startPoint = new int[2];
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (maze[row][col] == 'S') {
                    startPoint[0] = row;
                    startPoint[1] = col;
                }
            }
        }
        return startPoint; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean existsPathToExit(char[][] maze, int row, int col, int[][] direction) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
//        maze[row][col] = 'V';
//        if (maze[row + direction[0][0]][col + direction[0][1]] == '*' || maze[row + direction[0][0]][col + direction[0][1]] == 'V') {
//            return false;
//        } else if (maze[row + direction[2][0]][col + direction[2][1]] == '*' || maze[row + direction[2][0]][col + direction[2][1]] == 'V') {
//            return false;
//        } else if (maze[row + direction[2][0]][col + direction[2][1]] == '*' || maze[row + direction[2][0]][col + direction[2][1]] == 'V') {
//            return false;
//        } else if (maze[row + direction[2][0]][col + direction[2][1]] == '*' || maze[row + direction[2][0]][col + direction[2][1]] == 'V') {
//            return false;
//        }

        if (maze[row][col] == '*' || maze[row][col] == 'V') {
            return false;
        }
        if (maze[row][col] == 'E') {
            return true;
        }
        maze[row][col] = 'V';       // Besuchte Felder markieren (startPoint wird in main noch einmal extra ergänzt).
        if (existsPathToExit(maze, row + direction[0][0], col + direction[0][1], direction)         // Erste Richtung überprüfen.
                || existsPathToExit(maze, row + direction[1][0], col + direction[1][1], direction)  // Zweite Richtung überprüfen.
                || existsPathToExit(maze, row + direction[2][0], col + direction[2][1], direction)  // Dritte Richtung überprüfen.
                || existsPathToExit(maze, row + direction[3][0], col + direction[3][1], direction)  // Vierte Richtung überprüfen.
        ) {
            maze[row][col] = 'U';   // Verwendete Felder des gefundenen weges markieren.
            return true;
        }
        return false;
    }

    private static void printMaze(char[][] maze) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                System.out.print(maze[row][col]);
                if (col == maze[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }

}


