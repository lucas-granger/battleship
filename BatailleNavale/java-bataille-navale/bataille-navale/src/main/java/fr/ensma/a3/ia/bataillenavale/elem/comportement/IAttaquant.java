package fr.ensma.a3.ia.bataillenavale.elem.comportement;

import fr.ensma.a3.ia.bataillenavale.elem.Case;
import fr.ensma.a3.ia.bataillenavale.outils.MortPersonnageException;

public interface IAttaquant {

    public void aLAttaque(final Case cible)
        throws MortPersonnageException;
}
