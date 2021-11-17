
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Salary;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface salaryCrudRepository extends CrudRepository<Salary,Integer>{
    
    
    @Query(value="Select s from Salary s where s.employeeid=:employeeid")
    public List<Salary> findBySalaryEmployeeId(@Param("employeeid")Integer employeeid);

}