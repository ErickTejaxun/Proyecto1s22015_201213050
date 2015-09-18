/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Erick
 */
public class ListaDoble {
   public NodoLista cola;
   public NodoLista cabeza;
   public int cantidad;
   
   public ListaDoble()
   {
       this.cola=this.cabeza=null;
       this.cantidad=0;
   }
   
   public void InsertarInicio(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
       }
       else
       {
          NodoLista aux=this.cola;
          this.cola.ptr_anterior=nuevo_temporal;
          this.cola=nuevo_temporal;
          this.cola.ptr_siguiente=aux;
       }
       
   }
   
   public void InsertarFinal(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
       }
       else
       {
          NodoLista aux=this.cabeza;
          this.cabeza.ptr_siguiente=nuevo_temporal;
          this.cabeza=nuevo_temporal;
          this.cabeza.ptr_anterior=aux;
       }
       
   }
   
   public boolean Vacio()
   {
       return (this.cabeza==null)&&(this.cola==null);
   }
   
    public void ImprimirInicio()
    {
        NodoLista temp=this.cola;
        while(temp!=null)
        {
            Bus aux=(Bus)temp.data;
            System.out.print(aux.numero+"|");
            temp=temp.ptr_siguiente;
        }
    }
    
    public void ImprimirFinal()
    {
        NodoLista temp=this.cabeza;
        while(temp!=null)
        {
            Bus aux=(Bus)temp.data;
            System.out.print(aux.numero+"|");
            temp=temp.ptr_anterior;
        }
    }
    
    public void Eliminar(int clave)
    {
        NodoLista temp=this.cola;
        this.Vaciar();
        while(temp!=null)
        {
            Bus aux=(Bus)temp.data;
            if(aux.numero==clave)
            {
               System.out.println(aux.numero);
               temp=temp.ptr_siguiente;
            }
            Bus aux2=(Bus)temp.data;
                this.InsertarInicio(aux2);
                temp=temp.ptr_siguiente;  
        }   
    }
    
    public void Vaciar()
    {
         this.cola=this.cabeza=null;
    }
    
    public void Imprimir()throws IOException
    {
        String nombre_archivo="ListaBuses";
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Buses{"                
        + "node [shape = record,height=.1];");        
        
        //Recorrido de la lista
        
        NodoLista temp=this.cola;
        while(temp.ptr_siguiente!=null)
        {
            Bus aux=(Bus)temp.data;
            Bus aux2=(Bus)temp.ptr_siguiente.data;
            pw.println("\"Bus No."+aux.numero+"\"->"+"\"Bus No."+aux2.numero+"\"");
            temp=temp.ptr_siguiente;
        }
        temp=this.cabeza;
        while(temp.ptr_anterior!=null)
        {
            Bus aux=(Bus)temp.data;
            Bus aux2=(Bus)temp.ptr_anterior.data;
            pw.println("\"Bus No."+aux.numero+"\"->"+"\"Bus No."+aux2.numero+"\"");
            temp=temp.ptr_anterior;
        }
        pw.println("}"); 
        fichero.close();
        //Crear el archivo jpg para mostrar.
        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
        Runtime.getRuntime().exec(cmd);
    }
    
    
    public String PathActual()
    {
    String path="";
     File miDir = new File (".");
     try 
     {
        path=miDir.getCanonicalPath();
     }
     catch(Exception e) {
       }
     return path;
    }
}

