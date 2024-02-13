package fr.ensma.a3.ia.bataillenavale.affichage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.elem.Case;
import fr.ensma.a3.ia.bataillenavale.elem.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
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

    /**
     * Attaque un bateau adverse
     */
    //TODO : Créer une fonction qui vérifie que l'attaquant est bien un IAttaquant
    //       Sysout(attaquant.getName + " attaque !")
    //       Demander la cible
    //       if (cible.getAbonnes instanceOf() IVisible)
    //          ("Aie ca fait mal")
    //       cible.setNivVie(cible.getNivVie() - attaquant.getPuissAtk())
    @Override
    public void aLAttaque(final Case cible){
        Integer id = 0;

        /* Choix de l'attaquant */
        try {
            BufferedReader index = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Avec quel bateau voulez-vous attaquer ?");
            id = Integer.valueOf(index.readLine());
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e);
        }
        Bateau bateau = plateau.getBateau(id);

        
        erreurAtk
        System.out.println("Vous avez choisi le " + bateau.getName() + ".");

        /* Choix de la cible */
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

