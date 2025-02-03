package com.kht.PizzaMenu.mapper;

import com.kht.PizzaMenu.model.dto.PizzaMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PizzaMenuMapper {

    // 피자 메뉴 모두 조회
    List<PizzaMenu> getAllPizzaMenu();

    // 피자 상세 조회
    PizzaMenu getPizzaMenuById(int id);

    // 피자 저장
    // void = 저장할 피자 메뉴 개수 확인 or 제대로 저장되었는지 확인이 필요 없을 시
    // insert = 저장할 피자 메뉴 다수   or 제대로 저장되었는지 확인 작업이 필요할 시
    void insertPizzaMenu(PizzaMenu pizzaMenu);

    // 수정한 피자 메뉴 개수 확인
    int updatePizzaMenu(PizzaMenu pizzaMenu);

    // 피자 메뉴 삭제
    int deleteById(int id);
}
