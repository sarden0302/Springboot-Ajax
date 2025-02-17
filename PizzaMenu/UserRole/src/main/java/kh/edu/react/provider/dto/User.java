package kh.edu.react.provider.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    // id 값 자동 증가 @Id @GenerateValue 사용 xx
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userRole;
}
