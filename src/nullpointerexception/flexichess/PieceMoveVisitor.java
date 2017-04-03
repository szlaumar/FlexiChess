package nullpointerexception.flexichess;

public class PieceMoveVisitor implements MoveVisitor {

    @Override
    public ChessPiece visitPiece(SimpleMove simpleMove) {
        return simpleMove.piece();
    }

    @Override
    public Square visitSquare(SimpleMove simpleMove) {
        return simpleMove.to();
    }
}
