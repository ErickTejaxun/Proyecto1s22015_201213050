/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Erick
 */
public class Ruta {
    public String nombre;
    public ListaDoble estaciones;
    
    public Ruta(String nombre)
    {
       this.nombre=nombre;
       this.estaciones=new ListaDoble();
    }
    
    
}
