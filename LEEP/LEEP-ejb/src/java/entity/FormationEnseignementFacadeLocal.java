/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;
import persistence.FormationEnseignement;

/**
 *
 * @author Quentin
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
    
}
