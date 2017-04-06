package nullpointerexception.flexichess.classic;

import nullpointerexception.flexichess.game.ChessBoard;
import nullpointerexception.flexichess.game.ChessGameRules;
import nullpointerexception.flexichess.game.ChessPiece;
import nullpointerexception.flexichess.game.King;
import nullpointerexception.flexichess.game.Square;

public class ClassicChessRules extends ChessGameRules {

	public ClassicChessRules() {
		super(
			8, 8, 
			new Square("e1"), new Square("e8"), 
			true, true, true, 2, -3
		);	
	}
		
	@Override
	public void setUpPieces(ChessBoard board) {
		new Rook(board, ChessPiece.Color.WHITE, 'a', 1);
		new Knight(board, ChessPiece.Color.WHITE, 'b', 1);
		new Bishop(board, ChessPiece.Color.WHITE, 'c', 1);
		new Queen(board, ChessPiece.Color.WHITE, 'd', 1);
		new King(board, ChessPiece.Color.WHITE, 'e', 1);
		new Bishop(board, ChessPiece.Color.WHITE, 'f', 1);
		new Knight(board, ChessPiece.Color.WHITE, 'g', 1);
		new Rook(board, ChessPiece.Color.WHITE, 'h', 1);
		
		new Pawn(board, ChessPiece.Color.WHITE, 'a', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'b', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'c', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'd', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'e', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'f', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'g', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'h', 2);
		
		new Pawn(board, ChessPiece.Color.BLACK, 'a', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'b', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'c', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'd', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'e', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'f', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'g', 7);
		new Pawn(board, ChessPiece.Color.BLACK, 'h', 7);
		
		new Rook(board, ChessPiece.Color.BLACK, 'a', 8);
		new Knight(board, ChessPiece.Color.BLACK, 'b', 8);
		new Bishop(board, ChessPiece.Color.BLACK, 'c', 8);
		new Queen(board, ChessPiece.Color.BLACK, 'd', 8);
		new King(board, ChessPiece.Color.BLACK, 'e', 8);
		new Bishop(board, ChessPiece.Color.BLACK, 'f', 8);
		new Knight(board, ChessPiece.Color.BLACK, 'g', 8);
		new Rook(board, ChessPiece.Color.BLACK, 'h', 8);
	}
}
