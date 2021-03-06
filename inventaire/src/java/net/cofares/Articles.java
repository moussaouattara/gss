/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cofares;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author pfares
 */
@Entity
@Table(name = "Articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a"),
    @NamedQuery(name = "Articles.findByIdArticle", query = "SELECT a FROM Articles a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Articles.findByReferenceArticle", query = "SELECT a FROM Articles a WHERE a.referenceArticle = :referenceArticle"),
    @NamedQuery(name = "Articles.findByNomArticle", query = "SELECT a FROM Articles a WHERE a.nomArticle = :nomArticle")})
public class Articles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArticle")
    private Integer idArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "referenceArticle")
    private String referenceArticle;
    @Size(max = 45)
    @Column(name = "nomArticle")
    private String nomArticle;
    @Lob
    @Size(max = 65535)
    @Column(name = "descriptionArtile")
    private String descriptionArtile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<Mouvement> mouvementCollection;

    public Articles() {
    }

    public Articles(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Articles(Integer idArticle, String referenceArticle) {
        this.idArticle = idArticle;
        this.referenceArticle = referenceArticle;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getReferenceArticle() {
        return referenceArticle;
    }

    public void setReferenceArticle(String referenceArticle) {
        this.referenceArticle = referenceArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescriptionArtile() {
        return descriptionArtile;
    }

    public void setDescriptionArtile(String descriptionArtile) {
        this.descriptionArtile = descriptionArtile;
    }

    @XmlTransient
    public Collection<Mouvement> getMouvementCollection() {
        return mouvementCollection;
    }

    public void setMouvementCollection(Collection<Mouvement> mouvementCollection) {
        this.mouvementCollection = mouvementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+ idArticle+":" + referenceArticle + ":" + nomArticle+ "]";
    }
    
}
