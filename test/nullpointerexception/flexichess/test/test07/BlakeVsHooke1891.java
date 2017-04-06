package nullpointerexception.flexichess.test.test07;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.List;

import nullpointerexception.flexichess.game.ChessBoard;
import nullpointerexception.flexichess.game.ChessPiece;
import nullpointerexception.flexichess.game.SimpleMove;
import nullpointerexception.flexichess.game.Square;
import nullpointerexception.flexichess.game.Move;
import nullpointerexception.flexichess.classic.ClassicChessRules;

public class BlakeVsHooke1891 {

	private ChessBoard board;
	private List<Move> sortMoves(List<Move> moves) {
		moves.sort(new MoveComparator());
			return moves;
	}

	private class MoveComparator implements Comparator<Move> {
		@Override
		public int compare(Move m1, Move m2) {
			return m1.notation().compareTo(m2.notation());
		}
	}

	public BlakeVsHooke1891() {
		board = new ChessBoard(new ClassicChessRules());
	}

	private Set<Square> squareSet(String... coords) {
		Set<Square> result = new HashSet<Square>();
		for(String str : coords) {
			result.add(new Square(str));
		}
		return result;
	}

	@Test
	public void test() {
		startPosition();
		move00();
		move01();
		move02();
		move03();
		move04();
		move05();
		move06();
		move07();
		move08();
		move09();
		move10();
		move11();
		move12();
		move13();
		move14();
		move15();
		move16();
		move17();
		move18();
		move19();
		move20();
		move21();
		move22();
	}

	public void startPosition() {
		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 4)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 4)),
				new SimpleMove(board.pieceAt('e', 2), new Square('e', 3)),
				new SimpleMove(board.pieceAt('e', 2), new Square('e', 4)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('b', 1), new Square('a', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)),
				new SimpleMove(board.pieceAt('g', 1), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 1), new Square('h', 3))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}


	// Move 0: WHITE Pe2-e4
	public void move00() {
		new SimpleMove(
			board.pieceAt('e', 2), new Square('e', 4)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 7), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 7), new Square('d', 6)),
				new SimpleMove(board.pieceAt('e', 7), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('h', 6))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 1: BLACK Pe7-e5
	public void move01() {
		new SimpleMove(
			board.pieceAt('e', 7), new Square('e', 5)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a6", "b3", "b5", "c3", "c4", "d3", "d5", "e2", "e3", "f3", "f5", "g3", "g4", "h3", "h5"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('f', 1), new Square('a', 6)),
				new SimpleMove(board.pieceAt('f', 1), new Square('b', 5)),
				new SimpleMove(board.pieceAt('f', 1), new Square('c', 4)),
				new SimpleMove(board.pieceAt('f', 1), new Square('d', 3)),
				new SimpleMove(board.pieceAt('f', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 4)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('d', 1), new Square('f', 3)),
				new SimpleMove(board.pieceAt('d', 1), new Square('g', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('h', 5)),
				new SimpleMove(board.pieceAt('b', 1), new Square('a', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)),
				new SimpleMove(board.pieceAt('g', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('g', 1), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 1), new Square('h', 3))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 2: WHITE Sg1-f3
	public void move02() {
		new SimpleMove(
			board.pieceAt('g', 1), new Square('f', 3)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a3", "a6", "b4", "b6", "c5", "c6", "d4", "d6", "e6", "e7", "f4", "f6", "g5", "g6", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('f', 8), new Square('a', 3)),
				new SimpleMove(board.pieceAt('f', 8), new Square('b', 4)),
				new SimpleMove(board.pieceAt('f', 8), new Square('c', 5)),
				new SimpleMove(board.pieceAt('f', 8), new Square('d', 6)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 7), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 7), new Square('d', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('g', 5)),
				new SimpleMove(board.pieceAt('d', 8), new Square('h', 4)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('g', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('h', 6))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 3: BLACK Pd7-d6
	public void move03() {
		new SimpleMove(
			board.pieceAt('d', 7), new Square('d', 6)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a6", "b3", "b5", "c3", "c4", "d3", "d4", "d5", "e2", "e3", "e5", "f5", "g1", "g3", "g5", "h3", "h4"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('f', 1), new Square('a', 6)),
				new SimpleMove(board.pieceAt('f', 1), new Square('b', 5)),
				new SimpleMove(board.pieceAt('f', 1), new Square('c', 4)),
				new SimpleMove(board.pieceAt('f', 1), new Square('d', 3)),
				new SimpleMove(board.pieceAt('f', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 4)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('b', 1), new Square('a', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 4: WHITE Bf1-c4
	public void move04() {
		new SimpleMove(
			board.pieceAt('f', 1), new Square('c', 4)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a6", "b6", "c5", "c6", "d4", "d7", "e6", "e7", "f4", "f5", "f6", "g4", "g5", "g6", "h3", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('c', 8), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 8), new Square('f', 5)),
				new SimpleMove(board.pieceAt('c', 8), new Square('g', 4)),
				new SimpleMove(board.pieceAt('c', 8), new Square('h', 3)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('g', 5)),
				new SimpleMove(board.pieceAt('d', 8), new Square('h', 4)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('g', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('g', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('h', 6))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 5: BLACK Pf7-f5
	public void move05() {
		new SimpleMove(
			board.pieceAt('f', 7), new Square('f', 5)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a6", "b3", "b5", "c3", "d3", "d4", "d5", "e2", "e3", "e5", "e6", "f1", "f5", "f7", "g1", "g3", "g5", "g8", "h3", "h4"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 4), new Square('a', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 2)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 1)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)),
				new SimpleMove(board.pieceAt('c', 4), new Square('g', 8)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 2), new Square('d', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('b', 1), new Square('a', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 6: WHITE Pd2-d4
	public void move06() {
		new SimpleMove(
			board.pieceAt('d', 2), new Square('d', 4)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a6", "b6", "c5", "c6", "d4", "d7", "e4", "e6", "e7", "f4", "f6", "f7", "g4", "g5", "g6", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('c', 8), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('e', 5), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('e', 4)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('g', 5)),
				new SimpleMove(board.pieceAt('d', 8), new Square('h', 4)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('g', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('g', 8), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 8), new Square('h', 6))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 7: BLACK Sg8-f6
	public void move07() {
		new SimpleMove(
			board.pieceAt('g', 8), new Square('f', 6)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a6", "b3", "b5", "c3", "c5", "d2", "d3", "d5", "e2", "e3", "e5", "e6", "f1", "f4", "f5", "f7", "g1", "g3", "g5", "g8", "h3", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('c', 1), new Square('g', 5)),
				new SimpleMove(board.pieceAt('c', 1), new Square('h', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('a', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 2)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 1)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)),
				new SimpleMove(board.pieceAt('c', 4), new Square('g', 8)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('d', 1), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('b', 1), new Square('a', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('c', 3)),
				new SimpleMove(board.pieceAt('b', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 8: WHITE Sb1-c3
	public void move08() {
		new SimpleMove(
			board.pieceAt('b', 1), new Square('c', 3)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a6", "b6", "c5", "c6", "d4", "d5", "d7", "e4", "e6", "e7", "f4", "f7", "g4", "g6", "g8", "h5", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('c', 8), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('e', 5), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('e', 4)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('h', 8), new Square('g', 8)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('f', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('d', 7)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 4)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 6), new Square('h', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('e', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 9: BLACK Pe5-xd4
	public void move09() {
		new SimpleMove(
			board.pieceAt('e', 5), new Square('d', 4)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a4", "a6", "b1", "b3", "b5", "d2", "d3", "d4", "d5", "e2", "e3", "e5", "e6", "f1", "f4", "f5", "f7", "g1", "g3", "g5", "g8", "h3", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('c', 1), new Square('g', 5)),
				new SimpleMove(board.pieceAt('c', 1), new Square('h', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('a', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 2)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 1)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)),
				new SimpleMove(board.pieceAt('c', 4), new Square('g', 8)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('d', 1), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('d', 1), new Square('d', 4)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('a', 4)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('e', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 10: WHITE Qd1-xd4
	public void move10() {
		new SimpleMove(
			board.pieceAt('d', 1), new Square('d', 4)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a6", "b6", "c5", "c6", "d5", "d7", "e4", "e5", "e6", "e7", "f7", "g4", "g6", "g8", "h5", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('c', 8), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('e', 4)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 5)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('h', 8), new Square('g', 8)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('d', 7)),
				new SimpleMove(board.pieceAt('f', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('d', 7)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 4)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 6), new Square('h', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('e', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 11: BLACK Bc8-d7
	public void move11() {
		new SimpleMove(
			board.pieceAt('c', 8), new Square('d', 7)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a4", "a6", "a7", "b1", "b3", "b5", "b6", "c5", "d1", "d2", "d3", "d5", "d6", "e2", "e3", "e5", "e6", "f1", "f4", "f5", "f6", "f7", "g1", "g3", "g5", "g8", "h3", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('c', 1), new Square('g', 5)),
				new SimpleMove(board.pieceAt('c', 1), new Square('h', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('a', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 2)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 1)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)),
				new SimpleMove(board.pieceAt('c', 4), new Square('g', 8)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('b', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('c', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 1)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 2)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('a', 7)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('f', 6)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('a', 4)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('e', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 12: WHITE Sf3-g5
	public void move12() {
		new SimpleMove(
			board.pieceAt('f', 3), new Square('g', 5)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a4", "a6", "b5", "b6", "c5", "c6", "c8", "d5", "e4", "e5", "e6", "e7", "f7", "g4", "g6", "g8", "h5", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('d', 7), new Square('a', 4)),
				new SimpleMove(board.pieceAt('d', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('d', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 7), new Square('c', 8)),
				new SimpleMove(board.pieceAt('d', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 5)),
				new SimpleMove(board.pieceAt('a', 7), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 5)),
				new SimpleMove(board.pieceAt('b', 7), new Square('b', 6)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 5)),
				new SimpleMove(board.pieceAt('c', 7), new Square('c', 6)),
				new SimpleMove(board.pieceAt('d', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 5), new Square('e', 4)),
				new SimpleMove(board.pieceAt('g', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('h', 7), new Square('h', 6)),
				new SimpleMove(board.pieceAt('d', 8), new Square('c', 8)),
				new SimpleMove(board.pieceAt('d', 8), new Square('e', 7)),
				new SimpleMove(board.pieceAt('h', 8), new Square('g', 8)),
				new SimpleMove(board.pieceAt('b', 8), new Square('a', 6)),
				new SimpleMove(board.pieceAt('b', 8), new Square('c', 6)),
				new SimpleMove(board.pieceAt('f', 6), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 4)),
				new SimpleMove(board.pieceAt('f', 6), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 6), new Square('h', 5)),
				new SimpleMove(board.pieceAt('f', 6), new Square('e', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertFalse(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 13: BLACK Sb8-c6
	public void move13() {
		new SimpleMove(
			board.pieceAt('b', 8), new Square('c', 6)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a4", "a6", "a7", "b1", "b3", "b5", "b6", "c5", "d1", "d2", "d3", "d5", "d6", "e2", "e3", "e5", "e6", "f1", "f3", "f4", "f5", "f6", "f7", "g1", "g3", "g8", "h3", "h7"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('c', 4), new Square('a', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('c', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 2)),
				new SimpleMove(board.pieceAt('c', 4), new Square('e', 6)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 1)),
				new SimpleMove(board.pieceAt('c', 4), new Square('f', 7)),
				new SimpleMove(board.pieceAt('c', 4), new Square('g', 8)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('b', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('c', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 1)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 2)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('a', 7)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('f', 6)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('a', 4)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('e', 2)),
				new SimpleMove(board.pieceAt('g', 5), new Square('e', 6)),
				new SimpleMove(board.pieceAt('g', 5), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('f', 7)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 7))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 14: WHITE Bc4-f7
	public void move14() {
		new SimpleMove(
			board.pieceAt('c', 4), new Square('f', 7)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a5", "a6", "b4", "b6", "b8", "c5", "c8", "d4", "d5", "e4", "e5", "e6", "e7", "f7", "g4", "g6", "g8", "h5", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('e', 8), new Square('e', 7))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertTrue(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 15: BLACK Ke8-e7
	public void move15() {
		new SimpleMove(
			board.pieceAt('e', 8), new Square('e', 7)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a4", "a7", "b1", "b3", "b4", "b5", "b6", "c4", "c5", "d1", "d2", "d3", "d5", "d6", "e2", "e3", "e5", "e6", "e8", "f1", "f3", "f4", "f5", "f6", "g1", "g3", "g6", "g8", "h3", "h5", "h7"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 7), new Square('b', 3)),
				new SimpleMove(board.pieceAt('f', 7), new Square('c', 4)),
				new SimpleMove(board.pieceAt('f', 7), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('a', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('b', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('b', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('c', 4)),
				new SimpleMove(board.pieceAt('d', 4), new Square('c', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 1)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 2)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 3)),
				new SimpleMove(board.pieceAt('d', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('d', 4), new Square('a', 7)),
				new SimpleMove(board.pieceAt('d', 4), new Square('d', 6)),
				new SimpleMove(board.pieceAt('d', 4), new Square('f', 6)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('a', 4)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('e', 2)),
				new SimpleMove(board.pieceAt('g', 5), new Square('e', 6)),
				new SimpleMove(board.pieceAt('g', 5), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 7))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 16: WHITE Qd4-xf6
	public void move16() {
		new SimpleMove(
			board.pieceAt('d', 4), new Square('f', 6)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a5", "a6", "b4", "b6", "b8", "c5", "c8", "d4", "e4", "e5", "e6", "e8", "f6", "f7", "g4", "g6", "g8", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('e', 7), new Square('f', 6)),
				new SimpleMove(board.pieceAt('g', 7), new Square('f', 6))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertTrue(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 17: BLACK Ke7-xf6
	public void move17() {
		new SimpleMove(
			board.pieceAt('e', 7), new Square('f', 6)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "a4", "b1", "b3", "b5", "c4", "d1", "d2", "d3", "d5", "e2", "e3", "e6", "e8", "f1", "f3", "f4", "f5", "g1", "g3", "g6", "g8", "h3", "h5", "h7"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 7), new Square('b', 3)),
				new SimpleMove(board.pieceAt('f', 7), new Square('c', 4)),
				new SimpleMove(board.pieceAt('f', 7), new Square('d', 5)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('e', 5)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('a', 4)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('b', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 1)),
				new SimpleMove(board.pieceAt('c', 3), new Square('d', 5)),
				new SimpleMove(board.pieceAt('c', 3), new Square('e', 2)),
				new SimpleMove(board.pieceAt('g', 5), new Square('e', 6)),
				new SimpleMove(board.pieceAt('g', 5), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 7))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 18: WHITE Sc3-d5
	public void move18() {
		new SimpleMove(
			board.pieceAt('c', 3), new Square('d', 5)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a5", "a6", "b4", "b6", "b8", "c5", "c8", "d4", "e4", "e5", "e6", "e7", "e8", "f7", "g4", "g5", "g6", "g8", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('f', 6), new Square('e', 5))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertTrue(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 19: BLACK Kf6-e5
	public void move19() {
		new SimpleMove(
			board.pieceAt('f', 6), new Square('e', 5)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "b1", "b3", "b4", "b6", "c3", "c7", "d1", "d2", "d3", "e2", "e3", "e6", "e7", "e8", "f1", "f3", "f4", "f5", "f6", "g1", "g3", "g6", "g8", "h3", "h5", "h7"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 4)),
				new SimpleMove(board.pieceAt('e', 4), new Square('f', 5)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 3)),
				new SimpleMove(board.pieceAt('f', 2), new Square('f', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('d', 5), new Square('b', 4)),
				new SimpleMove(board.pieceAt('d', 5), new Square('b', 6)),
				new SimpleMove(board.pieceAt('d', 5), new Square('c', 3)),
				new SimpleMove(board.pieceAt('d', 5), new Square('e', 3)),
				new SimpleMove(board.pieceAt('d', 5), new Square('e', 7)),
				new SimpleMove(board.pieceAt('d', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('d', 5), new Square('f', 6)),
				new SimpleMove(board.pieceAt('d', 5), new Square('c', 7)),
				new SimpleMove(board.pieceAt('g', 5), new Square('e', 6)),
				new SimpleMove(board.pieceAt('g', 5), new Square('f', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 3)),
				new SimpleMove(board.pieceAt('g', 5), new Square('h', 7))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 20: WHITE Sg5-f3
	public void move20() {
		new SimpleMove(
			board.pieceAt('g', 5), new Square('f', 3)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a5", "a6", "b4", "b6", "b8", "c5", "c8", "d4", "d5", "e4", "e6", "e7", "e8", "f4", "f6", "g4", "g5", "g6", "g8", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('e', 5), new Square('e', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertTrue(board.king(ChessPiece.Color.BLACK).isInCheck());
	}

	// Move 21: BLACK Ke5-xe4
	public void move21() {
		new SimpleMove(
			board.pieceAt('e', 5), new Square('e', 4)
		).executeOnBoard(board);

		// Threatened by WHITE
		assertEquals(
			squareSet("a3", "b1", "b3", "b4", "b6", "c3", "c7", "d1", "d2", "d3", "d4", "e2", "e3", "e5", "e6", "e7", "e8", "f1", "f4", "f6", "g1", "g3", "g5", "g6", "g8", "h3", "h4", "h5", "h6"),
			board.threatenedBy(ChessPiece.Color.WHITE)
		);

		// Valid moves for WHITE
		assertEquals(
			Arrays.asList(
				new SimpleMove(board.pieceAt('c', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('c', 1), new Square('e', 3)),
				new SimpleMove(board.pieceAt('c', 1), new Square('f', 4)),
				new SimpleMove(board.pieceAt('c', 1), new Square('g', 5)),
				new SimpleMove(board.pieceAt('c', 1), new Square('h', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('e', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 6)),
				new SimpleMove(board.pieceAt('f', 7), new Square('g', 8)),
				new SimpleMove(board.pieceAt('f', 7), new Square('h', 5)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 1)),
				new SimpleMove(board.pieceAt('e', 1), new Square('d', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('e', 2)),
				new SimpleMove(board.pieceAt('e', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 3)),
				new SimpleMove(board.pieceAt('a', 2), new Square('a', 4)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 3)),
				new SimpleMove(board.pieceAt('b', 2), new Square('b', 4)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 3)),
				new SimpleMove(board.pieceAt('c', 2), new Square('c', 4)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 3)),
				new SimpleMove(board.pieceAt('g', 2), new Square('g', 4)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 3)),
				new SimpleMove(board.pieceAt('h', 2), new Square('h', 4)),
				new SimpleMove(board.pieceAt('a', 1), new Square('b', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('f', 1)),
				new SimpleMove(board.pieceAt('h', 1), new Square('g', 1)),
				new SimpleMove(board.pieceAt('d', 5), new Square('b', 4)),
				new SimpleMove(board.pieceAt('d', 5), new Square('b', 6)),
				new SimpleMove(board.pieceAt('d', 5), new Square('c', 3)),
				new SimpleMove(board.pieceAt('d', 5), new Square('e', 3)),
				new SimpleMove(board.pieceAt('d', 5), new Square('e', 7)),
				new SimpleMove(board.pieceAt('d', 5), new Square('f', 4)),
				new SimpleMove(board.pieceAt('d', 5), new Square('f', 6)),
				new SimpleMove(board.pieceAt('d', 5), new Square('c', 7)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 2)),
				new SimpleMove(board.pieceAt('f', 3), new Square('d', 4)),
				new SimpleMove(board.pieceAt('f', 3), new Square('e', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 1)),
				new SimpleMove(board.pieceAt('f', 3), new Square('g', 5)),
				new SimpleMove(board.pieceAt('f', 3), new Square('h', 4))
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertFalse(board.king(ChessPiece.Color.WHITE).isInCheck());
	}

	// Move 22: WHITE Sd5-c3
	public void move22() {
		new SimpleMove(
			board.pieceAt('d', 5), new Square('c', 3)
		).executeOnBoard(board);

		// Threatened by BLACK
		assertEquals(
			squareSet("a5", "a6", "b4", "b6", "b8", "c5", "c8", "d3", "d4", "d5", "e3", "e5", "e6", "e7", "e8", "f3", "f4", "f6", "g4", "g5", "g6", "g8", "h4", "h6"),
			board.threatenedBy(ChessPiece.Color.BLACK)
		);

		// Valid moves for BLACK
		assertEquals(
			Arrays.asList(
		),
		sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));

		assertTrue(board.king(ChessPiece.Color.BLACK).isInCheck());
	}
}
