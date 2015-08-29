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

public class AVL {
    public int altura;
    public NodoAVL raiz;
    public String nombre;
    
    public AVL()
    {
        this.altura=1;
        this.raiz=null;
        this.nombre="arbol";
    }
    public AVL(String nombre)
    {
        this.altura=1;
        this.raiz=null;
        this.nombre=nombre;
    }
    
    public void inicializar(Object data)
    {
        this.raiz=new NodoAVL(data);
        //  altura=1;
    }
    public void insertarR(NodoAVL nodo,Object data)
    {
        Administrador temporal1=(Administrador)nodo.data;
        Administrador temporal2=(Administrador)data;
        
        if(!comparar_cadenas(temporal1.correo,temporal2.correo))
        {
            if(nodo.ptr_izquierdo==null)
            {
                nodo.ptr_izquierdo= new NodoAVL(data);
                if(nodo.ptr_derecho==null)
                {
           //         nodo.fe++;
                }
            }
            else
            {
                insertarR(nodo.ptr_izquierdo,data);
            }
        }
        else
        {
            if(nodo.ptr_derecho==null)
            {
                nodo.ptr_derecho=new NodoAVL(data);
                if(nodo.ptr_izquierdo==null)
                {
             //       nodo.fe++;
                }
            }
            else 
            {
                insertarR(nodo.ptr_derecho,data);
            }
        }
    }
    public void InsertarRaiz(Object data)
    {
        this.raiz=new NodoAVL(data);
    }
    public void  Insertar(Object data)
    {
        if(this.raiz==null)
        {
            InsertarRaiz(data);
        }else
        {
            insertarR(this.raiz,data);
        }
        
    }
    
    
    public boolean comparar_cadenas(String cadena_raiz, String cadena_nueva)
    {
        boolean resultado=true;  
        if(cadena_raiz.compareTo(cadena_nueva)>0)
        {
            resultado=false;
        }
        System.out.println("resultado------"+resultado);
        return resultado; 
    }
    
    public void ImprimirAVL() throws IOException
    {
        String nombre_archivo="ArbolAVL";
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Administradores{"                
        + "node [shape = record,height=.1];");        
        ImprimirHoja(this.raiz, fichero);        
        pw.println("}"); 
        fichero.close();
        //Crear el archivo jpg para mostrar.
        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
        Runtime.getRuntime().exec(cmd);
    }
    public void ImprimirHoja(NodoAVL nodo, FileWriter fichero)
    {
        Administrador temporal=(Administrador)nodo.data;
        PrintWriter pw = new PrintWriter(fichero);
        if(nodo==raiz)
        {
           
                
                if(nodo.ptr_izquierdo!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Administrador temporali=(Administrador)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Administrador temporald=(Administrador)nodo.ptr_derecho.data;
                    pw.println("->\"correo:"+temporald.correo+"\nContrasena:"+temporald.contrasena+"\"");
                }
        }
        else
        {   
               
                pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                if(nodo.ptr_izquierdo!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Administrador temporali=(Administrador)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Administrador temporali=(Administrador)nodo.ptr_derecho.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
        }     
       
        if(nodo.ptr_izquierdo!=null)
        {
            ImprimirHoja(nodo.ptr_izquierdo,fichero);
        }
        if(nodo.ptr_derecho!=null)
        {  
            ImprimirHoja(nodo.ptr_derecho,fichero);
        }
        
        System.out.println(temporal.correo+" altura "+Altura(nodo));
        System.out.println(temporal.correo+" altura "+factorequilibrio(nodo));
        
    }    
    
    public String PathActual(){
    String path="";
     File miDir = new File (".");
     try {
       //System.out.println (miDir.getCanonicalPath());
       path=miDir.getCanonicalPath();
     }
     catch(Exception e) {
       }
     return path;
}

    public int Altura(NodoAVL nodo)
    {   
        int ld=0;
        int li=0;        
        if(nodo.ptr_derecho!=null)
        {            
           ld=+Altura(nodo.ptr_derecho)+nodo.ptr_derecho.fe;
        }
        if(nodo.ptr_izquierdo!=null)
        {            
           li=+Altura(nodo.ptr_izquierdo)+nodo.ptr_izquierdo.fe;
        }
        //System.out.println("Factor de Equilibrio "+ld +"-"+ li+"="+(ld-li));
        if(ld>li)
        {
            return ld;
        }else
        {
            return li;
        }
        
    }
    
        public int factorequilibrio(NodoAVL nodo)
    {        
        return (Altura(nodo.ptr_derecho)-Altura(nodo.ptr_izquierdo));   
    }
    
}
