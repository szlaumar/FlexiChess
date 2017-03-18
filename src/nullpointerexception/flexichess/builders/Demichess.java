package nullpointerexception.flexichess.builders;

import nullpointerexception.flexichess.Bishop;
import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;

public class Demichess implements ChessGameBuilder {
    
    private final int COLUMNS = 4;
    private final int ROWS = 8;

    
    @Override
    public ChessBoard board() {
        ChessBoard board = new ChessBoard(COLUMNS, ROWS);
        
        // place white pieces
        board.putPiece('a', 1, new Queen (board, ChessPiece.Color.WHITE));
        board.putPiece('b', 1, new Bishop(board, ChessPiece.Color.WHITE));
        board.putPiece('c', 1, new Rook  (board, ChessPiece.Color.WHITE));
        board.putPiece('d', 1, new King  (board, ChessPiece.Color.WHITE));
        board.putPiece('a', 2, new Pawn  (board, ChessPiece.Color.WHITE));
        board.putPiece('b', 2, new Pawn  (board, ChessPiece.Color.WHITE));
        board.putPiece('c', 2, new Pawn  (board, ChessPiece.Color.WHITE));
        board.putPiece('d', 2, new Pawn  (board, ChessPiece.Color.WHITE));
        
        // place black pieces
        board.putPiece('d', 8, new Queen (board, ChessPiece.Color.BLACK));
        board.putPiece('c', 8, new Bishop(board, ChessPiece.Color.BLACK));
        board.putPiece('b', 8, new Rook  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', 8, new King  (board, ChessPiece.Color.BLACK));
        board.putPiece('d', 7, new Pawn  (board, ChessPiece.Color.BLACK));
        board.putPiece('c', 7, new Pawn  (board, ChessPiece.Color.BLACK));
        board.putPiece('b', 7, new Pawn  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', 7, new Pawn  (board, ChessPiece.Color.BLACK));
        
        return board;
    }
    
}
