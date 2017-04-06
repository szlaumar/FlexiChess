package nullpointerexception.flexichess.test;

import nullpointerexception.flexichess.game.ChessBoard;
import nullpointerexception.flexichess.game.ChessGameRules;
import nullpointerexception.flexichess.game.ChessPiece;


/**
 * Created by JD-mac on 06/04/2017.
 */
public class TestChessBoard extends ChessBoard {

    public TestChessBoard(ChessGameRules rules) {
        super(rules);
    }

    @Override
    public void putPiece(char column, int row, ChessPiece piece) {
        piece.setPosition(column, row);
        m_board[column - 'a'][row - 1] = piece;
    }
}
