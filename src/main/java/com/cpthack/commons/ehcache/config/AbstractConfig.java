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

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>AbstractConfig.java</b></br>
 * 
 * <pre>
 * TODO(这里用一句话描述这个类的作用)
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:01:14
 * @since JDK 1.7
 */
public abstract class AbstractConfig {
	private static Logger logger      = LoggerFactory.getLogger(AbstractConfig.class);
	private InputStream   inputStream = null;
	
	public InputStream loadConfigFile() {
		try {
			String fileName = getConfigFile();
			ClassLoader classLoader = getClassLoader();
			inputStream = classLoader.getResourceAsStream(fileName);
			if (inputStream == null)
				throw new IllegalArgumentException("Config file not found in classpath: " + fileName);
			logger.debug("Loading config file Successfully! The filename is [" + fileName + "].");
		}
		catch (Exception e) {
			closeInputStream();
			logger.error("读取配置文件出错,Error：", e);
		}
		return inputStream;
	}
	
	public ClassLoader getClassLoader() {
		ClassLoader classLoader = Thread.currentThread()
		        .getContextClassLoader();
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		return classLoader;
	}
	
	protected InputStream getInputStream() {
		return inputStream;
	}
	
	protected boolean closeInputStream() {
		if (inputStream == null)
			return true;
		try {
			inputStream.close();
		}
		catch (IOException e) {
			logger.error("关闭流失败，Error：", e);
		}
		return true;
	}
	
	public abstract String getConfigFile();
}
