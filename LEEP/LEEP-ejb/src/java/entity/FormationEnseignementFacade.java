/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.FormationEnseignement;

/**
 *
 * @author Quentin
 */
@Stateless
public class FormationEnseignementFacade extends AbstractFacade<FormationEnseignement> implements FormationEnseignementFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormationEnseignementFacade() {
        super(FormationEnseignement.class);
    }
    
}
