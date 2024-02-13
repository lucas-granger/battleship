package fr.ensma.a3.ia.bataillenavale.elem.etatCase;

public interface IAutomEtat extends IEtat{
    IEtat getEtatNormal();

    IEtat getEtatTouchee();

    IEtat getEtatDetruite();

    void setEtatCourant(final IEtat state);

}
