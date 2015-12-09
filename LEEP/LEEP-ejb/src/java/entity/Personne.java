/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fayize Kaimou
 */
@Entity
@Table(name = "personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIdPersonne", query = "SELECT p FROM Personne p WHERE p.idPersonne = :idPersonne"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByAge", query = "SELECT p FROM Personne p WHERE p.age = :age"),
    @NamedQuery(name = "Personne.findByLogin", query = "SELECT p FROM Personne p WHERE p.login = :login"),
    @NamedQuery(name = "Personne.findByPassword", query = "SELECT p FROM Personne p WHERE p.password = :password")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonne")
    private Long idPersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "login")
    private int login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Enseignant enseignant;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Etudiant etudiant;

    public Personne() {
    }

    public Personne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Personne(Long idPersonne, String nom, String prenom, int age, int login, String password) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Personne[ idPersonne=" + idPersonne + " ]";
    }
    
}
