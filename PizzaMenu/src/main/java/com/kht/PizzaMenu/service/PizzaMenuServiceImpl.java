package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.PizzaMenuMapper;
import com.kht.PizzaMenu.model.dto.PizzaMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class PizzaMenuServiceImpl implements PizzaMenuService{

    @Autowired
    PizzaMenuMapper pizzaMenuMapper;

    // 직접적으로 경로를 작성할 경우 파일 위치 노출에 대한 위험이 있기 때문에 properties 작성 후 불러오기
    @Value("${upload-img}") // 파일이름.properties 에서 작성한 변수이름을 가져와서 변수 이름 내 작성된 경로 사용
    private String uploadPizzaMenu;

    @Override
    public List<PizzaMenu> getAllPizzaMenu() {
        return pizzaMenuMapper.getAllPizzaMenu();
    }

    @Override
    public PizzaMenu getPizzaMenuById(int id) {
        return pizzaMenuMapper.getPizzaMenuById(id);
    }

    @Override
    public void insertPizzaMenu(String name, int price, String description, MultipartFile file) {
        // file 앞에 System.currentTimeMillis() 현재 시간 추가한 다음
        //                      현재시간              +      원본파일명 + 확장자명
        String filename = System.currentTimeMillis() + file.getOriginalFilename();


        try {
            File saveFile = new File(uploadPizzaMenu + filename);
            file.transferTo(saveFile);
            PizzaMenu pizzaMenu = new PizzaMenu();
            pizzaMenu.setName(name);
            pizzaMenu.setPrice(price);
            pizzaMenu.setDescription(description);
            pizzaMenu.setImagePath("/pizzaImg/" + filename);

            pizzaMenuMapper.insertPizzaMenu(pizzaMenu);
        } catch (Exception e) {
            System.out.println("이미지 저장 실패!");
        }
    }

    @Override
    public int updatePizzaMenu(String name, int price, String description, MultipartFile file, PizzaMenu pizzaMenu) {
        // 프론트엔드 -> Controller 전달받은 데이터 중에서 이미지 경로만 String 으로 DB 에 저장하고
        // pizza 라는 변수 이름으로 SQL 전달

        // 이미지를 저장하기 전에 사용자1, 사용자2, 사용자3, ... 가 저장하는 이미지 파일명이 일치하는 경우
        // 마지막에 이미지를 저장하는 사용자의 파일로 모두 덮어쓰기가 되기 때문에
        // 각 회사만의 방법으로 이미지 덮어쓰기가 되지 않도록 분류
        /*
            1. UUID
                - 랜덤으로 이름 작성
            2. System.currentTimeMillis()
                - 현재 시간
         */

        // Universally Unique IDentifier 범용 고유 식별자
        // UUID.randomUUID() = 거의 충돌 없는 고유한 식별자 만듬
        // 만들어진 식별자 128비트(16바이트) 컴퓨터로 만들어진 값을 사람이 읽을 수 있는 문자열(String) 형태로 변환
        // UUID 의 경우 기존에 있던 파일 이름을 임의값 36자리로 변환해서 사용
        String uuid = UUID.randomUUID().toString(); // 8-4-4-4-12 총 36자리 문자열 형식 하이픈(-) 포함
        // File saveFile =  new File("어디에 저장할 것이고 어떤 이름으로 저장할 것인가");
        // File saveFile =  new File(uploadPizzaMenu + filename + ".png"); // 단점 : 확장자명을 png 로만 저장 가능

        // 1-1 확장자명을 고객이 작성한 확장자 명으로 가져오고 싶을 경우
        String originalFilename = file.getOriginalFilename();   // 사용자가 작성한 파일이름.확장명 가져오기
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".")); // . 뒤에 작성된 확장명 가져오기
        File saveFile =  new File(uploadPizzaMenu + uuid + fileExtension); // fileExtension = 사용자에게서 가져온 확장명 파일 유형

        // String filename = System.currentTimeMillis() + "_ " + file.getOriginalFilename(); // 이미지를 등록한 곳의 경로 불러옴


        // File saveFile = new File(uploadPizzaMenu + filename);
        // File saveFile = new File(file.getOriginalFileName());

        try {
            // 이미지를 어디 파일에 저장하는지 설정
            // File -> transferTo
            file.transferTo(saveFile);
            pizzaMenu.setName(name);
            pizzaMenu.setPrice(price);
            pizzaMenu.setDescription(description);

            // file.getOriginalFilename() -> uuid 로 작성된 파일명 설정
            // DB 에 경로를 추가할 때는 WebConfig 에 작성한 fake 경로를 파일명 앞에 작성
            // 예를 들어 WebConfig 에서 D://Leo/SoftwareEngineering/static/image/pizzamenu/ 경로를 /uploaded/ 라는 경로로 읽도록 설정
            pizzaMenu.setImagePath(uploadPizzaMenu + uuid + fileExtension);

            return pizzaMenuMapper.updatePizzaMenu(pizzaMenu);
        } catch (Exception e) {
            System.out.println("이미지 저장 실패!");
            return 0;
        }


    }

    @Override
    public int deleteById(int id) {
        return pizzaMenuMapper.deleteById(id);
    }
}
