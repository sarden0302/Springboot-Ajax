package kh.edu.react.provider.service;
import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.mapper.ClothesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesServiceImpl implements ClothesService {

    private final ClothesMapper clothesMapper;

    @Override
    public List<Clothes> getAllClothes() {
        return clothesMapper.getAllClothes();
    }

    @Override
    public Clothes getClothesById(int cId) {
        return clothesMapper.getClothesById(cId);
    }

    @Override
    public void insertClothes(String cName,
                              String cCategory,
                              String cBrand,
                              String cColor,
                              String cSize,
                              String cMaterial,
                              int cPrice,
                              int cStock,
                              String cGender,
                              String cSeason) {
        clothesMapper.insertClothes(cName, cCategory, cBrand, cColor, cSize, cMaterial, cPrice, cStock, cGender, cSeason);
    }

    @Override
    public void updateClothes(int cId,
                              String cName,
                              String cCategory,
                              String cBrand,
                              String cColor,
                              String cSize,
                              String cMaterial,
                              int cPrice,
                              int cStock,
                              String cGender,
                              String cSeason) {
        clothesMapper.updateClothes(cId, cName, cCategory, cBrand, cColor, cSize, cMaterial, cPrice, cStock, cGender, cSeason);
    }

    @Override
    public void deleteClothes(int cId) {
        clothesMapper.deleteClothes(cId);
    }
}