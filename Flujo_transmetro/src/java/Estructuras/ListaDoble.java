/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import flujo_transemtro_desktop.Flujo_transemtro_desktop;
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
   public int contador_cluster;
   
   public ListaDoble()
   {
       this.cola=this.cabeza=null;
       this.cantidad=contador_cluster=0;
   }
   public void InsertarFecha(String fecha,String Bus)
   {
         NodoLista temp=this.cola;
        while(temp!=null)
        {
            Asignacion aux=(Asignacion)temp.data;
            if(aux.bus.numero.equals(Bus))
            {
                Asignacion aux2=aux;
                this.EliminarBusC(aux.bus.numero);
//                aux2.fechas.InsertarFinal(fecha);
                temp=temp.ptr_siguiente;
            }else
            {
                temp=temp.ptr_siguiente;
                
            }

        }
   }
   
     public void EliminarBusC(String clave)
    {
        NodoLista temp=this.cola;
        this.Vaciar();
        while(temp!=null)
        {
            Asignacion aux=(Asignacion)temp.data;
            if(aux.bus.numero.equals(clave))
            {
               temp=temp.ptr_siguiente;
            }
            if(temp!=null)
            {
                if(temp.ptr_siguiente!=null)
                {
                    Asignacion aux2=(Asignacion)temp.data;
                    this.IngresarAsignacion(aux2.bus.numero, aux2.fecha);
                }

            }
            if(temp!=null)
            {
                temp=temp.ptr_siguiente;  
            }
                
        }   
    }
 
   
   public void InsertarInicio(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
           cantidad++;
       }
       else
       {
          NodoLista aux=this.cola;
          this.cola.ptr_anterior=nuevo_temporal;
          this.cola=nuevo_temporal;
          this.cola.ptr_siguiente=aux;
          cantidad++; 
       }

   }
   
      public void InsertarInicioBus(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
           cantidad++;
       }
       else
       {
           Bus tmp=(Bus)data;
           Bus auxiliar=(Bus)BuscarBus(tmp.numero).data;
           if(!auxiliar.numero.equals("XXinicioXX"))
           {
           System.out.println("Repetido---"+tmp.numero);
           }else
           {
          NodoLista aux=this.cola;
          this.cola.ptr_anterior=nuevo_temporal;
          this.cola=nuevo_temporal;
          this.cola.ptr_siguiente=aux;
          cantidad++; 
           }
       }
       Ordenar();
            
   }
   
   public void InsertarFinal(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
           cantidad++;
       }
       else
       {
          NodoLista aux=this.cabeza;
          this.cabeza.ptr_siguiente=nuevo_temporal;
          this.cabeza=nuevo_temporal;
          this.cabeza.ptr_anterior=aux;
          cantidad++;
       }  
   }
      public void InsertarFinalBus(Object data)
   {
       NodoLista nuevo_temporal=new NodoLista(data);
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
           cantidad++;
       }
       else
       {
           Bus tmp=(Bus)data;
           Bus auxiliar=(Bus)BuscarBus(tmp.numero).data;
           if(!auxiliar.numero.equals("XXinicioXX"))
           {
           System.out.println("Repetido---"+tmp.numero);
           }else
           {
            NodoLista aux=this.cabeza;
          this.cabeza.ptr_siguiente=nuevo_temporal;
          this.cabeza=nuevo_temporal;
          this.cabeza.ptr_anterior=aux;
          cantidad++;
           }
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
    
    public void EliminarEstacion(int clave)
    {
        NodoLista temp=this.cola;
        this.Vaciar();
        while(temp!=null)
        {
            Estacion aux=(Estacion)temp.data;
            if(aux.id==clave)
            {
               System.out.println(aux.id);
               temp=temp.ptr_siguiente;
            }
            Estacion aux2=(Estacion)temp.data;
                this.InsertarInicio(aux2);
                temp=temp.ptr_siguiente;  
        }   
    }
    
    public NodoLista BuscarEstacion(int clave)
    {
        NodoLista temp=this.cola;
        while(temp!=null)
        {
            Estacion aux=(Estacion)temp.data;
            if(aux.id==clave)
            {          
               return temp;
            }else
            {
                temp=temp.ptr_siguiente;
                
            }

        } 
        return null;
    }
    
    public NodoLista BuscarBus(String clave)
    {
        NodoLista temp=this.cola;
        NodoLista auxiliar=new NodoLista(new Bus());
        while(temp!=null)
        {
            Bus aux=(Bus)temp.data;
            if(aux.numero.equals(clave))
            {           
                auxiliar=temp;
            }
                temp=temp.ptr_siguiente;
        } 
        return auxiliar;
    }
    
    
    public void Eliminar(String clave)
    {
        NodoLista temp=this.cola;
        this.Vaciar();
        while(temp!=null)
        {
            Bus aux=(Bus)temp.data;
            if(aux.numero.equals(clave))
            {
               System.out.println(aux.numero);
               temp=temp.ptr_siguiente;
            }
            if(temp!=null)
            {
                 Bus aux2=(Bus)temp.data;
                this.InsertarInicio(aux2);
                temp=temp.ptr_siguiente; 
            }
        }   
    }
    
    public void Vaciar()
    {
         this.cola=this.cabeza=null;
         this.cantidad=0;
    }
    
    public void Imprimir(String nombre)throws IOException
    {
        String nombre_archivo=nombre;
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
    
        public void ImprimirRuta(String nombre)throws IOException
    {
        String nombre_archivo=nombre;
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
    
    public void ImprimirEstacion(String nombre)throws IOException
    {
        String nombre_archivo=nombre;
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Buses{"                
        + "node [shape = record,height=.1];");        
        
        //Recorrido de la lista
        //tipos: 1 Estacion Clave
        //       2 Estacion General
        //        Nombre  y ID 
        
        NodoLista temp=this.cola;
        while(temp.ptr_siguiente!=null)
        {
            Estacion aux=(Estacion)temp.data;
            Estacion aux2=(Estacion)temp.ptr_siguiente.data;
            String tipo1,tipo2="";
            if(aux.tipo==1){tipo1="Clave";}else{tipo1="General";}
            if(aux2.tipo==1){tipo2="Clave";}else{tipo2="General";}
            pw.println("\"Nombre:"+aux.nombre+"\nTipo:"+tipo1+"\nID:"+aux.id+"\"->"+"\"Nombre:"+aux2.nombre+"\nTipo:"+tipo2+"\nID:"+aux2.id+"\"");
            temp=temp.ptr_siguiente;
        }
        temp=this.cabeza;
        while(temp.ptr_anterior!=null)
        {
            Estacion aux=(Estacion)temp.data;
            Estacion aux2=(Estacion)temp.ptr_anterior.data;
            String tipo1,tipo2="";
            if(aux.tipo==1){tipo1="Clave";}else{tipo1="General";}
            if(aux2.tipo==1){tipo2="Clave";}else{tipo2="General";}
            pw.println("\"Nombre:"+aux.nombre+"\nTipo:"+tipo1+"\nID:"+aux.id+"\"->"+"\"Nombre:"+aux2.nombre+"\nTipo:"+tipo2+"\nID:"+aux2.id+"\"");
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
    
    
     public boolean comparar_cadenas(String cadena_raiz, String cadena_nueva)
    {
        System.out.println(cadena_raiz +"<"+ cadena_nueva+"\n");
        boolean resultado=true;  
        if(cadena_raiz.compareTo(cadena_nueva)>0)
        {
            resultado=false;
        }
        System.out.println("resultado------"+resultado);
        return resultado; 
    }
     
     public void Ordenar()
     {
         String[] auxiliar=new String[cantidad];
        int cantidad_inicial=cantidad;
         int contador=0;
         if(cantidad!=1)
        {
            NodoLista temporal=cola;
           while(temporal!=null)
           {
               Bus aux=(Bus)temporal.data;
               System.out.print(aux.numero+"|");
               auxiliar[contador]=aux.numero;
               temporal=temporal.ptr_siguiente;
               contador=contador+1;
           }
            
           burbuja(auxiliar);
            
                   this.Vaciar();
                   for(int i=0;i<cantidad_inicial;i++)
                   {
                       System.out.print(auxiliar[i]+"|");
                       this.InsertarFinal(new Bus(String.valueOf(auxiliar[i])));
                   }   
                   }
     }
     
     public static void burbuja(String [] A){
         int i, j;
         String aux;
         for(i=0;i<A.length-1;i++)
              for(j=0;j<A.length-i-1;j++)
                   if(A[j+1].compareTo(A[j])<0){
                      aux=A[j+1];
                      A[j+1]=A[j];
                      A[j]=aux;
                   }
        }
     
    public void ImprimirFecha( FileWriter fichero)throws IOException
    {
      //  String nombre_archivo=nombre;
      //  FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);      
          pw.println("	subgraph cluster_"+Flujo_transemtro_desktop.contador_cluster+" {\n" +
"		style=filled;\n" +
"		color=lightgrey;\n" +
"		node [style=filled,color=white];");
        NodoLista temp=this.cola;
        while(temp!=null)
        {
             Fecha aux=(Fecha)temp.data;
            if(temp.ptr_siguiente!=null)
            {
     
            Fecha aux2=(Fecha)temp.ptr_siguiente.data;
            pw.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
            System.out.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
            }else
                    
            {
                pw.println("\"Fecha:"+aux.fecha+"\"");
            }
            temp=temp.ptr_siguiente;
        }
        temp=this.cabeza;
        while(temp!=null)
        {
            Fecha aux=(Fecha)temp.data;
            if(temp.ptr_anterior!=null)
            {                        
            Fecha aux2=(Fecha)temp.ptr_anterior.data;
            pw.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
           
            }else
            {
                pw.println("\"Fecha:"+aux.fecha+"\"");
            }
             temp=temp.ptr_anterior;
        }
       pw.println("}"); 
       Flujo_transemtro_desktop.contador_cluster++;
//        fichero.close();
        //Crear el archivo jpg para mostrar.
//        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
//        Runtime.getRuntime().exec(cmd);
    }
    
        public void ImprimirFecha2(String nombre)throws IOException
    {
        String nombre_archivo=nombre;
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Fecha{"                
        + "node [shape = record,height=.1];");        
               
        NodoLista temp=this.cola;
        while(temp.ptr_siguiente!=null)
        {
            Fecha aux=(Fecha)temp.data;
            Fecha aux2=(Fecha)temp.ptr_siguiente.data;
            pw.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
            temp=temp.ptr_siguiente;
        }
        temp=this.cabeza;
        while(temp.ptr_anterior!=null)
        {
            Fecha aux=(Fecha)temp.data;
            Fecha aux2=(Fecha)temp.ptr_anterior.data;
            pw.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
            temp=temp.ptr_anterior;
        }
        pw.println("}"); 
        fichero.close();
        //Crear el archivo jpg para mostrar.
        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
        Runtime.getRuntime().exec(cmd);
    }
        public void ImprimirAsignaciones(String nombre)throws IOException
    {
        String nombre_archivo=nombre;
        FileWriter fichero = new FileWriter(this.PathActual()+"\\"+nombre_archivo+".dot");
        PrintWriter pw = new PrintWriter(fichero);
        pw.println( "digraph Fecha{"                
        + "node [shape = record,height=.1];");        
        NodoLista temp=this.cola;
        
        while(temp!=null)
        {
            if(temp.ptr_siguiente!=null)
            {
             Asignacion aux=(Asignacion)temp.data;
            Asignacion aux2=(Asignacion)temp.ptr_siguiente.data;
             pw.println("\"Bus:"+aux.bus.numero+"\"->"+"\"Bus:"+aux2.bus.numero+"\"");
             ListaDoble tmpfechas=aux.fechas;
             tmpfechas.ImprimirFecha(fichero);
             Fecha fe=(Fecha)tmpfechas.cabeza.data;
             pw.println("\"Bus:"+aux.bus.numero+"\"->"+"\"Fecha:"+fe.fecha+"\"");
            }else
            {
             Asignacion aux=(Asignacion)temp.data;
             ListaDoble tmpfechas=aux.fechas;
             tmpfechas.ImprimirFecha(fichero);
             Fecha fe=(Fecha)tmpfechas.cabeza.data;
             pw.println("\"Bus:"+aux.bus.numero+"\"->"+"\"Fecha:"+fe.fecha+"\"");
            }
             
             
//            if(aux.bus.numero.equals(aux2.bus.numero))
//
//            {                  
//                   pw.println("\"Fecha:"+aux.fecha+"\"->"+"\"Fecha:"+aux2.fecha+"\"");
//                 
//            }
//            else
//            {                
//                pw.println("\"Bus:"+aux.bus.numero+"\"->"+"\"Bus:"+aux2.bus.numero+"\"");
//            }          
            temp=temp.ptr_siguiente;
        }
        temp=cabeza;
        while(temp!=null)
        {
            if(temp.ptr_anterior!=null)
            {
             Asignacion aux=(Asignacion)temp.data;
            Asignacion aux2=(Asignacion)temp.ptr_anterior.data;
            pw.println("\"Bus:"+aux.bus.numero+"\"->"+"\"Fecha:"+aux.fecha+"\"");
            if(aux.bus.numero.equals(aux2.bus.numero))
            {

            }
            }
           
            temp=temp.ptr_anterior;
        }

        pw.println("}"); 
        fichero.close();
        //Crear el archivo jpg para mostrar.
        String  cmd = "dot "+PathActual()+"\\"+nombre_archivo+".dot "+"-Tpng "+"-o "+PathActual()+"\\"+nombre_archivo+".png"; //Crear imagen.
        Runtime.getRuntime().exec(cmd);
    }
    
    public void IngresarAsignacion(String bus, String fecha)
    {
       
       NodoLista nuevo_temporal=new NodoLista(new Asignacion(bus,fecha));
       if(Vacio())
       {
           this.cola=this.cabeza=nuevo_temporal;
           cantidad++;
       }
       else
       {
          NodoLista aux=this.cola;
          boolean encontrado=false;
          while(aux!=null)
          {
              Asignacion asignacion_temporal=(Asignacion)aux.data;              
              if(asignacion_temporal.bus.numero.equals(bus))
              {
                  asignacion_temporal.fechas.InsertarFinal(new Fecha(fecha));
                  ListaDoble nueva=asignacion_temporal.fechas;
                  this.EliminarBusC(bus);
                  Asignacion nuevo_asignacion=new Asignacion(bus,nueva);
                  this.InsertarInicio(nuevo_asignacion);
                  encontrado=true;
              
              }
              aux=aux.ptr_siguiente;
              
          }
          if(!encontrado)
          {
                this.cabeza.ptr_siguiente=nuevo_temporal;
               this.cabeza=nuevo_temporal;
               this.cabeza.ptr_anterior=aux;
               cantidad++;
           }
       } 
    }
    
}

