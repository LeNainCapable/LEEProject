/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import entity.CoursFacadeLocal;
import entity.FormationFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.Formation;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "Administration", urlPatterns = {"/Administration"})
public class Administration extends HttpServlet {
    @EJB
    private FormationFacadeLocal formationFacade;
    @EJB
    private CoursFacadeLocal coursFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administration at " + request.getContextPath() + "</h1>");
            
            
            out.println("<h1>Ajouter un nouveau type de Formation : </h1>");
            List lFormation = formationFacade.findAll();
            for (Iterator it = lFormation.iterator(); it.hasNext();) {
                Formation elem = (Formation) it.next();
                out.println("Type : <b>" + elem.getIdFormation()+ " </b> ");
                out.println("Prix : " + elem.getNom() + "<br/>");
            }
            String nomFormation;
            nomFormation = request.getParameter("nom");
            if (nomFormation != null) {
                try {
                    String nom;
                    nom = request.getParameter("nom");
                    
                    out.println("On ajoute un type de pizza<br/>");

                    Formation e = new Formation(null, nom);
                    formationFacade.create(e);
                    response.sendRedirect("Administration");

                } catch (Exception ex) {
                }
                out.println("Formation sauvegardÃ©");
            } else {
                out.println("<form method='POST'>");
                out.println("Type: <input type='text' name='id'><br/>");
                out.println("Prix: <input type='text' name='nom'><br/>");
                out.println("QuantitÃ©: <input type='text' name='quantite'><br/>");
                out.println("<input type='submit'><br/>");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
