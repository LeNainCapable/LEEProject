/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignant;
import entity.Enseignement;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class EnseignementFacade extends AbstractFacade<Enseignement> implements EnseignementFacadeLocal {
    @EJB
    private EnseignantFacadeLocal enseignantFacade;
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnseignementFacade() {
        super(Enseignement.class);
    }
    
    public Enseignement create(String nom, int sem, Enseignant enseignant){
        Enseignement en = new Enseignement();
        //en.setCoursCollection(new ArrayList());
        //en.getCoursCollection().add(coursFacade.find(l));
        en.setNbSem(sem);
        en.setNom(nom);
        en.setIdEnseignant(enseignant);        
        create(en);
        enseignant.getEnseignementCollection().add(en);
        enseignantFacade.edit(enseignant);
        return en;
    }
}
