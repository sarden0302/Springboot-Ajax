package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.PizzaMenuMapper;
import com.kht.PizzaMenu.model.dto.PizzaMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class PizzaMenuServiceImpl implements PizzaMenuService{

    @Autowired
    PizzaMenuMapper pizzaMenuMapper;

    @Value("D://Leo/SoftwareEngineering/static/image/pizzamenu")
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
    public int updatePizzaMenu(String name, int price, String description, MultipartFile file, PizzaMenu pizzaMenu) {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        File saveFile = new File(uploadPizzaMenu + filename);

        try {
            file.transferTo(saveFile);
            pizzaMenu.setName(name);
            pizzaMenu.setPrice(price);
            pizzaMenu.setDescription(description);
            pizzaMenu.setImagePath("/images/" + filename);

            return pizzaMenuMapper.updatePizzaMenu(pizzaMenu);
        } catch (Exception e) {
            System.out.println("이미지 저장 실패!");
            return 0;
        }


    }
}
