/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

public class Aufgabe1 {

    private static int columns;
    private static int rows;
    private static int fieldsUsed;

    private static int[][] genGameBoard(int row, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Spieler 1 wird mit '1' abgespeichert und entspricht "Rot", Spieler 2 mit '2' und entspricht "Gelb"
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Schriftzüge werden 1 Sek lang angezeigt vor dem Reset des Spielfelds. Geht mit myDrawObj.show(1000)
        myDrawObj.setColor(Palette.BLUE);
        myDrawObj.fillRectangle(0,0, columns * oneSquareSize, rows * oneSquareSize);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                switch (currentGameBoard[row][col]) {
                    case 0 -> myDrawObj.setColor(Palette.DARK_GRAY);
                    case 1 -> myDrawObj.setColor(Palette.RED);
                    case 2 -> myDrawObj.setColor(Palette.YELLOW);
                }
                myDrawObj.fillCircle(oneSquareSize / 2.0 + (col * oneSquareSize), oneSquareSize / 2.0 + (row * oneSquareSize), oneSquareSize / 3.0);
            }
        }

    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return currentGameBoard[0][col] == 0;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int row = rows - 1; row >= 0; row--) {
            if (currentGameBoard[row][col] == 0) {
                currentGameBoard[row][col] = player;
                break;
            }
        }
        fieldsUsed++;
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int counter = 0;
        // 1. Check rows for win
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (currentGameBoard[row][col] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }

        // 2. Check columns for win
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                if (currentGameBoard[row][col] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }

        // 3. Check diagonals form top-left to bottom-right.
        // We go from left to right: Start at 4th row from the bottom, because you need 4 in one diagonal.
        for (int row = rows - 4; row >= 0; row--) {
            // Go down the diagonal until you hit the bottom or right edge of the game board.
            // The number of steps depends on in which row you are and is limited by the total number of columns.
            for (int i = 0; i < rows - row && i < columns; i++) {
                if (currentGameBoard[row + i][i] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }
        for (int col = 1; col <= columns - 4; col++) {
            // Go down the diagonal until you hit the bottom or right edge of the game board.
            // The number of steps depends on in which row you are and is limited by the total number of columns.
            for (int i = 0; i < columns - col && i < rows; i++) {
                if (currentGameBoard[i][col + i] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }

        // 4. Check diagonals form bottom-left to top right-right.
        // We go from left to right: Start at 4th row from the top, because you need 4 in one diagonal.
        for (int row = 3; row < rows; row++) {
            // Go up the diagonal until you hit the top or right edge of the game board.
            // The number of steps depends on in which row you are and is limited by the total number of columns.
            for (int i = 0; i < row + 1 && i < columns; i++) {      // e.g. row = 3, then you can go 4 steps up
                if (currentGameBoard[row - i][i] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }
        for (int col = 1; col <= columns - 4; col++) {
            // Go up the diagonal until you hit the top or right edge of the game board.
            // The number of steps depends on in which row you are and is limited by the total number of columns.
            for (int i = 0; i < columns - col && i < rows; i++) {
                if (currentGameBoard[rows - 1 - i][col + i] == player) {
                    counter++;
                } else if (counter >= 4) {
                    return true;
                } else {
                    counter = 0;
                }
            }
            if (counter >= 4) {
                return true;
            }
            counter = 0;
        }
        return false;
    }


    public static void main(String[] args) {

        // canvas settings
        rows = 6;
        columns = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * columns;
        int height = oneSquareSize * rows;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rows, columns);
        int player = 1;
        fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
        myDrawObj.show();
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        // game play starts
        while (!myDrawObj.isClosed() && gameActive) {
            if(myEventSC.hasKeyPressEvent()){
                if(myEventSC.nextKeyPressEvent().getChar() == 'q'){
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();
                // TODO: Implementieren Sie hier die fehlende Spiellogik
                if (isMovePossible(myGameBoard, mouseX / oneSquareSize)) {
                    makeMove(myGameBoard, player, mouseX / oneSquareSize);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);   // Show the move.
                    myDrawObj.show(300);
                    // Check for winner.
                    if (existsWinner(myGameBoard, player)) {
                        // Display winning message.
                        myDrawObj.setColor(Palette.GREEN_YELLOW);
                        myDrawObj.drawText(width / 2.0, height / 2.0, "Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " won!");
                        myDrawObj.show(3000);
                        // Reset board and start new round.
                        myGameBoard = genGameBoard(rows, columns);
                        fieldsUsed = 0;
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                        myDrawObj.setColor(Palette.ORANGE);
                        myDrawObj.drawText(width / 2.0, height / 2.0, "Next round!");
                        myDrawObj.show(1000);
                    // Check whether board is full.
                    } else if (fieldsUsed >= rows * columns){
                        myDrawObj.setColor(Palette.ORANGE);
                        myDrawObj.drawText(width / 2.0, height / 2.0, "Board full!");
                        myDrawObj.show(1000);
                        // Animation
                        for (int i = 0; i < rows; i++) {
                            for (int row = rows - 1; row > i; row--) {
                                myGameBoard[row] = myGameBoard[row - 1];
                            }
                            myGameBoard[i] = new int[columns];
                            drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                            myDrawObj.show(500);
                        }
                        // Reset fieldsUsed
                        fieldsUsed = 0;
                    }
                    // Change player for the next turn.
                    player = player == 1 ? 2 : 1;
                    System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");

                } else {
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.drawText(width / 2.0, height / 2.0, "Column already full!");
                    myDrawObj.show(1000);
                }
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}