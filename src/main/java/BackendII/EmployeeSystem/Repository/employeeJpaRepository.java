
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeJpaRepository extends JpaRepository<Employee,Integer>{
    
}
