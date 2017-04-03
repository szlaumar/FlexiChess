import java.util.Comparator;
import java.util.List;

import nullpointerexception.flexichess.Move;
import nullpointerexception.flexichess.Square;

public abstract class ChessPieceTester {
	
	protected List<Move> sortMoves(List<Move> moves) {
		moves.sort(new MoveComparator());
		return moves;
	}
	
	protected List<Square> sortSquares(List<Square> squares) {
		squares.sort(new SquareComparator());
		return squares;
	}
	
	private class MoveComparator implements Comparator<Move> {
		@Override
		public int compare(Move m1, Move m2) {
			return m1.notation().compareTo(m2.notation());
		}	
	}
	
	private class SquareComparator implements Comparator<Square> {
		@Override
		public int compare(Square sq1, Square sq2) {
			return sq1.toString().compareTo(sq2.toString());
		}	
	}
}