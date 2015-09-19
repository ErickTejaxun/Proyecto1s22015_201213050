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
public class NodoAVL {
    public Object data;
    public NodoAVL ptr_izquierdo;
    public NodoAVL ptr_derecho;
    public int fe;//Factor de equilibrio
    public int altura;
    
    public NodoAVL()
    {
        data=null;
        ptr_izquierdo=null;
        ptr_derecho=null;  
        fe=0;
    }
    public NodoAVL(Object data)
    {
        this.data=data;
        this.ptr_derecho=null;
        this.ptr_izquierdo=null;
        this.fe=0;
    }
    public NodoAVL(Object data,NodoAVL izquierdo,NodoAVL derecho)
    {
        this.data=data;
        this.ptr_derecho=derecho;
        this.ptr_izquierdo=izquierdo;
        fe=0;
    }

}
