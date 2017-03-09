package nullpointerexception.flexichess.test;

//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import nullpointerexception.flexichess.ChessBoard;
//
//public class Tester02 {
//	
//	@Test
//	public void test1() {
//		ChessBoard board = new ChessBoard(4, 3);
//		assertEquals(4, board.columns());
//		assertEquals(3, board.rows());
//		
//		String expected =  
//				"   ┌───┬───┬───┬───┐\n" + 
//				" 3 │   │   │   │   │\n" +
//				"   ├───┼───┼───┼───┤\n" +
//				" 2 │   │   │   │   │\n" + 
//				"   ├───┼───┼───┼───┤\n" + 
//				" 1 │   │   │   │   │\n" +
//				"   └───┴───┴───┴───┘\n" +
//				"     a   b   c   d ";
//		assertEquals(expected, board.toString());
//	}
//	
//	@Test
//	public void test2() {
//		ChessBoard board = new ChessBoard(5, 1);
//		assertEquals(5, board.columns());
//		assertEquals(1, board.rows());
//		
//		String expected = 
//				"   ┌───┬───┬───┬───┬───┐\n" +
//				" 1 │   │   │   │   │   │\n" +
//				"   └───┴───┴───┴───┴───┘\n" +
//				"     a   b   c   d   e ";
//		assertEquals(expected, board.toString());
//	}
//	
//	@Test
//	public void test3() {
//		ChessBoard board = new ChessBoard(1, 12);
//		assertEquals(1, board.columns());
//		assertEquals(12, board.rows());
//		
//		String expected =  
//				"   ┌───┐\n" +
//				"12 │   │\n" +
//				"   ├───┤\n" +
//				"11 │   │\n" +
//				"   ├───┤\n" +
//				"10 │   │\n" +
//				"   ├───┤\n" +
//				" 9 │   │\n" +
//				"   ├───┤\n" +
//				" 8 │   │\n" +
//				"   ├───┤\n" +
//				" 7 │   │\n" +
//				"   ├───┤\n" +
//				" 6 │   │\n" +
//				"   ├───┤\n" +
//				" 5 │   │\n" +
//				"   ├───┤\n" +
//				" 4 │   │\n" +
//				"   ├───┤\n" +
//				" 3 │   │\n" +
//				"   ├───┤\n" +
//				" 2 │   │\n" +
//				"   ├───┤\n" +
//				" 1 │   │\n" +
//				"   └───┘\n" +
//				"     a ";
//		assertEquals(expected, board.toString());		
//	}
//	
//	@Test
//	public void test4() {
//		ChessBoard board = new ChessBoard(1, 1);
//		assertEquals(1, board.columns());
//		assertEquals(1, board.rows());
//		
//		String expected =  
//				"   ┌───┐\n" +
//				" 1 │   │\n" +
//				"   └───┘\n" +
//				"     a ";
//		assertEquals(expected, board.toString());
//	}
//	
//	@Test
//	public void test5() {
//		ChessBoard board = new ChessBoard(3, 3);
//		assertEquals(3, board.columns());
//		assertEquals(3, board.rows());
//		
//		board.putPiece(1, 'a', 1);
//		board.putPiece(2, 'a', 2);
//		board.putPiece(3, 'a', 3);
//		
//		board.putPiece(4, 'b', 1);
//		board.putPiece(5, 'b', 2);
//		board.putPiece(6, 'b', 3);
//		
//		board.putPiece(7, 'c', 1);
//		board.putPiece(8, 'c', 2);
//		board.putPiece(9, 'c', 3);
//		
//		String expected =
//				"   ┌───┬───┬───┐\n" +
//				" 3 │ 3 │ 6 │ 9 │\n" +
//				"   ├───┼───┼───┤\n" +
//				" 2 │ 2 │ 5 │ 8 │\n" +
//				"   ├───┼───┼───┤\n" +
//				" 1 │ 1 │ 4 │ 7 │\n" +
//				"   └───┴───┴───┘\n" +
//				"     a   b   c "; 
//		assertEquals(expected, board.toString());
//		
//		assertEquals(1, board.pieceAt('a', 1));
//		assertEquals(2, board.pieceAt('a', 2));
//		assertEquals(3, board.pieceAt('a', 3));
//		
//		assertEquals(4, board.pieceAt('b', 1));
//		assertEquals(5, board.pieceAt('b', 2));
//		assertEquals(6, board.pieceAt('b', 3));
//		
//		assertEquals(7, board.pieceAt('c', 1));
//		assertEquals(8, board.pieceAt('c', 2));
//		assertEquals(9, board.pieceAt('c', 3));		
//	}
//}