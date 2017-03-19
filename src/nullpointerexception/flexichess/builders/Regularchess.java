package nullpointerexception.flexichess.builders;

import nullpointerexception.flexichess.Bishop;
import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Knight;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;

public class Regularchess implements ChessGameBuilder {

    private final int COLUMNS = 8;
    private final int ROWS = 8;
    
    
    @Override
    public ChessBoard board() {
        ChessBoard board = new ChessBoard(COLUMNS, ROWS);
        
        // place white pieces
        board.putPiece('a', 1, new Rook  (board, ChessPiece.Color.WHITE));
        board.putPiece('b', 1, new Knight(board, ChessPiece.Color.WHITE));
        board.putPiece('c', 1, new Bishop(board, ChessPiece.Color.WHITE));
        board.putPiece('d', 1, new Queen (board, ChessPiece.Color.WHITE));
        board.putPiece('e', 1, new King  (board, ChessPiece.Color.WHITE));
        board.putPiece('f', 1, new Bishop(board, ChessPiece.Color.WHITE));
        board.putPiece('g', 1, new Knight(board, ChessPiece.Color.WHITE));
        board.putPiece('h', 1, new Rook  (board, ChessPiece.Color.WHITE));
        
        for (int i = 0; i < COLUMNS; i++) {
            board.putPiece((char) ('a' + i), 2, 
                    new Pawn(board, ChessPiece.Color.WHITE));
        }
        
        // place black pieces
        board.putPiece('h', ROWS, new Rook  (board, ChessPiece.Color.BLACK));
        board.putPiece('g', ROWS, new Knight(board, ChessPiece.Color.BLACK));
        board.putPiece('f', ROWS, new Bishop(board, ChessPiece.Color.BLACK));
        board.putPiece('e', ROWS, new Queen (board, ChessPiece.Color.BLACK));
        board.putPiece('d', ROWS, new King  (board, ChessPiece.Color.BLACK));
        board.putPiece('c', ROWS, new Bishop(board, ChessPiece.Color.BLACK));
        board.putPiece('b', ROWS, new Knight(board, ChessPiece.Color.BLACK));
        board.putPiece('a', ROWS, new Rook  (board, ChessPiece.Color.BLACK));
        
        for (int i = 0; i < COLUMNS; i++) {
            board.putPiece((char) ('a' + i), ROWS - 1, 
                    new Pawn(board, ChessPiece.Color.BLACK));
        }
        
        return board;
    }
    
}
