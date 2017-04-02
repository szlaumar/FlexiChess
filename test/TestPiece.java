import nullpointerexception.flexichess.*;

import java.util.List;

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
	public <T> T accept(ChessPieceVisitor<T> visitor) {
		return null;
	}

	@Override
	public boolean canBeCaptured() {
		return false;
	}

	@Override
	public List<Move> validMoves() {
		return null;
	}

	@Override
	public List<Square> threatens() {
		return null;
	}
}