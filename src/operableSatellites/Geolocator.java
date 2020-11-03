package operableSatellites;

import datatype.*;

/**
 * Geolocator est la sous-classe représentant un géolocalisateur, un sous-type
 * de composant. Elle hérite de la classe abstraite Subsystem.
 * 
 * Un géolocalisateur est caractérisé par un nom (de par son héritage).
 * 
 * Le rôle d'un géolocalisateur est de déclencher une mesure de type
 * géolocalisation. Il peut être lié à toutes les méthodes définies dans
 * Subsystem, notamment pour répondre à une commande ou réaliser une mesure :
 * 
 * @see Subsystem#operate(String)
 * @see Subsystem#measure()
 * 
 * @author ccornec
 */

public class Geolocator extends Subsystem {

    /**
     * Le constructeur de Geolocator
     * 
     * A la construction d'un objet Geolocator, le nom général du composant est personnalisé
     * par un suffixe.
     * 
     * @param suffixe, Le suffixe à ajouter à la fin du nom du composant
     */
    public Geolocator(String suffixe) {
        super("GEOLOCATOR" + suffixe);
    }

    /**
     * Effectue une mesure de géolocalisation
     * 
     * @return La donnée de géolocalisation mesurée 
     */
    public Measurement measure() {
        Measurement measurement = new Measurement();
        if (getStatus() == true) {
            measurement.setData(new Geolocation());
            measurement.setStatus(Status.OK);
        }
        else {
            measurement.setData(null);
            measurement.setStatus(Status.KO);
        }
    return measurement;
    }
}
