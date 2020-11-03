package operableSatellites;

import datatype.*;

/**
 * Imager est la sous-classe représentant un imageur, un sous-type de composant.
 * Elle hérite de la classe abstraite Subsystem.
 * 
 * Un imager est caractérisé par un nom (de par son héritage).
 * 
 * Le rôle d'un imageur est de réaliser une mesure de type bitmap. Il peut être
 * lié à toutes les méthodes définies dans Subsystem, notamment pour répondre à
 * une commande ou réaliser une mesure :
 * 
 * @see Subsystem#operate(String)
 * @see Subsystem#measure()
 * 
 * @author ccornec
 */

public class Imager extends Subsystem {

    /**
     * Le constructeur de Imager
     * 
     * A la construction d'un objet Imager, le nom général du composant est
     * personnalisé par un suffixe.
     * 
     * @param suffixe, Le suffixe à ajouter à la fin du nom du composant
     */
    public Imager(String suffixe) {
        super("IMAGER" + suffixe);
    }

    /**
     * Effectue une mesure sous forme de bitmap
     * 
     * @return La donnée bitmap mesurée
     */
    public Measurement measure() {
        Measurement measurement = new Measurement();
        if (getStatus() == true) {
            measurement.setData(new Bitmap());
            measurement.setStatus(Status.OK);
        }
        else {
            measurement.setData(null);
            measurement.setStatus(Status.KO);
        }
        return measurement;
    }

}
