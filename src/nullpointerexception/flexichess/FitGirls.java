/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

public class FitGirls {
    
    public static String boardAsString(int[][] board) {

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
        buffer.append("  ┌");
        for (int i = 0; i < sloupce - 1; i++) {
            buffer.append("───┬");
        }
        buffer.append("───┐\n");

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
        buffer.append("  └");
        for (int i = 0; i < sloupce - 1; i++) {
            buffer.append("───┴");
        }
        buffer.append("───┘");
        
        return buffer.toString();
    }
}
