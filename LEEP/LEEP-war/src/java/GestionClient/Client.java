/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionClient;


import entity.Cours;
import entity.Enseignement;
import entity.Etudiant;
import entity.Formation;
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

/**
 *
 * @author 11000505
 */
@WebServlet(name = "ClientEDT", urlPatterns = {"/ClientEDT"})
public class Client extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Commande Pizza</title>");  
            out.println("</head>");
            out.println("<body>");
                        //Liste des cours
            out.println("<h2> Liste des cours</h2>");
            out.println("<p>");
            /*
            List lCours = coursFacade.findAll();
            for (Iterator it = lCours.iterator(); it.hasNext();) {
                Cours elem = (Cours) it.next();
                Etudiant etu = etudiantFacade.find(1);

                Formation formetu = formationFacade.find(etu.getIdFormation());
                for (Iterator formiterator = formetu.getEnseignementCollection().iterator(); formiterator.hasNext();) {
                    Enseignement ensiterator = (Enseignement) formiterator.next();
                    if (elem.getIdEnseignement() == ensiterator) {
                        out.println("Cours : <b>" + elem.getNom() + " </b> ");
                    }
                    out.println("Id : " + elem.getIdEnseignement().getNom() + elem.getHeureDebut() + "<br/>");
                    out.println("Heure debut:" + elem.getHeureDebut() + " Heure de fin:" + elem.getHeureFin() + "<br/>");
                }

            }
            out.println("</p>");
            */
            /*List lStock = stockFacade.findAll();
            for (Iterator it = lStock.iterator(); it.hasNext();) {
                Stock s = (Stock) it.next();
                Pizza elem = s.getPizzaId();
                Stock ss = stockFacade.findQuantiteByPizzaId(elem);
                //stockFacade.find(it)
                //Integer ei = stockFacade.findQuantiteByPizzaId(elem);
                Integer i = s.getQuantite(); System.out.println(ss.getQuantite());
                out.println("Type : <b>" + elem.getPizzaId() + " </b> ");
                out.println("Prix : " + elem.getPrix() + "<br/>");
                out.println("Quantite : " + i + "<br/>");
            }            

            out.println("<h1>Choisissez votre pizza : </h1>");
            String type=request.getParameter("type");
            if (type!=null) {
                try {
                    int quantite=new Integer(request.getParameter("quantite"));             
                    String email=new String(request.getParameter("email"));
                    Pizza pizza = pizzaFacade.find(type);
                    int total = quantite * pizza.getPrix();
                    out.println("On ajoute une commande dont le prix total est :"+total+"<br/>");
                    Stock s = stockFacade.findQuantiteByPizzaId(pizza);
                    commandeFacade.create(type, quantite, total, email);
                    //stockFacade.updateStock(quantite, type);
                    //response.sendRedirect("Client");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            out.println("Commande effectuÃ©e");
                       lStock = stockFacade.findAll();
            for (Iterator it = lStock.iterator(); it.hasNext();) {
                Stock s = (Stock) it.next();
                Pizza elem = s.getPizzaId();
                //stockFacade.find(it)
                //Integer ei = stockFacade.findQuantiteByPizzaId(elem);
                Integer i = s.getQuantite();
                out.println("Type : <b>" + elem.getPizzaId() + " </b> ");
                out.println("Prix : " + elem.getPrix() + "<br/>");
                out.println("Quantite : " + i + "<br/>");
            }            
            } else {
                out.println("<form method='POST'>");
                out.println("Type: <input type='text' name='type'><br/>");
                out.println("QuantitÃ©: <input type='text' name='quantite'><br/>");
                out.println("Email: <input type='text' name='email'><br/>");
                out.println("<input type='submit'><br/>");
                out.println("</form>");
            }*/
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
