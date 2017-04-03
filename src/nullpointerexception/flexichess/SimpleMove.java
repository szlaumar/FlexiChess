/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

import java.util.Objects;

/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class SimpleMove implements Move{
    private ChessPiece piece;
    private Square from, to;
    
    
    
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
        if (!piece.validMoves().contains(this))
            return;

        if (!board.isEmptyAt(to))
            board.capturePieceAt(to);

        board.moveTo(from, to);
    }

    /**
     * Vrátí šachovnici přesně do takového stavu, v jakém byla po provedení tohoto tahu.
     */
    @Override
    public void revertOnBoard(ChessBoard board) {
        Move move;

        do {
            move = board.getPlayedMoves().pollLast();
            if (move == this)
                return;

            revertSingleMove(board);
        } while (true);
    }

    /**
     * provede obraceny tah
     * Throws IllegalStateException if not possible to revert move.
     *
     * @param board
     */
    @Override
    public void revertSingleMove(ChessBoard board) {
        if (!piece.validMoves().contains(new SimpleMove(piece, from)))
            throw new IllegalStateException("Can't revert this move");

        // piece is on board
        if (board.onBoardPieces().contains(piece)) {
            board.moveTo(to, from);
            piece.decrementMoveCounter();
        }
        // piece got captured
        else {
            board.putPiece(from.column, from.row, piece);
            board.capturedPieces(piece.color()).remove(piece);
        }

        piece.decrementMoveCounter();
    }

    public boolean isCapturing(){
        return !piece.board().isEmptyAt(to.column, to.row)
                && piece.board().pieceAt(to).color() == piece.color().opposite();
    }
    
    @Override
    public String notation(){
        return isCapturing()? String.format("%c%s-%s", piece.letter(), from, to) :
            String.format("%c%s-x%s", piece.letter(), from, to);
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

    @Override
    public ChessPiece acceptPiece(PieceMoveVisitor visitor) {
        return visitor.visitPiece(this);
    }

    @Override
    public Square acceptToPosition(PieceMoveVisitor visitor) {
        return visitor.visitSquare(this);
    }
}
