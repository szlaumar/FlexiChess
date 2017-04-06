package nullpointerexception.flexichess.test.chessPieceTest;

import nullpointerexception.flexichess.classic.Bishop;
import nullpointerexception.flexichess.classic.Rook;
import nullpointerexception.flexichess.game.*;

public class RookTestRules extends ChessGameRules {

    public RookTestRules() {
        super(
                8, 8,
                new Square("e1"), new Square("e8"),
                true, true, true, 2, -3
        );
    }

    @Override
    public void setUpPieces(ChessBoard board) {

        // Rook Test
        new Rook(board, ChessPiece.Color.WHITE, 'd', 3);
        new King(board, ChessPiece.Color.BLACK, 'd', 7);
        new King(board, ChessPiece.Color.WHITE, 'g', 3);

    }

}
