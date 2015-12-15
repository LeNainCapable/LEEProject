/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignant;
import entity.Etudiant;
import entity.Formation;
import entity.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class EnseignantFacade extends AbstractFacade<Enseignant> implements EnseignantFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnseignantFacade() {
        super(Enseignant.class);
    }
    public Enseignant create(Personne personne) {
        Enseignant e = new Enseignant();
        e.setIdPersonne(personne);
        create(e);
        return e;
    }
    
    public Enseignant create(String nom, String prenom,int age, int login, String password){
        Personne p = new Personne(null,nom,prenom,age,login,password,false);
        return create(p);
    }
}
