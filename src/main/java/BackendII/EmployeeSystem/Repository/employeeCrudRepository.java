
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeCrudRepository extends CrudRepository<Employee,Integer>{

   
  }
