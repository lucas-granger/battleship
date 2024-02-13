package fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class ContreTorpilleur extends Bateau{
    
    private Integer puissAtk;

    /**
     * Instancie un Contre-Torpilleur.
     *
     * @param c la liste de Cases du bateau
     * @throws ValParamException
     */
    public ContreTorpilleur() throws ValParamException{
        super(3, "Contre-Torpilleur", 3, 3);
        puissAtk = 3;
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
