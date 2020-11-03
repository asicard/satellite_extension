package operableSatellites;

import datatype.*;

/**
 * Subsystem est la super-classe abstraite représentant un composant de
 * satellite.
 * 
 * Un composant est caractérisé par : 1) Un nom, 2) un état allumé/éteint.
 * 
 * Le rôle du composant est de réaliser la commande ou de réaliser la mesure
 * déclenchée par le satellite auquel il appartient :
 * 
 * @see Subsystem#operate(String)
 * @see Subsystem#measure()
 * 
 * @author ccornec
 */

abstract public class Subsystem {

    /**
     * Le nom du composant.
     */
    private String sub_name;

    /**
     * L'état du composant : allumé (True) ou éteint (False).
     */
    private boolean activated;

    /**
     * Le constructeur de Subsystem
     * 
     * A la construction d'un objet Subsystem, le nom du composant est initialisé
     * avec le nom renseigné en paramètre et le composant est considéré éteint .
     * 
     * @param name Le nom du composant
     */
    public Subsystem(String name) {
        this.activated = false;
        this.sub_name = name;
    }

    /**
     * Réalise la commande si celle-ci est reconnue par le composant : ON ou OFF.
     * 
     * @param command La commande à réaliser
     * @return OK si la commande est un succès, KO si la commande est un échec
     */
    Status operate(String command) {
        if (command.equals("ON")) {
            if (activated == false) {
                this.activated = true;
                //System.out.println("\n" + sub_name + " a bien été activé :");
                return Status.OK;
            } else {
                //System.out.println("\n" + sub_name + " est déjà allumé :");
                return Status.OK;
            }
        }
        if (command.equals("OFF")) {
            if (activated == true) {
                this.activated = false;
                //System.out.println("\n" + sub_name + " a bien été désactivé :");
                return Status.OK;
            } else {
                //System.out.println("\n" + sub_name + " est déjà éteint :");
                return Status.OK;
            }
        } else {
            //System.out.println("\nLa commande n'existe pas pour le sous-sytème mentionné :");
            return Status.KO;
        }
    }

    /**
     * Effectue une mesure.
     * Méthode abstraite définie par chacun des sous-types de Subsystem.
     * 
     * @return La donnée mesurée
     */
    abstract Measurement measure();

    /**
     * Retourne l'état du composant.
     * 
     * @return True si le composant est allumé et False si le composant est éteint
     */
    boolean getStatus() {
        return activated;
    }

    /**
     * Retourne le nom du composant.
     * 
     * @return String, Le nom du satellite
     */
    public String getName() {
        return this.sub_name;
    }

}
