/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Cours;
import exception.HorairePrisException;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.Query;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class CoursFacade extends AbstractFacade<Cours> implements CoursFacadeLocal {
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursFacade() {
        super(Cours.class);
    }
    
    
    public void addHoraire(Cours cours, int y, int m, int d, int h, int mn, int duree) throws HorairePrisException{ 
        String s1 = "select * from cours where heureDebut < ? and heureFin > ? and idCours != ?";
        String s2 = "select * from cours where heureDebut > ? and heureDebut < ? and idCours != ?";
        Query q1 = em.createNativeQuery(s1,Cours.class);
        Query q2 = em.createNativeQuery(s1,Cours.class);
        Query q3 = em.createNativeQuery(s2,Cours.class);
    
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, m-1, d, h, mn, 00);
        
        Date debut =calendar.getTime();
        q1.setParameter(1, debut);
        q1.setParameter(2, debut);
        q1.setParameter(3, cours.getIdCours());
        System.out.println(q1.getResultList().isEmpty()+"1");
        if (!q1.getResultList().isEmpty()) {
          throw new HorairePrisException();
        }
     
        for (Iterator it = q1.getResultList().iterator(); it.hasNext();) {
                Cours elem = (Cours) it.next();
                System.out.println("Cours : <b>" + elem.getNom() + " </b> ");
        }
        cours.setHeureDebut(debut);
        
        calendar.add(Calendar.MINUTE, duree);
        Date fin = calendar.getTime();
        q2.setParameter(1, fin);
        q2.setParameter(2, fin); 
        q2.setParameter(3, cours.getIdCours());
        
        if (!q2.getResultList().isEmpty()) {
          throw new HorairePrisException();
        }
        cours.setHeureFin(fin);
        
        q3.setParameter(1, debut); System.out.println(debut);
        q3.setParameter(2, fin); System.out.println(fin);
        q3.setParameter(3, cours.getIdCours());
        
        if (!q3.getResultList().isEmpty()) {
          throw new HorairePrisException();
        }
        edit(cours);
    }
    
}
