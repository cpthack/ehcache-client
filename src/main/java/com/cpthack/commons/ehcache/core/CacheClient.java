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

import com.cpthack.commons.ehcache.config.EhcacheConfig;

/**
 * <b>CacheClient.java</b></br>
 * 
 * <pre>
 * TODO(这里用一句话描述这个类的作用)
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:19:31
 * @since JDK 1.7
 */
public interface CacheClient {
	
	CacheClient setEhcacheConfig(EhcacheConfig ehcacheConfig);
	
	CacheManager getCacheManage();
	
	String get(String orgin, String key);
	
	boolean put(String orgin, String key, String value);
	
	boolean delete(String orgin, String key);
	
	boolean update(String orgin, String key, String value);
	
	boolean start();
	
	boolean stop();
}
