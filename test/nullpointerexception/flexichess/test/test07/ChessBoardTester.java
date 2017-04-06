package nullpointerexception.flexichess.test.test07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import nullpointerexception.flexichess.classic.ClassicChessRules;
import nullpointerexception.flexichess.game.ChessBoard;
import nullpointerexception.flexichess.game.ChessPiece;

public class ChessBoardTester {

	@Test
	public void test() {
		ClassicChessRules rules = new ClassicChessRules();
		ChessBoard board = new ChessBoard(rules);
		
		assertSame(rules, board.rules());
		assertEquals(rules.boardColumns, board.columns());  
		assertEquals(rules.boardRows, board.rows());
		assertEquals(rules.whiteKingPosition, board.king(ChessPiece.Color.WHITE).position());
		assertEquals(rules.blackKingPosition, board.king(ChessPiece.Color.BLACK).position());
	}
}
