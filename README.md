# 大营销抽奖系统 - By 刘仕杰

项目介绍：大营销平台是各个互联网公司用于拉新、促活、留存、转化的重要手段，此项目针对高并发场景，搭建为各平台促销提效的大营销平台，管理员可通过后台管理活动与奖品，用户可以通过抽奖的方式获取奖品，在寻常抽奖的基础上扩展了黑名单用户兜底，用户权重分析，次数解锁奖品，兜底奖品随机积分等功能。整体采用DDD架构设计，支持分布式水平扩展，单实例部署下QPS实测1000左右。

核心技术：SpringBoot、MyBatis、MySQL、Redis、Redisson、Guava、RabbitMQ。

项目尚未完结，只完成了一个简单的抽奖功能，仍在持续迭代，小伙伴可以先行扩展

前端很简单，故就没有上传了，使用了https://100px.net/这个大转盘插件，vue/react/原生js都可以实现的

---

>**作者**：LuckySJ-刘仕杰 - 在线演示地址 [**www.luckylottery.site**](www.luckylottery.site)

## 运行配置

- 运行环境：JDK 1.8+
- Springboot：2.7.12
- mysql：8.2
- redis：5.0

业务实现：

- DDD架构设计：负责项目的整体架构设计，采用DDD进行领域驱动开发。
- 概率策略设计：负责了抽奖概率装配的实现，通过计算出活动中各奖品的总库存占比，为其分配对应的概率区间。
- 抽奖实现：设计并实现了抽奖功能，用户可以通过平台进行抽奖活动。
- 玩法扩展：在原来抽奖的基础上进行了内容扩展，配合责任链模式在抽奖前实现了黑名单用户处理，权重用户抽取处理，默认抽取处理。使用组合模式构建决策树完成了抽奖后的次数锁判断，库存判断，兜底奖励处理等
- 高并发处理：抽奖也是一种峰值流量高的业务场景，因此在设计奖品库存扣减上，采用了Redis decr原子性操作进行库存扣减，使用消息队列消费数据库库存的同时进行上锁标记。这样可以不超卖的同时，又减少数据库的压力。


