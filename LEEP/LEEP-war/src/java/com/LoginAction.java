/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistence.CoursFacadeLocal;
import persistence.EnseignantFacadeLocal;
import persistence.EnseignementFacadeLocal;
import persistence.EtudiantFacadeLocal;
import persistence.FormationEnseignementFacadeLocal;
import persistence.FormationFacadeLocal;
import persistence.PersonneFacadeLocal;

/**
 *
 * @author LEEP
 */
public class LoginAction extends org.apache.struts.action.Action {

    PersonneFacadeLocal personneFacade1 = lookupPersonneFacadeLocal();

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
    public PersonneFacadeLocal personneFacade;
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginForm = (LoginForm) form;
        
        System.out.println(loginForm.getUserName());
        long l = 1;
        PersonneFacadeLocal PFL = this.lookupPersonneFacadeLocal();
        
        System.out.println(PFL.find(l).getNom());
        if (PFL.find(Long.valueOf(loginForm.getUserName()).longValue()).getPassword().equals(loginForm.getPassword()) && PFL.find(Long.valueOf(loginForm.getUserName()).longValue()).getResponsable()) {
        //if(loginForm.getUserName().equals(loginForm.getPassword())){
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }

    private PersonneFacadeLocal lookupPersonneFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PersonneFacadeLocal) c.lookup("java:global/LEEP/LEEP-ejb/PersonneFacade!persistence.PersonneFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
