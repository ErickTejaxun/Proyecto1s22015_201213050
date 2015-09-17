/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.estructuras.webservice;

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
    
    public AVL Arbol_Administradores=new AVL();

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
}
