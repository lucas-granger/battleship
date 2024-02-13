package fr.ensma.a3.ia.bataillenavale.elem.objets;

import fr.ensma.a3.ia.bataillenavale.elem.Case;
import fr.ensma.a3.ia.bataillenavale.elem.ElementJeu;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Bombe extends ElementJeu{

    /**
     * Instancie une Bombe.
     *
     * @param Case[] la liste des cases composant la bombe
     * @throws ValParamException
     */
    public Bombe(Case[] c) throws ValParamException{
        super(1, 3);
    }
    
}
