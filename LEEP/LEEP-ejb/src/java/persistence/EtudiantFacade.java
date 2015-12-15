/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Etudiant;
import entity.Formation;
import entity.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class EtudiantFacade extends AbstractFacade<Etudiant> implements EtudiantFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtudiantFacade() {
        super(Etudiant.class);
    }
    
    public void create(Personne personne, Formation formation) {

        Etudiant e = new Etudiant();
        e.setIdFormation(formation);
        e.setIdPersonne(personne);
        create(e);
    }
    
    public void create(String nom, String prenom,int age, int login, String password, Formation formation){
        Personne p = new Personne(null,nom,prenom,age,login,password,false);
        create(p, formation);
    }
    
    
    
}
