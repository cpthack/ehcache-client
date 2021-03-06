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
package com.cpthack.commons.ehcache.exception;

/**
 * <b>EhcacheExcepiton.java</b></br>
 * 
 * <pre>
 * 针对Ehcache的相关异常逻辑，自定义异常处理类
 * </pre>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月16日 下午10:48:44
 * @since JDK 1.7
 */
public class EhcacheExcepiton extends ApplicationException {
	
	private static final long serialVersionUID = 5384992447757581988L;
	
	public EhcacheExcepiton(Throwable t) {
		super(t);
	}
	
	public EhcacheExcepiton(String message) {
		super(message);
	}
}
