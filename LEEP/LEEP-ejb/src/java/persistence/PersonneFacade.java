/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

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
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
    public void create(String nom, String prenom,int age, int login, String password) {
        String s = "insert into personne(idPersonne,nom,prenom,age,login,password) values (NULL,?,?,?,?,?)";
     //   INSERT INTO `leep`.`personne` (`idPersonne`, `nom`, `prenom`, `age`, `login`, `password`) VALUES (NULL, 'kai', 'fay', '14', '1', 'fefesfsef');
        Query q1 = em.createNativeQuery(s);
        q1.setParameter(1, prenom);
        q1.setParameter(2, nom);
        q1.setParameter(3, age);
        q1.setParameter(4, login);
        q1.setParameter(5,password)  ;      
        q1.executeUpdate();     
        //em.refresh(ss);
    }
    
}
