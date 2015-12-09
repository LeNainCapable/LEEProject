/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignement;
import entity.Formation;
import entity.FormationEnseignement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fayize Kaimou
 */
@Local
public interface FormationEnseignementFacadeLocal {

    void create(FormationEnseignement formationEnseignement);

    void edit(FormationEnseignement formationEnseignement);

    void remove(FormationEnseignement formationEnseignement);

    FormationEnseignement find(Object id);

    List<FormationEnseignement> findAll();

    List<FormationEnseignement> findRange(int[] range);

    int count();
    
    void create(Formation f, Enseignement e);
}
