package fr.ensma.a3.ia.bataillenavale.elem;

import fr.ensma.a3.ia.bataillenavale.affichage.Case;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;

/**
 * Associe un ou plusieurs éléments à une case du jeu
 *
 * @author Lucas Granger
 * @since 1.0
 * @version 1.0
 */
public interface IElementJeu {
    /**
     * Associe un ou plusieurs éléments à une case du jeu
     */
    void etreTouche();

    @Override
    String toString();
}
