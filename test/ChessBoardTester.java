import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.Move;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.SimpleMove;
import nullpointerexception.flexichess.Square;

public class ChessBoardTester extends ChessPieceTester {
	
	private class ChessPieceComparator implements Comparator<ChessPiece> {
		@Override
		public int compare(ChessPiece p1, ChessPiece p2) {
			return p1.position().toString().compareTo(p2.position().toString());
		}	
	}
	
	private List<ChessPiece> sortPieces(List<ChessPiece> pieces) {
		pieces.sort(new ChessPieceComparator());
		return pieces;
	}
	
	@Test
	public void isideBoard() {
		ChessBoard board = new ChessBoard(3, 6, 
				new Square('b', 1), new Square('b', 6));
		System.out.println(board);
		assertTrue(board.isInsideBoard('a', 1));
		assertTrue(board.isInsideBoard('b', 2));
		assertTrue(board.isInsideBoard('c', 3));
		assertFalse(board.isInsideBoard('a', 0));
		assertFalse(board.isInsideBoard('a', 7));
		assertFalse(board.isInsideBoard('d', 1));
		assertFalse(board.isInsideBoard('d', 6));
		assertFalse(board.isInsideBoard('x', 1));
		assertFalse(board.isInsideBoard(' ', 3));
	}
	
	@Test
	public void piecesList() {
		ChessBoard board = new ChessBoard(3, 6, 
				new Square('b', 1), new Square('b', 6));
		Pawn whitePawn1 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 1);
		Pawn whitePawn2 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 2);
		Pawn whitePawn3 = new Pawn(board, ChessPiece.Color.WHITE, 'b', 2);
		Pawn whitePawn4 = new Pawn(board, ChessPiece.Color.WHITE, 'c', 2);
		Pawn whitePawn5 = new Pawn(board, ChessPiece.Color.WHITE, 'c', 1);
		
		Pawn blackPawn1 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 6);
		Pawn blackPawn2 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 5);
		Pawn blackPawn3 = new Pawn(board, ChessPiece.Color.BLACK, 'b', 5);
		Pawn blackPawn4 = new Pawn(board, ChessPiece.Color.BLACK, 'c', 5);
		Pawn blackPawn5 = new Pawn(board, ChessPiece.Color.BLACK, 'c', 6);
		
		assertEquals(
				Arrays.asList(
					whitePawn1,
					whitePawn2,
					board.king(ChessPiece.Color.WHITE),
					whitePawn3,					
					whitePawn5,
					whitePawn4
				), 
				sortPieces(board.onBoardPieces(ChessPiece.Color.WHITE)));
		
		assertEquals(
				Arrays.asList(
					blackPawn2,
					blackPawn1,
					blackPawn3,
					board.king(ChessPiece.Color.BLACK),										
					blackPawn4,
					blackPawn5
				), 
				sortPieces(board.onBoardPieces(ChessPiece.Color.BLACK)));
		
		assertEquals(
				Arrays.asList(
					whitePawn1,
					whitePawn2,
					blackPawn2,
					blackPawn1,
					board.king(ChessPiece.Color.WHITE),
					whitePawn3,
					blackPawn3,
					board.king(ChessPiece.Color.BLACK),										
					whitePawn5,
					whitePawn4,
					blackPawn4,
					blackPawn5
				), 
				sortPieces(board.onBoardPieces()));
	}
	
	@Test
	public void gamePlay() {
		ChessBoard board = new ChessBoard(3, 6, 
				new Square('b', 1), new Square('b', 6));
		Pawn whitePawn1 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 1);
		Pawn whitePawn2 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 2);
		Pawn whitePawn3 = new Pawn(board, ChessPiece.Color.WHITE, 'b', 2);
		Pawn whitePawn4 = new Pawn(board, ChessPiece.Color.WHITE, 'c', 2);
		Pawn whitePawn5 = new Pawn(board, ChessPiece.Color.WHITE, 'c', 1);
		
		Pawn blackPawn1 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 6);
		Pawn blackPawn2 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 5);
		Pawn blackPawn3 = new Pawn(board, ChessPiece.Color.BLACK, 'b', 5);
		Pawn blackPawn4 = new Pawn(board, ChessPiece.Color.BLACK, 'c', 5);
		Pawn blackPawn5 = new Pawn(board, ChessPiece.Color.BLACK, 'c', 6);


		assertEquals(
				new HashSet<Square>(Arrays.asList(
					new Square('a', 1),
					new Square('a', 2),
					new Square('a', 3),
					new Square('b', 2),
					new Square('b', 3),
					new Square('c', 1),
					new Square('c', 2),
					new Square('c', 3)
				)),
				board.threatenedBy(ChessPiece.Color.WHITE));

		assertEquals(
				Arrays.asList(
					new SimpleMove(whitePawn2, new Square('a', 3)),
					new SimpleMove(whitePawn2, new Square('a', 4)),
					new SimpleMove(whitePawn3, new Square('b', 3)),
					new SimpleMove(whitePawn3, new Square('b', 4)),
					new SimpleMove(whitePawn4, new Square('c', 3)),
					new SimpleMove(whitePawn4, new Square('c', 4))
				),
				sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertEquals(
				new HashSet<Square>(Arrays.asList(
					new Square('a', 1), 
					new Square('a', 2), 
					new Square('a', 3),
					new Square('b', 2),
					new Square('b', 3), 
					new Square('c', 1),
					new Square('c', 2),
					new Square('c', 3) 
				)), 
				board.threatenedBy(ChessPiece.Color.WHITE));
		
		assertEquals(
				Arrays.asList(
					new SimpleMove(whitePawn2, new Square('a', 3)),
					new SimpleMove(whitePawn2, new Square('a', 4)),
					new SimpleMove(whitePawn3, new Square('b', 3)),
					new SimpleMove(whitePawn3, new Square('b', 4)),
					new SimpleMove(whitePawn4, new Square('c', 3)),
					new SimpleMove(whitePawn4, new Square('c', 4))
				), 
				sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		System.out.println(board);
		assertEquals(
				new HashSet<Square>(Arrays.asList(
					new Square('a', 4),
					new Square('a', 5), 
					new Square('a', 6),
					new Square('b', 4), 
					new Square('b', 5), 
					new Square('c', 4), 
					new Square('c', 5),
					new Square('c', 6)
				)), 
				board.threatenedBy(ChessPiece.Color.BLACK));
		
		assertEquals(
				Arrays.asList(
					new SimpleMove(blackPawn2, new Square('a', 3)),
					new SimpleMove(blackPawn2, new Square('a', 4)),
					new SimpleMove(blackPawn3, new Square('b', 3)),
					new SimpleMove(blackPawn3, new Square('b', 4)),
					new SimpleMove(blackPawn4, new Square('c', 3)),
					new SimpleMove(blackPawn4, new Square('c', 4))
				), 
				sortMoves(board.validMovesFor(ChessPiece.Color.BLACK)));
		
		Move move = sortMoves(whitePawn3.validMoves()).get(1);
		move.executeOnBoard(board);
		move = sortMoves(whitePawn3.validMoves()).get(0);
		move.executeOnBoard(board);

		assertEquals(
				new HashSet<Square>(Arrays.asList(
					new Square('a', 1),
					new Square('a', 2),
					new Square('b', 2),
					new Square('b', 3),
					new Square('b', 6),
					new Square('c', 1),
					new Square('c', 2)
				)),
				board.threatenedBy(ChessPiece.Color.WHITE));

		assertEquals(
				Arrays.asList(
					new SimpleMove(board.king(ChessPiece.Color.WHITE), new Square('b', 2)),
					new SimpleMove(whitePawn2, new Square('a', 3)),
					new SimpleMove(whitePawn2, new Square('a', 4)),
					new SimpleMove(whitePawn4, new Square('c', 3)),
					new SimpleMove(whitePawn4, new Square('c', 4))
				),
				sortMoves(board.validMovesFor(ChessPiece.Color.WHITE)));

		assertEquals(
				new HashSet<Square>(Arrays.asList(
					new Square('a', 4),
					new Square('a', 5),
					new Square('a', 6),
					new Square('b', 4),
					new Square('b', 5),
					new Square('c', 4),
					new Square('c', 5),
					new Square('c', 6)
				)),
				board.threatenedBy(ChessPiece.Color.BLACK));

		assertEquals(
				Arrays.asList(
					new SimpleMove(board.king(ChessPiece.Color.BLACK), new Square('a', 5))
				), 
				board.validMovesFor(ChessPiece.Color.BLACK));
	}
}

