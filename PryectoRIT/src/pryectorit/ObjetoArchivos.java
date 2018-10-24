/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

/**
 *
 * @author Jorge
 */
public class ObjetoArchivos {
    public String NombreArchivo;
    public String[] palabras;

    public ObjetoArchivos(String NombreArchivo, String[] palabras) {
        this.NombreArchivo = NombreArchivo;
        this.palabras = palabras;
    }
        public ObjetoArchivos() {

    }

    public String getNombreArchivo() {
        return NombreArchivo;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }    
    
    
}
