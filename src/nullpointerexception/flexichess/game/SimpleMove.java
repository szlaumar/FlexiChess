package nullpointerexception.flexichess.game;

import java.util.List;
import java.util.Objects;

/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class SimpleMove implements Move{
    private ChessPiece piece;
    private Square from, to;
    boolean capturing;

    
    public SimpleMove(ChessPiece piece, Square to){
        this.piece = piece;
        from = piece.position();
        this.to = to;
    }

    public ChessPiece piece() {
        return piece;
    }

    public Square from() {
        return from;
    }

    public Square to() {
        return to;
    }

    /**
     * Provede tah. Pokud je cílové políčko prázdné, figurka se tam jen posune. Pokud je na něm soupeřova figurka, tak je zajmuta.
     *
     * @param board
     */
    @Override
    public void executeOnBoard(ChessBoard board) {
        capturing = isCapturing();

        if (!board.isEmptyAt(to))
            board.capturePieceAt(to);

        board.addPlayedMove(this);
        board.moveTo(from, to);
    }

    /**
     * Vrátí šachovnici přesně do takového stavu, v jakém byla před provedením tohoto tahu.
     */
    @Override
    public void revertOnBoard(ChessBoard board) {
        revertSingleMove(board);
    }

    /**
     * provede obraceny tah
     * Throws IllegalStateException if not possible to revert move.
     *
     * @param board
     */
    private void revertSingleMove(ChessBoard board) {
        board.moveTo(to, from);
        piece.decrementMoveCounter();

        if (capturing) {
            List<ChessPiece> list = board.capturedPieces(piece.color().opposite());
            ChessPiece capturedPiece = list.remove(list.size() - 1);
            board.removeCapturedPiece();
            board.putPiece(to.column, to.row, capturedPiece);
        }

        piece.decrementMoveCounter();
    }

    /**
     * Has to be called during the state when the move is executed.
     *
     * @return
     */
    public boolean isCapturing(){
        return !piece.board().isEmptyAt(to.column, to.row)
                && piece.board().pieceAt(to).color() == piece.color().opposite();
    }
    
    @Override
    public String notation(){
        return isCapturing()? String.format("%c%s-x%s", piece.letter(), from, to) :
                String.format("%c%s-%s", piece.letter(), from, to);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.from);
        hash = 59 * hash + Objects.hashCode(this.to);
        hash = 59 * hash + Objects.hashCode(this.piece);
        return hash;
    }

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
        final SimpleMove other = (SimpleMove) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return notation();
    }

}
