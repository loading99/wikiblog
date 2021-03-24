package com.jiawa.wiki.mapper;

import com.jiawa.wiki.domain.TestAcc;
import org.apache.ibatis.annotations.Param;


public interface DocMapperCust {
    public void updateViewCount(@Param("id") Long id);

}
