import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.EmptyStackException;

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

public class ChessBoardTester {
	
	@Test
	public void square() {
		Square square1 = new Square('b', 12);
		Square square2 = new Square("b12");
		
		assertEquals('b', square1.column);
		assertEquals(12, square1.row);
		assertEquals('b', square2.column);
		assertEquals(12, square2.row);
		
		assertEquals(square1, square2);
		assertEquals(square1.hashCode(), square2.hashCode());
	}
	
	@Test
	public void chessPiece() {
		ChessBoard board = new ChessBoard(4, 3);
		
		ChessPiece pieceWOn = new TestPiece(board, ChessPiece.Color.WHITE, 'a', 1);
		ChessPiece pieceWOff = new TestPiece(board, ChessPiece.Color.WHITE);
		
		assertEquals(ChessPiece.Color.WHITE, pieceWOn.color());
		assertEquals(ChessPiece.Color.WHITE, pieceWOff.color());
		assertEquals('T', pieceWOn.letter());		
		assertEquals('T', pieceWOff.letter());
		assertEquals("+T", pieceWOn.symbol());
		assertEquals("+T", pieceWOff.symbol());
		assertEquals("+T", pieceWOn.toString());
		assertEquals("+T", pieceWOff.toString());
		assertEquals(pieceWOn.symbol(), pieceWOn.toString());
		assertEquals(pieceWOff.symbol(), pieceWOff.toString());
		assertFalse(pieceWOn.isOffBoard());
		assertTrue(pieceWOff.isOffBoard());		
		assertEquals(pieceWOn.position(), new Square('a', 1));
		try{ pieceWOff.position(); fail(); } catch(IllegalStateException e) {};				
		try{ pieceWOn.setPosition(null); fail(); } catch(NullPointerException e) {};
		try{ pieceWOff.setPosition(null); fail(); } catch(NullPointerException e) {};
		
		ChessPiece pieceBOn = new TestPiece(board, ChessPiece.Color.BLACK, 'b', 2);				
		ChessPiece pieceBOff = new TestPiece(board, ChessPiece.Color.BLACK);
		
		assertEquals(ChessPiece.Color.BLACK, pieceBOn.color());
		assertEquals(ChessPiece.Color.BLACK, pieceBOff.color());
		assertEquals('T', pieceBOn.letter());		
		assertEquals('T', pieceBOff.letter());
		assertEquals("-T", pieceBOn.symbol());
		assertEquals("-T", pieceBOff.symbol());
		assertEquals("-T", pieceBOn.toString());
		assertEquals("-T", pieceBOff.toString());
		assertEquals(pieceBOn.symbol(), pieceBOn.toString());
		assertEquals(pieceBOff.symbol(), pieceBOff.toString());
		assertFalse(pieceBOn.isOffBoard());
		assertTrue(pieceBOff.isOffBoard());		
		assertEquals(pieceBOn.position(), new Square('b', 2));
		try{ pieceBOff.position(); fail(); } catch(IllegalStateException e) {};
		try{ pieceBOn.setPosition(null); fail(); } catch(NullPointerException e) {};
		try{ pieceBOff.setPosition(null); fail(); } catch(NullPointerException e) {};
		
		Square square = new Square('a', 2);
		pieceWOff.setPosition(square);		
		assertSame(square, pieceWOff.position());
		assertFalse(pieceWOff.isOffBoard());		
		pieceWOff.setOffBoard();				
		try{ pieceWOff.position(); fail(); } catch(IllegalStateException e) {};
		assertTrue(pieceWOff.isOffBoard());
		
		pieceBOff.setPosition('a', 2);		
		assertEquals(square, pieceBOff.position());
		assertFalse(pieceBOff.isOffBoard());		
		pieceBOff.setOffBoard();				
		try{ pieceBOff.position(); fail(); } catch(IllegalStateException e) {};
		assertTrue(pieceBOff.isOffBoard());
	}
	
	@Test
	public void chessBoard() {
		ChessBoard board = new ChessBoard(6, 2);
		assertSame(6, board.columns());
		assertSame(2, board.rows());
		
		ChessPiece pieceA1 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 1);
		ChessPiece pieceB1 = new Knight(board, ChessPiece.Color.WHITE, 'b', 1);
		ChessPiece pieceC1 = new Bishop(board, ChessPiece.Color.WHITE, 'c', 1);
		ChessPiece pieceD1 = new Rook(board, ChessPiece.Color.WHITE, 'd', 1);
		ChessPiece pieceE1 = new Queen(board, ChessPiece.Color.WHITE, 'e', 1);
		ChessPiece pieceF1 = new King(board, ChessPiece.Color.WHITE, 'f', 1);
		
		ChessPiece pieceA2 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 2);
		ChessPiece pieceB2 = new Knight(board, ChessPiece.Color.BLACK, 'b', 2);
		ChessPiece pieceC2 = new Bishop(board, ChessPiece.Color.BLACK, 'c', 2);
		ChessPiece pieceD2 = new Rook(board, ChessPiece.Color.BLACK, 'd', 2);
		ChessPiece pieceE2 = new Queen(board, ChessPiece.Color.BLACK, 'e', 2);
		ChessPiece pieceF2 = new King(board, ChessPiece.Color.BLACK, 'f', 2);
		
		String expected =    
				"   ┌───┬───┬───┬───┬───┬───┐\n" +
				" 2 │-P │-S │-B │-R │-Q │-K │\n" +
				"   ├───┼───┼───┼───┼───┼───┤\n" +
				" 1 │+P │+S │+B │+R │+Q │+K │\n" +
				"   └───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, board.toString());
		
		assertSame(pieceA1, board.pieceAt('a', 1));
		assertSame(pieceB1, board.pieceAt('b', 1));
		assertSame(pieceC1, board.pieceAt('c', 1));
		assertSame(pieceD1, board.pieceAt('d', 1));
		assertSame(pieceE1, board.pieceAt('e', 1));
		assertSame(pieceF1, board.pieceAt('f', 1));
		
		assertSame(pieceA2, board.pieceAt('a', 2));
		assertSame(pieceB2, board.pieceAt('b', 2));
		assertSame(pieceC2, board.pieceAt('c', 2));
		assertSame(pieceD2, board.pieceAt('d', 2));
		assertSame(pieceE2, board.pieceAt('e', 2));
		assertSame(pieceF2, board.pieceAt('f', 2));		
	}
	
	@Test
	public void movingAndCapturig() {
		ChessBoard board = new ChessBoard(6, 2);
		
		ChessPiece pieceA1 = new Pawn(board, ChessPiece.Color.WHITE, 'a', 1);
		ChessPiece pieceB1 = new Knight(board, ChessPiece.Color.WHITE, 'b', 1);
		ChessPiece pieceC1 = new Bishop(board, ChessPiece.Color.WHITE, 'c', 1);
		ChessPiece pieceD1 = new Rook(board, ChessPiece.Color.WHITE, 'd', 1);
		ChessPiece pieceE1 = new Queen(board, ChessPiece.Color.WHITE, 'e', 1);
		ChessPiece pieceF1 = new King(board, ChessPiece.Color.WHITE, 'f', 1);
		
		ChessPiece pieceA2 = new Pawn(board, ChessPiece.Color.BLACK, 'a', 2);
		ChessPiece pieceB2 = new Knight(board, ChessPiece.Color.BLACK, 'b', 2);
		ChessPiece pieceC2 = new Bishop(board, ChessPiece.Color.BLACK, 'c', 2);
		ChessPiece pieceD2 = new Rook(board, ChessPiece.Color.BLACK, 'd', 2);
		ChessPiece pieceE2 = new Queen(board, ChessPiece.Color.BLACK, 'e', 2);
		ChessPiece pieceF2 = new King(board, ChessPiece.Color.BLACK, 'f', 2);
		
		board.capturePieceAt('a', 1);
		board.capturePieceAt('f', 2);
		board.capturePieceAt('b', 1);
		board.capturePieceAt('e', 2);
		board.capturePieceAt('c', 1);
		board.capturePieceAt('d', 2);
		
		String expected =    
				"   ┌───┬───┬───┬───┬───┬───┐\n" +
				" 2 │-P │-S │-B │   │   │   │\n" +
				"   ├───┼───┼───┼───┼───┼───┤\n" +
				" 1 │   │   │   │+R │+Q │+K │\n" +
				"   └───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f \n" +
				"W+: P S B\n" +
				"B-: K Q R";
		assertEquals(expected, board.toString());
		
		assertEquals(
				Arrays.asList(
						pieceA1, pieceF2, pieceB1,
						pieceE2, pieceC1, pieceD2),
				board.capturedPieces());
		assertEquals(
				Arrays.asList(
						pieceA1, pieceB1, pieceC1),
				board.capturedPieces(ChessPiece.Color.WHITE));
		assertEquals(
				Arrays.asList(
						pieceF2, pieceE2, pieceD2),
				board.capturedPieces(ChessPiece.Color.BLACK));
		
		board.moveTo('a', 2, 'f', 2);
		board.moveTo('b', 2, 'e', 2);
		board.moveTo('c', 2, 'd', 2);
		board.moveTo('f', 1, 'a', 1);
		board.moveTo('e', 1, 'b', 1);
		board.moveTo('d', 1, 'c', 1);
		
		expected =    
				"   ┌───┬───┬───┬───┬───┬───┐\n" +
				" 2 │   │   │   │-B │-S │-P │\n" +
				"   ├───┼───┼───┼───┼───┼───┤\n" +
				" 1 │+K │+Q │+R │   │   │   │\n" +
				"   └───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f \n" +
				"W+: P S B\n" +
				"B-: K Q R";
		assertEquals(expected, board.toString());
		
		try{ board.moveTo('a', 1, 'd', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.moveTo('b', 1, 'e', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.moveTo('c', 1, 'f', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.moveTo('a', 2, 'd', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.moveTo('b', 2, 'e', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.moveTo('c', 2, 'f', 1); fail(); } catch(IllegalStateException e) {};
		try{ board.capturePieceAt('a', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.capturePieceAt('b', 2); fail(); } catch(IllegalStateException e) {};
		try{ board.capturePieceAt('c', 2); fail(); } catch(IllegalStateException e) {};
		
		expected =    
				"   ┌───┬───┬───┬───┬───┬───┐\n" +
				" 2 │   │   │   │-B │-S │-P │\n" +
				"   ├───┼───┼───┼───┼───┼───┤\n" +
				" 1 │+K │+Q │+R │   │   │   │\n" +
				"   └───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f \n" +
				"W+: P S B\n" +
				"B-: K Q R";
		assertEquals(expected, board.toString());
		
		board.returnLastCapturedTo('a', 2);
		board.returnLastCapturedTo('b', 2);
		board.returnLastCapturedTo('c', 2);
		board.returnLastCapturedTo('d', 1);
		board.returnLastCapturedTo('e', 1);
		board.returnLastCapturedTo('f', 1);
		
		expected =    
				"   ┌───┬───┬───┬───┬───┬───┐\n" +
				" 2 │-R │+B │-Q │-B │-S │-P │\n" +
				"   ├───┼───┼───┼───┼───┼───┤\n" +
				" 1 │+K │+Q │+R │+S │-K │+P │\n" +
				"   └───┴───┴───┴───┴───┴───┘\n" +
				"     a   b   c   d   e   f \n" +
				"W+:\n" +
				"B-:";
		assertEquals(expected, board.toString());
		
		board.emptySquare('a', 1);
		try{ board.returnLastCapturedTo('a', 1); fail(); } catch(EmptyStackException e) {};
	}
}