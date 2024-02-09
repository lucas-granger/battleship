package fr.ensma.a3.ia.bataillenavale.affichage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputFilter.Config;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.TextTable.Cell;

import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.PorteAvions;
import fr.ensma.a3.ia.bataillenavale.outils.GestionCoordonnees;
import fr.ensma.a3.ia.bataillenavale.outils.GestionFlotte;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

/**
 * Modélise un Joueur
 * 
 * @author Lucas
 * @since 1.0
 * @version 1.0
 */
public class Joueur {

    protected String pseudo;
    protected Plateau plateau = new Plateau();

    /**
     * Instancie un Joueur
     * 
     * @param pseudo String (non null)
     * @throws ValParamException
     */
    public Joueur(String p) throws ValParamException{
        setPseudo(p);
        logger.info("Joueur cree : Pseudo = {}", pseudo);
    }

    /**
     * Renvoie le pseudo du joueur
     * @return le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }
    
    /**
     * Renvoie le plateau du joueur
     * @return Plateau
     */
    protected Plateau getPlateau() {
        return plateau;
    }
    
    /**
     * Met à jour le pseudo du Joueur
     * @param pseudo
     */
    public void setPseudo(String p) {
        pseudo = p;
    }

    public void placerBateaux(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <plateau.getBateaux().length; i++) {
            //Choix Case + direction
            String input = "";
            try{
                input = in.readLine();
            } catch (java.io.IOException ex){
                System.out.println("Erreur : " + ex);
            }
            if (Pattern.matches("^[HVhv][abcdefghijABCDEFGHIJ][1-9][0]{0,1}", input)) {
                    String direction = input.substring(0, 1).toUpperCase();
                    Integer x = Integer .valueOf(input.substring(2)) - 1;
                    Integer y = Integer .valueOf(GestionCoordonnees.lettreANombre(input.substring(1, 2).toUpperCase()));
                    Case[] coordBat = plateau.getBateaux().generateBoatCoordinates(x, y, direction, boatSize, Integer .valueOf(Config.getBoatsConfig(i)[0]));


            }
        }
    }

    /**
     * Redéfinition de toString.
     */
    @Override
    public String toString() {
        return "Joueur " + pseudo;
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
        Joueur other = (Joueur) obj;
        if (!pseudo.equals(other.pseudo))
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
        result = prime * result + pseudo.hashCode();
        return result;
    }

    private static Logger logger = LogManager.getLogger(Joueur.class);
}

