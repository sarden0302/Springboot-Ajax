package kh.edu.react.provider.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AirQualityService {

    // 요청주소 http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth
    private final String API_AIR_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
    /*
        final
            = 상수 처리하는 명령어 (final 로 선언시 변수에 선언된 값 변경 불가능)
            ↓ 아래와 같이 final 선언 이 후 URL 주소 변경 시 에러 발생
            API_AIR_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
     */
    // 일반 인증키
    // phoXr5cRFtN82bz2oGxvrPYt63bVFgnraA5SgBK4%2FG6L%2B6VF1yv4ygILeTSRakFS9ohf33YCtdPoiFQdfo5umw%3D%3D
    private final String SERVICE_KEY = "phoXr5cRFtN82bz2oGxvrPYt63bVFgnraA5SgBK4%2FG6L%2B6VF1yv4ygILeTSRakFS9ohf33YCtdPoiFQdfo5umw%3D%3D";

    public String getAirQuality(String searchDate) {
        // RestTemplate HTTP 요청을 보낼 때 사용
        // RESTful API 통신할 때 사용
        // GET POST PUT DELETE 등의 HTTP 메서드를 사용할 수 있음
        // JSON, XML 데이터 받을 수 있음
        RestTemplate restTemplate = new RestTemplate();

        // UrlComponentBuilder
        // URI = URL 과 URN 을 포함하는 개념
        // 주소로 자주 부르는 URL 은 URI 의 한 종류
        /*
                   URI
   ┌────────────────┴────────────────┐
  URN                               URL
 번호                             번호에 대한 모든 정보

위치종류가 없는                  위치 주소를 나타냄
고유한 이름                     어디서 어떤 정보가 사용자들이 볼 수 있도록
책이름, 코드번호                  전달되는지
와 같이 이름만 존재             정보가 전달되고, 전달하는 위치가 어디인지
*
예 ) 배달서비스 http://baedal.com/
*
URI = Rider
URL = customer
URN = store

URI    http://baedal.com/order/ABC고객/12345     12345번 주문을 식별하는 고유 식별자
       배달/주문/ABC고객/12345                    -> 12345 번으로 고객이 주문
URL    http://baedal.com/store/77/menu   가게에서 77 번 음식점의 메뉴를 가져오는 위치
       77 번 가게에서 메뉴를 모두 가져오는 것
URN    order:12345                       주문번호 12345를 나타내는 주문 번호
       몇 번 주문오더 주문번호만 확인
*
Component

Builder

queryParam = url api endpoint 주소 ?key=value 설정
*/
        String apiURL = UriComponentsBuilder.fromHttpUrl(API_AIR_URL)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("returnType", "json")
                .queryParam("searchDate", searchDate)
                .queryParam("numOfRows", 10)
                .queryParam("pageNo", 1)
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(apiURL, String.class);

        return response.getBody();
    }

}
