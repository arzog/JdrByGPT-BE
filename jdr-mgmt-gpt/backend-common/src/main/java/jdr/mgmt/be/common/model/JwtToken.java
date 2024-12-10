package jdr.mgmt.be.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtToken {

    private String accessToken;
    private String refreshToken;
}
