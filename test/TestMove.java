import nullpointerexception.flexichess.*;

public class TestMove implements Move {

	@Override
	public void executeOnBoard(ChessBoard board) {
				
	}

	@Override
	public void revertOnBoard(ChessBoard board) {
		
	}
	
	@Override
	public String notation() {
		return null;
	}

	@Override
	public void revertSingleMove(ChessBoard board) {

	}

	@Override
	public ChessPiece acceptPiece(PieceMoveVisitor visitor) {
		return null;
	}

	@Override
	public Square acceptToPosition(PieceMoveVisitor visitor) {
		return null;
	}
}
