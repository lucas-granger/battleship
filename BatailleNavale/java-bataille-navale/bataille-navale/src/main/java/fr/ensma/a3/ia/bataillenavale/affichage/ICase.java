package fr.ensma.a3.ia.bataillenavale.affichage;

import fr.ensma.a3.ia.bataillenavale.elem.IElementJeu;

/**
 * Typage pour Observable
 * Pattern Observateur pour la case
 * @author Lucas Granger
 * @since 1.0
 * @version 1.0
 */
public interface ICase {

    /**
     * Permet de rejoindre une case
     * @param obs l'élément qui rejoint la case
     */
    void rejoindreCase(final IElementJeu obs);

    /**
     * Permet de quitter la case
     * @param obs l'élément quittant la case
     */
    void quitterCase(final IElementJeu obs);

    /**
     * TODO Vérif utilité 
     */
    void etreTouche();
}