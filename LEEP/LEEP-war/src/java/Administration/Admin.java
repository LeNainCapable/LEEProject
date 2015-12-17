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
import exception.HorairePrisException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            Cours cc = coursFacade.find(3L);
            try {
                coursFacade.addHoraire(cc, 2015, 12, 16, 12, 0, 20);
            } catch (HorairePrisException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS\\style.css\">");
            out.println("<title>Administration Emploi du temps</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Administration de l'emploi du temps</h1>");

            out.println("<a  href=\"./ClientEDT\" >Client</a>");
            out.println("<h2> Liste des personnes</h2>");
            out.println("<p>");

            List lPersonne = personneFacade.findAll();
            for (Iterator it = lPersonne.iterator(); it.hasNext();) {
                Personne elem = (Personne) it.next();
                out.println("Personne : <b>" + elem.getIdPersonne() + " </b> ");
                out.println("Nom et prenom : " + elem.getNom() + " " + elem.getPrenom() + "<br/>");

            }
            out.println("</p>");

            //Liste des enseignants
            out.println("<h2> Liste des enseignants</h2>");
            List lEnseignant = enseignantFacade.findAll();
            out.println("<p>");
            for (Iterator it = lEnseignant.iterator(); it.hasNext();) {
                Enseignant elem = (Enseignant) it.next();
                out.println("Enseignant : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignant() + "<br/>");
                out.println("Liste d'enseignement<br/>");
                for (Iterator itz = elem.getEnseignementCollection().iterator(); itz.hasNext();) {
                    Enseignement en = (Enseignement) itz.next();
                    out.println("Nom : <b>" + en.getNom() + " </b> ");
                }

            }
            out.println("<p>");

            //Liste des étudiants
            out.println("<h2> Liste des etudiants</h2>");
            out.println("<p>");
            List lEtudiant = etudiantFacade.findAll();
            for (Iterator it = lEtudiant.iterator(); it.hasNext();) {
                Etudiant elem = (Etudiant) it.next();
                out.println("Etudiant : <b>" + elem.getIdPersonne().getNom() + " </b> ");
                out.println("Formation : " + elem.getIdFormation().getNom() + "<br/>");

            }
            out.println("</p>");

            //Liste des enseignements          
            out.println("<h2> Liste des enseignements</h2>");
            out.println("<p>");
            List lEnseignement = enseignementFacade.findAll();
            for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                Enseignement elem = (Enseignement) it.next();
                out.println("Enseignement : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignement()
                        + "Enseignant responsable" + elem.getIdEnseignant().getIdPersonne().getNom() + "<br/>");
            }
            out.println("</p>");

            //Liste des cours
            out.println("<h2> Liste des cours</h2>");
            out.println("<p>");
            List lCours = coursFacade.findAll();
            for (Iterator it = lCours.iterator(); it.hasNext();) {
                Cours elem = (Cours) it.next();
                out.println("Cours : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdEnseignement().getNom() + elem.getHeureDebut() + "<br/>");
                out.println("Heure debut:" + elem.getHeureDebut() + " Heure de fin:" + elem.getHeureFin() + "<br/>");
            }
            out.println("</p>");

            //Liste des formations
            out.println("<h2> Liste de formation</h2>");
            out.println("<p>");
            List lFormation = formationFacade.findAll();
            for (Iterator it = lFormation.iterator(); it.hasNext();) {
                Formation elem = (Formation) it.next();
                out.println("Formation : <b>" + elem.getNom() + " </b> ");
                out.println("Id : " + elem.getIdFormation());
                out.println("Nb n'enseignement : " + elem.getEnseignementCollection().size());
                out.println(" Effectif" + elem.getEtudiantCollection().size() + "<br/>");
                out.println("Liste d'élèves<br/>");
                for (Iterator itz = elem.getEtudiantCollection().iterator(); itz.hasNext();) {
                    Etudiant el = (Etudiant) itz.next();
                    out.println("Nom : <b>" + el.getIdPersonne().getNom() + " </b> ");
                }
                out.println("<h2>Liste d'enseignement</h2>");
                for (Iterator itz = elem.getEnseignementCollection().iterator(); itz.hasNext();) {
                    Enseignement en = (Enseignement) itz.next();
                    out.println("Nom : <b>" + en.getNom() + " </b> ");
                }
            }
            out.println("</p>");

            //ajout d'une entite
            out.println("<h2>Ajout d'une entite</h2>");
            out.println("Selectionner l'entité a ajouter :");
            out.println("<FORM>");
            out.println("<SELECT name=\"entite\" size=\"1\">");
            out.println("<OPTION>Etudiant");
            out.println("<OPTION>Enseignant");
            out.println("<OPTION>Cours");
            out.println("<OPTION>Formation");
            out.println("<OPTION>Enseignement");
            out.println("</SELECT>");
            out.println("<input type='Submit'><br/>");
            out.println("</FORM>");
            String entite = null;

            entite = request.getParameter("entite");
            System.out.println("Entite :" + entite);

            String type = null;
            type = request.getParameter("nom");
            if (type != null) {
                try {
                    out.println("On ajoute un type d'entité<br/>");

                    switch (entite) {
                        case "Etudiant":
                          //on ajoute un étu, mettre la méthode a chaque fois d'ajout avec les param
                            String nom = request.getParameter("nom");
                            String prenom = request.getParameter("prenom");
                            String age = request.getParameter("age");
                            String login = request.getParameter("login");
                            String pw = request.getParameter("pw");
                            System.out.println("Nom :" + nom);
                            System.out.println("Prenom :" + prenom);
                            System.out.println("Age :" + age);
                            System.out.println("Login :" + login);
                            
                            break;
                        case "Enseignant":
                           
                            break;
                        case "Cours":
                           
                            break;
                        case "Formation":
                           
                            break;
                        case "Enseignement":
                           
                            break;
                        default:
                            break;
                    }
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
                out.println("Entité sauvegardée");
            } else {
                switch (entite) {
                    case "Etudiant":
                        //Remplir les champs relatifs a chaque classe
                        out.println("<form method='POST'>");
                        out.println("Nom: <input type='text' name='nom'><br/>");
                        out.println("Prenom: <input type='text' name='prenom'><br/>");
                        out.println("Age: <input type='text' name='age'><br/>");
                        out.println("Login: <input type='text' name='login'><br/>");
                        out.println("Password: <input type='text' name='password'><br/>");
                        out.println("Formation: <input type='text' name='formation'><br/>");
                        out.println("<input type='submit'><br/>");
                        out.println("</form>");
                        out.println("<select name='pays' id='enseignement'>");
                        for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                            Enseignement elem = (Enseignement) it.next();
                            out.println("<option value='" + elem.getIdEnseignement() + "'>" + elem.getNom() + "</option>");
                        }

                        out.println("</select>");
                        break;
                    case "Enseignant":
                        out.println("<form method='POST'>");
                        out.println("Nom: <input type='text' name='nom'><br/>");
                        out.println("Prenom: <input type='text' name='prenom'><br/>");
                        out.println("Age: <input type='text' name='age'><br/>");
                        out.println("Login: <input type='text' name='login'><br/>");
                        out.println("Password: <input type='text' name='password'><br/>");
                        out.println("<input type='submit'><br/>");
                        out.println("</form>");
                        out.println("<select name='pays' id='enseignement'>");

                        for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                            Enseignement elem = (Enseignement) it.next();
                            out.println("<option value='" + elem.getIdEnseignement() + "'>" + elem.getNom() + "</option>");
                        }

                        out.println("</select>");
                        break;
                    case "Cours":
                        out.println("<form method='POST'>");
                        out.println("idEnseignement: <input type='text' name='idenseignement'><br/>");
                        out.println("Nom: <input type='text' name='nom'><br/>");
                        out.println("Heure début: <input type='text' name='heured'><br/>");
                        out.println("Heure fin: <input type='text' name='heuref'><br/>");
                        out.println("<input type='submit'><br/>");
                        out.println("</form>");
                        out.println("<select name='pays' id='enseignement'>");
                        for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                            Enseignement elem = (Enseignement) it.next();
                            out.println("<option value='" + elem.getIdEnseignement() + "'>" + elem.getNom() + "</option>");
                        }

                        out.println("</select>");
                        break;
                    case "Formation":
                        out.println("<form method='POST'>");
                        out.println("Nom: <input type='text' name='nom'><br/>");
                        out.println("<input type='submit'><br/>");
                        out.println("</form>");
                        out.println("<select name='pays' id='enseignement'>");
                        for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                            Enseignement elem = (Enseignement) it.next();
                            out.println("<option value='" + elem.getIdEnseignement() + "'>" + elem.getNom() + "</option>");
                        }

                        out.println("</select>");
                        break;
                    case "Enseignement":
                        out.println("<form method='POST'>");
                        out.println("Nom: <input type='text' name='nom'><br/>");
                        out.println("idEnseignant: <input type='text' name='prix'><br/>");
                        out.println("nbTD: <input type='text' name='nbtd'><br/>");
                        out.println("nbSem: <input type='text' name='nbsem'><br/>");
                        out.println("idCours: <input type='text' name='idcours'><br/>");
                        out.println("<input type='submit'><br/>");
                        out.println("</form>");
                        out.println("<select name='pays' id='enseignement'>");
                        for (Iterator it = lEnseignement.iterator(); it.hasNext();) {
                            Enseignement elem = (Enseignement) it.next();
                            out.println("<option value='" + elem.getIdEnseignement() + "'>" + elem.getNom() + "</option>");
                        }

                        out.println("</select>");
                        break;
                    default:
                        break;
                }

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
