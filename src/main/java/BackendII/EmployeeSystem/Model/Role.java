
package BackendII.EmployeeSystem.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ADMIN = "ADMIN";
    public static final String EMPLOYEES = "EMPLOYEES";
    public static final String ACCOUNTANT = "ACCOUNTANT";
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    
    @Column(name = "name")
    private String name;

    public static String getADMIN() {
        return ADMIN;
    }

    public static String getEMPLOYEES() {
        return EMPLOYEES;
    }

    public static String getACCOUNTANT() {
        return ACCOUNTANT;
    }

    public Role() {
    }

    public Role(String name) {
        this.name=name;
    }

    public Role( String name , Set<UserEntity> users) {
        this.users = users;
        this.name = name;
    }
public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }
public Set<UserEntity> getUsers() {
        return users;
    }
 
 
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BackendII.EmployeeSystem.Model.Role[ id=" + id + " ]";
    }
    
}
