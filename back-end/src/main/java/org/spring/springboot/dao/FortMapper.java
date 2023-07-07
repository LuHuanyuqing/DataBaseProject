package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Fort;
import org.spring.springboot.domain.FortExample;

public interface FortMapper {
    long countByExample(FortExample example);

    int deleteByExample(FortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fort record);

    int insertSelective(Fort record);

    List<Fort> selectByExample(FortExample example);

    Fort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fort record, @Param("example") FortExample example);

    int updateByExample(@Param("record") Fort record, @Param("example") FortExample example);

    int updateByPrimaryKeySelective(Fort record);

    int updateByPrimaryKey(Fort record);
}