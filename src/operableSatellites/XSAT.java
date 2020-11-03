package operableSatellites;

/**
 * XSAT est la sous-classe représentant un satellite de la famille XSAT. Elle
 * hérite de la classe Satellite.
 * 
 * Un satellite XSAT est caractérisé par : 1) un nom (de par son héritage), 2)
 * des composants (de par son héritage).
 * 
 * Il possède 4 sous-systèmes dès sa création : deux imageurs et deux
 * géolocalisateurs.
 * 
 * Il peut être lié à toutes les méthodes définies dans Satellite, les
 * principales étant pour déclencher une commande ou une mesure sur l'un de ses
 * composants :
 * 
 * @see Satellite#teleCommand(String, String)
 * @see Satellite#teleMetry(String)
 * 
 * @author ccornec
 */

public class XSAT extends Satellite {

    /**
     * Le constructeur de XSAT
     * 
     * A la construction d'un objet XSAT, le nom général du satellite est
     * personnalisé par un suffixe. Deux Imager et deux Geolocator sont
     * automatiquement ajoutés à ses composants.
     * 
     * @param suffixe, Le suffixe à ajouter à la fin du nom du composant
     */
    public XSAT(String suffixe) {

        super("XSAT" + suffixe);

        addSubsystem(new Imager("1"));
        addSubsystem(new Imager("2"));
        addSubsystem(new Geolocator("1"));
        addSubsystem(new Geolocator("2"));
    }

}
