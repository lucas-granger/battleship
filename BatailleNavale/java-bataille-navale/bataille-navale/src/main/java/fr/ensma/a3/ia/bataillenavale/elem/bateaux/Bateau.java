package fr.ensma.a3.ia.bataillenavale.elem.bateaux;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputFilter.Config;
import java.util.regex.Pattern;

import fr.ensma.a3.ia.bataillenavale.affichage.Case;
import fr.ensma.a3.ia.bataillenavale.elem.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.outils.GestionCoordonnees;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public abstract class Bateau extends ElementJeu{

    protected Integer id;
    private String nom;
    private String dir;

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

    public void setDir(String d) {
        dir = d;
    }

    public Case[] placerBateau(Bateau bat){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            // Choix Case + direction
        String input = "";
        try {
            input = in.readLine();
        } catch (java.io.IOException ex) {
            System.out.println("Erreur : " + ex);
        }
        if (Pattern.matches("^[HVhv][abcdefghijABCDEFGHIJ][1-9][0]{0,1}", input)) {
            String direction = input.substring(0, 1).toUpperCase();
            Integer x = Integer.valueOf(input.substring(2)) - 1;
            Integer y = Integer.valueOf(GestionCoordonnees.lettreANombre(input.substring(1, 2).toUpperCase()));
            bat.setDir(direction);
            Case[] coordBat = new Case[bat.getTaille()];
            for (int index = 0; index < bat.getTaille(); index++) {
                if (bat.getDirection() == "H"){
                    coordBat[index] = new Case(x, y);
                    
                    

                }
  
            }
        }
        return coordBat;
    }
}