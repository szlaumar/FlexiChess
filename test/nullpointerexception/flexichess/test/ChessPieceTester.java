package nullpointerexception.flexichess.test;

import static org.junit.Assert.*;

import nullpointerexception.flexichess.game.*;
import nullpointerexception.flexichess.test.chessPieceTest.BishopTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.KnightTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.QueenTestRules;
import nullpointerexception.flexichess.test.chessPieceTest.RookTestRules;
import org.junit.Test;

import java.util.List;

/**
 * Created by JD-mac on 06/04/2017.
 */
public class ChessPieceTester {
    private String expected;

    @Test
    public void bishopGameTest() {
        ChessBoard board = new TestChessBoard(new BishopTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), false);
//        new SimpleMove(board.pieceAt('e', 2), new Square('e', 4)).executeOnBoard(board);

        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │-  │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │-  │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │-  │   │-  │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │   │   │+B │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │-  │   │+K │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │-  │   │   │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void rookGameTest() {
        ChessBoard board = new TestChessBoard(new RookTestRules());

//        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), false);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │-  │-  │-  │+R │-  │-  │+K │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │   │   │-  │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void queenGameTest() {
        ChessBoard board = new TestChessBoard(new QueenTestRules());

        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('d', 3), true);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │-  │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │   │-  │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │-  │-  │-  │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │-  │-  │-  │+Q │-  │-  │+P │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │-  │-  │+P │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │   │-  │   │-  │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }

    @Test
    public void knightGameTest() {
        ChessBoard board = new TestChessBoard(new KnightTestRules());

        System.out.println(board);
        showThreatensTravelPath(board, board.pieceAt('b', 3), true);
        expected =  "   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n" +
                    " 8 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 7 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 6 │   │   │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 5 │-  │   │-  │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 4 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 3 │   │+S │   │   │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 2 │   │   │   │-  │   │   │   │   │\n" +
                    "   ├───┼───┼───┼───┼───┼───┼───┼───┤\n" +
                    " 1 │-  │   │+P │   │   │   │   │   │\n" +
                    "   └───┴───┴───┴───┴───┴───┴───┴───┘\n" +
                    "     a   b   c   d   e   f   g   h \n" +
                    "W+:\n" +
                    "B-:";
        assertEquals(expected, board.toString());
    }



    // testing helper methods
    private void showThreatensTravelPath(ChessBoard board, ChessPiece piece, boolean print) {
        for (Square s : piece.threatens()) {
            new MoveIndicator(board, ChessPiece.Color.BLACK, s.column, s.row);
        }

        if (print)
            System.out.println(board);
    }

    private class MoveIndicator extends ChessPiece {
        protected MoveIndicator(ChessBoard board, Color color, char column, int row) {
            super(board, color, column, row);
        }

        @Override
        public char letter() {
            return ' ';
        }

        @Override
        public boolean canBeCaptured() {
            return false;
        }

        @Override
        public List<Move> validMoves() {
            return null;
        }

        @Override
        public List<Square> threatens() {
            return null;
        }

        @Override
        public <T> T accept(ChessPieceVisitor<T> visitor) {
            return null;
        }
    }
}
