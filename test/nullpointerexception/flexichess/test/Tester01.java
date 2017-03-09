package nullpointerexception.flexichess.test;

//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import nullpointerexception.flexichess.FlexiChess;
//
//public class Tester01 {
//	
//	@Test
//	public void test1() {
//		int[][] board = new int[3][4];
//		String expected = 
//				"    0   1   2   3 \n" + 
//				"  ┌───┬───┬───┬───┐\n" + 
//				"0 │   │   │   │   │\n" +
//				"  ├───┼───┼───┼───┤\n" +
//				"1 │   │   │   │   │\n" + 
//				"  ├───┼───┼───┼───┤\n" + 
//				"2 │   │   │   │   │\n" +
//				"  └───┴───┴───┴───┘";
//		assertEquals(expected, FlexiChess.boardAsString(board));
//	}
//	
//	@Test
//	public void test2() {
//		int[][] board = new int[1][5];
//		String expected = 
//				"    0   1   2   3   4 \n" + 
//				"  ┌───┬───┬───┬───┬───┐\n" +
//				"0 │   │   │   │   │   │\n" +
//				"  └───┴───┴───┴───┴───┘";
//		assertEquals(expected, FlexiChess.boardAsString(board));
//	}
//	
//	@Test
//	public void test3() {
//		int[][] board = new int[5][1];
//		String expected = 
//				"    0 \n" + 
//				"  ┌───┐\n" +
//				"0 │   │\n" +
//				"  ├───┤\n" +
//				"1 │   │\n" +
//				"  ├───┤\n" +
//				"2 │   │\n" +
//				"  ├───┤\n" +
//				"3 │   │\n" +
//				"  ├───┤\n" +
//				"4 │   │\n" +
//				"  └───┘";
//		assertEquals(expected, FlexiChess.boardAsString(board));		
//	}
//	
//	@Test
//	public void test4() {
//		int[][] board = new int[1][1];
//		String expected = 
//				"    0 \n" + 
//				"  ┌───┐\n" +
//				"0 │   │\n" +
//				"  └───┘";
//		assertEquals(expected, FlexiChess.boardAsString(board));
//	}
//	
//	@Test
//	public void test5() {
//		int[][] board = new int[5][5];
//		board[0][0] = 1; board[0][1] = 2; board[0][2] = 3; board[0][3] = 4; board[0][4] = 5;
//		board[1][0] = 5; board[1][1] = 4; board[1][2] = 3; board[1][3] = 2; board[1][4] = 1;
//		board[2][0] = 9; board[2][1] = 8; board[2][2] = 9; board[2][3] = 8; board[2][4] = 9;
//		board[3][0] = 1; board[3][1] = 2; board[3][2] = 1; board[3][3] = 2; board[3][4] = 1;
//		board[4][0] = 1; board[4][1] = 0; board[4][2] = 0; board[4][3] = 1; board[4][4] = 0;
//		
//		String expected = 
//				"    0   1   2   3   4 \n" +  
//				"  ┌───┬───┬───┬───┬───┐\n" +
//				"0 │ 1 │ 2 │ 3 │ 4 │ 5 │\n" +
//				"  ├───┼───┼───┼───┼───┤\n" +
//				"1 │ 5 │ 4 │ 3 │ 2 │ 1 │\n" +
//				"  ├───┼───┼───┼───┼───┤\n" +
//				"2 │ 9 │ 8 │ 9 │ 8 │ 9 │\n" +
//				"  ├───┼───┼───┼───┼───┤\n" +
//				"3 │ 1 │ 2 │ 1 │ 2 │ 1 │\n" +
//				"  ├───┼───┼───┼───┼───┤\n" +
//				"4 │ 1 │   │   │ 1 │   │\n" +
//				"  └───┴───┴───┴───┴───┘";
//		assertEquals(expected, FlexiChess.boardAsString(board));
//	}
//}