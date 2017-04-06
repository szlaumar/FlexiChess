/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess.game;

/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public interface Move {
    public void executeOnBoard(ChessBoard board);
    public void revertOnBoard(ChessBoard board);
    public String notation();
}
