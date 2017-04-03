package nullpointerexception.flexichess;

public class HandleChessPieceVisitor<T> implements  ChessPieceVisitor {

    @Override
    public T visit(Bishop bishop) {
        return null;
    }

    @Override
    public King visit(King king) {
        return king;
    }

    @Override
    public T visit(Knight knight) {
        return null;
    }

    @Override
    public T visit(Pawn pawn) {
        return null;
    }

    @Override
    public T visit(Queen queen) {
        return null;
    }

    @Override
    public T visit(Rook rook) {
        return null;
    }
}
