package operableSatellites;

/**
 * ISAESAT est la sous-classe représentant un satellite de la famille ISAESAT.
 * Elle hérite de la classe Satellite.
 * 
 * Un satellite ISAESAT est caractérisé par : 1) un nom (de par son héritage),
 * 2) des composants (de par son héritage).
 * 
 * Il possède 2 composants dès sa création : 2 imageurs.
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

public class ISAESAT extends Satellite {

    /**
     * Le constructeur de ISAESAT
     * 
     * A la construction d'un objet ISAESAT, le nom général du satellite est
     * personnalisé par un suffixe. Deux Imager sont automatiquement ajoutés à ses
     * composants.
     * 
     * @param suffixe, Le suffixe à ajouter à la fin du nom du composant
     */
    public ISAESAT(String suffixe) {

        super("ISAESAT" + suffixe);

        addSubsystem(new Imager("1"));
        addSubsystem(new Imager("2"));

    }

}
