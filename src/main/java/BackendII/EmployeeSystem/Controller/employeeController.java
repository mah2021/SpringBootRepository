
package BackendII.EmployeeSystem.Controller;

import BackendII.EmployeeSystem.Model.Employee;
import BackendII.EmployeeSystem.Service.employeeService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class employeeController {
     private final employeeService employeeserv;

    public employeeController(employeeService employeeserv) {
        this.employeeserv = employeeserv;
    }
   
    //////////////////////////////////////////crud-function
    @PostMapping(path = "addCrud")
    public String addNewEmployeeByCrud(@RequestBody Employee employee){
        return employeeserv.create(employee);
    }
    
    @GetMapping(path = "getAllEmployeeCrud")
    public Iterable<Employee> getAllEmployeeCrud(){
        return employeeserv.getAll();
    }
    
    @DeleteMapping(path = "deleteEmployeeCrud/{id}") 
    public void deleteEmployeeCrud(@RequestBody Integer id){
        employeeserv.deleteEmployee(id);
    }

    @PutMapping(path = "updateEmployeeCrud/{id}")
    public String updateEmployeeCrud(@RequestBody Employee employee ,Integer id ){
        return employeeserv.updateEmployee(employee,id); 
    }
    
    
    ////////////////////////////////////////spq-jpa
    @PostMapping(value = "add")
    public String addNewEmployeeByJpa(@RequestBody Employee employee){
        return employeeserv.add(employee);
    
    }  
    @GetMapping(value = "/findemployeeJpa")
    public List<Employee> findAllEmployeeJpa(){
        return employeeserv.getEmployeeJpa();
    }
  
   
    @DeleteMapping(value = "deleteEmployeeJpa/{id}")
    public String deleteEmployeeByJpa(@PathVariable Integer id ){
        return employeeserv.delete(id);
    }
    
    
}
