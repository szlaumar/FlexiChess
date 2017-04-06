package nullpointerexception.flexichess.test.chessPieceTest;

import nullpointerexception.flexichess.classic.Bishop;
import nullpointerexception.flexichess.classic.Queen;
import nullpointerexception.flexichess.game.*;

public class BishopTestRules extends ChessGameRules {

    public BishopTestRules() {
        super(
                8, 8,
                new Square("e1"), new Square("e8"),
                true, true, true, 2, -3
        );
    }

    @Override
    public void setUpPieces(ChessBoard board) {

        // Bishop Test
        new Bishop(board, ChessPiece.Color.WHITE, 'd', 3);
        new King(board, ChessPiece.Color.BLACK, 'e', 4);
        new King(board, ChessPiece.Color.WHITE, 'e', 2);

    }

}
