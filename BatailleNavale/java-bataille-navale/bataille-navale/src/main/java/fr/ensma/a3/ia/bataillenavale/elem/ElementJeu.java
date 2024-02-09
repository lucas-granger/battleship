package fr.ensma.a3.ia.bataillenavale.elem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.affichage.Case;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

/**
 * Modélisation d'un élément de jeu.
 *
 * @author Lucas Granger
 * @since 1.0
 * @version 1.0
 * @see IElementJeu
 */
public abstract class ElementJeu implements IElementJeu {

    private Integer resistance;
    private Integer taille;
    private Case[] coord;

    /**
     * Instancie un élément du jeu.
     *
     * @param c la liste des Cases représentant un bateau
     * @param res la resistance du bateau (non null)
     * @param t la taille du bateau (non null)
     * @throws ValParamException
     */
    public ElementJeu(final Integer res, final Integer t) throws ValParamException {
        try {
            resistance = Objects.requireNonNull(res);
            taille = Objects.requireNonNull(t);
        } catch (final Throwable ex) {
            logger.error("Parametres null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
    }

    /**
     * Renvoie la pos-ième Case de l'élément
     * @return Case
     */
    public Case getCase(Integer pos) {
        return coord[pos];
    }

    /**
     * Renvoie la case selon ses coordonnées x et y
     * @return Case
     */
    public Case getCase(Integer x, Integer y) {
        for (Integer i = 0; i < coord.length; i++) {
            if (getCase(i).getX() == x && getCase(i).getY() == y) {
                return getCase(i);
            }
        }
        // Obligatoire d'avoir un return en sortie de boucle
        return getCase(0);
    }
    
    /**
     * Renvoie la taille d'un bateau
     * @return
     */
    public Integer getTaille() {
        return taille;
    }

    /**
     * Renvoie la liste de Case qui composent le bateau
     * @return Case[]
     */
    public Case[] getCases() {
        return coord;
    }

    /**
     * Obtient la résistance d'un élément.
     *
     * @return la résistance de l'élément de jeu.
     */
    public final Integer getRes() {
        return resistance;
    }
    
    /**
     * Redéfinition de toString.
     */
    @Override
    public String toString() {
        return toString();
    }

    @Override
    public void etreTouche() {
        // TODO Auto-generated method stub
        
    }

    /**
     * Redéfinition de equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ElementJeu other = (ElementJeu) obj;
        if (!resistance.equals(other.resistance))
            return false;
        return true;
    }

    /**
     * Redéfinition de hashCode pour conformité à equals
     *
     * @see equals
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + resistance.hashCode();
        return result;
    }

    private static Logger logger = LogManager.getLogger(ElementJeu.class);
}
