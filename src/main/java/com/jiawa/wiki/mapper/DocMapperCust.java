package com.jiawa.wiki.mapper;

import com.jiawa.wiki.domain.TestAcc;
import org.apache.ibatis.annotations.Param;


public interface DocMapperCust {
    void updateViewCount(@Param("id") Long id);

    void updateVoteCount(@Param("id") Long id);

}
