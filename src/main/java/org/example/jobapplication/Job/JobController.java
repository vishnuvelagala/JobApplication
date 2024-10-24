package org.example.jobapplication.Job;

import org.example.jobapplication.Job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping("/jobs")
// The above line creates a base url for all the methods we can add additional url just in the mappings below
@RestController
public class JobController {

    @Autowired
    JobRepository jobService;
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs(){
        return ResponseEntity.ok(jobService.getJobs());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody Job job){
       return jobService.addJob(job);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id){
        return jobService.getJobById(id);
    }


    // The below 2 are same
    // @RequestMapping(value = "/jobs/{id}",method = RequestMethod.PUT)
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job,@PathVariable("id") Long id){
            return jobService.updateJob(id,job);
        }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }

}
