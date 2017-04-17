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

import com.cpthack.commons.ehcache.config.EhcacheConfig;

/**
 * <b>EhcacheConfigTest.java</b></br>
 * 
 * <pre>
 * Ehcache自定义配置类 - 测试
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午11:35:26
 * @since JDK 1.7
 */
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
