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

import net.sf.ehcache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpthack.commons.ehcache.config.EhcacheConfig;
import com.cpthack.commons.ehcache.exception.EhcacheExcepiton;

/**
 * <b>CacheManageFactory.java</b></br>
 * 
 * <pre>
 * CacheManager对象生成工厂类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:23:02
 * @since JDK 1.7
 */
public class CacheManageFactory {
	
	private static Logger       logger       = LoggerFactory.getLogger(CacheManageFactory.class);
	private static CacheManager cacheManager = null;
	
	public static CacheManager getCacheManager() {
		return getCacheManager(null);
	}
	
	public synchronized static CacheManager getCacheManager(EhcacheConfig ehcacheConfig) {
		
		if (null != cacheManager) {
			return cacheManager;
		}
		
		if (null == ehcacheConfig)
			ehcacheConfig = new EhcacheConfig();// 使用默认的Ehcache.xml配置
			
		try {
			cacheManager = CacheManager.create(ehcacheConfig.loadConfigFile());
		}
		catch (Exception e) {
			logger.error("获取CacheManager对象失败");
			throw new EhcacheExcepiton(e);
		}
		finally {
			ehcacheConfig.closeInputStream();
		}
		
		return cacheManager;
	}
}
