package datatype;

import java.util.Date;

/**
 * Data est la super-classe représentant une donnée satellite.
 * 
 * Une donnée satellite est caractérisée par une date.
 * 
 * @author ccornec
 */

public class Data {

    /**
     * La date et l'heure associées à la donnée.
     */
    private Date date;

    /**
     * Le constructeur de Data
     * 
     * A la construction d'un objet Data, la date est initialisée avec l'heure et la
     * date de construction de l'objet.
     */
    public Data() {
        this.date = new Date();
    }

    /**
     * Permet d'accéder à la date d'une donnée
     * 
     * @return Date, La date de la donnée
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Retourne une représentation textuelle de la donnée
     * 
     * @return La représentation String de la donnée
     */
    @Override
    public String toString() {
        return "{" + date + "}";
    }

}
