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
    
    @Override
    public void executeOnBoard(ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void revertOnBoard(ChessBoard board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean isCapturing(){
        return !piece.board().isEmptyAt(to.column, to.row);
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
        return true;
    }
    
    @Override
    public String toString(){
        return notation();
    }
}
