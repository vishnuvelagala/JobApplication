package org.example.jobapplication.Job.Repository;

import org.example.jobapplication.Job.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobRepository {
    List<Job> getJobs();
    ResponseEntity<Job> getJobById(Long id);
    ResponseEntity<String> addJob(Job job);
    ResponseEntity<String> updateJob(Long id,Job job);

    ResponseEntity<String> deleteJobById(Long id);
}
