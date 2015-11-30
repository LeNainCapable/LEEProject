/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;


import entity.Enseignant;
import entity.Etudiant;
import persistence.PersonneFacadeLocal;
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
import entity.Personne;
import persistence.EnseignantFacadeLocal;
import persistence.EtudiantFacadeLocal;

/**
 *
 * @author 11000505
 */
@WebServlet(name = "AdminEDT", urlPatterns = {"/AdminEDT"})
public class Admin extends HttpServlet {
    
    @EJB
    private EtudiantFacadeLocal etudiantFacade;
    @EJB
    private EnseignantFacadeLocal enseignantFacade;
    @EJB
    private PersonneFacadeLocal personneFacade;


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
            out.println("<title>Administration Emploi du temps</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ajouter un nouveau type de pizza : </h1>");
               List lPersonne = personneFacade.findAll();
            for (Iterator it = lPersonne.iterator(); it.hasNext();) {
                Personne elem = (Personne) it.next();
                //Stock s = stockFacade.findQuantiteByPizzaId(elem);
                out.println("Id Personne : <b>" + elem.getIdPersonne() + " </b> ");
                out.println("Prenom : " + elem.getPrenom()+ "<br/>");
                
            }    
            List lEnseignant = enseignantFacade.findAll();
            for (Iterator it = lEnseignant.iterator(); it.hasNext();) {
                Enseignant elem = (Enseignant) it.next();
                //Stock s = stockFacade.findQuantiteByPizzaId(elem);
                out.println("Nom : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignant()+ "<br/>");
                
            } 
            List lEtudiant = etudiantFacade.findAll();
            for (Iterator it = lEtudiant.iterator(); it.hasNext();) {
                Etudiant elem = (Etudiant) it.next();
                //Stock s = stockFacade.findQuantiteByPizzaId(elem);
                out.println("Nom : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Id : " + elem.getIdFormation().getNom()+ "<br/>");
                
            }      
            String type=null;
            type=request.getParameter("type");
            if (type!=null) {
                try {
                    int prix=0;
                    prix=new Integer(request.getParameter("prix"));
                    int quantite=new Integer(request.getParameter("quantite"));             
                    out.println("On ajoute un type de pizza<br/>");

                    //Pizza e = new Pizza();
                    //e.setPizzaId(type);
                    //e.setPrix(prix);
                    //pizzaFacade.create(e);
                    //stockFacade.create(type,quantite);
                    response.sendRedirect("AdminPizza");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            out.println("Pizza sauvegardÃ©");
            } else {
                out.println("<form method='POST'>");
                out.println("Type: <input type='text' name='type'><br/>");
                out.println("Prix: <input type='text' name='prix'><br/>");
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
