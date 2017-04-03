package nullpointerexception.flexichess;

public interface MoveVisitor<T> {

    public T visitPiece(SimpleMove simpleMove);
    public T visitSquare(SimpleMove simpleMove);

}
