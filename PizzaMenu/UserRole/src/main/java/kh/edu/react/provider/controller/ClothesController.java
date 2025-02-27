package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.service.ClothesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private ClothesServiceImpl clothesService;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    @GetMapping("/{id}")
    public Clothes getClothesById(@PathVariable int id) {
        return clothesService.getClothesById(id);
    }

    @PostMapping
    public void insertClothes(@RequestParam("cName") String cName,
                              @RequestParam("cCategory") String cCategory,
                              @RequestParam("cBrand") String cBrand,
                              @RequestParam("cColor") String cColor,
                              @RequestParam("cSize") String cSize,
                              @RequestParam("cMaterial") String cMaterial,
                              @RequestParam("cPrice") int cPrice,
                              @RequestParam("cStock") int cStock,
                              @RequestParam("cGender") String cGender,
                              @RequestParam("cSeason") String cSeason) {
        log.info("====== Insert Clothes =====");
        clothesService.insertClothes(cName, cCategory, cBrand, cColor, cSize, cMaterial, cPrice, cStock, cGender, cSeason);
    }

    @PutMapping
    public void updateClothes(@RequestParam("cId") int cId,
                              @RequestParam("cName") String cName,
                              @RequestParam("cCategory") String cCategory,
                              @RequestParam("cBrand") String cBrand,
                              @RequestParam("cColor") String cColor,
                              @RequestParam("cSize") String cSize,
                              @RequestParam("cMaterial") String cMaterial,
                              @RequestParam("cPrice") int cPrice,
                              @RequestParam("cStock") int cStock,
                              @RequestParam("cGender") String cGender,
                              @RequestParam("cSeason") String cSeason) {
        log.info("====== update Clothes =====");
        clothesService.updateClothes(cId, cName, cCategory, cBrand, cColor, cSize, cMaterial, cPrice, cStock, cGender, cSeason);
    }

    @DeleteMapping("/{id}")
    public void deleteClothes(@PathVariable int id) {
        clothesService.deleteClothes(id);
    }
}