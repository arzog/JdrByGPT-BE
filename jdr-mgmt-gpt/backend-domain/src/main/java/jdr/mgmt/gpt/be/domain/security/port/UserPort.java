package jdr.mgmt.gpt.be.domain.security.port;

import jdr.mgmt.gpt.be.domain.model.CustomUser;

import java.util.Optional;

public interface UserPort {

    Optional<CustomUser> findByUsername(String username);
}
