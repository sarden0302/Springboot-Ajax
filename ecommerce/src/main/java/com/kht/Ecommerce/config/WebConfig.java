package com.kht.Ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 웹 관련 설정 Springboot 프로젝트가 컴퓨터에 직접적으로 접근 할 수 있도록 설정
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload-img}")
    private String uploadImg;

    // 이미지 처리할 때 1. static 폴더 아래 이미지
    //               2. 업로드 폴더 위치 이미지 설정
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // resources
        registry.addResourceHandler("/images/**") // 외부에서 보여질 가짜 이미지 경로 (암호화)
                .addResourceLocations("file:" + uploadImg + "/images/users/", "file:" + uploadImg + "/images/books/"); // 실제 저장되는 진짜 이미지 경로
    }
}
