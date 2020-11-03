package controlCenter;

import java.util.Scanner;

import operableSatellites.*;
import datatype.*;
import database.*;
import SCRIPTS.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * ControlCenter est la classe représentant un centre de contrôle de satellites.
 * 
 * Un centre de contrôle est caractérisé par : 1) Un tableau de satellites qu'il
 * peut téléopérer, 2) une archive qui contient les mesures effectuées par les
 * composants des satellites.
 * 
 * Le rôle de ControlCenter est de téléopérer des satellites à distance.
 * 
 * @see ControlCenter#teleOperation()
 * 
 * @author ccornec
 */

public class ControlCenter {

    /**
     * Le tableau de satellites téléopérés par le centre de contrôle. Ce tableau est
     * incrémentable.
     * 
     * @see ControlCenter#addSatellite(Satellite)
     */
    private HashMap<String, Satellite> satellites_map;

    /**
     * L'archive du centre de contrôle. Cette archive est incrémentable.
     * 
     * @see DataArchive#addData(Data)
     */
    private static DataArchive archive;

    /**
     * Le constructeur de ControlCenter.
     * 
     * A la construction d'un objet ControlCenter, le tableau de satellites et
     * l'archive sont créés vides.
     */
    public ControlCenter() {
        this.satellites_map = new HashMap<String, Satellite>();
        this.archive = new DataArchive();
    }

    /**
     * Ajoute un satellite au tableau de satellites téléopérés.
     * 
     * @param sat Le nouveau satellite téléopéré par le centre de contrôle.
     */
    public void addSatellite(Satellite satellite) {
        satellites_map.put(satellite.getName(), satellite);
    }

    /**
     * Vérifie si le satellite appartient au tableau de satellites téléopérés.
     * 
     * @param sat Le satellite à vérifier.
     * @return True si le satellite est téléopéré par le centre de contrôle, False
     *         sinon.
     */
    public boolean checkSat(Satellite sat) {
        if (satellites_map.containsValue(sat)) {
            return true;
        } else {
            return false;
        }
    }

    // Permet de choisir entre une télécommande et une télémesure
    static public Status operation(Satellite sat, String sub, String op) {

        if (op.equals("DATA")) {
            // Transmet une demande de mesure au satellite sat, pour un composant sub donné.
            if (sat.teleMetry(sub).getStatus() == Status.OK) {
                // Archive le résultat de la mesure si celle-ci a été effectuée avec succès.
                archive.addData(sat.teleMetry(sub).getData());
                return Status.OK;
            } else {
                return Status.KO;
            }
        } else {
            /*
             * Transmet une demande de commande op au satellite sat, pour un composant sub
             * donné.
             */
            return sat.teleCommand(sub, op);
        }
    }

    /**
     * Gère la téléopération des satellites. Transmet les demandes d'opérations de
     * l'utilisateur aux satellites ou à l'archive.
     * 
     * @throws IOException
     */
    public void teleOperation() throws IOException {

        /*
         * Explique le fonctionnement du centre de contrôle à l'utilisateur et lui
         * propose de saisir une opération.
         */
        System.out.println("\nBienvenue au centre de contrôle ! Votre opération doit être sous la forme :");
        System.out.println("- SATELLITE:SUBSYSTEM:OPERATION pour effectuer une opération sur un satellite");
        System.out.println("- SATELLITE:PROCEDURE pour lancer une procédure sur un satellite");
        System.out.println("- PRINT_ARCHIVE pour imprimer le contenu de l'archive");
        System.out.println("- EXIT pour quitter le centre de contrôle\n");
        System.out.println("Opération à réaliser :");

        // Lance l'interface utilisateur.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String user_text = scanner.nextLine();
            String[] text = user_text.split(":");

            if (text.length == 1) {
                if (user_text.equals("PRINT_ARCHIVE")) {
                    // Imprime l'archive dans le terminal.
                    if (archive.getSize() != 0) {
                        archive.display();
                    } else {
                        System.out.println("\nL'archive est actuellement vide.");
                    }
                } else if (user_text.equals("EXIT")) {
                    // Termine le programme.
                    break;
                } else {
                    // Signale à l'utilisateur que sa saisie ne peut pas être traitée.
                    System.out.println("\nL'opération que vous avez saisie n'est pas de la forme désirée.");
                }
            }

            else {
                Satellite sat = satellites_map.get(text[0]);

                /*
                 * S'exécute si le satellite renseigné est téléopéré par le centre de contrôle.
                 */
                if (checkSat(sat)) {
                    if (text.length == 2) {

                        String script = text[1];

                        ScriptReader script_reader = new ScriptReader();
                        System.out.println(script_reader.read(sat, script));

                    } else if ((text.length == 3)) {

                        String sub = text[1];
                        String op = text[2];

                        System.out.println(operation(sat, sub, op));
                    }
                }

                else {
                    System.out.println(Status.KO);
                }
            }

            // Propose à l'utilisateur de faire une nouvelle saisie.
            System.out.println("\nOpération suivante :");
        }
    }
}

// if (user_text.endsWith(":")) {
// System.out.println("\nL'opération que vous avez saisie n'est pas de la forme
// désirée.");
// }