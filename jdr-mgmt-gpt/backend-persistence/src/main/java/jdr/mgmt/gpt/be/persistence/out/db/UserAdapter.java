package jdr.mgmt.gpt.be.persistence.out.db;

import jdr.mgmt.gpt.be.domain.model.CustomUser;
import jdr.mgmt.gpt.be.domain.security.port.UserPort;
import jdr.mgmt.gpt.be.persistence.mapper.UserMapper;
import jdr.mgmt.gpt.be.persistence.repository.JpaUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserAdapter implements UserPort {

    private final JpaUserRepository repository;
    private final UserMapper mapper;

    @Override
    public Optional<CustomUser> findByUsername(String username) {
        return Optional.ofNullable(mapper.toDomainUser(repository.findByUsername(username)));
    }
}
