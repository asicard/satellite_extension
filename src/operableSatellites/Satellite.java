package operableSatellites;

import java.util.HashMap;
import datatype.*;

/**
 * Satellite est la super-classe représentant un satellite téléopérable.
 * 
 * Un satellite est caractérisé par : 1) Un nom, 2) des composants.
 * 
 * Le rôle du satellite est de déclencher une commande ou une télémesure sur un
 * de ses composants :
 * 
 * @see Satellite#teleCommand(String, String)
 * @see Satellite#teleMetry(String)
 * 
 *      Le satellite pourra ajouter des composants à son tableau :
 * @see Satellite#addSubsystem(Subsystem)
 * 
 * @author ccornec
 */

public class Satellite {

    /**
     * Le nom du satellite.
     */
    private String sat_name;

    /**
     * Les composants que possède le satellite. Ce tableau est incrémentable.
     * 
     * @see Satellite#addSubsystem(Subsystem)
     */
    private HashMap<String, Subsystem> subsys_map;

    /**
     * Le constructeur de Satellite
     * 
     * A la construction d'un objet Satellite, le nom du satellite est initialisé
     * avec le nom renseigné en paramètre et le tableau de composants est créé vide.
     * 
     * @param name Le nom du satellite
     */
    public Satellite(String name) {
        sat_name = name;
        subsys_map = new HashMap<String, Subsystem>();
    }

    /**
     * Vérifie que le satellite possède un composant, à partir de son nom.
     * 
     * @param sub Le composant à vérifier
     * @return True si le satellite possède ce composant, False sinon
     */
    public boolean checkSub(String sub) {
        if (subsys_map.containsKey(sub)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Déclenche une commande sur un composant si celui-ci appartient effectivement
     * au satellite.
     * 
     * @param sub     Le composant sur lequel porte la commande
     * @param command La commande à déclencher
     * @return OK si la commande est un succès, KO si la commande est un échec
     */
    public Status teleCommand(String sub, String command) {
        if (checkSub(sub) == true) {
            return getSubsystem(sub).operate(command);
        } else {
           // System.out.println("\nLe sous-système renseigné n'appartient pas au satellite :");
            return Status.KO;
        }
    }

    /**
     * Déclenche une mesure par un composant si celui-ci appartient effectivement au
     * satellite et est allumé.
     * 
     * @param sub Le composant qui doit réaliser la mesure
     * @return La donnée mesurée
     */
    public Measurement teleMetry(String sub) {
        if (checkSub(sub) == true) {
            // System.out.println("\nLa mesure a été réalisée avec succès :\n" + Status.OK);
            return getSubsystem(sub).measure();
        } else {
            getSubsystem(sub).measure().setStatus(Status.KO);
            //System.out.println(
            //        "\nLe sous-système renseigné n'existe pas pour ce satellite, ou n'a pas encore été activé :\n"
            //                + Status.KO);
            return getSubsystem(sub).measure();
        }
    }

    /**
     * Retourne le nom du satellite.
     * 
     * @return Le nom du satellite
     */
    public String getName() {
        return this.sat_name;
    }

    /**
     * Retourne un composant, à partir de son nom.
     * 
     * @param sub_name Le nom du composant
     * @return Le composant à retourner
     */
    public Subsystem getSubsystem(String sub_name) {
        return subsys_map.get(sub_name);
    }

    /**
     * Ajoute un composant au satellite.
     * 
     * @param sub Le composant ajouté
     */
    public void addSubsystem(Subsystem sub) {
        subsys_map.put(sub.getName(), sub);
    }

}