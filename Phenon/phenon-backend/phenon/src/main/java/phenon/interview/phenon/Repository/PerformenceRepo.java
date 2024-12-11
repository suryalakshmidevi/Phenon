package phenon.interview.phenon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import phenon.interview.phenon.Model.Performence;

@Repository
public interface PerformenceRepo  extends JpaRepository<Performence, Integer>{
 Performence findByempid(int empid);
}
