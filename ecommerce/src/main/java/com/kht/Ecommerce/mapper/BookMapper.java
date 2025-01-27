package com.kht.Ecommerce.mapper;

import com.kht.Ecommerce.dto.KHTBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface BookMapper {
    // 책 목록 모두 조회 findAll
    // *** 목록이나 리스트와 같은 형태로 2개 이상을 조회할 때 List<DTO파일명>
    List<KHTBook> findAll();

    KHTBook findById(int id);

    void insertBook(KHTBook book);

    int updateById(KHTBook book);

    int deleteById(int id);
}
