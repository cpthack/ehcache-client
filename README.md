# ehcache-client

Ehcache属于进程级缓存，针对Ehcache常用的方法进行了简单的封装，方便后期使用。

## 一、使用示例：

#### 1、自定义EhcacheConfigTest配置
> EhcacheConfigTest.java代码引用

	public class EhcacheConfigTest extends EhcacheConfig {
		private final String FILE_NAME = "test-ehcache.xml";
		
		public EhcacheConfigTest() {
			loadConfigFile();
		}
		
		@Override
		public String getConfigFile() {
			return FILE_NAME;
		}
	}

配置文件模板如：[test-ehcache.xml](https://github.com/cpthack/ehcache-client/blob/master/src/test/resources/test-ehcache.xml)所示，主要参考配置项

#### 2、获取缓存操作客户端CacheClient
> EhcacheClientTest.java代码引用

		CacheClient cacheClient = EhcacheClientFactory.getEhcacheClient(new EhcacheConfigTest());
		cacheClient.start();
		logger.info("获取EhcacheClient对象>>>" + cacheClient);

#### 3、缓存的基本CURD
> EhcacheClientTest.java代码引用

		String orgin = "ehcache1";
		String key = "key1";
		String value = "value1";
		logger.info("先尝试从磁盘中恢复数据>>>ORGIN = [" + orgin + "]" + ",KEY = [" + key + "],VALUE = [" + cacheClient.get(orgin, key) + "]");
		
		cacheClient.put(orgin, key, value);
		logger.info("直接读取内存中的数据>>>ORGIN = [" + orgin + "]" + ",KEY = [" + key + "],VALUE = [" + cacheClient.get(orgin, key) + "]");
		
		logger.info("删除缓存中的数据");
		cacheClient.delete(orgin, key);
		}

## 二、具体参考：

* 自定义配置参考类：[EhcacheConfigTest.java](https://github.com/cpthack/ehcache-client/blob/master/src/test/java/com/cpthack/commons/ehcache/EhcacheConfigTest.java)

* 缓存基本操作测试类：[EhcacheClientTest.java](https://github.com/cpthack/ehcache-client/blob/master/src/test/java/com/cpthack/commons/ehcache/EhcacheClientTest.java)
