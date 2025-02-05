package com.kht.PizzaMenu.controller;

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
@RequestMapping("/oauth/naver")
public class NaverAPIController {

    // ${} 내부에서 ctrl + space 누르면 properties 에서 가져올 수 있는 변수 이름 표기
    @Value("${naver.client-id}")
    private String naverClientId;

    @Value("${naver.redirect-url}")
    private String naverRedirectUrl;
    /*
        아래와 같이 직접적으로 properties 에 작성한 값을 넣을 수 있지만
        id 나 secret 키가 유출될 가능성이 높기 때문에 properties 파일에 작성 후 가져오는 형식으로 설정
        private String naverRedirectUrl = "http://localhost:8080/oauth/naver/callback";
     */
    @Value("${naver.client-secret}")
    private String naverClientSecret;

    @GetMapping("/login")
    public ResponseEntity<?> getNaverLoginUrl() {
        String url = "https://nid.naver.com/oauth2.0/authorize?response_type=code" +
                "&client_id=" + naverClientId + "&redirect_uri=" + naverRedirectUrl +
                "&state=xyz123";
        return ResponseEntity.ok(url);
    }

    @GetMapping("/callback")
    public String handleCallback(@RequestParam("code") String code,
                                 @RequestParam("state") String state) {
        try {
            String tokenUrl = "https://nid.naver.com/oauth2.0/token";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "authorization_code");
            params.add("client_id", naverClientId);
            params.add("client_secret", naverClientSecret);
            params.add("code", code);
            params.add("state", state);

            HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
            // 로그인 실패시
            if (response.getBody() == null || !response.getBody().containsKey("access_token")) {
                System.err.println("🚨 네이버 로그인 실패: 액세스 토큰을 받아오지 못했습니다.");
                return "redirect:/error?message=네이버 로그인 실패";
            }

            String accessToken = (String) response.getBody().get("access_token");

            String userInfoUrl = "https://openapi.naver.com/v1/nid/me";
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.add("Authorization", "Bearer " + accessToken);

            HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);
            ResponseEntity<Map> userResponse = restTemplate.postForEntity(userInfoUrl, userRequest, Map.class);

            if (userResponse.getBody() == null || !userResponse.getBody().containsKey("response")) {
                System.err.println("🚨 네이버 사용자 정보를 가져올 수 없습니다.");
                return "redirect:/error?message=사용자 정보 없음";
            }

            Map userInfo = userResponse.getBody();
            Map<String, Object> responseData = (Map<String, Object>) userInfo.get("response");


            String name = (String) responseData.get("name");
            String email = (String) responseData.get("email");

            if (name == null || name.isEmpty()) {
                System.err.println("🚨 name 값이 없습니다! 기본값 설정");
                name = "네이버 사용자";
            }
            if (email == null) email = "이메일 없음";


            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);

            return "redirect:/naversignup?name=" + encodedName + "&email=" + email ;

        } catch (Exception e) {
            System.err.println("🚨 네이버 로그인 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return "redirect:/error?message=네이버 로그인 오류 발생";
        }
    }
}
