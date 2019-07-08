package com.fuse.Tool;

import com.alibaba.fastjson.JSONObject;

public class Convert {
	public static String object(Object object) {
		return JSONObject.toJSONString(object);
	}
}
