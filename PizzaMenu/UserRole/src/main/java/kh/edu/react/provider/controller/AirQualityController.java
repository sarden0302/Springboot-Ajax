package kh.edu.react.provider.controller;

import kh.edu.react.provider.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/air-quality")
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;

    // GetMapping 으로 미세먼지 정보 가져오는 기능
    @GetMapping("/forecast")
    // -> Service 방식이 아닌 webConfig 사용할 때 사용 방법
    // public Mono<String> getForeCast(@RequestParam String date) {
    // service 에서 직접적으로 불러올 때는 Mono 와 같은 객체 사용 x
    public String getForeCast(@RequestParam(name = "searchDate") String searchDate) {
        return airQualityService.getAirQuality(searchDate);
    }
}
