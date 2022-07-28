package co.id.practice.practice.dao.h2.hello;

import co.id.practice.practice.model.HelloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<HelloModel, Long> {
}
