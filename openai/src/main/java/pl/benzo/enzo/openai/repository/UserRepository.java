package pl.benzo.enzo.openai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.openai.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
