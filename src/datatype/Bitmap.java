package datatype;

import java.util.Arrays;
import java.util.Random;

/**
 * Bitmap est la classe représentant une bitmap, un sous-type de données. Elle
 * hérite de la classe Geolocation, qui hérite de la classe Data.
 * 
 * Une bitmap est caractérisée par : 1) Une date (de par son héritage), 2) une
 * géolocalisation (de par son héritage), soit une latitude et une longitude, 3)
 * une matrice de nuances de gris.
 * 
 * @author ccornec
 */

public class Bitmap extends Geolocation {

    /**
     * La matrice de nuances de gris qui constitue la bitmap.
     */
    private int[][] gray_matrix;

    /**
     * Le constructeur de Bitmap.
     * 
     * A la construction d'un objet Bitmap, la matrice de nuances de gris est
     * initialisée avec une matrice de dimension 10x10, remplie aléatoirement avec des
     * entiers entre 0 et 255.
     */
    public Bitmap() {

        super();
        int dimension = 10;
        int gray_shades = 255;
        int[][] gray = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Random rand = new Random();
                gray[i][j] = rand.nextInt(gray_shades);
            }
        }
        this.gray_matrix = gray;
    }

    /**
     * Retourne une représentation textuelle de la donnée bitmap
     * 
     * @return La représentation String de la donnée bitmap
     */
    @Override
    public String toString() {
        return "{ " + getDate() + "\nCoordonnées : " + toWGS84() + "\nBitmap : " + Arrays.deepToString(this.gray_matrix)
                + " }";
    }

}
