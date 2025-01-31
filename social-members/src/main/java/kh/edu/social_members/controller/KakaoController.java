package kh.edu.social_members.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping("/login/oauth2/code/kakao")
public class KakaoController {

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}")
    private String kakaoClientSecret;

    @GetMapping("/login")
    public ResponseEntity<?> getKakaoLoginUrl() {
        String url = "https://kauth.kakao.com/oauth/authorize?response_type=code" +
                "&client_id=" + kakaoClientId +
                "&redirect_uri=" + redirectUri;
        return ResponseEntity.ok(url);
    }

    @GetMapping("/callback")
    public String handleCallback(@RequestParam("code") String code) {
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        RestTemplate restTemplate = new RestTemplate();

        // header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"); // utf-8 작성 안할 시 한글 전송 x

        // request
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoClientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        if (kakaoClientSecret != null) {
            params.add("client_secret", kakaoClientSecret);
        }

        // response
        HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
        String accessToken = (String) response.getBody().get("access_token");

        String userInfoUrl = "https://kapi.kakao.com/v2/user/me";
        HttpHeaders userHeaders = new HttpHeaders();
        userHeaders.add("Authorization", "Bearer " + accessToken);

        HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);
        ResponseEntity<Map> userResponse = restTemplate.postForEntity(userInfoUrl, userRequest, Map.class);


        Map userInfo = userResponse.getBody();
        Map<String, Object> properties = (Map<String, Object>) userInfo.get("properties");
        Map<String, Object> kakaoAccount = (Map<String, Object>) userInfo.get("kakao_account");

        // 추후 프로젝트에 맞게 카카오에서 가져올 값 설정
        String nickname = (String) properties.get("nickname"); // 현재는 닉네임만 가져오도록 설정한 상태
        String profileImg = (String) properties.get("profile_image");

        // 한글 깨짐 방지
        String encodedNickname = URLEncoder.encode(nickname, StandardCharsets.UTF_8);

        String email = (String) kakaoAccount.get("email");
        String name = (String) kakaoAccount.get("name");


        // 키-값 받아오기 위해 키-값 시작 = ? 기호
        // 키-값 여러값 받아오고 전달할 경우 = & 기호로 키-값 다수 사용
        return "redirect:/signup?nickname=" + encodedNickname + "&email=" + email + "&profileImg=" + profileImg + "&name" + name;
    }
}
