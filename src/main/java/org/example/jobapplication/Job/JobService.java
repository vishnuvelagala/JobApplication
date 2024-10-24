package org.example.jobapplication.Job;

import org.example.jobapplication.Job.Job;
import org.example.jobapplication.Job.Repository.JobJPARepository;
import org.example.jobapplication.Job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements JobRepository {

    @Autowired
    private JobJPARepository jobJPARepository;

    public JobService(){

    }

    @Override
    public List<Job> getJobs(){
        return jobJPARepository.findAll();
    }

    @Override
    public ResponseEntity<String> addJob(Job job) {
        jobJPARepository.save(job);
        try{
            jobJPARepository.save(job);
            return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Unable to save Job",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Job> getJobById(Long id) {
        try{
            return new ResponseEntity<>(jobJPARepository.findById(id).get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<String> updateJob(Long id, Job job) {
        try {
            Job existingJob = jobJPARepository.findById(id).get();

            if (job.getDescription() != null) {
                existingJob.setDescription(job.getDescription());
            }
            if (job.getLocation() != null) {
                existingJob.setLocation(job.getLocation());
            }
            if (job.getTitle() != null) {
                existingJob.setTitle(job.getTitle());
            }
            if (job.getMinSalary() != null) {
                existingJob.setMinSalary(job.getMinSalary());
            }
            if (job.getMaxSalary() != null) {
                existingJob.setMaxSalary(job.getMaxSalary());
            }

            jobJPARepository.save(existingJob);

            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<String> deleteJobById(Long id) {
        try{
            jobJPARepository.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }
    }
}
