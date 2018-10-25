/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class PryectoRIT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjetoArchivos nuevoArchivo = new ObjetoArchivos();
        nuevoArchivo.NombreArchivo = "chmod.1";
        nuevoArchivo.palabras = new String [] {"hola", "perro"};
        System.out.println(nuevoArchivo.palabras[1]);
    }
    
}
