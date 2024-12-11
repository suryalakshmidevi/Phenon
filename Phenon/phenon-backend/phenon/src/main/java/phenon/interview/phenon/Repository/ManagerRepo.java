package phenon.interview.phenon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import phenon.interview.phenon.Model.ManagerReview;

@Repository
public interface ManagerRepo extends JpaRepository<ManagerReview ,Integer> {

    ManagerReview findByempid(int empid);

    
}
