
package BackendII.EmployeeSystem.Service;

import BackendII.EmployeeSystem.Model.Employee;
import BackendII.EmployeeSystem.Repository.employeeCrudRepository;
import BackendII.EmployeeSystem.Repository.employeeJpaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;


@Service
public class employeeService {
    private final employeeJpaRepository employeereposit;
    private final employeeCrudRepository crudemployeereposit;
    @PersistenceContext
    public EntityManager em;
    
    public employeeService(employeeJpaRepository employeereposit, employeeCrudRepository crudemployeereposit) {
        this.employeereposit = employeereposit;
        this.crudemployeereposit = crudemployeereposit;
    }
   
    ///////////////////////////////crud-function
     public String create(Employee employee){
         crudemployeereposit.save(employee);
         return "You register successfully, Thank you.";
    }
     
     public Iterable<Employee> getAll(){
        return crudemployeereposit.findAll();
    }
    
    public String deleteEmployee(Integer id){
        crudemployeereposit.deleteById(id);
        return "Deleted successfully";
    }
    public String updateEmployee(Employee employee,Integer id) {
        Employee updateEmployee=crudemployeereposit.findById(id).get();
        updateEmployee.setFirstname(employee.getFirstname());
        updateEmployee.setLastname(employee.getLastname());
        updateEmployee.setPhone(employee.getPhone());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setPassword(employee.getPassword());
      
          crudemployeereposit.save(updateEmployee);
          return "Update done successfully , thank you";
    }

   /////////////////////////////////////////////////// spq-jpa
     public String add(Employee employee){
          try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewEmployee");
            spq.registerStoredProcedureParameter("firstIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("addressIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
           
            spq.setParameter("firstIN", employee.getFirstname());
            spq.setParameter("lastIN", employee.getLastname());
            spq.setParameter("phoneIN", employee.getPhone());
            spq.setParameter("emailIN", employee.getEmail());
            spq.setParameter("addressIN", employee.getAddress());
            spq.setParameter("passwordIN", employee.getPassword());
         
            spq.execute();
            return "You register successfully, Thank you.";
        }
        catch(Exception ex){
            return "You have an error,please try again.";
        }
    }

        public List<Employee> getEmployeeJpa(){
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getEmployee");
            return spq.getResultList();
        }
      
       
       public String delete(Integer id) {
          try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteEmployee");
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);

               spq.setParameter("idIN",id);
            spq.execute();
            return "Deleted successfully";
        }
        catch(Exception ex){
            return "You have an error,please try again.";
        }
    }
    
    
    
}
