package main;

import operableSatellites.*;
import java.io.IOException;

import SCRIPTS.*;
import controlCenter.*;


/**
 * Main est la classe exécutable qui permet de démarrer la téléopération de
 * satellites par l'utilisateur, via le centre de contrôle.
 * 
 * C'est dans Main que sont créés : 1) Une instance de ControlCenter, 2) des
 * instances de Satellite qui pourront être ajoutés au tableau de satellites
 * téléopérés par le centre de contrôle.
 * 
 * La méthode qui lance la téléopération est finalement appelée dans Main.
 * 
 * @author ccornec
 */

public class Main {
    public static void main(String[] args) throws IOException {

       ControlCenter controlCenter = new ControlCenter();

       controlCenter.addSatellite(new ISAESAT("1"));
       controlCenter.addSatellite(new XSAT("1"));

       controlCenter.teleOperation();

       //ScriptReader scriptr = new ScriptReader();
       // scriptr.read(new ISAESAT("1"), "IMAGESEQMAIN" );

    }
}
