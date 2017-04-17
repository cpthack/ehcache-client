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
 * Ehcache操作工具API定义
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:19:31
 * @since JDK 1.7
 */
public interface CacheClient {
	
	/**
	 * 
	 * <b>setEhcacheConfig</b> <br/>
	 * <br/>
	 * 
	 * 自定义EhcacheConfig配置类,如果不定义的话，则使用类库中默认配置<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param ehcacheConfig
	 * @return CacheClient
	 *
	 */
	CacheClient setEhcacheConfig(EhcacheConfig ehcacheConfig);
	
	/**
	 * 
	 * <b>getCacheManage</b> <br/>
	 * <br/>
	 * 
	 * 获取Ehcache操作类对象：CacheManager<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @return CacheManager
	 *
	 */
	CacheManager getCacheManage();
	
	/**
	 * 
	 * <b>get</b> <br/>
	 * <br/>
	 * 
	 * 从缓存中读取数据 <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param orgin
	 *            缓存名称
	 * @param key
	 *            具体缓存KEY
	 * @return String
	 *
	 */
	String get(String orgin, String key);
	
	/**
	 * 
	 * <b>put</b> <br/>
	 * <br/>
	 * 
	 * 添加数据到缓存中<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param orgin
	 *            缓存名称
	 * @param key
	 *            具体缓存KEY
	 * @param value
	 *            具体缓存值
	 * @return boolean
	 *
	 */
	boolean put(String orgin, String key, String value);
	
	/**
	 * 
	 * <b>delete</b> <br/>
	 * <br/>
	 * 
	 * 从缓存中删除数据<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param orgin
	 *            缓存名称
	 * @param key
	 *            具体缓存KEY
	 * @return boolean
	 *
	 */
	boolean delete(String orgin, String key);
	
	/**
	 * 
	 * <b>update</b> <br/>
	 * <br/>
	 * 
	 * 从缓存中更新数据<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param orgin
	 *            缓存名称
	 * @param key
	 *            具体缓存KEY
	 * @param value
	 *            具体缓存值
	 * @return boolean
	 *
	 */
	boolean update(String orgin, String key, String value);
	
	/**
	 * 
	 * <b>start</b> <br/>
	 * <br/>
	 * 
	 * 初始化Ehcache操作类对象：CacheManager，此处才是真正生成CacheManager的时候<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @return boolean
	 *
	 */
	boolean start();
	
	/**
	 * 
	 * <b>stop</b> <br/>
	 * <br/>
	 * 
	 * 关闭Ehcache操作类对象：CacheManager。内部实际调用CacheManager.stop();<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @return boolean
	 *
	 */
	boolean stop();
}
