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
        board.putPiece('d', ROWS, new Rook  (board, ChessPiece.Color.BLACK));
        board.putPiece('c', ROWS, new Bishop(board, ChessPiece.Color.BLACK));
        board.putPiece('b', ROWS, new Knight(board, ChessPiece.Color.BLACK));
        board.putPiece('a', ROWS, new King  (board, ChessPiece.Color.BLACK));
        board.putPiece('a', ROWS - 1, new Pawn  (board, ChessPiece.Color.BLACK));
        
        return board;
    }
    
}
