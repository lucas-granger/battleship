package fr.ensma.a3.ia.bataillenavale.affichage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.elem.Case;
import fr.ensma.a3.ia.bataillenavale.elem.ElementJeu;
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

    /*************************GETTERS ET SETTERS********************************/

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

    /*************************GETTERS ET SETTERS********************************/

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

    /**
     * Renvoie la grille d'un joueur
     * 
     * @return Case[][]
     */
    public Case[][] getGrille() {
        return grille;
    }

    /*************************AUTRES FONCTIONS********************************/

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
     * Place les bateaux sur la grille
     * 
     * @return void
     */
    public void placerBateaux(){
        for (Bateau bateau : bateaux) {
            Boolean error = true;
            String dir = "";
            Integer x = 0;
            Integer y = 0;

            /* Tant qu'on a une erreur, on redemande un placement */
            while (error == true) {
                error = false;
                System.out.println("Bateau a placer : " + bateau.toString());
                BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader coordx = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader coordy = new BufferedReader(new InputStreamReader(System.in));

                try {
                    System.out.print("Veuillez choisir une direction (H ou V) : ");
                    dir = d.readLine();
                    System.out.print("Veuillez choisir une ligne (0-9) : ");
                    x = Integer.valueOf(coordx.readLine());
                    System.out.print("Veuillez choisir une colonne (0-9) : ");
                    y = Integer.valueOf(coordy.readLine());
                } catch (java.io.IOException e) {
                    System.out.println("Une erreur est survenue : " + e);
                }

                /* Recherche d'une potentielle erreur */
                error = erreurPlacement(bateau, x, y, dir);
            }

            /*Pas d'erreur, le bateau rejoint les cases dont les informations sont mises à jour */
            if (dir.equals("H")){
                for (int i = 0; i < bateau.getTaille(); i++) {
                    Case cell = getCoord(x, y+i);
                    cell.rejoindreCase(bateau);
                    cell.setNivVie(bateau.getRes());
                    bateau.setDir(dir);
                    logger.info(cell.toString());
                }
            }
            if (dir.equals("V")){
                for (int i = 0; i < bateau.getTaille(); i++) {
                    Case cell = getCoord(x+i, y);
                    cell.rejoindreCase(bateau);
                    cell.setNivVie(bateau.getRes());
                    bateau.setDir(dir);
                    logger.info(cell.toString());
                }
            }
            System.out.println(this.toString());
        }
    }

    /**
     * Vérifie que les coordonnées restent bien dans la grille
     *
     * @param Integer x
     * @param Integer y
     * 
     * @return boolean
     */
    public boolean isInBoard(Integer x, Integer y) {
        if (!(x >= 0 && x <= 9 && y >= 0 && y <= 9)) {
            return false;
        }
        return true;
    }

    /**
     * Vérifie si une erreur de placement est faite
     *
     * @param Bateau bateau
     * @param Integer x
     * @param Integer y
     * @param String dir
     * 
     * @return boolean
     */
    public boolean erreurPlacement(Bateau bateau, Integer x, Integer y, String dir) {

        /* ERREUR : Paramètre x en dehors de [0, 9] */
        if (x < 0 || x > 9) {
            System.out.println("La composante X de votre bateau est invalide.");
            return true;
        }

        /* ERREUR : Paramètre y en dehors de [0, 9] */
        if (y < 0 || y > 9) {
            System.out.println("La composante X de votre bateau est invalide.");
            return true;
        }

        /* ERREUR : Paramètre dir différent de "V" ou de "H" */
        if (!dir.equals("V") & !dir.equals("H")){
            System.out.println("La direction de votre bateau est invalide.");
            return true;
        }

        /* ERREUR : Un bateau en chevauche un autre */
        Case[] casesBateau = new Case[bateau.getTaille()];
        if (dir.equals("H")){
            for (int i = 0; i < bateau.getTaille(); i++) {

                /* ERREUR : La case a un paramètre x ou y en dehors de [0, 9] */
                if (!isInBoard(x, y+i)){
                    System.out.println("La composante Y de votre bateau est invalide.");
                    return true;
                }

                Case cell = getCoord(x, y+i);
                casesBateau[i] = cell;
                if (cell.estOccupee() == true) {
                    System.out.println("Votre bateau en chevauche un autre.");
                    return true;
                }
            }
            return false;
        }
        
        if (dir.equals("V")) {
            for (int i = 0; i < bateau.getTaille(); i++) {

                /* ERREUR : La case a un paramètre x ou y en dehors de [0, 9] */
                if (!isInBoard(x+i, y)){
                    System.out.println("La composante X de votre bateau est invalide.");
                    return true;
                }

                Case cell = getCoord(x+i, y);
                casesBateau[i] = cell;
                if (cell.estOccupee() == true) {
                    System.out.println("Votre bateau en chevauche un autre.");
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String buffer = "";
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                for (ElementJeu bateau : grille[i][j].getAbonnes()) {
                    if (bateau instanceof Bateau) {
                        buffer += (" " + bateau.getId() + " ");
                    }
                }
                if (grille[i][j].getAbonnes().isEmpty()){
                    buffer += "   ";
                }
                if (j < grille[i].length - 1) {
                    buffer += ("|");
                }
            }
            buffer += "\n";
            if (i < grille.length - 1) {
                for (int k = 0; k < grille[i].length; k++) {
                    buffer += "---";
                    if (k < grille[i].length - 1) {
                        buffer += "|";
                    }
                }
                buffer += "\n";
            }
        }
        return buffer;
    }

    private static Logger logger = LogManager.getLogger(Plateau.class);

}
