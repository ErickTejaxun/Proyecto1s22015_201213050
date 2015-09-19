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
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class AVL_ {
    public NodoAVL raiz;
    public AVL_()
    {
        this.raiz=new NodoAVL(new Persona());
       
    }
        //Ubicacion del proyecto
    public String PathActual()
    {
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
    
    public boolean comparar_cadenas(NodoAVL raiz, String dato)
    {
        boolean resultado=true;  
        Persona auxiliar=(Persona)raiz.data;
        if(auxiliar.tipo==1)
        {
            if(auxiliar.correo.compareTo(dato)>0)
            {
                resultado=false;
                return false;
            }
        }else if(auxiliar.tipo==2)
        {
            if(String.valueOf(auxiliar.clave).compareTo(dato)>0)
            {
                resultado=false;
                return false;
            }
            
        }
        

        System.out.println("resultado------"+resultado);
        return resultado; 
    }
    
    public boolean Igualar(NodoAVL raiz, String dato)
    {
        boolean resultado=false;  
        Persona auxiliar=(Persona)raiz.data;
        if(auxiliar.tipo==1)
        {
            if(auxiliar.correo.equals(dato))
            {
                resultado=true;
                return true;
            }
        }else if(auxiliar.tipo==2)
        {
            if(String.valueOf(auxiliar.clave).equals(dato))
            {
                resultado=true;
                return true;
            }
            
        }
        

        System.out.println("resultado------"+resultado);
        return resultado; 
    }
    
    //Busqueda de nodo
    public NodoAVL buscar(String dato, NodoAVL r)
    {
        Persona auxiliar=(Persona)raiz.data;
        //1 Administrador, 2 Chofer
        if(r==null)
        {
            return null;
        }else if(Igualar(r,dato))
        {
            return r;
        }
        else if(comparar_cadenas(r,dato))
        {
            return buscar(dato,r.ptr_derecho);   
        }
        else
        {
            return buscar(dato,r.ptr_izquierdo);
        } 
    }
    //Factor de Equilibrio
    public int Factor_equilibrio(NodoAVL r)
    {
        if(r==null)
        {
            return -1;
        }else
        {
            return r.fe;
        }
    }
    //Rotaciones Simples
    //Izquierda
    public NodoAVL rotacionIzquierda(NodoAVL r)
    {
        NodoAVL auxiliar=r.ptr_izquierdo;
        r.ptr_izquierdo=auxiliar.ptr_derecho;
        auxiliar.ptr_derecho=r;
        r.fe=Math.max(Factor_equilibrio(r.ptr_izquierdo), Factor_equilibrio(r.ptr_derecho))+1;
        auxiliar.fe=Math.max(Factor_equilibrio(auxiliar.ptr_izquierdo), Factor_equilibrio(auxiliar.ptr_derecho))+1;
        return auxiliar;
    }
    
    //Derecha
    public NodoAVL rotacionDerecha(NodoAVL r)
    {
        NodoAVL auxiliar=r.ptr_derecho;
        r.ptr_derecho=auxiliar.ptr_izquierdo;
        auxiliar.ptr_izquierdo=r;
        r.fe=Math.max(Factor_equilibrio(r.ptr_izquierdo), Factor_equilibrio(r.ptr_derecho))+1;
        auxiliar.fe=Math.max(Factor_equilibrio(auxiliar.ptr_izquierdo), Factor_equilibrio(auxiliar.ptr_derecho))+1;
        return auxiliar;
    }
    
    //Rotaciones Dobles
    //Izquierda
    public NodoAVL rotacionDobleIzquierda(NodoAVL r)
    {
        NodoAVL temporal;
        r.ptr_izquierdo=rotacionDerecha(r.ptr_izquierdo);
        temporal=rotacionIzquierda(r);
        return temporal;
    }
    //Rotacion Derecha
    public NodoAVL rotacionDobleDerecha(NodoAVL r)
    {
        NodoAVL temporal;
        r.ptr_derecho=rotacionIzquierda(r.ptr_derecho);
        temporal=rotacionDerecha(r);
        return temporal;
    }
    //Insertar 
    public NodoAVL Insertar(NodoAVL nuevo, NodoAVL subarbol)
    {
        NodoAVL nuevoPadre=subarbol;
        Persona temporal_subarbol=(Persona)subarbol.data;
        Persona temporal_nuevo=(Persona)nuevo.data;
        //Para Administradores
        if(temporal_subarbol.tipo==1)
        {
            if(comparar_cadenas(nuevo,temporal_subarbol.correo))
            {
                if(subarbol.ptr_izquierdo==null)
                {
                    subarbol.ptr_izquierdo=nuevo;
                }else 
                {
                    subarbol.ptr_izquierdo=Insertar(nuevo,subarbol.ptr_izquierdo);
                    if((Factor_equilibrio(subarbol.ptr_izquierdo)-Factor_equilibrio(subarbol.ptr_derecho))==2)
                    {
                        Persona tmp=(Persona)subarbol.ptr_izquierdo.data;
                        if(!comparar_cadenas(nuevo, tmp.correo))
                        {
                            nuevoPadre=rotacionIzquierda(subarbol);
                        }else
                        {
                            nuevoPadre=rotacionDobleIzquierda(subarbol);
                        }
                    } 
                }
            } else if(!this.comparar_cadenas(nuevo, temporal_subarbol.correo))
            {
                if(subarbol.ptr_derecho==null)
                {
                    subarbol.ptr_derecho=nuevo;
                }else
                {
                    subarbol.ptr_derecho=Insertar(nuevo,subarbol.ptr_derecho);
                    if((this.Factor_equilibrio(subarbol.ptr_derecho)-this.Factor_equilibrio(subarbol.ptr_izquierdo))==2)
                    {
                        Persona tmp=(Persona)subarbol.ptr_derecho.data;
                        if(this.comparar_cadenas(nuevo,tmp.correo ))
                        {
                            nuevoPadre=rotacionDerecha(subarbol);
                        }else
                        {
                            nuevoPadre=rotacionDobleDerecha(subarbol);
                        }
                    }
                }
            }else 
            {
                JOptionPane.showMessageDialog(null, "Los datos ya han sido ingresados");
            }
            
        }
        //Para Choferes----------------------------------
        if(temporal_subarbol.tipo==2)
        {
            if(comparar_cadenas(nuevo,String.valueOf(temporal_subarbol.clave)))
            {
                if(subarbol.ptr_izquierdo==null)
                {
                    subarbol.ptr_izquierdo=nuevo;
                }else 
                {
                    subarbol.ptr_izquierdo=Insertar(nuevo,subarbol.ptr_izquierdo);
                    if((Factor_equilibrio(subarbol.ptr_izquierdo)-Factor_equilibrio(subarbol.ptr_derecho))==2)
                    {
                        Persona tmp=(Persona)subarbol.ptr_izquierdo.data;
                        if(comparar_cadenas(nuevo, tmp.correo))
                        {//Aca esta el error
                            
                            nuevoPadre=rotacionDerecha(subarbol);
                        }else
                        {
                            nuevoPadre=rotacionDobleDerecha(subarbol);
                        }
                    } 
                }
            } else if(!this.comparar_cadenas(nuevo, String.valueOf(temporal_subarbol.clave)))
            {
                if(subarbol.ptr_derecho==null)
                {
                    subarbol.ptr_derecho=nuevo;
                }else
                {
                    subarbol.ptr_derecho=Insertar(nuevo,subarbol.ptr_derecho);
                    if((this.Factor_equilibrio(subarbol.ptr_derecho)-this.Factor_equilibrio(subarbol.ptr_izquierdo))==2)
                    {
                        Persona tmp=(Persona)subarbol.ptr_derecho.data;
                        if(!this.comparar_cadenas(nuevo,tmp.correo ))
                        {
                            nuevoPadre=rotacionDerecha(subarbol);
                        }else
                        {
                            nuevoPadre=rotacionDobleDerecha(subarbol);
                        }
                    }
                }
            }else 
            {
                JOptionPane.showMessageDialog(null, "Los datos ya han sido ingresados");
            }
            
        }
        //Factor Equilibrio
        if((subarbol.ptr_izquierdo==null)&&(subarbol.ptr_derecho!=null))
        {
            subarbol.fe=subarbol.ptr_derecho.fe+1;
        }else if((subarbol.ptr_derecho==null)&&(subarbol.ptr_izquierdo!=null))
        {
            subarbol.fe=subarbol.ptr_izquierdo.fe+1;
        }else
        {
            subarbol.fe=Math.max(this.Factor_equilibrio(subarbol.ptr_derecho), this.Factor_equilibrio(subarbol.ptr_izquierdo))+1;
        }
        return nuevoPadre;
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
        Persona temporal=(Persona)nodo.data;
        //System.out.println(temporal.correo+" altura "+factorequilibrio(nodo));
        PrintWriter pw = new PrintWriter(fichero);
        if(nodo==raiz)
        {
           
                
                if(nodo.ptr_izquierdo!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Persona temporali=(Persona)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Persona temporald=(Persona)nodo.ptr_derecho.data;
                    pw.println("->\"correo:"+temporald.correo+"\nContrasena:"+temporald.contrasena+"\"");
                }
        }
        else
        {   
               
                pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                if(nodo.ptr_izquierdo!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Persona temporali=(Persona)nodo.ptr_izquierdo.data;
                    pw.println("->\"correo:"+temporali.correo+"\nContrasena:"+temporali.contrasena+"\"");
                }
                if(nodo.ptr_derecho!=null)
                {
                    pw.println("\"correo:"+temporal.correo+"\nContrasena:"+temporal.contrasena+"\"");
                    Persona temporali=(Persona)nodo.ptr_derecho.data;
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
        //System.out.println(temporal.correo+" altura "+factorequilibrio(nodo));
        
    }  
    
    
    
    

    
    
    
}
