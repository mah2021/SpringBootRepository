
package BackendII.EmployeeSystem.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "leaves")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leaves.findAll", query = "SELECT l FROM Leaves l"),
    @NamedQuery(name = "Leaves.findById", query = "SELECT l FROM Leaves l WHERE l.id = :id"),
    @NamedQuery(name = "Leaves.findByEmployeeid", query = "SELECT l FROM Leaves l WHERE l.employeeid = :employeeid"),
    @NamedQuery(name = "Leaves.findByFromdate", query = "SELECT l FROM Leaves l WHERE l.fromdate = :fromdate"),
    @NamedQuery(name = "Leaves.findByTodate", query = "SELECT l FROM Leaves l WHERE l.todate = :todate"),
    @NamedQuery(name = "Leaves.findByReason", query = "SELECT l FROM Leaves l WHERE l.reason = :reason"),
    @NamedQuery(name = "Leaves.findByStatus", query = "SELECT l FROM Leaves l WHERE l.status = :status")})
public class Leaves implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)

    @Column(name = "employeeid")
    private int employeeid;
    @Basic(optional = false)
 
    @Column(name = "fromdate")
    @Temporal(TemporalType.DATE)
    private Date fromdate;
    @Basic(optional = false)
   
    @Column(name = "todate")
    @Temporal(TemporalType.DATE)
    private Date todate;
    @Basic(optional = false)
    
    @Column(name = "reason")
    private String reason;
    @Basic(optional = false)
 
    @Column(name = "status")
    private boolean status;

    public Leaves() {
    }

    public Leaves(Integer id) {
        this.id = id;
    }

    public Leaves(Integer id, int employeeid, Date fromdate, Date todate, String reason, boolean status) {
        this.id = id;
        this.employeeid = employeeid;
        this.fromdate = fromdate;
        this.todate = todate;
        this.reason = reason;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leaves)) {
            return false;
        }
        Leaves other = (Leaves) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BackendII.EmployeeSystem.Model.Leaves[ id=" + id + " ]";
    }
    
}
