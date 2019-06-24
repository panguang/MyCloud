package com.graduate.Utils;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author 潘广
 * @time 2019-3-1
 * @功能 对象转json
 */
public class Convert {
	public static String object(Object object) {
		String jsonObject = JSONObject.toJSONString(object);
		return jsonObject;
	}
}
