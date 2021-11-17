
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleJpaRepository  extends JpaRepository<Role,Integer>{
    
}
