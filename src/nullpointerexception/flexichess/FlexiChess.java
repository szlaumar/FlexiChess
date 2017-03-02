package nullpointerexception.flexichess;
/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 */
public class FlexiChess {

    public static void main(String[] args) {
        // test data
        int rows = 3;
        int columns = 10;
        
        int[][] board = new int[rows][columns];
        board[0][1] = 5;
        board[1][1] = 4;
        board[2][3] = 1;
        
//        System.out.print(FitGirls.boardAsString(board));
        
        ChessBoard myBoard = new ChessBoard(columns, rows);
        System.out.print(myBoard.toString());
    }
    
    public static String boardAsString(int[][] board) {
        final int rows    = board.length;
        StringBuffer buffer = new StringBuffer();
        
        printHeader(buffer, board);
        printTopBorder(buffer, board);
        
        // print each inner row
        for (int row = 0; row < rows - 1; row++) {
            printContentRow(buffer, board, row);
            printInnerBorder(buffer, board);
        }
        
        // print last row
        printContentRow(buffer, board, rows - 1);
        printBottomBorder(buffer, board);
        
        return buffer.toString();
    }
    
    /**
     * Adds the header output line to the buffer.
     */
    private static void printHeader(StringBuffer buffer, int[][] board) {
        buffer.append("  ");
        for (int col = 0; col < board[0].length; col++) {
            buffer.append(String.format("  %d ", col));
        }
        buffer.append("\n");
    }
    
    /**
     * Adds the top border output line to the buffer.
     */
    private static void printTopBorder(StringBuffer buffer, int[][] board) {
        buffer.append("  ┌───");
        for (int col = 0; col < board[0].length - 1; col++) {
            buffer.append("┬───");
        }
        buffer.append("┐\n");
    }
    
    /**
     * Adds the inner border output line to the buffer.
     */
    private static void printInnerBorder(StringBuffer buffer, int[][] board) {
        buffer.append("  ├───");
        for (int col = 0; col < board[0].length - 1; col++) {
            buffer.append("┼───");
        }
        buffer.append("┤\n");
    }
    
    /**
     * Adds the bottom border output line to the buffer.
     */
    private static void printBottomBorder(StringBuffer buffer, int[][] board) {
        buffer.append("  └───");
        for (int col = 0; col < board[0].length - 1; col++) {
            buffer.append("┴───");
        }
        buffer.append("┘");
    }
    
    /**
     * Adds the inner output line containing as well row numbers
     * and chess pieces to the buffer.
     */
    private static void printContentRow(StringBuffer buffer, int[][] board, int row) { 
        buffer.append(String.format("%d │", row));
        for (int col = 0; col < board[0].length; col++) {
            String chessPiece = (board[row][col] > 0)
                    ? String.valueOf(board[row][col]) : " ";
            buffer.append(String.format(" %s │", chessPiece));
        }
        buffer.append("\n");
    }
}