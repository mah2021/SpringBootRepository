
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.Role;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface roleCrudRepository extends CrudRepository<Role,Integer>{
    
    @Query(value="Select r from Role r where r.id=:id")
    public List<Role> findByIdRole(@Param("id")Integer id);
    
    
}
