package database;

import datatype.*;

import java.util.TreeMap;
import java.util.Date;

/**
 * DataArchive est la classe représentant une archive de données qui proviennent
 * des mesures effectuées par les composants des satellites.
 * 
 * Une archive de données est caractérisée par un tableau de données, ordonnées
 * par date.
 * 
 * @author ccornec
 */

public class DataArchive {

    /**
     * Le tableau de données, ordonnées par date, qui constitue l'archive. Ce
     * tableau est incrémentable.
     * 
     * @see DataArchive#addData(Data)
     */
    private TreeMap<Date, Data> data_map;

    /**
     * Le constructeur de DataArchive.
     * 
     * A la construction d'un objet DataArchive, le tableau de données est créé
     * vide.
     */
    public DataArchive() {
        data_map = new TreeMap<Date, Data>();
    }

    /**
     * Ajoute une donnée à l'archive.
     * 
     * @param data La donnée ajoutée.
     */
    public void addData(Data data) {
        data_map.put(new Date(), data);
    }

    /**
     * Retourne le nombre de données dans l'archive.
     * 
     * @return Le nombre de données.
     */
    public int getSize(){
        return data_map.size();
    }

    /**
     * Imprime proprement les valeurs de l'archive.
     * 
     * @param data La donnée ajoutée.
     */
    public void display() {
        System.out.println("\nDonnées archivées :");
        for (Data data : data_map.values()) {
            System.out.println();
            System.out.println(data);
        }
    }

    /**
     * Retourne une représentation textuelle de l'archive.
     * 
     * @return Une représentation String de l'archive
     */
    @Override
    public String toString() {
        return "\nDonnées archivées : \n" + data_map;
    }

}
