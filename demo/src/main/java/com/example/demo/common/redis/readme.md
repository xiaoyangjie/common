# spring-redis服务包
## 结构
- RedisConfig  
- RedisConfigurationProperties
- RedisConstant
- RedisServer 
- RedisServerCustom
- RedisUtil

### RedisConfig
用于RedisTemplate的key、value、hashkey、hashvalue序列化。

### RedisConfigurationProperties
序列化配置参数，满足spring的配置风格，即配置key的序列化：spring.redis.serializer.key = string；
用户只能配置6种序列化策略

- string ：  StringRedisSerializer
- gjackson ： GenericJackson2JsonRedisSerializer
- jackson ： Jackson2JsonRedisSerializer
- gstring ： GenericToStringSerializer
- jdk ： JdkSerializationRedisSerializer
- omx ： OxmSerializer

### RedisConstant
必要的常量

### RedisServer
对外的基础服务方法类，主要分为key操作，string操作，list操作，set操作，zset操作，hash操作。注意：所有操作的key必须是string类型

### RedisServerCustom
自定义redis操作，应对特定的业务逻辑

### RedisUtil
redis常用工具方法


--------------------------------------

## 使用方法
1. 在公司提供框架的common.config.MvcConfiguration中引入reids包，
即@ComponentScan({"com.unisinsight.framework.*", "com.unisinsight.traffic.common.redis"})
2. 注入RedisServer

-------------------------------------------------------------

联系人：yangjie [yang.jie@unisinsight.com]
电话 ： 17384743663