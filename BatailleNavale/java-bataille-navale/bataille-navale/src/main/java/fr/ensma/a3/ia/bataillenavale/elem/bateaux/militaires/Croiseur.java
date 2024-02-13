package fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Croiseur extends Bateau{
    
    private Integer  puissAtk;

    /**
     * Instancie un Croiseur.
     *
     * @param c la liste de Cases du bateau
     * @throws ValParamException
     */
    public Croiseur() throws ValParamException{
        super(2, "Croiseur", 4, 4);
        puissAtk = 4;
    }

    /**
     * Obtient la puissance d'attaque
     *
     * @return la puissance d'attaque du bateau
     */
    public final Integer getPuissAttaque() {
        return puissAtk;
    }
}
