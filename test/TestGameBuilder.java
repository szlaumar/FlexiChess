import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;
import nullpointerexception.flexichess.builders.ChessGameBuilder;

public class TestGameBuilder implements ChessGameBuilder {

	@Override
	public ChessBoard board() {
		ChessBoard board = new ChessBoard(3, 4);
		
		new Rook(board, ChessPiece.Color.WHITE, 'a', 1);
		new Queen(board, ChessPiece.Color.WHITE, 'b', 1);
		new King(board, ChessPiece.Color.WHITE, 'c', 1);
		
		new Pawn(board, ChessPiece.Color.WHITE, 'a', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'b', 2);
		new Pawn(board, ChessPiece.Color.WHITE, 'c', 2);
		
		new Pawn(board, ChessPiece.Color.BLACK, 'a', 3);
		new Pawn(board, ChessPiece.Color.BLACK, 'b', 3);
		new Pawn(board, ChessPiece.Color.BLACK, 'c', 3);
		
		new Rook(board, ChessPiece.Color.BLACK, 'a', 4);
		new Queen(board, ChessPiece.Color.BLACK, 'b', 4);
		new King(board, ChessPiece.Color.BLACK, 'c', 4);
		
		return board;
	}
	
}