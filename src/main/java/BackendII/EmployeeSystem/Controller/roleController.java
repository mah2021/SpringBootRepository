
package BackendII.EmployeeSystem.Controller;

import BackendII.EmployeeSystem.Model.Role;
import BackendII.EmployeeSystem.Service.roleService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class roleController {
     private final roleService roleserv;

    public roleController(roleService roleserv) {
        this.roleserv = roleserv;
    }
    
    @PostMapping(path = "addRoleCrud")
    public String addNewEmployeeByCrud(@RequestBody Role role){
        return roleserv.create(role);
    }
   @GetMapping(value="getById/{id}")
    public List<Role> findById(@PathVariable("id") Integer id){
        return roleserv.findById(id);
    }
    @GetMapping(path = "getAllRoleCrud")
    public Iterable<Role> getAllRoleCrud(){
        return roleserv.getAll();
    }
    
}
