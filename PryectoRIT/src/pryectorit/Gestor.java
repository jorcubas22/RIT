/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryectorit;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jorge
 */
public class Gestor {
    private Set<ObjetoArchivos> gestor ;
    
     public Gestor() {
        gestor = new HashSet<>();   // aplicabilidad del polimorfismo
    }
      
    public boolean agregar(ObjetoArchivos Archivo){
        return gestor.add(Archivo);
    }
    
    @Override
    public String toString(){
        return gestor.toString();
    }
    
    public int getCantidadProfesores(){
        int acum = 0;
        for (Archivo persona : gestor) {
            if (persona instanceof Profesor){
                acum++;
            }
        }
        return acum;
    }
}
