package com.jiawa.wiki.mapper;


import com.jiawa.wiki.response.StatisticResp;

import java.util.List;

public interface EbookSnapshotMapperCust {

    void genSnapshot();

    List<StatisticResp> getStatistic();

    List<StatisticResp> get30Statistic();
}