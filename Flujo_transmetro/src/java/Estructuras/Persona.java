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
public class Persona {
    public String nombre;
    public String apellido;
    public String correo;
    public int clave;
    public String contrasena;
    public int tipo;//1 Administrador, 2 Chofer
    
    public Persona()
    {
        this.nombre="Juan Luis";
        this.apellido="Tejaxun Xicon";
        this.clave=1339;
        this.contrasena="guatemala";
        this.correo="juanteja@gmail.com";
        this.tipo=1;
    }
    public Persona(String nombre, String apellido, int clave,String contrasena)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.clave=clave;
        this.contrasena=contrasena;
        this.tipo=2;
    }
    public Persona(String correo, String contrasena)
    {
        this.contrasena=contrasena;
        this.correo=correo;
        this.tipo=1;
    }
   
    
}
