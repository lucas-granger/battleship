package fr.ensma.a3.ia.bataillenavale.elem;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.elem.etatCase.Detruite;
import fr.ensma.a3.ia.bataillenavale.elem.etatCase.IAutomEtat;
import fr.ensma.a3.ia.bataillenavale.elem.etatCase.IEtat;
import fr.ensma.a3.ia.bataillenavale.elem.etatCase.Normal;
import fr.ensma.a3.ia.bataillenavale.elem.etatCase.Touchee;
import fr.ensma.a3.ia.bataillenavale.outils.TransitionException;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Case implements ICase, IElementJeu, IAutomEtat{

    private Integer x;                  // indique la ligne de la case
    private Integer y;                  // indique la colonne de la case
    private Integer nivVie;             // indique le niveau de vie de la case (0 par défaut)
    
    private IEtat normal;               // etat représentant une case non touche ou vide
    private IEtat touchee;              // etat représentant une case touche
    private IEtat detruite;             // etat représentant une case detruite
    private IEtat etatCourant;          // etat représentant l'etat actuel de la case

    private List<ElementJeu> abonnes;   // liste d'abonnes a la case

    /*************************INITIALISATION********************************/

    /**
     * Instancie une Case.
     *
     * @param lig l'indice de la ligne
     * @param col l'indice de la colonne
     * @throws ValParamException
     */
    public Case(Integer  lig, Integer  col) {
        abonnes = new ArrayList<>();
        x = lig;
        y = col;
        nivVie = 0;

        normal = new Normal(this);
        touchee = new Touchee(this);
        detruite = new Detruite(this);
        etatCourant = normal;
    }

    /*************************GETTERS ET SETTERS********************************/

    /**
     * Renvoie la valeur de x
     * 
     * @return Integer 
     */
    public Integer getX() {
        return x;
    }

    /**
     * Renvoie la valeur de y
     * 
     * @return Integer 
     */
    public Integer getY() {
        return y;
    }

    /**
     * Renvoie le niveau de vie de la case
     * 
     * @return Integer 
     */
    public Integer getNivVie() {
        return nivVie;
    }

    /**
     * Met à jour le niveau de vie de la case
     * 
     * @return Integer 
     */
    public void setNivVie(Integer vie) {
        nivVie = vie;
    }

    /**
     * Renvoie la liste d'abonnés
     * 
     * @return List<ElementJeu>
     */
    public List<ElementJeu> getAbonnes(){
        return abonnes;
    }

    /*************************FONCTIONS D'ABONNEMENT********************************/

    /**
     * Permet de rejoindre une case
     * @param obs l'élément qui rejoint la case
     */
    @Override
    public void rejoindreCase(ElementJeu obs) {
        abonnes.add(obs);
    }

    /**
     * Permet de quitter une case
     * @param obs l'élément qui quitte la case
     */
    @Override
    public void quitterCase(ElementJeu obs) {
        if (abonnes.isEmpty()){
        }
        abonnes.remove(obs);
    }

    /*************************FONCTIONS D'ETAT********************************/

    @Override
    public IEtat getEtatDetruite() {
        return detruite;
    }

    @Override
    public IEtat getEtatNormal() {
        return normal;
    }

    @Override
    public IEtat getEtatTouchee() {
        return touchee;
    }

    @Override
    public void setEtatCourant(final IEtat state) {
        etatCourant = state;
    }

    @Override
    public void subirAttaque() throws TransitionException {
        try {
            etatCourant.subirAttaque();
            logger.info("Je subis une attaque");
        } catch (TransitionException e) {
            logger.warn("Incohérence d'état...");
        }        
    }

    /*************************AUTRES FONCTIONS********************************/

    /**
     * Renvoie si la case est occupee (true) ou non (false)
     * 
     * @return Boolean
     */
    public Boolean estOccupee() {
        return !abonnes.isEmpty();
    }


    @Override
    public String toString() {
        return "Case [x = "+x+", y = "+y+", nivVie = "+nivVie+", occupee = "+estOccupee().toString()+"]";
    }

    private static Logger logger = LogManager.getLogger(Case.class);
}
