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
public class Asignacion {
    public Bus bus;
    public String fecha;
    public ListaDoble fechas;
    public Asignacion(String  bus, String date)
    {
        this.bus=new Bus(bus);
        this.fecha=date;
        fechas=new ListaDoble();
        fechas.InsertarInicio(new Fecha(date));
    }
     public Asignacion(String  bus, ListaDoble date)
    {
        this.bus=new Bus(bus);
        fechas=date;
        
    }
}
