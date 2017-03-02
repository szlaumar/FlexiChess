/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

public class ChessBoard {
    private int rows;
    private int columns;
    private int[][] board;
    
    public ChessBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        
        board = new int[rows][columns];
    }
    
    public int rows() { return rows; }
    
    public int columns() { return columns; }
    
    public void putPiece(int piece, char column, int row) {
        board[row][column - 'a'] = piece;
    }
    
    public int pieceAt(char column, int row) {
        return board[row][column - 'a'];
    }

    @Override
    public String toString() {
        int radky = board.length;
        int sloupce = board[0].length;
        StringBuffer buffer = new StringBuffer();

        buffer.append("    ");

        for (int i = 0; i < sloupce; i++) {
            buffer.append(i);
            if (i == (sloupce - 1)) {
                buffer.append(" \n");
            } else {
                buffer.append("   ");
            }
        }
        
        buffer = topEdgeToString(buffer);

        for (int i = 0; i < (radky * 2) - 1; i++) {
            if (i % 2 == 0) {
                buffer.append(i / 2);
                buffer.append(" │");
                for (int j = 0; j < sloupce; j++) {
                    buffer.append(" ");
                    if (board[i / 2][j] != 0) {
                        buffer.append(board[i / 2][j]);
                    } else {
                        buffer.append(" ");
                    }
                    buffer.append(" │");
                }
                buffer.append("\n");
            } else {
                buffer.append("  ├");
                for (int j = 0; j < sloupce - 1; j++) {
                    buffer.append("───┼");
                }
                buffer.append("───┤\n");
            }
        }
        buffer = bottomEdgeToString(buffer);
        
        return buffer.toString();
    }
    
    private StringBuffer bottomEdgeToString(StringBuffer buffer) {
        buffer.append("  └");
        for (int i = 0; i < columns - 1; i++) {
            buffer.append("───┴");
        }
        buffer.append("───┘");
        
        return buffer;
    }
    
    private StringBuffer topEdgeToString(StringBuffer buffer) {
        buffer.append("  ┌");
        for (int i = 0; i < columns - 1; i++) {
            buffer.append("───┬");
        }
        buffer.append("───┐\n");
        
        return buffer;
    }
    
}
