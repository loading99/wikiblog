package com.jiawa.wiki.mapper;

import com.jiawa.wiki.domain.Visits;
import com.jiawa.wiki.domain.VisitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitsMapper {
    long countByExample(VisitsExample example);

    int deleteByExample(VisitsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Visits record);

    int insertSelective(Visits record);

    List<Visits> selectByExample(VisitsExample example);

    Visits selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Visits record, @Param("example") VisitsExample example);

    int updateByExample(@Param("record") Visits record, @Param("example") VisitsExample example);

    int updateByPrimaryKeySelective(Visits record);

    int updateByPrimaryKey(Visits record);
}