package nullpointerexception.flexichess;

/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class FlexiChess {

    public static void main(String[] args) {
        
        System.out.println("FlexiChess v3.0\n");

        ChessBoard board = new ChessBoard(4, 4);
        ChessBoardAsString boardAsString = new ChessBoardAsString(board);

        System.out.println("Printing test #3:\n");
        board.putPiece('a', 1, new ChessPiece('R', ChessPiece.Color.WHITE));
        board.putPiece('b', 1, new ChessPiece('Q', ChessPiece.Color.WHITE));
        board.putPiece('c', 1, new ChessPiece('K', ChessPiece.Color.WHITE));
        board.putPiece('d', 1, new ChessPiece('R', ChessPiece.Color.WHITE));

        board.putPiece('a', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
        board.putPiece('b', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
        board.putPiece('c', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
        board.putPiece('d', 2, new ChessPiece('p', ChessPiece.Color.WHITE));

        board.putPiece('a', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
        board.putPiece('b', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
        board.putPiece('c', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
        board.putPiece('d', 3, new ChessPiece('p', ChessPiece.Color.BLACK));

        board.putPiece('a', 4, new ChessPiece('R', ChessPiece.Color.BLACK));
        board.putPiece('b', 4, new ChessPiece('Q', ChessPiece.Color.BLACK));
        board.putPiece('c', 4, new ChessPiece('K', ChessPiece.Color.BLACK));
        board.putPiece('d', 4, new ChessPiece('R', ChessPiece.Color.BLACK));

        String expected = 
                        "   ┌───┬───┬───┬───┐\n" + 
                        " 4 │-R │-Q │-K │-R │\n" +
                        "   ├───┼───┼───┼───┤\n" +
                        " 3 │-p │-p │-p │-p │\n" +
                        "   ├───┼───┼───┼───┤\n" +
                        " 2 │+p │+p │+p │+p │\n" +
                        "   ├───┼───┼───┼───┤\n" +
                        " 1 │+R │+Q │+K │+R │\n" +
                        "   └───┴───┴───┴───┘\n" +
                        "     a   b   c   d "; 

        System.out.print(expected + "\n");
        System.out.print(board.toString() + "\n");
        System.out.print(boardAsString.toString() + "\n");        
    }
    
}