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

    @GetMapping("/{cId}")
    public Clothes getClothesById(@PathVariable("cId") int cId) {
        return clothesService.getClothesById(cId);
    }

    @PostMapping
    public void insertClothes(@RequestBody Clothes clothes) {
        log.info("====== Insert Clothes =====");
        clothesService.insertClothes(clothes);
    }

    @PutMapping
    public void updateClothes(@RequestBody Clothes clothes) {
        log.info("====== update Clothes =====");
        clothesService.updateClothes(clothes);
    }

    @DeleteMapping("/{cId}")
    public void deleteClothes(@PathVariable("cId") int cId) {
        clothesService.deleteClothes(cId);
    }
}