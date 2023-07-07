package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Taste;
import org.spring.springboot.domain.TasteExample;

public interface TasteMapper {
    long countByExample(TasteExample example);

    int deleteByExample(TasteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Taste record);

    int insertSelective(Taste record);

    List<Taste> selectByExample(TasteExample example);

    Taste selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Taste record, @Param("example") TasteExample example);

    int updateByExample(@Param("record") Taste record, @Param("example") TasteExample example);

    int updateByPrimaryKeySelective(Taste record);

    int updateByPrimaryKey(Taste record);
}