package fr.ensma.a3.ia.bataillenavale.elem.bateaux.civils;

import fr.ensma.a3.ia.bataillenavale.affichage.Case;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Voilier extends Bateau{

    /**
     * Instancie un Voilier.
     *
     * @param c la liste de Cases du bateau
     * @throws ValParamException
     */
    public Voilier(Case[] c) throws ValParamException{
        super(6, "Voilier", c, 2, 1);
    }
}
