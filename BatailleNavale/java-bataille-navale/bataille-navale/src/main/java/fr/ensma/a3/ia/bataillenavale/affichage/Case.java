package fr.ensma.a3.ia.bataillenavale.affichage;

import java.util.List;

import fr.ensma.a3.ia.bataillenavale.elem.IElementJeu;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Case implements ICase, IElementJeu{

    private Integer x;
    private Integer y;
    private Integer id;             // id correspondant au bateau sur la case (0 par défaut)
    private Integer nivVie;         // indique le niveau de vie de la case (0 par défaut)
    private boolean shot;       // indique si la Case a été testée

    private List<IElementJeu> abonnes;

    /**
     * Instancie une Case.
     *
     * @param lig l'indice de la ligne
     * @param col l'indice de la colonne
     * @throws ValParamException
     */
    public Case(Integer  lig, Integer  col) {
        x = lig;
        y = col;
        id = 0;
        nivVie = 0;
        shot = false;
    }

    /**
     * Permet de rejoindre une case
     * @param obs l'élément qui rejoint la case
     */
    @Override
    public void rejoindreCase(IElementJeu obs) {
        abonnes.add(obs);
    }

    /**
     * Permet de quitter une case
     * @param obs l'élément qui quitte la case
     */
    @Override
    public void quitterCase(IElementJeu obs) {
        abonnes.remove(obs);
    }

    /**
     * TODO Vérifier utilité
     */
    @Override
    public void etreTouche() {
        for (IElementJeu elem : abonnes) {
            elem.etreTouche();
        }
    }

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
     * @returnInteger 
     */
    public Integer getY() {
        return y;
    }

    /**
     * Renvoie l'id de la case
     * 
     * @returnInteger 
     */
    public Integer getId() {
        return id;
    }

    /**
     * Renvoie le niveau de vie de la case
     * 
     * @returnInteger 
     */
    public Integer getNivVie() {
        return nivVie;
    }

    /**
     * Renvoie si la case a déjà été testée
     * 
     * @return boolean
     */
    public boolean isShot() {
        return shot;
    }

    /**
     * Met à jour la valeur du booléen shot
     * 
     * @return void
     */
    public void setShot() {
        shot = true;
    }
}
