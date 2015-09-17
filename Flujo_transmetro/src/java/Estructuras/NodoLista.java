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
public class NodoLista {
    public Object data;
    public NodoLista ptr_anterior;
    public NodoLista ptr_siguiente;
    
    public NodoLista()
    {
        this.data=null;
        this.ptr_anterior=null;
        this.ptr_siguiente=null;
                
    }
    
    public NodoLista(Object data)
    {
        this.data=data;
        this.ptr_anterior=null;
        this.ptr_siguiente=null;
    }
    
    public NodoLista(Object data, NodoLista anterior, NodoLista siguiente)
    {
        this.data=data;
        this.ptr_anterior=anterior;
        this.ptr_siguiente=siguiente;
    }
    
}
