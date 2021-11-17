
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface leavesJpaRepository extends JpaRepository<Leaves,Integer>{


    
    
}
