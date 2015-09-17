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
public class Chofer {
    public String nombre;
    public String apellido;
    public int clave;
    public String contrasena;
    
    public Chofer()
    {
        this.nombre="Juan Carlos";
        this.apellido="Tejaxun Xicon";
        this.clave=1339;
        this.contrasena="guatemala";
    }
    public Chofer(String nombre, String apellido, int clave,String contrasena)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.clave=clave;
        this.contrasena=contrasena;
    }
    
}
