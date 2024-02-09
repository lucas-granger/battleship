package fr.ensma.a3.ia.bataillenavale.outils;

/**
 * Config : game configuration file
 */
public abstract class GestionFlotte {

    /**
     * The boats and their configuration
     * {:id, :name, :size}
     */
    private static final String[][] flotte =
    {
        {"1", "Porte-avions", "5"},
        {"2", "Croiseur", "4",},
        {"3", "Contre-torpilleur", "3"},
        {"4", "Contre-torpilleur", "3"},
        {"5", "Torpilleur", "2"}
    };

    /**
     * Returns a given boat's configuration
     * 
     * @param Integer boatId
     *
     * @return String[]
     */
    public static String[] getBateauCases(Integer id) {
        if (id < 0 || id >= flotte.length) {
            return new String[0];
        }
        return flotte[id];
    }

    /**
     * Returns the configuration of every boat
     *
     * @return String[][]
     */
    public static String[][] getBoatsConfig() {
        return flotte;
    }

    /**
     * Returns the number of boats
     *
     * @return Integer 
     */
    public static Integer getNbBoats() {
        return flotte.length;
    }
}