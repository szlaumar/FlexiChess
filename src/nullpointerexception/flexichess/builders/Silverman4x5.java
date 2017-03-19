package nullpointerexception.flexichess.builders;

import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;

public class Silverman4x5 implements ChessGameBuilder {

    private final int COLUMNS = 4;
    private final int ROWS = 5;
    
    @Override
    public ChessBoard board() {
        ChessBoard board = new ChessBoard(COLUMNS, ROWS);
        
        // place white pieces
        board.putPiece('a', 1, new Rook  (board, ChessPiece.Color.WHITE));
        board.putPiece('b', 1, new Queen (board, ChessPiece.Color.WHITE));
        board.putPiece('c', 1, new King  (board, ChessPiece.Color.WHITE));
        board.putPiece('d', 1, new Rook  (board, ChessPiece.Color.WHITE));
        for (int i = 0; i < COLUMNS; i++) {
            board.putPiece((char) ('a' + i), 2, 
                    new Pawn(board, ChessPiece.Color.WHITE));
        }
        
        // place black pieces
        board.putPiece('d', ROWS, new Rook  (board, ChessPiece.Color.BLACK));
        board.putPiece('c', ROWS, new Queen (board, ChessPiece.Color.BLACK));
        board.putPiece('b', ROWS, new King  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', ROWS, new Rook  (board, ChessPiece.Color.BLACK));
        for (int i = 0; i < COLUMNS; i++) {
            board.putPiece((char) ('a' + i), ROWS - 1, 
                    new Pawn(board, ChessPiece.Color.BLACK));
        }
        
        return board;
    }
    
}
