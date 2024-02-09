package fr.ensma.a3.ia.bataillenavale.affichage;

import fr.ensma.a3.ia.bataillenavale.outils.GestionConsole;
import fr.ensma.a3.ia.bataillenavale.outils.GestionTexte;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Integer joueurActif;
    private String winner;

    public void init(String pseudo1, String pseudo2) throws ValParamException{
        joueur1 = new Joueur(pseudo1);
        joueur2 = new Joueur(pseudo2);

        joueur1.placerBateaux();
        joueur2.placerBateaux();
    }

}
