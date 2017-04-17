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
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cpthack.commons.ehcache.config.EhcacheConfig;
import com.cpthack.commons.ehcache.exception.EhcacheExcepiton;

/**
 * <b>EhcacheClient.java</b></br>
 * 
 * <pre>
 * CacheClient实现类，针对Ehcache缓存操作的具体实现类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:34:32
 * @since JDK 1.7
 */
public class EhcacheClient implements CacheClient {
	private static Logger logger        = LoggerFactory.getLogger(EhcacheClient.class);
	private EhcacheConfig ehcacheConfig = null;
	
	@Override
	public CacheClient setEhcacheConfig(EhcacheConfig ehcacheConfig) {
		this.ehcacheConfig = ehcacheConfig;
		return this;
	}
	
	@Override
	public CacheManager getCacheManage() {
		return CacheManageFactory.getCacheManager(ehcacheConfig);
	}
	
	@Override
	public String get(String orgin, String key) {
		Element element = null;
		try {
			element = getCache(orgin).get(key);
		}
		catch (Exception e) {
			logger.error("缓存查询失败，orgin = [" + orgin + "],key = [" + key + "]");
			throw new EhcacheExcepiton(e);
		}
		if (element == null) {
			return null;
		}
		return (String) element.getObjectValue();
	}
	
	@Override
	public boolean put(String orgin, String key, String value) {
		try {
			getCache(orgin).put(new Element(key, value));
		}
		catch (Exception e) {
			logger.error("缓存添加失败，orgin = [" + orgin + "],key = [" + key + "],value = [" + value + "]");
			throw new EhcacheExcepiton(e);
		}
		return true;
	}
	
	@Override
	public boolean delete(String orgin, String key) {
		try {
			return getCache(orgin).remove(key);
		}
		catch (Exception e) {
			logger.error("删除添加失败，orgin = [" + orgin + "],key = [" + key + "]");
			throw new EhcacheExcepiton(e);
		}
	}
	
	@Override
	public boolean update(String orgin, String key, String value) {
		delete(orgin, key);
		put(orgin, key, value);
		return true;
	}
	
	@Override
	public boolean start() {
		getCacheManage();
		return true;
	}
	
	@Override
	public boolean stop() {
		getCacheManage().shutdown();
		return true;
	}
	
	private net.sf.ehcache.Cache getCache(String orgin) {
		CacheManager cacheManager = getCacheManage();
		net.sf.ehcache.Cache cache = cacheManager.getCache(orgin);
		if (cache != null)
			return cache;
		else {
			logger.error("Can't find the cahce.The orgin = [" + orgin + "]");
			throw new NullPointerException("Can't find the cahce.The orgin = [" + orgin + "]");
		}
	}
}
