package nullpointerexception.flexichess;

import nullpointerexception.flexichess.builders.Demichess;
import nullpointerexception.flexichess.builders.Microchess;
import nullpointerexception.flexichess.builders.Regularchess;
import nullpointerexception.flexichess.builders.Silverman4x4;
import nullpointerexception.flexichess.builders.Silverman4x5;

/**
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class FlexiChess {

    public static void main(String[] args) {
        
        System.out.println("FlexiChess v4.0\n");

        
        System.out.println("Demichess:");
        Demichess demichess = new Demichess();
        ChessBoard boardDemi = demichess.board();
        System.out.print(boardDemi.toString() + "\n");
        
        
        System.out.println("\nMicrochess:");
        Microchess microchess = new Microchess();
        ChessBoard boardMicro = microchess.board();
        System.out.print(boardMicro.toString() + "\n");
        
        
        System.out.println("\nRegularchess:");
        Regularchess regularchess = new Regularchess();
        ChessBoard boardReg = regularchess.board();
        System.out.print(boardReg.toString() + "\n");
        
        
        System.out.println("\nSilverman4x4:");
        Silverman4x4 silverman4x4 = new Silverman4x4();
        ChessBoard boardSilver4x4 = silverman4x4.board();
        System.out.print(boardSilver4x4.toString() + "\n");
        
        
        System.out.println("\nSilverman4x5:");
        Silverman4x5 silverman4x5 = new Silverman4x5();
        ChessBoard boardSilver4x5 = silverman4x5.board();
        System.out.print(boardSilver4x5.toString() + "\n");
    }
    
}