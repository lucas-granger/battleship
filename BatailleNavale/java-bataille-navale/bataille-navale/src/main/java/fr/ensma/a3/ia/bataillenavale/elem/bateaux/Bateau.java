package fr.ensma.a3.ia.bataillenavale.elem.bateaux;

import fr.ensma.a3.ia.bataillenavale.elem.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public abstract class Bateau extends ElementJeu{

    protected Integer id;   // identifiant associé à un bateau
    private String nom;     // nom du bateau
    private String dir;     // direction du bateau (Horizontale ou verticale)

    /*************************INITIALISATION********************************/

    /**
     * Instancie un Bateau.
     *
     * @param num l'identifiant unique d'un bateau
     * @param n le nom du bateau
     * @param Case[] la liste des cases composant le bateau
     * @param res la résistance du bateau
     * @param taille la taille du bateau
     * @throws ValParamException
     */
    public Bateau(Integer num, String n, Integer  res, Integer t) throws ValParamException{
        super(res, t);
        nom = n;
        id = num;
    }

    /*************************GETTERS ET SETTERS********************************/

    /**
     * Renvoie l'identifiant du bateau
     * @return Integer 
     */
    public Integer getId() {
        return id;
    }

    /**
     * Renvoie le nom du bateau
     * 
     * @return String
     */
    public String getName() {
        return nom;
    }

    /**
     * Renvoie la direction du bateau
     * 
     * @return String
     */
    public String getDirection() {
        return dir;
    }

    /**
     * Met à jour la direction du bateau
     * 
     * @param d
     * 
     * @return void
     */
    public void setDir(String d) {
        dir = d;
    }

    /*************************AUTRES FONCTIONS********************************/

    @Override
    public String toString() {
        return "Bateau [id = " + id + ", nom = " + nom + ", dir = " + dir + ", " + super.toString() + "]";
    }
}