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
package com.cpthack.commons.ehcache.config;

import com.cpthack.commons.ehcache.constants.EhcacheConstants;

/**
 * <b>EhcacheConfig.java</b></br>
 * 
 * <pre>
 * TODO(这里用一句话描述这个类的作用)
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:12:00
 * @since JDK 1.7
 */
public class EhcacheConfig extends AbstractConfig {
	private final String FILE_NAME = EhcacheConstants.DEFAULT_CONFIG_FILE_NAME;
	
	public EhcacheConfig() {
		loadConfigFile();
	}
	
	@Override
	public String getConfigFile() {
		return FILE_NAME;
	}
	
}
