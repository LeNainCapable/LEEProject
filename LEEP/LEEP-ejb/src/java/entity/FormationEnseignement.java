/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fayize Kaimou
 */
@Entity
@Table(name = "formation_enseignement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormationEnseignement.findAll", query = "SELECT f FROM FormationEnseignement f"),
    @NamedQuery(name = "FormationEnseignement.findByIdFormation", query = "SELECT f FROM FormationEnseignement f WHERE f.formationEnseignementPK.idFormation = :idFormation"),
    @NamedQuery(name = "FormationEnseignement.findByIdEnseignement", query = "SELECT f FROM FormationEnseignement f WHERE f.formationEnseignementPK.idEnseignement = :idEnseignement")})
public class FormationEnseignement implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FormationEnseignementPK formationEnseignementPK;
    @JoinColumn(name = "idEnseignement", referencedColumnName = "idEnseignement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Enseignement enseignement;
    @JoinColumn(name = "idFormation", referencedColumnName = "idFormation", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Formation formation;

    public FormationEnseignement() {
    }

    public FormationEnseignement(FormationEnseignementPK formationEnseignementPK) {
        this.formationEnseignementPK = formationEnseignementPK;
    }

    public FormationEnseignement(long idFormation, long idEnseignement) {
        this.formationEnseignementPK = new FormationEnseignementPK(idFormation, idEnseignement);
    }

    public FormationEnseignementPK getFormationEnseignementPK() {
        return formationEnseignementPK;
    }

    public void setFormationEnseignementPK(FormationEnseignementPK formationEnseignementPK) {
        this.formationEnseignementPK = formationEnseignementPK;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formationEnseignementPK != null ? formationEnseignementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormationEnseignement)) {
            return false;
        }
        FormationEnseignement other = (FormationEnseignement) object;
        if ((this.formationEnseignementPK == null && other.formationEnseignementPK != null) || (this.formationEnseignementPK != null && !this.formationEnseignementPK.equals(other.formationEnseignementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormationEnseignement[ formationEnseignementPK=" + formationEnseignementPK + " ]";
    }
    
}
