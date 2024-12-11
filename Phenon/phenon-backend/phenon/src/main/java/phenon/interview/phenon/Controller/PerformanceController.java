package phenon.interview.phenon.Controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phenon.interview.phenon.Model.EmployeeReview;
import phenon.interview.phenon.Model.ManagerReview;
import phenon.interview.phenon.Model.Performence;
import phenon.interview.phenon.Repository.EmployeeRepo;
import phenon.interview.phenon.Repository.ManagerRepo;
import phenon.interview.phenon.Service.Reviewservice;

import java.time.LocalDate;


@RestController
@RequestMapping("/api")
public class PerformanceController {

    @Autowired
    private EmployeeRepo selfReviewRepository;

    @Autowired
    public ManagerRepo managerReviewRepository;
    @Autowired
    private Reviewservice performanceService;

    @PostMapping("/reviews/self")
    public String submitSelfReview(@RequestBody EmployeeReview selfReview) {
        selfReview.setDate(LocalDate.now());
        selfReviewRepository.save(selfReview);
        System.out.println(selfReview);
        return "Self-review submitted successfully!";
    }

    @PostMapping("/reviews/manager")
    public String submitManagerReview(@RequestBody ManagerReview managerReview) {
        managerReview.setDate(LocalDate.now());
        managerReviewRepository.save(managerReview);
        return "Manager review submitted successfully!";
    }

    @GetMapping("/performance/{employeeId}")
    public Performence getPerformanceSummary(@PathVariable int employeeId) {
       
        return performanceService.employeePerformenceReview(employeeId);
    }
}

    

