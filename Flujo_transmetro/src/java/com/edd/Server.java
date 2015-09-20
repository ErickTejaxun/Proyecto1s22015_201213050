/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edd;

import Estructuras.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Erick
 */
@WebService(serviceName = "Operacioens")
public class Server {
    
    public AVL_ Arbol_Administradores=new AVL_();
    public AVL_ Arbol_choferes=new AVL_();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Iniciar")
    public Server Iniciar() {
        Arbol_Administradores.Insertar(new Administrador("erickteja@gmail.com","guatemala"));
        
        return null;
    }
    @WebMethod(operationName = "Logear")
    public Server Logear(@WebParam(name="username")String username,@WebParam(name="password")String password){
        NodoAVL temporal=Arbol_Administradores.buscar(username, Arbol_Administradores.raiz);
       if(temporal!=null)
       {
           
       }
        return null;
}
}
