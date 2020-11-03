package datatype;

import java.util.Random;

/**
 * Geolocation est la classe représentant une géolocalisation, un sous-type de
 * données. Elle hérite de la classe Data.
 * 
 * Une géolocalisation est caractérisée par : 1) Une date (de par son héritage),
 * 2) une latitude et une longitude.
 * 
 * @author ccornec
 */

public class Geolocation extends Data {

    /**
     * La latitude
     */
    private int[] latitude;

    /**
     * La matrice de nuances de gris qui constitue la bitmap.
     */
    private int[] longitude;

    /**
     * Le constructeur de Bitmap
     * 
     * A la construction d'un objet Geolocation, la latitude et la longitude sont
     * initialisées avec une liste de 3 entiers. Le premier élément est un entier
     * aléatoire qui vaut 0 ou 1 pour Nord ou Sud et Est ou Ouest. Le deuxième
     * élément correspond au degré, choisi aléatoirement entre 0 et 89, et le
     * troisième élément se réfère aux minutes, choisies aléatoirement entre 0 et
     * 59.
     */
    public Geolocation() {
        super();
        Random rand = new Random();
        latitude = new int[] { rand.nextInt(2), rand.nextInt(89), rand.nextInt(59) };
        longitude = new int[] { rand.nextInt(2), rand.nextInt(89), rand.nextInt(59) };
    }

    /**
     * Associe la latitude et la longitude pour créer une représentation textuelle
     * d'une coordonnée WGS84 sous la forme {N 15° 49', O 72° 44'}
     * 
     * @return La coordonnée WGS84
     */
    String toWGS84() {
        String[] lat_direction = { "N", "S" };
        String[] longit_direction = { "E", "O" };
        return lat_direction[latitude[0]] + " " + latitude[1] + "° " + latitude[2] + "', "
                + longit_direction[longitude[0]] + " " + longitude[1] + "° " + longitude[2] + "'";
    }

    /**
     * Retourne une représentation textuelle d'une donnée de type géolocalisation,
     * qui comprend une date et une coordonnée WGS84.
     * 
     * @return La représentation String de la géolocalisation
     */
    @Override
    public String toString() {
        return "{ " + getDate() + "\nCoordonnées : " + toWGS84() + " }";
    }

}
