package phenon.interview.phenon.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Empperfomence")
public class Performence {

    @Id
    private int empid;
    private int rateing;
    
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
   
    public int getRateing() {
        return rateing;
    }
    public void setRateing(int rateing) {
        this.rateing = rateing;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    private LocalDate date;
}
