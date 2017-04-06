package nullpointerexception.flexichess.test.chessPieceTest;

import nullpointerexception.flexichess.classic.Knight;
import nullpointerexception.flexichess.classic.Pawn;
import nullpointerexception.flexichess.classic.Rook;
import nullpointerexception.flexichess.game.*;

public class KnightTestRules extends ChessGameRules {

    public KnightTestRules() {
        super(
                8, 8,
                new Square("e1"), new Square("e8"),
                true, true, true, 2, -3
        );
    }

    @Override
    public void setUpPieces(ChessBoard board) {

        // Knight Test
        new Knight(board, ChessPiece.Color.WHITE, 'b', 3);
        new Pawn(board, ChessPiece.Color.BLACK, 'd', 2);
        new Pawn(board, ChessPiece.Color.WHITE, 'c', 1);

    }

}
