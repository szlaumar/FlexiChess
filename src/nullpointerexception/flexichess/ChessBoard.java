/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class ChessBoard {
    int[][] board;
    
    
    public ChessBoard(int column, int row){
        board = new int[row][column];
    }
    
    public int columns(){
        return board[0].length;
    }
    
    public int rows(){
        return board.length;
    }
    
    public int pieceAt(char column, int row){
        return board[rows() - row][column - 'a'];
    }
    
    public void putPiece(int piece, char column, int row){
        board[rows() - row][column - 'a'] = piece;
    }
    
    @Override
    public String toString(){
        int rows = board.length;
        StringBuffer buffer = new StringBuffer();

        bufferAppendTopBorder(buffer);

        // For every line print either content row or deviding row
        for (int i = 0; i < (rows * 2) - 1; i++) {
            if (i % 2 == 0) {
                bufferAppendContentRow(buffer, i);
            } else {
                bufferAppendDividingRow(buffer);
            }
        }
        
        bufferAppendBottomBorder(buffer);
        bufferAppendColumnsNotation(buffer);
        
        return buffer.toString();
    }
    
    private void bufferAppendTopBorder(StringBuffer buffer) {
        buffer.append("   ┌");
        for (int i = 0; i < board[0].length - 1; i++) {
            buffer.append("───┬");
        }
        buffer.append("───┐\n");
    }
    
    private void bufferAppendBottomBorder(StringBuffer buffer) {
        buffer.append("   └");
        for (int i = 0; i < board[0].length - 1; i++) {
            buffer.append("───┴");
        }
        buffer.append("───┘\n");
    }
    
    private void bufferAppendColumnsNotation(StringBuffer buffer) {
        buffer.append("     ");

        for (int i = 0; i < board[0].length; i++) {
            buffer.append((char)('a' + i));
            if (i == (board[0].length - 1)) {
                buffer.append(" ");
            } else {
                buffer.append("   ");
            }
        }
    }
    
    private void bufferAppendContentRow(StringBuffer buffer, int row) {
        // print row notation
        buffer.append(String.format("%2d │", board.length - row / 2));
        
        // print each column
        for (int col = 0; col < board[0].length; col++) {
            if (board[row / 2][col] != 0) {
                buffer.append(String.format(" %d │", board[row / 2][col]));
            } else {
                buffer.append("   │");
            }
        }
        buffer.append("\n");
    }
    
    private void bufferAppendDividingRow(StringBuffer buffer) {
        buffer.append("   ├");
        for (int col = 0; col < board[0].length - 1; col++) {
            buffer.append("───┼");
        }
        buffer.append("───┤\n");
    }
}