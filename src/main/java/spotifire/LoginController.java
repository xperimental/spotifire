package spotifire;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import spotifire.data.AuthToken;
import spotifire.state.Client;
import spotifire.state.GlobalState;

import java.util.Base64;
import java.util.Locale;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    private static final String LOGIN_FORMAT = "https://accounts.spotify.com/authorize?response_type=code&client_id=%s&scopes=user-library-read,playlist-read-private,playlist-modify-private&redirect_uri=%s";

    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    private String redirectUrl = "http://localhost:8080/login/callback";

    private RestTemplate restTemplate = new RestTemplate();

    private String getLoginURL() {
        return String.format(Locale.US, LOGIN_FORMAT, Client.ID, redirectUrl);
    }

    private String getTokenAuthHeaderValue() {
        String headerValue = String.format("%s:%s", Client.ID, Client.SECRET);
        byte[] headerBytes = headerValue.getBytes();
        return "Basic " + Base64.getEncoder().encodeToString(headerBytes);
    }

    @GetMapping
    public ResponseEntity loginRedirect() {
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .header("Location", getLoginURL())
            .build();
    }

    @GetMapping(path = "/callback")
    public ResponseEntity loginCallback(@RequestParam() String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", getTokenAuthHeaderValue());

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("grant_type", "authorization_code");
        request.add("code", code);
        request.add("redirect_uri", redirectUrl);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<AuthToken> response = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, requestEntity, AuthToken.class);

        AuthToken token = response.getBody();
        GlobalState.getInstance().setAuthToken(token);
        System.out.println("Access token: " + token.getAccessToken());
        
        return ResponseEntity.status(HttpStatus.FOUND)
            .header("Location", "/playlists.html")
            .build();
    }

}
