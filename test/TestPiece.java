import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;

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
}