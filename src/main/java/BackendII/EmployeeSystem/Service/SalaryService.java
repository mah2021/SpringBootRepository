
package BackendII.EmployeeSystem.Service;

import BackendII.EmployeeSystem.Model.Salary;
import BackendII.EmployeeSystem.Repository.salaryCrudRepository;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class SalaryService {
    private final salaryCrudRepository salaryrepo;

    public SalaryService(salaryCrudRepository salaryrepo) {
        this.salaryrepo = salaryrepo;
    }
    
    public String create(Salary salary){
        double tax,remainsalary;
        double s=salary.getBasicsalary();
        if(s>500000){
             tax=s*10/100;
        } 
        else if(s > 300000)
        {
             tax =  s * 5/100;
        }
        else
        {
            tax = 0;
        }
        
        
        remainsalary=s-tax;
        salary.setTax(tax);
        salary.setRemainsalary(remainsalary);
        salaryrepo.save(salary);
         return "successfully, Thank you.";
    }
      
     public String updateSalary(Salary salary,Integer id) {
        Salary updateSalary=salaryrepo.findById(id).get();
        double tax,remainsalary;
        double s=salary.getBasicsalary();
        if(s>500000){
             tax=s*10/100;
        } 
        else if(s > 300000)
        {
             tax =  s * 5/100;
        }
        else
        {
            tax = 0;
        }
        
        
        remainsalary=s-tax;
        updateSalary.setTax(tax);
        updateSalary.setRemainsalary(remainsalary);
        updateSalary.setBasicsalary(salary.getBasicsalary());
        updateSalary.setTotalworking(salary.getTotalworking());
        salaryrepo.save(updateSalary);
         return "Update successfully, Thank you.";
    }  
     
       public Iterable<Salary> getAll(){
        return salaryrepo.findAll();
    }
    
    public String deleteSalary(Integer id){
        salaryrepo.deleteById(id);
        return "Deleted successfully";
    }
    
    public List<Salary> findBySalaryEmployeeId(Integer employeeid) {
        List<Salary>  result=salaryrepo.findBySalaryEmployeeId(employeeid);
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException("there isn't any salary request");
        }
        else{
            return result;
        }
      }
}
