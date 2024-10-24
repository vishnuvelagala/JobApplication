package org.example.jobapplication.Job.Repository;

import org.example.jobapplication.Job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobJPARepository extends JpaRepository<Job,Long> {
}
