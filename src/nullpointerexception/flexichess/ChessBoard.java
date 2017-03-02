/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

public class ChessBoard {
    int[][] board;
    
    
    public ChessBoard(int column, int row){
        board = new int[row][column];
    }
    
    public void putPiece(int piece, char column, int row){
        board[rows() - row][column - 'a'] = piece;
    }
    
    int columns(){
        return board[0].length;
    }
    
    int rows(){
        return board.length;
    }
    
    public int pieceAt(char column, int row){
        return board[rows() - row][column - 'a'];
    }
    
    @Override
    public String toString(){
        int radky = board.length;
        int sloupce = board[0].length;
        StringBuffer buffer = new StringBuffer();

        buffer.append("   ┌");
        for (int i = 0; i < sloupce - 1; i++) {
            buffer.append("───┬");
        }
        buffer.append("───┐\n");

        for (int i = 0; i < (radky * 2) - 1; i++) {
            if (i % 2 == 0) {
                buffer.append(String.format("%2d", radky - i / 2));
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
                buffer.append("   ├");
                for (int j = 0; j < sloupce - 1; j++) {
                    buffer.append("───┼");
                }
                buffer.append("───┤\n");
            }
        }
        buffer.append("   └");
        for (int i = 0; i < sloupce - 1; i++) {
            buffer.append("───┴");
        }
        buffer.append("───┘\n");
        
        buffer.append("     ");

        for (int i = 0; i < sloupce; i++) {
            buffer.append((char)('a' + i));
            if (i == (sloupce - 1)) {
                buffer.append(" ");
            } else {
                buffer.append("   ");
            }
        }
        return buffer.toString();
    }
}