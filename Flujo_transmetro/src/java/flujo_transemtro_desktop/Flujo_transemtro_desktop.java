/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujo_transemtro_desktop;

import Estructuras.*;
import Estructuras.Administrador;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class Flujo_transemtro_desktop {
public static int contador_cluster;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       AVL_ arbol=new AVL_();
        Random rnd = new Random();
        contador_cluster=0;
 //      arbol.Insertar(new NodoAVL(new Persona("juanteja@gmail.com","2239h9auds")),arbol.raiz);
     arbol.Insertar(new Persona("edgarallanpoe@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("alberteinstein@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("florindatejaxun@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("edgaraquino@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("rodolfosenteno@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("lucreciocubur@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("luisteja@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("eulalioteja@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("erickteja@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("magalyteja@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("domingoteja@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("elenateja@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("waldoteja@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("antana@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("ezgaz@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("francisco@gmail.com","2239h9auds"));
     arbol.Insertar(new Persona("josthynteja@gmail.com","2239h9auds"));
      arbol.Insertar(new Persona("laurateja@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("ceciliateja@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("fredericNitzce@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("stephenking@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("rafael@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("eduardo@gmail.com","2239h9auds"));
    arbol.Insertar(new Persona("angelo@gmail.com","XXXXXXXXXXXXXx"));
    arbol.Insertar(new Persona("luiz@gmail.com","XXXXXXXXXXXXXx"));
 arbol.Insertar(new Persona("luiza@gmail.com","12345"));
 arbol.Insertar(new Persona("lukza@gmail.com","12345"));
 arbol.Insertar(new Persona("bladimir@gmail.com","2239h9auds"));
 arbol.Insertar(new Persona("guatemala2000@gmail.com","2239h9auds"));
 arbol.Actualizar("edgarallanpoe@gmail.com",new Persona("erickRoberto@hotmail.com","1214"));
 arbol.Inorden(arbol.raiz);
  if(arbol.buscar("angelo@gmail.com", arbol.raiz)!=null)
 {
     Persona temporal=(Persona)arbol.buscar("angelo@gmail.com", arbol.raiz).data;
     System.out.println(temporal.contrasena+" Correo: "+temporal.correo);
 }
  
  
   AVL_ choferes=new AVL_(1);
    choferes.Insertar(new Persona("Erick Roberto","Tejaxun Xicon",100,"Guatemala"));
    choferes.Insertar(new Persona("Juan Carlos","Tejaxun Xicon",2,"Guatemala"));
    choferes.Insertar(new Persona("Waldo Romeo","Tejaxun Xicon",3,"Guatemala"));
    choferes.Insertar(new Persona("Domingo","Tejaxun Xicon",105,"Guatemala"));
    choferes.Insertar(new Persona("Elena","Tejaxun Xicon",102,"Guatemala"));
    choferes.Insertar(new Persona("Hector","Tejaxun Xicon",110,"Guatemala"));
   choferes.eliminar("100");
    choferes.eliminar("102");
    choferes.eliminar("110");
   choferes.Insertar(new Persona("Erick Roberto","Tejaxun Xicon",100,"Guatemala"));
    choferes.Actualizar("100", new Persona("Eleonora","Tejaxun Xicon",120,"Guatemala"));
    choferes.Actualizar("120", new Persona("Eleonora","Tejaxun Xicon",144,"Guatemala"));
    choferes.ImprimirAVL("choferes");
       
//       for(int x=0;x<100;x++)
//       {
//           String correo="correo"+x*2;
//           String password=String.valueOf(x*3+2000);
//           arbol.Insertar(new Administrador(correo,password));
//       }
//       for(int x=0;x<1000;x++)
//       {
//           String correo="erick"+x*2;
//           String password=String.valueOf(x*3+2000);
//           arbol.Insertar(new Administrador(correo,password));
//       }
       
       arbol.ImprimirAVL("Administradores");
       
       ListaDoble lista=new ListaDoble();
       for(int x=0;x<500;x++)
       {
           lista.InsertarInicioBus(new Bus(String.valueOf((int) (rnd.nextDouble() * 999 + 0))));
           
       }
       //Estaba a punto de hacer la lista de estaciones en la ruta.
       lista.ImprimirFinal();
       System.out.println("\n");
       lista.ImprimirInicio();
       
       for(int x=40;x<60;x++)
       {
           lista.Eliminar(String.valueOf(x*2));
       }
       System.out.println("\n");
       lista.ImprimirFinal();
       System.out.println("\n");
       lista.ImprimirInicio();
       
       lista.Imprimir("Buses");
       
       
       ListaDoble estaciones=new ListaDoble();
       estaciones.InsertarInicio(new Estacion(1,11,"123","Don Bosco"));
       estaciones.InsertarInicio(new Estacion(1,12,"123","Charcas"));
       estaciones.InsertarInicio(new Estacion(1,13,"123","USAC"));
       estaciones.InsertarInicio(new Estacion(1,14,"123","Petapa"));
       estaciones.InsertarInicio(new Estacion(1,15,"123","Terminal"));
       estaciones.InsertarInicio(new Estacion(1,16,"123","Fisica"));
       estaciones.EliminarEstacion(14);
       estaciones.ImprimirEstacion("Estaciones");
       System.out.println(((Estacion)estaciones.BuscarEstacion(11).data).nombre);
       System.out.println(((Bus)lista.BuscarBus("999").data).numero);
       
        Ruta nueva_ruta=new Ruta("Sabadazo");
        nueva_ruta.estaciones.InsertarInicio(estaciones.BuscarEstacion(11).data);
        nueva_ruta.estaciones.InsertarInicio(estaciones.BuscarEstacion(13).data);
        nueva_ruta.estaciones.InsertarInicio(estaciones.BuscarEstacion(12).data);
        nueva_ruta.estaciones.InsertarInicio(estaciones.BuscarEstacion(16).data);
        nueva_ruta.estaciones.ImprimirEstacion("nueva");
        
        ListaDoble fechas=new ListaDoble();
        fechas.InsertarFinal(new Fecha("11/12/2015"));
       fechas.InsertarFinal(new Fecha("12/12/2015"));
        fechas.InsertarFinal(new Fecha("11/12/2017"));
        fechas.InsertarFinal(new Fecha("14/12/2015"));
        fechas.InsertarFinal(new Fecha("11/06/2015"));
        
        ListaDoble asignacion_choferes=new ListaDoble();

       asignacion_choferes.IngresarAsignacion("abc3","14/06/2014");
      asignacion_choferes.IngresarAsignacion("abc3","10/06/2016");
//        asignacion_choferes.IngresarAsignacion("abc3","13/06/2015");
        asignacion_choferes.IngresarAsignacion("abcc","29/06/2015");
        asignacion_choferes.IngresarAsignacion("abca","22/06/2015");
        asignacion_choferes.IngresarAsignacion("abcp","14/06/2015");
        asignacion_choferes.IngresarAsignacion("abc","10/08/2013");
                asignacion_choferes.IngresarAsignacion("abc1","10/06/2015");
        asignacion_choferes.IngresarAsignacion("abc1","13/06/2012");
        asignacion_choferes.IngresarAsignacion("abc1","10/06/2013");
                asignacion_choferes.IngresarAsignacion("juancho","19/06/2015");
//        asignacion_choferes.IngresarAsignacion("juancho","22/06/2015");
//        asignacion_choferes.IngresarAsignacion("juancho","14/06/2015");
//        asignacion_choferes.IngresarAsignacion("juancho","10/08/2013");
//                asignacion_choferes.IngresarAsignacion("juancho","10/06/2015");
//        asignacion_choferes.IngresarAsignacion("juancho","13/06/2012");
//        asignacion_choferes.IngresarAsignacion("juancho","10/06/2013");
        
        asignacion_choferes.ImprimirAsignaciones("Chepe");

    }
    
}
