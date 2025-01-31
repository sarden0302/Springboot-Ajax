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
public class KakaoController {

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}")
    private String kakaoClientSecret;

    @GetMapping("/auth/kakao/callback")
    public ResponseEntity<?> getKakaoLoginUrl() {
        String url = "https://kauth.kakao.com/oauth/authorize?response_type=code" +
                "&client_id=" + kakaoClientId +
                "&redirect_uri=" + redirectUri;
        return ResponseEntity.ok(url);
    }

    @GetMapping("/login/oauth2/code/kakao")
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
        String email = (String) kakaoAccount.get("email");
        String name = (String) kakaoAccount.get("name");
        // 한글 깨짐 방지
        String encodedNickname = URLEncoder.encode(nickname, StandardCharsets.UTF_8);
        String encodeName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String gender = (String) kakaoAccount.get("gender");

        System.out.println("=============== [Controller] user info ===============");
        System.out.println("nickname: " + encodedNickname);
        System.out.println("profileImg: " + profileImg);
        System.out.println("email: " + email);
        System.out.println("name: " + name);
        System.out.println("gender: " + gender);
        // 키-값 받아오기 위해 키-값 시작 = ? 기호
        // 키-값 여러값 받아오고 전달할 경우 = & 기호로 키-값 다수 사용
        return "redirect:/signup?nickname=" + encodedNickname + "&email=" + email + "&name=" + encodeName + "&gender=" + gender + "&profileImg=" + profileImg;
        /*
        signup.html 에서 회원가입란을 작성하지 않고, 카카오 로그인 클릭 후 바로 DB에 저장하는 방식

            memberService.insertMember(nickname, name, email, gender);
            return "DB에 저장완료";

        ※ 문제 발생!
            -> 로그인 하는 회사별로 사용하는 JSON 형식을 모두 파악
            -> service 에서 개발자로 처리하는 로직에서 문제가 발생
            -> DB에 값이 제대로 넘어오지 않는 경우 존재 => 소셜 변수명 변경, JSON 형식 변경했을 때
        */
    }
}
