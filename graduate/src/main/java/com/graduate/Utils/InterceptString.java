package com.graduate.Utils;

/**
 *
 * @author 潘广
 * @接取字符串特定内容
 */
public class InterceptString {
	public static String Content(String content) {
		String ip = content.substring(content.indexOf("=") + 1, content.indexOf(","));
		return ip;
	}

	public static String Content1(String content) {
		String id = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
		return id;
	}
}
