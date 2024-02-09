package fr.ensma.a3.ia.bataillenavale.affichage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.ContreTorpilleur;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.Croiseur;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.PorteAvions;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.SousMarin;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.Torpilleur;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

/**
 * Modélise un plateau de jeu
 * 
 * @author Lucas
 * @since 1.0
 * @version 1.0
 */

public class Plateau {

    private Case[][] grille;
    private Bateau[] bateaux = new Bateau[5];

    /**
     * Instancie un plateau par défaut
     * 
     * @param typePlateau {@link EType} (non null)
     * @throws ValParamException
     */
    public Plateau() throws ValParamException{
        try{
            grille = genererPlateau(10, 10);

            bateaux[0] = new PorteAvions();
            bateaux[1] = new ContreTorpilleur();
            bateaux[2] = new Croiseur();
            bateaux[3] = new SousMarin();
            bateaux[4] = new Torpilleur();

        } catch (NullPointerException ex){
            logger.error("Parametre null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        logger.info("Plateau cree");
    }

    /**
     * Crée un plateau vide
     * @param Integer w
     * @param Integer h
     * 
     * @return Case[][]
     */
    public Case[][] genererPlateau(Integer w, Integer h) {
        Case[][] newPlateau = new Case[w][h];
        for (Integer i = 0; i < w; i++) {
            for (Integer j = 0; j < h; j++) {
                newPlateau[i][j] = new Case(i, j);
            }
        }
        return newPlateau;
    }

    /**
     * Renvoie une case du plateau
     * 
     * @param Integer x
     * @param Integer y
     *
     * @return Case
     */
    public Case getCoord(Integer x, Integer y) {
        return grille[x][y];
    }

    /**
     * Renvoie la liste de bateaux d'un joueur
     * 
     * @return Bateau[]
     */
    public Bateau[] getBateaux() {
        return bateaux;
    }

    /**
     * Renvoie le bateau d'un joueur
     * 
     * @param Integer bateauId
     * 
     * @return Bateau
     */
    public Bateau getBateau(Integer bateauId) {
        for (Integer i = 0; i < bateaux.length; i++) {
            if (bateaux[i].getId() == bateauId) {
                return bateaux[i];
            }
        }
        return bateaux[0];
    }

    private static Logger logger = LogManager.getLogger(Plateau.class);

}
