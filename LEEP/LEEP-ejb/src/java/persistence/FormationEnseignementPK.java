/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Quentin
 */
@Embeddable
public class FormationEnseignementPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idFormation")
    private long idFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEnseignement")
    private long idEnseignement;

    public FormationEnseignementPK() {
    }

    public FormationEnseignementPK(long idFormation, long idEnseignement) {
        this.idFormation = idFormation;
        this.idEnseignement = idEnseignement;
    }

    public long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(long idFormation) {
        this.idFormation = idFormation;
    }

    public long getIdEnseignement() {
        return idEnseignement;
    }

    public void setIdEnseignement(long idEnseignement) {
        this.idEnseignement = idEnseignement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFormation;
        hash += (int) idEnseignement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormationEnseignementPK)) {
            return false;
        }
        FormationEnseignementPK other = (FormationEnseignementPK) object;
        if (this.idFormation != other.idFormation) {
            return false;
        }
        if (this.idEnseignement != other.idEnseignement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FormationEnseignementPK[ idFormation=" + idFormation + ", idEnseignement=" + idEnseignement + " ]";
    }
    
}
