/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Enseignement;

/**
 *
 * @author Quentin
 */
@Stateless
public class EnseignementFacade extends AbstractFacade<Enseignement> implements EnseignementFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnseignementFacade() {
        super(Enseignement.class);
    }
    
}
