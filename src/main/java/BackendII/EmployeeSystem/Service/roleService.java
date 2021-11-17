
package BackendII.EmployeeSystem.Service;

//import BackendII.EmployeeSystem.Repository.roleCrudRepository;
import BackendII.EmployeeSystem.Model.Role;
import BackendII.EmployeeSystem.Repository.roleCrudRepository;
import BackendII.EmployeeSystem.Repository.roleJpaRepository;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class roleService {
    
    private final roleJpaRepository rolerepos;
    private final roleCrudRepository rolecrudrepo;

    public roleService(roleJpaRepository rolerepos, roleCrudRepository rolecrudrepo) {
        this.rolerepos = rolerepos;
        this.rolecrudrepo = rolecrudrepo;
    }
    
    ///////////////////////////////crud-create
     public String create(Role role){
         rolecrudrepo.save(role);
         return "Thank you.Successfully added";
    }
     
     public List<Role> findById(Integer id) {
        List<Role>  result=rolecrudrepo.findByIdRole(id);
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException("there isn't any Role with this Id");
        }
        else{
            return result;
        }
      }
     
     
     public Iterable<Role> getAll(){
        return rolecrudrepo.findAll();
    }
}
