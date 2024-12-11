package jdr.mgmt.gpt;

import jdr.mgmt.gpt.be.api.TestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class TestController implements TestApi {

    @Override
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}
