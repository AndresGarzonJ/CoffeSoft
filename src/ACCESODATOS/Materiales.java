/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESODATOS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NELCY
 */
@Entity
@Table(name = "MATERIALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")
    , @NamedQuery(name = "Materiales.findByMatcodigo", query = "SELECT m FROM Materiales m WHERE m.matcodigo = :matcodigo")
    , @NamedQuery(name = "Materiales.findByMatnombre", query = "SELECT m FROM Materiales m WHERE m.matnombre = :matnombre")
    , @NamedQuery(name = "Materiales.findByMatdescripcion", query = "SELECT m FROM Materiales m WHERE m.matdescripcion = :matdescripcion")
    , @NamedQuery(name = "Materiales.findByMatproveedor", query = "SELECT m FROM Materiales m WHERE m.matproveedor = :matproveedor")
    , @NamedQuery(name = "Materiales.findByMatfecha", query = "SELECT m FROM Materiales m WHERE m.matfecha = :matfecha")
    , @NamedQuery(name = "Materiales.findByMattipo", query = "SELECT m FROM Materiales m WHERE m.mattipo = :mattipo")
    , @NamedQuery(name = "Materiales.findByMatestado", query = "SELECT m FROM Materiales m WHERE m.matestado = :matestado")
    , @NamedQuery(name = "Materiales.findByMatmarca", query = "SELECT m FROM Materiales m WHERE m.matmarca = :matmarca")
    , @NamedQuery(name = "Materiales.findByMatcosto", query = "SELECT m FROM Materiales m WHERE m.matcosto = :matcosto")
    , @NamedQuery(name = "Materiales.findByMatcantidad", query = "SELECT m FROM Materiales m WHERE m.matcantidad = :matcantidad")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MATCODIGO")
    private BigDecimal matcodigo;
    @Basic(optional = false)
    @Column(name = "MATNOMBRE")
    private String matnombre;
    @Column(name = "MATDESCRIPCION")
    private String matdescripcion;
    @Column(name = "MATPROVEEDOR")
    private String matproveedor;
    @Column(name = "MATFECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matfecha;
    @Column(name = "MATTIPO")
    private String mattipo;
    @Column(name = "MATESTADO")
    private String matestado;
    @Column(name = "MATMARCA")
    private String matmarca;
    @Basic(optional = false)
    @Column(name = "MATCOSTO")
    private BigInteger matcosto;
    @Basic(optional = false)
    @Column(name = "MATCANTIDAD")
    private BigInteger matcantidad;

    public Materiales() {
    }

    public Materiales(BigDecimal matcodigo) {
        this.matcodigo = matcodigo;
    }

    public Materiales(BigDecimal matcodigo, String matnombre, BigInteger matcosto, BigInteger matcantidad) {
        this.matcodigo = matcodigo;
        this.matnombre = matnombre;
        this.matcosto = matcosto;
        this.matcantidad = matcantidad;
    }

    public BigDecimal getMatcodigo() {
        return matcodigo;
    }

    public void setMatcodigo(BigDecimal matcodigo) {
        this.matcodigo = matcodigo;
    }

    public String getMatnombre() {
        return matnombre;
    }

    public void setMatnombre(String matnombre) {
        this.matnombre = matnombre;
    }

    public String getMatdescripcion() {
        return matdescripcion;
    }

    public void setMatdescripcion(String matdescripcion) {
        this.matdescripcion = matdescripcion;
    }

    public String getMatproveedor() {
        return matproveedor;
    }

    public void setMatproveedor(String matproveedor) {
        this.matproveedor = matproveedor;
    }

    public Date getMatfecha() {
        return matfecha;
    }

    public void setMatfecha(Date matfecha) {
        this.matfecha = matfecha;
    }

    public String getMattipo() {
        return mattipo;
    }

    public void setMattipo(String mattipo) {
        this.mattipo = mattipo;
    }

    public String getMatestado() {
        return matestado;
    }

    public void setMatestado(String matestado) {
        this.matestado = matestado;
    }

    public String getMatmarca() {
        return matmarca;
    }

    public void setMatmarca(String matmarca) {
        this.matmarca = matmarca;
    }

    public BigInteger getMatcosto() {
        return matcosto;
    }

    public void setMatcosto(BigInteger matcosto) {
        this.matcosto = matcosto;
    }

    public BigInteger getMatcantidad() {
        return matcantidad;
    }

    public void setMatcantidad(BigInteger matcantidad) {
        this.matcantidad = matcantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matcodigo != null ? matcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.matcodigo == null && other.matcodigo != null) || (this.matcodigo != null && !this.matcodigo.equals(other.matcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ACCESODATOS.Materiales[ matcodigo=" + matcodigo + " ]";
    }
    
}
