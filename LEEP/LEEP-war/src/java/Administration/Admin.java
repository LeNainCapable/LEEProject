/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;


import entity.Cours;
import entity.Enseignant;
import entity.Enseignement;
import entity.Etudiant;
import entity.Formation;
import entity.FormationEnseignement;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import persistence.CoursFacadeLocal;
import persistence.EnseignantFacadeLocal;
import persistence.EnseignementFacadeLocal;
import persistence.EtudiantFacadeLocal;
import persistence.FormationEnseignementFacadeLocal;
import persistence.FormationFacadeLocal;

/**
 *
 * @author 11000505
 */
@WebServlet(name = "AdminEDT", urlPatterns = {"/AdminEDT"})
public class Admin extends HttpServlet {
    @EJB
    private FormationEnseignementFacadeLocal formationEnseignementFacade;
    @EJB
    private FormationFacadeLocal formationFacade;
    @EJB
    private EnseignementFacadeLocal enseignementFacade;
    @EJB
    private CoursFacadeLocal coursFacade;
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
            out.println("<h1>Truc</h1>");
            
            out.println("<a  href=\"./ClientEDT\" >Client</a>");
                      out.println("<br/> Liste des personne<br/>");
               List lPersonne = personneFacade.findAll();
            for (Iterator it = lPersonne.iterator(); it.hasNext();) {
                Personne elem = (Personne) it.next();
                out.println( "Personne : <b>" + elem.getIdPersonne() + " </b> ");
                out.println("Nom et prenom : " + elem.getNom() + " "+ elem.getPrenom()+ "<br/>");
                
            }
            out.println("<br/> Liste des enseignant<br/>");
            List lEnseignant = enseignantFacade.findAll();
            for (Iterator it = lEnseignant.iterator(); it.hasNext();) {
                Enseignant elem = (Enseignant) it.next();
                out.println("Enseignant : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignant()+ "<br/>");
                 out.println("Liste d'enseignement<br/>");
                for (Iterator itz = elem.getEnseignementCollection().iterator(); itz.hasNext();) {
                        Enseignement en = (Enseignement) itz.next();
                        out.println("-Nom : <b>" + en.getNom() + " </b> ");
                }
                
            } 
            out.println("<br/> Liste des etudiant<br/>");
            List lEtudiant = etudiantFacade.findAll();
            for (Iterator it = lEtudiant.iterator(); it.hasNext();) {
                Etudiant elem = (Etudiant) it.next();
                out.println("Etudiant : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Formation : " + elem.getIdFormation().getNom()+ "<br/>");
                
            } 
                      
            out.println("<br/> Liste des enseignement<br/>");
            List lEnseignement = enseignementFacade.findAll();
            for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                Enseignement elem = (Enseignement) it.next();
                out.println("Enseignement : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignement()+
                        "Enseignant responsable"+ elem.getIdEnseignant().getIdPersonne().getNom()+ "<br/>");               
            }      
            out.println("<br/> Liste des cours<br/>");          
            List lCours = coursFacade.findAll();
            for (Iterator it = lCours.iterator(); it.hasNext();) {
                Cours elem = (Cours) it.next();
                out.println("Cours : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignement().getNom()+ "<br/>");    
            }
            out.println("<br/> Liste de formation<br/>");
            List lFormation = formationFacade.findAll();
            for (Iterator it = lFormation.iterator(); it.hasNext();) {
                Formation elem = (Formation) it.next();
                out.println("Formation : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdFormation());
                out.println("Nb n'enseignement : " + elem.getEnseignementCollection().size());
                out.println(" Effectif" +   elem.getEtudiantCollection().size() +"<br/>");
                out.println("List d'élèves<br/>");
                for (Iterator itz = elem.getEtudiantCollection().iterator(); itz.hasNext();) {
                        Etudiant el = (Etudiant) itz.next();
                        out.println("-Nom : <b>" + el.getIdPersonne().getNom() + " </b> ");
                    }
                out.println("<br/>Liste d'enseignement<br/>");
                for (Iterator itz = elem.getEnseignementCollection().iterator(); itz.hasNext();) {
                        Enseignement en = (Enseignement) itz.next();
                        out.println("-Nom : <b>" + en.getNom() + " </b> ");
                }
            }      
            
            String type=null;
            type=request.getParameter("type");
            if (type!=null) {
                try {
                    int prix=0;
                    prix=new Integer(request.getParameter("prix"));
                    int quantite=new Integer(request.getParameter("quantite"));             
                    out.println("On ajoute un type de pizza<br/>");
/*
                    long etu = 1;
                    long ettt =45;
                    Personne p = personneFacade.find(etu);
                    p.setNom("Testboogaloa");
                    personneFacade.edit(p);
                    //personneFacade.create(p);
                    System.out.println(p.getIdPersonne());
                    long l = 1;
                    Etudiant e = etudiantFacade.find(l);
                    e.getIdPersonne().setNom("testbooogalo2");
                    personneFacade.edit(e.getIdPersonne());
                    Enseignement en = new Enseignement();
                    //en.setCoursCollection(new ArrayList());
                    //en.getCoursCollection().add(coursFacade.find(l));
                    en.setNbSem(5);
                    en.setNom("Notjava67");
                    Enseignant eee = enseignantFacade.create(personneFacade.find(ettt));
                    enseignementFacade.create("nokavaz", 6, eee);
                    //Formation f = formationFacade.find(l);
                    //f.getEnseignementCollection().add(en);
                    //formationFacade.edit(f);

                    //formationEnseignementFacade.create(f,en);
                    //etudiantFacade.edit(e);
                    //etudiantFacade.edit(p, formationFacade.find(l));
                    //personneFacade.create("k", "y", 4, 5, "ooooo");*/
                    
                    response.sendRedirect("AdminEDT");

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
            out.println("<select name='pays' id='enseignement'>"); 
            for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                Enseignement elem = (Enseignement) it.next();
                out.println("<option value='" + elem.getIdEnseignement()+"'>"+ elem.getNom()+ "</option>");               
            }      
            
            out.println("</select>");
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
