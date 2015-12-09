/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Cours;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fayize Kaimou
 */
@Local
public interface CoursFacadeLocal {

    void create(Cours cours);

    void edit(Cours cours);

    void remove(Cours cours);

    Cours find(Object id);

    List<Cours> findAll();

    List<Cours> findRange(int[] range);

    int count();
    
}
