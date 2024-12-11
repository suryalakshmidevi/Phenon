package phenon.interview.phenon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import phenon.interview.phenon.Model.EmployeeReview;

@Repository
public interface EmployeeRepo  extends JpaRepository<EmployeeReview ,Integer> {
 EmployeeReview findByempid(int empid);
   
 

    
    
}
