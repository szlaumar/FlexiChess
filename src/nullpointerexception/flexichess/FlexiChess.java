package nullpointerexception.flexichess;

import nullpointerexception.flexichess.builders.Demichess;

/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class FlexiChess {

    public static void main(String[] args) {
        
        System.out.println("FlexiChess v4.0\n");

        Demichess demichess = new Demichess();
        ChessBoard board = demichess.board();

        System.out.print(board.toString() + "\n");
    }
    
}