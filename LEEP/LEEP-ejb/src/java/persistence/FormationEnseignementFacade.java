/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignement;
import entity.Formation;
import entity.FormationEnseignement;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class FormationEnseignementFacade extends AbstractFacade<FormationEnseignement> implements FormationEnseignementFacadeLocal {
    @EJB
    private FormationFacadeLocal formationFacade;
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormationEnseignementFacade() {
        super(FormationEnseignement.class);
    }
    
    public void create(Formation f, Enseignement e){
        FormationEnseignement fe = new FormationEnseignement(f.getIdFormation(),e.getIdEnseignement());
        f.getEnseignementCollection().add(e);
        formationFacade.edit(f); 
        fe.setEnseignement(e);
        fe.setFormation(f);
        create(fe);
    }
}
