package fr.ensma.a3.ia.bataillenavale.elem.etatCase;

import fr.ensma.a3.ia.bataillenavale.outils.TransitionException;

public abstract class AbstractEtat implements IEtat {

    protected IAutomEtat monAutom;

    public AbstractEtat(final IAutomEtat autom){
        monAutom = autom;
    }

    @Override
    public void subirAttaque() throws TransitionException{
        throw new TransitionException("Transition subirAttaque non tirable");
    }
}