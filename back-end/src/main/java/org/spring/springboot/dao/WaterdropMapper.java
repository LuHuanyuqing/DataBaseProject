package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Waterdrop;
import org.spring.springboot.domain.WaterdropExample;

public interface WaterdropMapper {
    long countByExample(WaterdropExample example);

    int deleteByExample(WaterdropExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Waterdrop record);

    int insertSelective(Waterdrop record);

    List<Waterdrop> selectByExample(WaterdropExample example);

    Waterdrop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Waterdrop record, @Param("example") WaterdropExample example);

    int updateByExample(@Param("record") Waterdrop record, @Param("example") WaterdropExample example);

    int updateByPrimaryKeySelective(Waterdrop record);

    int updateByPrimaryKey(Waterdrop record);
}