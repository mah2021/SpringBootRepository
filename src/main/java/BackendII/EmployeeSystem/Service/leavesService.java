
package BackendII.EmployeeSystem.Service;


import BackendII.EmployeeSystem.Model.Leaves;
import BackendII.EmployeeSystem.Repository.leavesCrudRepository;
import BackendII.EmployeeSystem.Repository.leavesJpaRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class leavesService {
    private final leavesJpaRepository leavesrepo;
    private final leavesCrudRepository leavescrudrepo;

    public leavesService(leavesJpaRepository leavesrepo, leavesCrudRepository leavescrudrepo) {
        this.leavesrepo = leavesrepo;
        this.leavescrudrepo = leavescrudrepo;
    }

    
     @PersistenceContext
    public EntityManager em;
    
     
     ///////////////////////////////crud-function
     public String create(Leaves leave){
         leave.setStatus(false);
         leavescrudrepo.save(leave);
         return "Your request added successfully, Thank you.";
    }
     
     public List<Leaves> findByEmployeeId(Integer employeeid) {
        List<Leaves>  result=leavescrudrepo.findByEmployeeId(employeeid);
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException("there isn't any leaves request");
        }
        else{
            return result;
        }
      }
     public Iterable<Leaves> getAll(){
        return leavescrudrepo.findAll();
    }
    
    public String deleteLeaves(Integer id){
        leavescrudrepo.deleteById(id);
        return "Deleted successfully";
    }
    public String updateLeaves(Leaves leave,Integer id) {
            Leaves update=leavescrudrepo.findById(id).get();
            update.setStatus(true);
            leavescrudrepo.save(update);
            return "update Successfully";
    } 
       
    

   /////////////////////////////////////////////////// spq-jpa
     public String add(Leaves leave){
          try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewLeaves");
            spq.registerStoredProcedureParameter("employeeidIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("fromdateIN", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("todateIN", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("reasonIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("status", Boolean.class, ParameterMode.IN);
           
            spq.setParameter("employeeidIN", leave.getEmployeeid());
            spq.setParameter("fromdateIN", leave.getFromdate());
            spq.setParameter("todateIN", leave.getTodate());
            spq.setParameter("reasonIN", leave.getReason());
            spq.setParameter("status", false);
            spq.execute();
            return "Your request added successfully, Thank you.";
        }
        catch(Exception ex){
            return "You have an error,please try again.";
        }
    }

        public List<Leaves> getLeavesJpa(){
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getLeaves");
            return spq.getResultList();
        }
      
      

    public String delete(Integer id) {
          try{
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteLeaves");
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
