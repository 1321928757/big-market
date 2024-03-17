package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Luckysj @刘仕杰
 * @description 抽奖活动账户表Dao
 * @create 2024/03/14 14:47:24
 */
@Mapper
@DBRouterStrategy(splitTable = false) //账户开启分库不分表
public interface IRaffleActivityAccountDao {
}
