package com.kht.Ecommerce.dto;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class KHTBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Column 작성 안할 경우 Default -> (unique=false, nullable=true)
    private String title;

    private String author;

    private String genre;

    private String imagePath;   // 책 표지 이미지 경로 추가
}