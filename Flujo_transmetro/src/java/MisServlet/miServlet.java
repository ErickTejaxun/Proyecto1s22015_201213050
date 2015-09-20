/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MisServlet;

import Estructuras.*;
import MisBean.DatosPersona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kaaf
 */
@WebServlet(name = "miServlet", urlPatterns = {"/miServlet"})
public class miServlet extends HttpServlet {
  AVL_ administradores=new AVL_();
  AVL_ choferes=new AVL_(1);
  Ruta nueva_ruta=new Ruta("Sabadazo");
  ListaDoble fechas=new ListaDoble();
  ListaDoble asignacion_choferes=new ListaDoble();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tipo=request.getParameter("tipo_dato");
        String username=request.getParameter("username");
        System.out.println(username+tipo);
        Persona au=(Persona)administradores.raiz.data;
        
      if(tipo.equals("Administrador"))
      {
       
        NodoAVL tmp=administradores.buscar(username,administradores.raiz);
        if(tmp!=null)
        {
              
            Persona temporal=(Persona)tmp.data;
            System.out.println(temporal.correo);
            if(temporal.contrasena.equals(request.getParameter("txtApellido")))
            {
               request.getRequestDispatcher("salida.jsp").forward(request, response); 
               request.setAttribute("datosPersona", temporal);
             System.out.print("Existente");  
            }else
            {
                System.out.print("Inexistente");
                request.setAttribute("datosPersona", temporal);
                request.getRequestDispatcher("index.jsp").forward(request, response);                
            }
            
        }
      }
        
//        datosPersona.setNombre(request.getParameter("txtNombre"));
//        datosPersona.setApellido(request.getParameter("txtApellido"));
//        datosPersona.setDni(request.getParameter("tipo_dato"));
        
//        request.setAttribute("datosPersona", datosPersona);
//        request.getRequestDispatcher("salida.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
