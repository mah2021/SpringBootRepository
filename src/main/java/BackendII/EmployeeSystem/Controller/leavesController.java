
package BackendII.EmployeeSystem.Controller;


import BackendII.EmployeeSystem.Model.Leaves;
import BackendII.EmployeeSystem.Service.leavesService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class leavesController {
    private final leavesService leavesserv;

    public leavesController(leavesService leavesserv) {
        this.leavesserv = leavesserv;
    }
    //////////////////////////////////////////crud-function
    @PostMapping(path = "addLeaveCrud")
    public String addNewLeavesByCrud(@RequestBody Leaves leave){
        return leavesserv.create(leave);
    }
    @GetMapping(value="getByEmployeeId/{employeeid}")
    public List<Leaves> findByEmployeeId(@PathVariable("employeeid") Integer employeeid){
        return leavesserv.findByEmployeeId(employeeid);
    }
    @GetMapping(path = "getAllLeavesCrud")
    public Iterable<Leaves> getAllLeavesCrud(){
        return leavesserv.getAll();
    }
    
    @DeleteMapping(path = "deleteLeavesCrud/{id}") 
    public void deleteLeavesCrud(@RequestBody Integer id){
        leavesserv.deleteLeaves(id);
    }

    @PutMapping(path = "updateLeavesCrud/{id}")
    public String updateLeavesCrud(@RequestBody Leaves leave ,Integer id ){
        return leavesserv.updateLeaves(leave, id);
    }
    
    
    ////////////////////////////////////////spq-jpa
    @PostMapping(value = "addLeavesJpa")
    public String addNewLeavesByJpa(@RequestBody Leaves leave){
        return leavesserv.add(leave);
    
    }  
    @GetMapping(value = "/findleavesJpa")
    public List<Leaves> findAllLeavesJpa(){
        return leavesserv.getLeavesJpa();
    }
  
    
    @DeleteMapping(value = "deleteLeavesJpa/{id}")
    public String deleteLeavesByJpa(@PathVariable Integer id ){
        return leavesserv.delete(id);
    }
}
