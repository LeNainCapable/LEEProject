/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignant;
import entity.Personne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fayize Kaimou
 */
@Local
public interface EnseignantFacadeLocal {

    void create(Enseignant enseignant);

    void edit(Enseignant enseignant);

    void remove(Enseignant enseignant);

    Enseignant find(Object id);

    List<Enseignant> findAll();

    List<Enseignant> findRange(int[] range);

    int count();
    
    Enseignant create(String nom, String prenom,int age, int login, String password);
}
