package com.zidio.connect.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.connect.model.Job;
public interface JobRepository extends JpaRepository<Job, Long> {}