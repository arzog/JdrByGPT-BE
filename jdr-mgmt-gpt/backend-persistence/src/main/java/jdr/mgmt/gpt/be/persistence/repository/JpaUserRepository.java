package jdr.mgmt.gpt.be.persistence.repository;

import jdr.mgmt.gpt.be.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
