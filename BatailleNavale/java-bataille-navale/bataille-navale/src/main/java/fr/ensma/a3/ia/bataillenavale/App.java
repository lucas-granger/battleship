package fr.ensma.a3.ia.bataillenavale;

import fr.ensma.a3.ia.bataillenavale.affichage.Joueur;
import fr.ensma.a3.ia.bataillenavale.affichage.Plateau;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.ContreTorpilleur;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.Croiseur;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.PorteAvions;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.SousMarin;
import fr.ensma.a3.ia.bataillenavale.elem.bateaux.militaires.Torpilleur;
import fr.ensma.a3.ia.bataillenavale.outils.ValParamException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Bataille Navale");
        try{
            //genererPlateau(10, 10);
            Plateau plateau = new Plateau();

        }
        catch (final ValParamException ex) {
            System.out.println(ex.getMessage());
        }
        
        // System.out.println("Le jeu des personnages !!");
        // try {
        //     Base winterfell = new Base("Winterfell", ECouleur.bleu);
        //     Ouvrier hodor = new Ouvrier(255.0f, winterfell, 2500, "Hodor");
        //     Guerrier jSnow = new Guerrier(150.0f, winterfell, 450, "John Snow");
        //     System.out.println(winterfell.afficheElements());
        //     Base castralRoc = new Base("Castral Roc", ECouleur.rouge);
        //     Guerrier joffrey = new Guerrier(75.0f, castralRoc, 200, "Joffrey");
        //     System.out.println(castralRoc.afficheElements());
        //     Base peyredragon = new Base("Peyredragon", ECouleur.noir);
        //     Dragon viserion = new Dragon(2000.0f, peyredragon, "Viserion", 3000);
        //     Dragon drogon = new Dragon(3500.0f, peyredragon, "Drogon", 3500);
        //     System.out.println(peyredragon.afficheElements());
        //     // déplacement
        //     hodor.deplacer();
        //     jSnow.deplacer();
        //     joffrey.deplacer();
        //     viserion.deplacer();
        //     drogon.deplacer();
        //     // Attaque
        //     try {
        //         jSnow.aLAttaque(joffrey);
        //         joffrey.aLAttaque(hodor);

        //         // joffrey.aLAttaque(viserion);
        //         viserion.aLAttaque(joffrey);
        //         drogon.aLAttaque(viserion);
        //     } catch (MortPersonnageException ex) {
        //         if (ex.getElem() == joffrey) {
        //             joffrey = null;
        //         }
        //     }
        //     //joffrey.deplacer();
        //     //La Troupe
        //     Troupe amis = new Troupe("Troupe des amis...");
        //     amis.rejoindreTroupe(jSnow);
        //     amis.rejoindreTroupe(hodor);
        //     amis.rejoindreTroupe(viserion);
        //     System.out.println(amis);
        //     amis.deplacer();
        //     amis.quitterTroupe(hodor);
        //     jSnow.setCompDepl(new Courir());
        //     System.out.println(amis);
        //     //Pattern Etat --> arret
        //     jSnow.arret();
        //     amis.deplacer();

        //     joffrey = new Guerrier(75.0f, castralRoc, 200, "Joffrey");
        //     jSnow.setCompAtt(new ALaHache());
        //     try {
        //         jSnow.aLAttaque(joffrey);
        //     } catch (MortPersonnageException ex) {
        //         ex.printStackTrace();
        //     }

        //     IGuerrier joffreyCask = new Casque(joffrey);
        //     System.out.println(joffreyCask);
        //     joffreyCask.deplacer();
        //     joffreyCask.arret();
        //     joffreyCask.deplacer();
        //     try {
        //         jSnow.aLAttaque(joffreyCask);
        //     } catch (MortPersonnageException ex) {
        //         ex.printStackTrace();
        //     }
        //     System.out.println(joffrey);

        //     IGuerrier monguerrier = new Guerrier(75.0f, castralRoc, 200, "Bob");
        //     System.out.println(monguerrier);
        //     monguerrier = new Casque(monguerrier);
        //     System.out.println(monguerrier);


        // } catch (final ValParamException ex) {
        //     System.out.println(ex.getMessage());
        // }
    }
}
