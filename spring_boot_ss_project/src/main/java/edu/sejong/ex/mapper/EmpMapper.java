package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.EmpDeptVo;

@Mapper
public interface EmpMapper {
	List<EmpDeptVo> selectJoinList1();
}
