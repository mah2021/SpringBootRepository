
package BackendII.EmployeeSystem.Repository;

import BackendII.EmployeeSystem.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface userRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    public UserEntity getUserByEmail(@Param("email") String email);
}
