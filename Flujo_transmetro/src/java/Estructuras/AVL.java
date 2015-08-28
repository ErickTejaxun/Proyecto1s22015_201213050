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
        altura=1;
    }
    public void insertarR(NodoAVL nodo,Object data)
    {
        Administrador temporal1=(Administrador)nodo.data;
        Administrador temporal2=(Administrador)data;
        
        if(comparar_cadenas(temporal1.correo,temporal2.correo))
        {
            if(nodo.ptr_izquierdo==null)
            {
                nodo.ptr_izquierdo= new NodoAVL(data);
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
        boolean resultado=false;
        
        char[] cad1=cadena_raiz.toCharArray();
        char[] cad2=cadena_nueva.toCharArray();
        int long1=cad1.length;
        int long2=cad2.length;
        
        if(long1<=long2)
        {
            for(int x=0;x<long1;x++)
            {
                int n1=cad1[x];
                int n2=cad2[x];
                System.out.println(n1 +"--- "+n2);
                if(cad1[x]<cad2[x])
                {
                    return true;
                }
            }
        }
        else
        {
            for(int x=0;x<long2;x++)
            {
                if(cad1[x]<cad2[x])
                {
                    return true;
                }
            }
        }
        System.out.println("resultado=false");
        return resultado; 
    }
    
    public void ImprimirAVL() throws IOException
    {
        String nombre_archivo="ArbolAVL";
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Administradores{"
        + "node [dir=both,shape=polygon, fontcolor=\"Black\", height=0.5, color=\"Grey\"]"
        + "edge [color=\"blue\", color=\"blue:red\"]"
        + "rankdir=BT"
        + "");
        
        ImprimirHoja(this.raiz, fichero);
        
        pw.println("}"); 
        fichero.close();
        
        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
        Runtime.getRuntime().exec(cmd);
    }
    public void ImprimirHoja(NodoAVL nodo, FileWriter fichero)
    {
        Administrador temporal=(Administrador)nodo.data;
        PrintWriter pw = new PrintWriter(fichero);
        if(nodo==raiz)
        {
                pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                if(nodo.ptr_izquierdo!=null)
                {
                    Administrador temporali=(Administrador)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    Administrador temporali=(Administrador)nodo.ptr_derecho.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
        }
        else
        {
             pw.println("->\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                             if(nodo.ptr_izquierdo!=null)
                {
                    Administrador temporali=(Administrador)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    Administrador temporali=(Administrador)nodo.ptr_derecho.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
        }
        
       
        if(nodo.ptr_izquierdo!=null)
        {
//            Administrador temporali=(Administrador)nodo.ptr_izquierdo.data;
//            pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
            ImprimirHoja(nodo.ptr_izquierdo,fichero);
        }
        if(nodo.ptr_derecho!=null)
        {  
//            Administrador temporald=(Administrador)nodo.ptr_derecho.data;
//            pw.println("->\"correo:"+temporald.correo+"\nContrasena:"+temporald.contrasena+"\"");
            ImprimirHoja(nodo.ptr_derecho,fichero);
        }
        
    }    
    
    public String PathActual(){
    String path="";
     File miDir = new File (".");
     try {
       //System.out.println (miDir.getCanonicalPath());
       path=miDir.getCanonicalPath();
     }
     catch(Exception e) {
       e.printStackTrace();
       }
     return path;
}


    
}
