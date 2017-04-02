package nullpointerexception.flexichess;

/**
 * Představuje jeden čtverec šachovnice.
 * 
 * @author Drabek Jan
 * @author Stastny Martin
 * @author Szlauer Martin
 */
public class Square {
    
    public final char  column;
    public final int   row;
    
    /**
     * Vytvoří čtverec s danými souřadnicemi.
     * 
     * @param column    Column letter.
     * @param row       Row number.
     */
    public Square(char column, int row){
        this.column = column;
        this.row    = row;
    }
    
    /**
     * Vytvoří čtverec s souřadnicemi danými jako retezec.
     * Očekává zvalidovaný vstup.
     * 
     * @param str    Coordinates string like "a5", "c12" etc.
     */
    public Square(String str){
        column = str.charAt(0);
        
        str = str.substring(1);
        row = Integer.parseInt(str);
    }

    /**
     * HashCode se vypočítává z obou atributů (column, row).
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.column;
        hash = 59 * hash + this.row;
        return hash;
    }

    /**
     * Aby objekty Square byly stejné, musí se shodovat jak atribut column,
     * tak row.
     * 
     * @param obj
     * @return 
     */
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
        final Square other = (Square) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%c%d", column, row);
    }
    
    public Square step(int colStep, int rowStep){
        return new Square((char)(column + colStep), row + rowStep); 
    }
}
