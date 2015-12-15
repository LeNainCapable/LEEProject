/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fayize Kaimou
 */
@Entity
@Table(name = "enseignement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignement.findAll", query = "SELECT e FROM Enseignement e"),
    @NamedQuery(name = "Enseignement.findByIdEnseignement", query = "SELECT e FROM Enseignement e WHERE e.idEnseignement = :idEnseignement"),
    @NamedQuery(name = "Enseignement.findByNom", query = "SELECT e FROM Enseignement e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enseignement.findByNbTD", query = "SELECT e FROM Enseignement e WHERE e.nbTD = :nbTD"),
    @NamedQuery(name = "Enseignement.findByNbSem", query = "SELECT e FROM Enseignement e WHERE e.nbSem = :nbSem")})
public class Enseignement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnseignement")
    private Long idEnseignement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbTD")
    private int nbTD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbSem")
    private int nbSem;
    @JoinTable(name = "formation_enseignement", joinColumns = {
        @JoinColumn(name = "idEnseignement", referencedColumnName = "idEnseignement")}, inverseJoinColumns = {
        @JoinColumn(name = "idFormation", referencedColumnName = "idFormation")})
    @ManyToMany
    private Collection<Formation> formationCollection;
    @JoinColumn(name = "idCours", referencedColumnName = "idCours")
    @ManyToOne
    private Cours idCours;
    @JoinColumn(name = "idEnseignant", referencedColumnName = "idEnseignant")
    @ManyToOne(optional = false)
    private Enseignant idEnseignant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnseignement")
    private Collection<Cours> coursCollection;

    public Enseignement() {
    }

    public Enseignement(Long idEnseignement) {
        this.idEnseignement = idEnseignement;
    }

    public Enseignement(Long idEnseignement, String nom, int nbTD, int nbSem) {
        this.idEnseignement = idEnseignement;
        this.nom = nom;
        this.nbTD = nbTD;
        this.nbSem = nbSem;
    }

    public Long getIdEnseignement() {
        return idEnseignement;
    }

    public void setIdEnseignement(Long idEnseignement) {
        this.idEnseignement = idEnseignement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbTD() {
        return nbTD;
    }

    public void setNbTD(int nbTD) {
        this.nbTD = nbTD;
    }

    public int getNbSem() {
        return nbSem;
    }

    public void setNbSem(int nbSem) {
        this.nbSem = nbSem;
    }

    @XmlTransient
    public Collection<Formation> getFormationCollection() {
        return formationCollection;
    }

    public void setFormationCollection(Collection<Formation> formationCollection) {
        this.formationCollection = formationCollection;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    @XmlTransient
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnseignement != null ? idEnseignement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignement)) {
            return false;
        }
        Enseignement other = (Enseignement) object;
        if ((this.idEnseignement == null && other.idEnseignement != null) || (this.idEnseignement != null && !this.idEnseignement.equals(other.idEnseignement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Enseignement[ idEnseignement=" + idEnseignement + " ]";
    }
    
}
