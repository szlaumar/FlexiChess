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

    @Override
    public List<Move> validMoves() {
        List<Move> list = new ArrayList<>();

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                addMoveToListIfValid(i, j, list);

        return list;
    }

    private void addMoveToListIfValid(int i, int j, List<Move> list) {
        char newCol = (char)(position().column + i);
        int newRow = position().row + j;

        // skip the King itself, field outside if board and field with own piece
        if (i == 0 && j == 0 || !board().isInsideBoard(newCol, newRow)
                || (!board().isEmptyAt(newCol, newRow) && board().pieceAt(newCol, newRow).color() == color()))
            return;

        list.add(new SimpleMove(board().pieceAt(newCol, newRow), new Square(newCol, newRow)));
    }

    @Override
    public List<Square> threatens() {
        List<Square> list = new ArrayList<>();
        PieceMoveVisitor visitor = new PieceMoveVisitor();
        ChessPiece piece;

        for (Move move : validMoves()) {
            piece = move.acceptPiece(visitor);
            if (piece.color() == color().opposite())
                list.add(move.acceptToPosition(visitor));
        }

        return list;
    }

    @Override
    public <T> T accept(ChessPieceVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
