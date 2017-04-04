package nullpointerexception.flexichess;

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

    public List<Move> validMoves() {
        List<Move> list = new ArrayList<>();
        PieceMoveVisitor visitor = new PieceMoveVisitor();
        Square square;

        for (Move move : allMoves()) {
            square = move.acceptToPosition(visitor);

            if (board().isEmptyAt(square) || (board().pieceAt(square).color() == color().opposite()
                    && board().pieceAt(square).letter() != 'K'))
                list.add(move);
        }

        return list;
    }

    public List<Move> allMoves() {
        List<Move> list = new ArrayList<>();

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                addMoveToList(i, j, list);

        return list;
    }

    public List<Move> checkAllMoves() {
        List<Move> list = new ArrayList<>();

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                checkAddMoveToList(i, j, list);

        return list;
    }

    private void addMoveToList(int i, int j, List<Move> list) {
        Square newSquare = new Square((char)(position().column + i), position().row + j);

        if ((i == 0 && j == 0) || !board().isInsideBoard(newSquare) || isInCheck(newSquare))
            return;

        list.add(new SimpleMove(this, newSquare));
    }

    private void checkAddMoveToList(int i, int j, List<Move> list) {
        Square newSquare = new Square((char)(position().column + i), position().row + j);

        if ((i == 0 && j == 0) || !board().isInsideBoard(newSquare))
            return;

        list.add(new SimpleMove(this, newSquare));
    }

    public boolean isInCheck(Square validatePosition) {
        for (Square square : this.board().threatenedBy(color().opposite()))
            if (validatePosition.equals(square))
                return true;

        return false;
    }

    public boolean isInCheck() {
        return isInCheck(position());
    }

    @Override
    public List<Square> threatens() {
        List<Square> list = new ArrayList<>();
        PieceMoveVisitor visitor = new PieceMoveVisitor();

        for (Move move : checkAllMoves())
                list.add(move.acceptToPosition(visitor));

        return list;
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
