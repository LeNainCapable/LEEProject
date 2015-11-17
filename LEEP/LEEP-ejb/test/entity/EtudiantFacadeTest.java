/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import database.DBConnection;
import database.DataInit;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.Etudiant;
import persistence.Personne;

/**
 *
 * @author Quentin
 */
public class EtudiantFacadeTest {

    public EtudiantFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class EtudiantFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        DataInit.createTables();
        
        //Session session = DBConnection.getSession();
        SessionFactory sf = new Configuration().configure("database/connection.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        Personne e = new Personne(Long.MIN_VALUE, "Quentin", "Amelot", 21, 1, "test");
        session.persist(e);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Test of edit method, of class EtudiantFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        DataInit.createTables();
        Session session = DBConnection.getSession();
    }

    /**
     * Test of remove method, of class EtudiantFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Etudiant entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EtudiantFacadeLocal instance = (EtudiantFacadeLocal) container.getContext().lookup("java:global/classes/EtudiantFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class EtudiantFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EtudiantFacadeLocal instance = (EtudiantFacadeLocal) container.getContext().lookup("java:global/classes/EtudiantFacade");
        Etudiant expResult = null;
        Etudiant result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EtudiantFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EtudiantFacadeLocal instance = (EtudiantFacadeLocal) container.getContext().lookup("java:global/classes/EtudiantFacade");
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class EtudiantFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EtudiantFacadeLocal instance = (EtudiantFacadeLocal) container.getContext().lookup("java:global/classes/EtudiantFacade");
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class EtudiantFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EtudiantFacadeLocal instance = (EtudiantFacadeLocal) container.getContext().lookup("java:global/classes/EtudiantFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
