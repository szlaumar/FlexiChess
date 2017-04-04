import java.util.Collections;
import java.util.List;

import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.ChessPieceVisitor;
import nullpointerexception.flexichess.Move;
import nullpointerexception.flexichess.Square;

public class TestPiece extends ChessPiece {

	public TestPiece(ChessBoard board, Color color) {
		super(board, color);
	}

	public TestPiece(ChessBoard board, Color color, char column, int row) {
		super(board, color, column, row);
	}

	@Override
	public char letter() {
		return 'T';
	}
	
	@Override
	public List<Move> validMoves() {
		return Collections.emptyList();
	}

	@Override
	public List<Square> threatens() {
		return Collections.emptyList();
	}

	@Override
	public boolean canBeCaptured() {
		return true;
	}

	@Override
	public <T> T accept(ChessPieceVisitor<T> visitor) {
		return null;
	}
}
