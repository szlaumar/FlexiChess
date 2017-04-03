/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullpointerexception.flexichess;

/**
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public interface Move {
    /**
     * Provede tah na šachovnici.
     * 
     * @param board 
     */
    public void executeOnBoard(ChessBoard board);
    
    /**
     * Vrátí šachovnici přesně do takového stavu, v jakém byla po provedení tohoto tahu.
     * 
     * @param board 
     */
    public void revertOnBoard(ChessBoard board);
    
    /**
     * Textový popis tahu v šachové notaci.
     * 
     * @return 
     */
    public String notation();
}
