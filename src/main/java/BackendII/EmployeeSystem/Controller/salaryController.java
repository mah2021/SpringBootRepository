
package BackendII.EmployeeSystem.Controller;

import BackendII.EmployeeSystem.Model.Salary;
import BackendII.EmployeeSystem.Service.SalaryService;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@SecurityRequirement(name = "javaapi")
public class salaryController {
    private final SalaryService  salaryserv;

    public salaryController(SalaryService salaryserv) {
        this.salaryserv = salaryserv;
    }
    
    
      @PostMapping(path = "addSalary")
    public String addNewSalary(@RequestBody Salary salary){
        return salaryserv.create(salary);
    } 
    
     @PutMapping(path = "updateSalary/{id}")
    public String updateSalaryCrud(@RequestBody Salary salary ,Integer id ){
        return salaryserv.updateSalary(salary,id); 
    }
     @GetMapping(path = "getAllSalary")
    public Iterable<Salary> getAllEmployeeCrud(){
        return salaryserv.getAll();
    }
    
    @DeleteMapping(path = "deletesalary/{id}") 
    public void deleteSalary(@RequestBody Integer id){
        salaryserv.deleteSalary(id);
    }
    @GetMapping(value="getBySalaryEmployeeId/{employeeid}")
    public List<Salary> findByEmployeeId(@PathVariable("employeeid") Integer employeeid){
        return salaryserv.findBySalaryEmployeeId(employeeid);
    }
}
