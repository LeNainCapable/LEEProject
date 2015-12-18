/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignant;
import entity.Enseignement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fayize Kaimou
 */
@Local
public interface EnseignementFacadeLocal {

    void create(Enseignement enseignement);

    void edit(Enseignement enseignement);

    void remove(Enseignement enseignement);

    Enseignement find(Object id);

    List<Enseignement> findAll();

    List<Enseignement> findRange(int[] range);

    int count();
    Enseignement create(String nom, int sem, Enseignant enseignant);
    
}
