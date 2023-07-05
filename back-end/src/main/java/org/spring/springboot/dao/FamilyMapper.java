package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Family;
import org.spring.springboot.domain.FamilyExample;

public interface FamilyMapper {
	long countByExample(FamilyExample example);

	int deleteByExample(FamilyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Family record);

	int insertSelective(Family record);

	List<Family> selectByExample(FamilyExample example);

	Family selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Family record, @Param("example") FamilyExample example);

	int updateByExample(@Param("record") Family record, @Param("example") FamilyExample example);

	int updateByPrimaryKeySelective(Family record);

	int updateByPrimaryKey(Family record);
}