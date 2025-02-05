package com.kht.PizzaMenu.controller;

import lombok.extern.slf4j.Slf4j;
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

/*@Slf4j
@Controller
@RequestMapping("/oauth/kakao")
public class KakaoAPIController2 {

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    // url : uri : 식별하는 문자열 urn :
    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}")
    private String kakaoClientSecret;

    @GetMapping("/")
    public ResponseEntity<?> getKakaoLoginUrl() {
        String url = "https://kauth.kakao.com/oauth/authorize?response_type=code" +
                "&client_id=" + kakaoClientId + "&redirect_uri=" + redirectUri;
        return ResponseEntity.ok(url);  // 200 status
    }

    @GetMapping("/login")
    public String handleCallback(@RequestParam String code) {
        String tokenUrl = "https://kauth.kakao.com/oauth/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoClientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        // 보안 강화
        if (kakaoClientSecret != null) {
            params.add("client_secret", kakaoClientSecret);
        }

        HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
        *//*************************************** 카카오 인증 처리 끝 ***************************************//*

        String accessToken = (String) response.getBody().get("access_token");

        String userInfoUrl = "https://kapi.kakao.com/v2/user/me";
        HttpHeaders userHeaders = new HttpHeaders();

        *//***************************** Kakao 규칙 *****************************//*
        userHeaders.add("Authorization", "Bearer " + accessToken);

        HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);
        ResponseEntity<Map> userResponse = restTemplate.postForEntity(userInfoUrl, userRequest, Map.class);

        *//******
         * 필수 동의 설정
         * 이름 성별 생일 을 가져오고 signup/kakao 페이지에서 가져온 데이터 출력
         *
         *//*

        Map userInfo = userResponse.getBody();
        System.out.println("userInfo: " + userInfo);

        // 프로필사진, 이메일, 이름, 성별, 생일, 전화번호
        // kakao json 형식을 확인하고 본인이 가져오고자 하는 경로에서 필요한 데이터 가져오기 설정
        // 1. properties 내에 존재하는 nickname profileImg 가져오기
        Map<String, Object> properties = (Map<String, Object>) userInfo.get("properties");
        String nickname = (String) properties.get("nickname");
        String encodedNickname = URLEncoder.encode(nickname, StandardCharsets.UTF_8);
        String profileImg = (String) properties.get("profile_image");

        // 2. kakaoAccount 내에 존재하는 email 가져오기
        Map<String, Object> kakaoAccount = (Map<String, Object>) userInfo.get("kakao_account");
        String email = (String) kakaoAccount.get("email");
        String gender = (String) kakaoAccount.get("gender");
        String birthday = (String) kakaoAccount.get("birthday");
        String phoneNumber = (String) kakaoAccount.get("phone_number");

        log.info("profile_image : " + profileImg + ", email: " + email + ", gender: " + gender + ", birthday: " + birthday + ", phone: " + phoneNumber);

        // 3. 회원가입으로 이동할 때 카카오에서 가져온 데이터 사용하기위해 전달
        return "redirect:/signup/kakao?nickname=" + encodedNickname + "&email=" + email + "&profileImg=" + profileImg + "&gender=" + gender + "&birthday=" + birthday;
    }
}*/
