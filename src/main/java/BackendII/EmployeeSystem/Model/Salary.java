
package BackendII.EmployeeSystem.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "salary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s"),
    @NamedQuery(name = "Salary.findById", query = "SELECT s FROM Salary s WHERE s.id = :id"),
    @NamedQuery(name = "Salary.findByEmployeeid", query = "SELECT s FROM Salary s WHERE s.employeeid = :employeeid"),
    @NamedQuery(name = "Salary.findByTotalworking", query = "SELECT s FROM Salary s WHERE s.totalworking = :totalworking"),
    @NamedQuery(name = "Salary.findByBasicsalary", query = "SELECT s FROM Salary s WHERE s.basicsalary = :basicsalary"),
    @NamedQuery(name = "Salary.findByTax", query = "SELECT s FROM Salary s WHERE s.tax = :tax"),
    @NamedQuery(name = "Salary.findByRemainsalary", query = "SELECT s FROM Salary s WHERE s.remainsalary = :remainsalary")})
public class Salary implements Serializable {

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
   
    @Column(name = "totalworking")
    private int totalworking;
    @Basic(optional = false)
 
    @Column(name = "basicsalary")
    private double basicsalary;
    @Basic(optional = false)
  
    @Column(name = "tax")
    private double tax;
    @Basic(optional = false)
   
    @Column(name = "remainsalary")
    private double remainsalary;

    public Salary() {
    }

    public Salary(Integer id) {
        this.id = id;
    }

    public Salary(Integer id, int employeeid, int totalworking, double basicsalary, double tax, double remainsalary) {
        this.id = id;
        this.employeeid = employeeid;
        this.totalworking = totalworking;
        this.basicsalary = basicsalary;
        this.tax = tax;
        this.remainsalary = remainsalary;
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

    public int getTotalworking() {
        return totalworking;
    }

    public void setTotalworking(int totalworking) {
        this.totalworking = totalworking;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRemainsalary() {
        return remainsalary;
    }

    public void setRemainsalary(double remainsalary) {
        this.remainsalary = remainsalary;
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
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BackendII.EmployeeSystem.Model.Salary[ id=" + id + " ]";
    }
    
}
