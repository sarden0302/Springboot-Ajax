package com.kh.AjaxProject.mapper;

import com.kh.AjaxProject.DTO.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// id에 해당하는 구문을 보유하고 있을 뿐 실질적인 기능 xx -> interface
// sql 구문을 xml 파일에서 id에 해당하는 구문을 가져와 설정
@Mapper // Autowired 내장되어 있음 자동으로 MemberMapper 파일을 SpringBoot 관리할 수 있도록 설정
public interface MemberMapper {
    List<Member> getAllMembers();
}
