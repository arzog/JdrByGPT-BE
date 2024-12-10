package jdr.mgmt.gpt.be.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomUser {

    private Long id;
    private String username;
    private String password;
    private String role;
}
