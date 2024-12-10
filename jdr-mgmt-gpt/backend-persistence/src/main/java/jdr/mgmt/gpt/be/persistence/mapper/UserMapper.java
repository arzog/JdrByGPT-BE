package jdr.mgmt.gpt.be.persistence.mapper;

import jdr.mgmt.gpt.be.domain.model.CustomUser;
import jdr.mgmt.gpt.be.persistence.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    CustomUser toDomainUser(UserEntity entity);

    UserEntity toEntityUser(CustomUser customUser);
}
