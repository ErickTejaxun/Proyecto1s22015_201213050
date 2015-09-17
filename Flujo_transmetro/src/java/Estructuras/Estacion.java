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
public class Estacion {
    public int tipo;
    public int id;
    public String contrasena;
    public String nombre;
    //tipos: 1 Estacion Clave
    //       2 Estacion General
    public Estacion()
    {
        this.tipo=1;
        this.id=0;
        this.contrasena="";
        this.nombre="";
    }
    
    public Estacion(int tipo,int id,String contrasena, String nombre)
    {
        this.tipo=tipo;
        this.id=id;
        this.nombre=nombre;
        this.contrasena=contrasena;
    }
    
    
}
