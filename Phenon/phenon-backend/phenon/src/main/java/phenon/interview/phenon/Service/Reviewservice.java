package phenon.interview.phenon.Service;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phenon.interview.phenon.Model.EmployeeReview;
import phenon.interview.phenon.Model.ManagerReview;
import phenon.interview.phenon.Model.Performence;
import phenon.interview.phenon.Repository.EmployeeRepo;
import phenon.interview.phenon.Repository.ManagerRepo;
import phenon.interview.phenon.Repository.PerformenceRepo;

@Service
public class Reviewservice {
        
   
                
         @Autowired
        private EmployeeRepo empRepo;
                            
        @Autowired
        private ManagerRepo manageRepo;
                            
       @Autowired
       private PerformenceRepo perform;
                                                      

    public Performence employeePerformenceReview(int empid) {
        
        EmployeeReview empReview = empRepo.findByempid(empid);
        ManagerReview managerReview = manageRepo.findByempid(empid);

        if (empReview == null || managerReview == null) {
            System.out.println("Reviews not found for employee: " + empid);
            return null;  
        }

        int empScore = 0;
        int managerScore = 0;
        int managerRating = 0;

        
        if (empReview.getText() != null) {
            empScore = empReview.getText().length();  
        }

        if (managerReview.getText() != null) {
            managerScore = managerReview.getText().length(); 
        }

        if (managerReview.getRateing() != 0) {
            managerRating = managerReview.getRateing();  
        }
              

      
        int overallPerformanceReview = 0;

        if (empScore != 0 && managerScore != 0 && managerRating != 0) {
            overallPerformanceReview = (empScore + (managerScore * managerRating)) / 2;  
        } else {
            System.out.println("Unable to calculate performance review due to missing data");
        }

        
        Performence performance = new Performence();
        performance.setEmpid(empid);
        performance.setRateing(overallPerformanceReview); 
        performance.setDate(LocalDate.now()); 

        
        return perform.save(performance);
    }
}

    
      

       
         
       
       


    


    

