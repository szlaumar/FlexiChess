package nullpointerexception.flexichess.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import nullpointerexception.flexichess.ChessBoard;
import nullpointerexception.flexichess.ChessBoardAsString;
import nullpointerexception.flexichess.ChessPiece;
import nullpointerexception.flexichess.Square;

public class Tester03 {
	 
	@Test
	public void chessPiece() {
		ChessPiece pieceW = new ChessPiece('W', ChessPiece.Color.WHITE);
		ChessPiece pieceB = new ChessPiece('B', ChessPiece.Color.BLACK);
		
		assertEquals(ChessPiece.Color.WHITE, pieceW.color());
		assertEquals('W', pieceW.letter());		
		assertEquals("+W", pieceW.symbol());
		assertTrue(pieceW.isOffBoard());
		try{ pieceW.square(); fail(); } catch(IllegalStateException e) {};
		assertEquals(pieceW.symbol(), pieceW.toString());
		
		assertEquals(ChessPiece.Color.BLACK, pieceB.color());		
		assertEquals('B', pieceB.letter());
		assertEquals("-B", pieceB.symbol());
		assertTrue(pieceB.isOffBoard());		
		try{ pieceB.square(); fail(); } catch(IllegalStateException e) {};
		assertEquals(pieceB.symbol(), pieceB.toString());
		
		try{ pieceW.setSquare(null); fail(); } catch(NullPointerException e) {};
		
		Square square = new Square('a', 1);
		pieceW.setSquare(square);
		assertSame(square, pieceW.square());
		pieceW.setOffBoard();		
		
		try{ pieceW.square(); fail(); } catch(IllegalStateException e) {};
	}
		
	@Test
	public void pieceAndSquare() {
		ChessPiece pieceW = new ChessPiece('W', ChessPiece.Color.WHITE);
		ChessPiece pieceB = new ChessPiece('B', ChessPiece.Color.BLACK);
		
		Square square = new Square('a', 1);
		assertSame('a', square.column());
		assertSame(1, square.row());
		
		assertTrue(square.isEmpty());
		try{ square.piece(); fail(); } catch(IllegalStateException e) {};
		try{ square.empty(); fail(); } catch(IllegalStateException e) {};
		
		square.putPiece(pieceW);
		assertSame(pieceW, square.piece());
		assertSame(square, pieceW.square());
		assertFalse(square.isEmpty());
		assertFalse(pieceW.isOffBoard());
		
		try{ square.putPiece(pieceB); fail(); } catch(IllegalStateException e) {};
		
		assertSame(pieceW, square.empty());
		assertTrue(square.isEmpty());
		assertTrue(pieceW.isOffBoard());
		
		try{ pieceW.square(); fail(); } catch(IllegalStateException e) {};		
		try{ square.piece(); fail(); } catch(IllegalStateException e) {};
	}
		
	@Test
	public void chessBoard() {
		ChessBoard board = new ChessBoard(3, 2);
		assertSame(3, board.columns());
		assertSame(2, board.rows());
		
		ChessPiece pieceA1 = new ChessPiece('P', ChessPiece.Color.WHITE);
		ChessPiece pieceA2 = new ChessPiece('Q', ChessPiece.Color.BLACK);
		ChessPiece pieceB1 = new ChessPiece('R', ChessPiece.Color.BLACK);
		ChessPiece pieceB2 = new ChessPiece('S', ChessPiece.Color.WHITE);
		ChessPiece pieceC1 = new ChessPiece('T', ChessPiece.Color.WHITE);
		ChessPiece pieceC2 = new ChessPiece('U', ChessPiece.Color.BLACK);
		
		try{ board.pieceAt('a', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.pieceAt('a', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.pieceAt('b', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.pieceAt('b', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.pieceAt('c', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.pieceAt('c', 2); fail(); } catch(IllegalStateException e) {};
		
		board.putPiece('a', 1, pieceA1);
		board.putPiece('a', 2, pieceA2);
		board.putPiece('b', 1, pieceB1);
		board.putPiece('b', 2, pieceB2);
		board.putPiece('c', 1, pieceC1);
		board.putPiece('c', 2, pieceC2);
		
		assertSame(pieceA1, board.pieceAt('a', 1));
		assertSame(pieceA2, board.pieceAt('a', 2));
		assertSame(pieceB1, board.pieceAt('b', 1));
		assertSame(pieceB2, board.pieceAt('b', 2));
		assertSame(pieceC1, board.pieceAt('c', 1));
		assertSame(pieceC2, board.pieceAt('c', 2));		
	}
	
	@Test
	public void boardAsString() {
		ChessBoard board = new ChessBoard(3, 2);
		ChessBoardAsString boardAsString = new ChessBoardAsString(board);
		
		board.putPiece('a', 1, new ChessPiece('P', ChessPiece.Color.WHITE));
		board.putPiece('a', 2, new ChessPiece('Q', ChessPiece.Color.BLACK));
		board.putPiece('b', 1, new ChessPiece('R', ChessPiece.Color.BLACK));
		board.putPiece('b', 2, new ChessPiece('S', ChessPiece.Color.WHITE));
		board.putPiece('c', 1, new ChessPiece('T', ChessPiece.Color.WHITE));
		board.putPiece('c', 2, new ChessPiece('U', ChessPiece.Color.BLACK));
				
		String expected = 
				"   ┌───┬───┬───┐\n" +
				" 2 │-Q │+S │-U │\n" +
				"   ├───┼───┼───┤\n" +
				" 1 │+P │-R │+T │\n" +
				"   └───┴───┴───┘\n" +
				"     a   b   c "; 
		assertEquals(expected, board.toString());
		assertEquals(expected, boardAsString.toString());
	}
	
	@Test
	public void silverman4x4() {
		ChessBoard board = new ChessBoard(4, 4);
		ChessBoardAsString boardAsString = new ChessBoardAsString(board);
		
		board.putPiece('a', 1, new ChessPiece('R', ChessPiece.Color.WHITE));
		board.putPiece('b', 1, new ChessPiece('Q', ChessPiece.Color.WHITE));
		board.putPiece('c', 1, new ChessPiece('K', ChessPiece.Color.WHITE));
		board.putPiece('d', 1, new ChessPiece('R', ChessPiece.Color.WHITE));
		
		board.putPiece('a', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
		board.putPiece('b', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
		board.putPiece('c', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
		board.putPiece('d', 2, new ChessPiece('p', ChessPiece.Color.WHITE));
		
		board.putPiece('a', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
		board.putPiece('b', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
		board.putPiece('c', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
		board.putPiece('d', 3, new ChessPiece('p', ChessPiece.Color.BLACK));
		
		board.putPiece('a', 4, new ChessPiece('R', ChessPiece.Color.BLACK));
		board.putPiece('b', 4, new ChessPiece('Q', ChessPiece.Color.BLACK));
		board.putPiece('c', 4, new ChessPiece('K', ChessPiece.Color.BLACK));
		board.putPiece('d', 4, new ChessPiece('R', ChessPiece.Color.BLACK));
		
		String expected = 
				"   ┌───┬───┬───┬───┐\n" + 
				" 4 │-R │-Q │-K │-R │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 3 │-p │-p │-p │-p │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 2 │+p │+p │+p │+p │\n" +
				"   ├───┼───┼───┼───┤\n" +
				" 1 │+R │+Q │+K │+R │\n" +
				"   └───┴───┴───┴───┘\n" +
				"     a   b   c   d "; 
		assertEquals(expected, board.toString());
		assertEquals(expected, boardAsString.toString());
	}
}