package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Incident;
import org.spring.springboot.domain.IncidentExample;

public interface IncidentMapper {
	long countByExample(IncidentExample example);

	int deleteByExample(IncidentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Incident record);

	int insertSelective(Incident record);

	List<Incident> selectByExample(IncidentExample example);

	Incident selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Incident record, @Param("example") IncidentExample example);

	int updateByExample(@Param("record") Incident record, @Param("example") IncidentExample example);

	int updateByPrimaryKeySelective(Incident record);

	int updateByPrimaryKey(Incident record);
}