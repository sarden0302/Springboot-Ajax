package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.Clothes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClothesMapper {
    List<Clothes> getAllClothes();
    Clothes getClothesById(int cId);
    void insertClothes(@Param("cName") String cName,
                       @Param("cCategory") String cCategory,
                       @Param("cBrand") String cBrand,
                       @Param("cColor") String cColor,
                       @Param("cSize") String cSize,
                       @Param("cMaterial") String cMaterial,
                       @Param("cPrice") int cPrice,
                       @Param("cStock") int cStock,
                       @Param("cGender") String cGender,
                       @Param("cSeason") String cSeason);

    void updateClothes(@Param("cId") int cId,
                       @Param("cName") String cName,
                       @Param("cCategory") String cCategory,
                       @Param("cBrand") String cBrand,
                       @Param("cColor") String cColor,
                       @Param("cSize") String cSize,
                       @Param("cMaterial") String cMaterial,
                       @Param("cPrice") int cPrice,
                       @Param("cStock") int cStock,
                       @Param("cGender") String cGender,
                       @Param("cSeason") String cSeason);
    void deleteClothes(int cId);
}