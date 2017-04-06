package nullpointerexception.flexichess.game;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {

    public King(ChessBoard board, Color color) {
        super(board, color);
    }

    public King(ChessBoard board, Color color, char column, int row) {
        super(board, color, column, row);
    }

    @Override
    public char letter() {
        return 'K';
    }

    @Override
    public boolean canBeCaptured() {
        return false;
    }

//    /**
//     * Returns list of moves which are possible to  carry out at this state.
//     *
//     * @return
//     */
//    public List<Move> validMoves() {
//        List<Move> list = new ArrayList<>();
//        Square newSquare;
//        Move move;
//
//        for (int i = -1; i < 2; i++) {
//            for (int j = -1; j < 2; j++) {
//                newSquare = new Square((char) (position().column + i), position().row + j);
//                if ((i == 0 && j == 0))
//                    continue;
//
//                move = isMoveToSquareValid(newSquare);
//                if (move != null)
//                    list.add(move);
//            }
//        }
//
//        return list;
//    }

    /**
     * Returns list of squares where the chess piece could potentially capture a enemy piece.
     *
     * @return
     */
    @Override
    public List<Square> threatens() {
        List<Square> list = new ArrayList<>();
        Square newSquare;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                newSquare = new Square((char) (position().column + i), position().row + j);

                if ((i == 0 && j == 0) || !board().isInsideBoard(newSquare)
                        || (!board().isEmptyAt(newSquare) && board().pieceAt(newSquare).color() == color()))
                    continue;
                list.add(newSquare);
            }
        }

        return list;
    }

    /**
     * Checks if the move to the given square is valid.
     *
     * @return The move instance if it is valid move, NULL if not valid move.
     */
    private Move isMoveToSquareValid(Square square) {
        if (!board().isInsideBoard(square) || isInCheck(square))
            return null;
        if (!board().isEmptyAt(square) && ((board().pieceAt(square).color() == color().opposite()
                && board().pieceAt(square).letter() == 'K') || board().pieceAt(square).color() == color()))
            return null;

        return new SimpleMove(this, square);
    }

    /**
     * Checks if the King would be in Check on that particular position.
     *
     * @param validatePosition  Position to be checked
     * @return
     */
    private boolean isInCheck(Square validatePosition) {
        for (Square square : this.board().threatenedBy(color().opposite()))
            if (validatePosition.equals(square))
                return true;

        return false;
    }

    public boolean isInCheck() {
        return isInCheck(position());
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        return visitor.visit(this);
    }

    /**
     * HashCode se vypočítává z char K (King) a barvy figurky.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 'K';
        hash = 59 * hash + this.color().m_sign;
        return hash;
    }

    /**
     * Aby objekty Square byly stejné, musí se shodovat jak atribut color,
     * tak board.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final King other = (King) obj;
        if (this.board() != other.board()) {
            return false;
        }
        if (this.color() != other.color()) {
            return false;
        }

        return true;
    }
}
