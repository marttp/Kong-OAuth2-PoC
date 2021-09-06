package dev.tpcoder.bookstore.key;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("key")
@Slf4j
public class KeyController {
    @GetMapping("/public")
    public Mono<String> generatePublicKey(@RequestHeader MultiValueMap<String, String> multiValueMap)
            throws NoSuchAlgorithmException {
        var pair = KeyHelper.generateKeyPair();
        var publicKey = pair.getPublic();
        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("Public Key:");
        String convertToPublicKey = convertToPublicKey(encodedPublicKey);
        System.out.println(convertToPublicKey);
        return Mono.just(convertToPublicKey);
    }

    // Add BEGIN and END comments
    private String convertToPublicKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PUBLIC KEY-----\n");
        result.append(key);
        result.append("\n-----END PUBLIC KEY-----");
        return result.toString();
    }
}
