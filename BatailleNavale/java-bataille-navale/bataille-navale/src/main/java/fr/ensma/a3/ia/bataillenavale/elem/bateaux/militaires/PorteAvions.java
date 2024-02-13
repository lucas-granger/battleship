package fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires;

import fr.ensma.a3.ia.bataillenavale.elem.bateaux.Bateau;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

public class PorteAvions extends Bateau{
    
    private Integer puissAtk;

    /**
     * Instancie un PorteAvions.
     *
     * @param c la liste de Cases du bateau
     * @throws ValParamException
     */
    public PorteAvions() throws ValParamException{
        super(1, "Porte-Avions ", 5, 5);
        puissAtk = 5;
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