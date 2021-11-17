
package BackendII.EmployeeSystem.Repository;


import BackendII.EmployeeSystem.Model.Leaves;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface leavesCrudRepository extends CrudRepository<Leaves,Integer>{
      @Query(value="Select e from Leaves e where e.employeeid=:employeeid")
    public List<Leaves> findByEmployeeId(@Param("employeeid")Integer employeeid);

   
}
