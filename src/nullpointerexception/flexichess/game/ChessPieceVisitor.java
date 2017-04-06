/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess.game;

import nullpointerexception.flexichess.classic.*;

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
