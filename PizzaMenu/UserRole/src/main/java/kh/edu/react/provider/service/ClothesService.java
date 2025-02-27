package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Clothes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClothesService {
    List<Clothes> getAllClothes();
    Clothes getClothesById(int cId);
    void insertClothes(String cName,
                       String cCategory,
                       String cBrand,
                       String cColor,
                       String cSize,
                       String cMaterial,
                       int cPrice,
                       int cStock,
                       String cGender,
                       String cSeason);
    void updateClothes(int cId,
                       String cName,
                       String cCategory,
                       String cBrand,
                       String cColor,
                       String cSize,
                       String cMaterial,
                       int cPrice,
                       int cStock,
                       String cGender,
                       String cSeason);
    void deleteClothes(int cId);
}