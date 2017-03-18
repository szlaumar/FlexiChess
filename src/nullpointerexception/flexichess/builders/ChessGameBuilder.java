package nullpointerexception.flexichess.builders;

import nullpointerexception.flexichess.ChessBoard;

/**
 * Rozhraní pro třídy, které stavějí konkrétní šachovou hru.
 */
public interface ChessGameBuilder {
    
    /**
     * Vrátí šachovnici s rozestavním figurek podle dané hry.
     */
    public ChessBoard board();
    
}
