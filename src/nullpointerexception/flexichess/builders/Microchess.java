package nullpointerexception.flexichess.builders;

import nullpointerexception.flexichess.Bishop;
import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Knight;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;

public class Microchess implements ChessGameBuilder {

    private final int COLUMNS = 4;
    private final int ROWS = 5;
    
    @Override
    public ChessBoard board() {
        ChessBoard board = new ChessBoard(COLUMNS, ROWS);
        
        // place white pieces
        board.putPiece('a', 1, new Rook (board, ChessPiece.Color.WHITE));
        board.putPiece('b', 1, new Bishop(board, ChessPiece.Color.WHITE));
        board.putPiece('c', 1, new Knight(board, ChessPiece.Color.WHITE));
        board.putPiece('d', 1, new King  (board, ChessPiece.Color.WHITE));
        board.putPiece('d', 2, new Pawn  (board, ChessPiece.Color.WHITE));
        
        // place black pieces
        board.putPiece('d', 5, new Rook (board, ChessPiece.Color.BLACK));
        board.putPiece('c', 5, new Bishop(board, ChessPiece.Color.BLACK));
        board.putPiece('b', 5, new Rook  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', 5, new King  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', 4, new Pawn  (board, ChessPiece.Color.BLACK));
        
        return board;
    }
    
}
