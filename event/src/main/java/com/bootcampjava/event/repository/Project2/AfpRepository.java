package com.bootcampjava.event.repository.Project2;
import com.bootcampjava.event.domain.Project2.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AfpRepository  extends JpaRepository<Afp, Long> {

    List<Afp> findByDescription(String description) ;
}
