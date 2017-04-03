import static org.junit.Assert.*;

import org.junit.Test;

import nullpointerexception.flexichess.Bishop;
import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.King;
import nullpointerexception.flexichess.Knight;
import nullpointerexception.flexichess.Pawn;
import nullpointerexception.flexichess.Queen;
import nullpointerexception.flexichess.Rook;
import nullpointerexception.flexichess.Square;

public class TestPieceTester extends ChessPieceTester {

	@Test
	public void color() {
		assertEquals(ChessPiece.Color.BLACK, ChessPiece.Color.WHITE.opposite());
		assertEquals(ChessPiece.Color.WHITE, ChessPiece.Color.BLACK.opposite());
	}
	
	@Test
	public void canBeCaptured() {
		ChessBoard board = new ChessBoard(3, 3, 
				new Square('b', 1), new Square('b', 3));
		Bishop bishop = new Bishop(board, ChessPiece.Color.WHITE);
		King king = new King(board, ChessPiece.Color.WHITE);
		Knight knight = new Knight(board, ChessPiece.Color.WHITE);
		Pawn pawn = new Pawn(board, ChessPiece.Color.WHITE);
		Queen queen = new Queen(board, ChessPiece.Color.WHITE);
		Rook rook = new Rook(board, ChessPiece.Color.WHITE);
		
		assertTrue(bishop.canBeCaptured());
		assertFalse(king.canBeCaptured());
		assertTrue(knight.canBeCaptured());
		assertTrue(pawn.canBeCaptured());
		assertTrue(queen.canBeCaptured());
		assertTrue(rook.canBeCaptured());
	}
	
	@Test
	public void moveCounter() {
		ChessBoard board = new ChessBoard(3, 3, 
				new Square('b', 1), new Square('b', 3));
		ChessPiece whiteTest = new TestPiece(board, ChessPiece.Color.WHITE, 'c', 2);
		ChessPiece blackTest = new TestPiece(board, ChessPiece.Color.BLACK, 'a', 2);
				
		assertSame(0, blackTest.moveCounter());
		assertSame(0, whiteTest.moveCounter());
		
		blackTest.incrementMoveCounter();
		whiteTest.incrementMoveCounter();
		
		assertSame(1, blackTest.moveCounter());
		assertSame(1, whiteTest.moveCounter());
		
		blackTest.decrementMoveCounter();
		whiteTest.decrementMoveCounter();
		
		assertSame(0, blackTest.moveCounter());
		assertSame(0, whiteTest.moveCounter());
	}
}
