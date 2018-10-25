/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

import java.io.File;
import java.util.Arrays;

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
        final File folder = new File("C:/Users/Jorge/Documents/TEC/VII Semestre/RIT 2/TP2 - RIT - 2018ii");
        listFilesForFolder(folder);
    }
    
    public static void listFilesForFolder(final File folder) {
        System.out.println("entro");
        for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
                 } else {
                System.out.println(fileEntry.getName());
                }
            }
        }
    }
