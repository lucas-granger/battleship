package fr.ensma.a3.ia.bataillenavale.outils;

public class GestionTexte {
    /**
     * Displays spaces one after the other
     *
     * @param Integer spaceSize : the number of spaces to generate
     * 
     * @return void
     */
    public static void generateSpaceBlanks(Integer spaceSize) {
        for (Integer i = 0; i < spaceSize; i++) {
            System.out.print(" ");
        }
    }
}
