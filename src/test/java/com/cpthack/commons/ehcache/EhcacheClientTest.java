/**
 * Copyright (c) 2013-2020, cpthack 成佩涛 (cpt@jianzhimao.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cpthack.commons.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpthack.commons.ehcache.core.CacheClient;
import com.cpthack.commons.ehcache.core.EhcacheClientFactory;

/**
 * <b>EhcacheClientTest.java</b></br>
 * 
 * <pre>
 * TODO(这里用一句话描述这个类的作用)
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午11:05:28
 * @since JDK 1.7
 */
public class EhcacheClientTest {
	
	private static Logger logger = LoggerFactory.getLogger(EhcacheClientTest.class);
	
	public static void main(String[] args) {
		CacheClient cacheClient = EhcacheClientFactory.getEhcacheClient(new EhcacheConfigTest());
		cacheClient.start();
		logger.info("获取EhcacheClient对象>>>" + cacheClient);
		
		String orgin = "ehcache1";
		String key = "key1";
		String value = "value1";
		logger.info("先尝试从磁盘中恢复数据>>>ORGIN = [" + orgin + "]" + ",KEY = [" + key + "],VALUE = [" + cacheClient.get(orgin, key) + "]");
		
		cacheClient.put(orgin, key, value);
		logger.info("直接读取内存中的数据>>>ORGIN = [" + orgin + "]" + ",KEY = [" + key + "],VALUE = [" + cacheClient.get(orgin, key) + "]");
		
		logger.info("删除缓存中的数据");
		cacheClient.delete(orgin, key);
		
		cacheClient.stop();
	}
}
