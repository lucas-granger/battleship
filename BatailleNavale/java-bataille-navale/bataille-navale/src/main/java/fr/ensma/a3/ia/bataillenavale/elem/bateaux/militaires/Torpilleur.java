package fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.affichage.Case;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class Torpilleur extends Bateau{
    
    private Integer  puissAtk;

    /**
     * Instancie un Torpilleur.
     *
     * @param c la liste de Cases du bateau
     * @throws ValParamException
     */
    public Torpilleur() throws ValParamException{
        super(5, "Torpilleur", 2, 2);
        puissAtk = 2;
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
