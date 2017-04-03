package nullpointerexception.flexichess;

/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public interface ChessPieceVisitor<T> {
    public T visit(Bishop bishop);
    public T visit(King king);
    public T visit(Knight knight);
    public T visit(Pawn pawn);
    public T visit(Queen queen);
    public T visit(Rook rook);
}
