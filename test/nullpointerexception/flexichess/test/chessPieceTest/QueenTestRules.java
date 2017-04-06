package nullpointerexception.flexichess.test.chessPieceTest;

import nullpointerexception.flexichess.classic.Pawn;
import nullpointerexception.flexichess.classic.Queen;
import nullpointerexception.flexichess.classic.Rook;
import nullpointerexception.flexichess.game.*;

public class QueenTestRules extends ChessGameRules {

    public QueenTestRules() {
        super(
                8, 8,
                new Square("e1"), new Square("e8"),
                true, true, true, 2, -3
        );
    }

    @Override
    public void setUpPieces(ChessBoard board) {

        // Queen Test
        new Queen(board, ChessPiece.Color.WHITE, 'd', 3);
        new King (board, ChessPiece.Color.WHITE, 'd', 1);
        new Rook (board, ChessPiece.Color.BLACK, 'd', 7);
        new Pawn (board, ChessPiece.Color.WHITE, 'g', 3);
        new Pawn (board, ChessPiece.Color.BLACK, 'e', 4);
        new Pawn (board, ChessPiece.Color.WHITE, 'e', 2);

    }

}
