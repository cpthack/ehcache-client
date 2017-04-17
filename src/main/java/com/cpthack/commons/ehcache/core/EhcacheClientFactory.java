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
package com.cpthack.commons.ehcache.core;

import java.util.Map;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpthack.commons.ehcache.config.EhcacheConfig;
import com.cpthack.commons.ehcache.constants.EhcacheConstants;

/**
 * <b>EhcacheClientFactory.java</b></br>
 * 
 * <pre>
 * CacheClient对象生成工厂类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:54:10
 * @since JDK 1.7
 */
public class EhcacheClientFactory {
	
	private static Logger                   logger           = LoggerFactory.getLogger(EhcacheClientFactory.class);
	private static Map<String, CacheClient> ehcacheClientMap = new ConcurrentHashMap<String, CacheClient>();
	
	public static CacheClient getEhcacheClient() {
		return getEhcacheClient(null);
	}
	
	public static CacheClient getEhcacheClient(EhcacheConfig ehcacheConfig) {
		CacheClient ehcacheClient = null;
		String ehcacheConfigFileName = EhcacheConstants.DEFAULT_CONFIG_FILE_NAME;
		
		// 获取默认EhcacheConfig配置的CacheClient对象，并缓存到ehcacheClientMap对象中
		if (null == ehcacheConfig) {
			ehcacheClient = ehcacheClientMap.get(ehcacheConfigFileName);
			if (ehcacheClient == null) {
				ehcacheClient = new EhcacheClient().setEhcacheConfig(null);
				ehcacheClientMap.put(ehcacheConfigFileName, ehcacheClient);
			}
			
			logger.debug("获取默认配置的CacheClient对象,config name = [" + ehcacheConfigFileName + "]");
			
			return ehcacheClient;
		}
		
		// 获取自定义的EhcacheConfig配置的RedisClient对象，并缓存到ehcacheClientMap对象中
		ehcacheConfigFileName = ehcacheConfig.getConfigFile();
		ehcacheClient = ehcacheClientMap.get(ehcacheConfigFileName);
		if (ehcacheClient == null) {
			ehcacheClient = new EhcacheClient().setEhcacheConfig(ehcacheConfig);
			ehcacheClientMap.put(ehcacheConfigFileName, ehcacheClient);
		}
		
		logger.debug("获取自定义配置的CacheClient对象,config name = [" + ehcacheConfigFileName + "]");
		
		return ehcacheClient;
	}
}
