package fr.ensma.a3.ia.bataillenavale.outils;

public class GestionErreurs {
    /**
     * Checks if the coordinate don't go out of the board
     *
     * @param Integer x
     * @param Integer y
     * 
     * @return boolean
     */
    public static boolean isValid(Integer x, Integer y) {
        return (x >= 0 && x <= 9 && y >= 0 && y <= 9);
    }
}
