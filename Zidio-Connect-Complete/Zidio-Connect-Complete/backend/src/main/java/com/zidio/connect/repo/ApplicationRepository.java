package com.zidio.connect.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.connect.model.Application;
import java.util.List;
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByUserId(Long userId);
}