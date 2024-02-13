package fr.ensma.a3.ia.bataillenavale.elem.etatCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.bataillenavale.outils.TransitionException;

public class Normal extends AbstractEtat{
    public Normal(final IAutomEtat autom){
        super(autom);
    }
    
    @Override
    public void subirAttaque() throws TransitionException {
        monAutom.setEtatCourant(monAutom.getEtatTouchee());
        logger.info("Case touchee !!!");
    }
private static Logger logger = LogManager.getLogger(Normal.class);
}
