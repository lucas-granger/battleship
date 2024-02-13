package fr.ensma.a3.ia.bataillenavale.outils;

import fr.ensma.a3.ia.bataillenavale.elem.Case;

public class MortPersonnageException extends Exception {

    private Case elem;

    public MortPersonnageException(Case pers) {
        elem = pers;
    }

    public Case getElem() {
        return elem;
    }

}
