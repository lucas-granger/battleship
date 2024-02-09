package fr.ensma.a3.ia.bataillenavale.outils;

public class GestionCoordonnees {

    /**
     * Transforms a "letter" coordinate by its equivalent "number"
     *
     * @param String coordinate : the coordinate to transform
     * 
     * @return String
     */
    public static String lettreANombre(String coordinate) {
        return String.valueOf(new String("ABCDEFGHIJ").indexOf(coordinate));
    }

    /**
     * Transforms a "number" coordinate by its "letter" equivalent
     *
     * @param Integer coordinate : the coordinate to transform
     * 
     * @return String
     */
    public static String nombreALettre(Integer coordinate) {
        String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        return letters[coordinate];
    }

    /**
     * Checks if the coordinate don't go out of the board
     *
     * @param Integer x
     * @param Integer y
     * 
     * @return boolean
     */
    public static boolean dansPlateau(Integer x, Integer y) {
        return (x >= 0 && x <= 9 && y >= 0 && y <= 9);
    }
}
