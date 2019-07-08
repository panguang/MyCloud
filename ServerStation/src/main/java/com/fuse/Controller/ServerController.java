package com.fuse.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.KeyStone.keystone;
import com.fuse.Tool.Convert;
import com.fuse.entity.Customer;
import com.fuse.entity.VCustomer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "v1/api", tags = { "电费接口测试" })
@RestController
public class ServerController {

	@ApiOperation(value = "查询电费", notes = "电费信息")
	@RequestMapping(value = { "/selectInfo" }, method = { RequestMethod.POST })
	public String SelectQuery(HttpServletRequest request, @RequestBody Customer customer) throws IOException {
		String data = Convert.object(customer);
		return keystone.ValidationPost("https://horven.sumpahpalapa.com/api/inquire/electricity.json", "fuse",
				"oobo9gxI3Tx2Ycm3mZjAJcYXOsh5V2IBvoZQkONg1vk", data);
	}

	@ApiOperation(value = "创建新的电费订单", notes = "创建订单信息")
	@RequestMapping(value = { "/buyelectric" }, method = { RequestMethod.POST })
	public String BuyEelectric(HttpServletRequest request, @RequestBody VCustomer vcustomer) throws IOException {
		String data = Convert.object(vcustomer);
		return keystone.ValidationPost("https://horven.sumpahpalapa.com/api/transaction/electricity.json", "fuse",
				"oobo9gxI3Tx2Ycm3mZjAJcYXOsh5V2IBvoZQkONg1vk", data);
	}

	@ApiOperation(value = "获取预交付ID信息", notes = "获取预交付ID信息")
	@RequestMapping(value = { "/getpreInfo/{transaction_id}" }, method = { RequestMethod.GET })
	public String getpreInfo(HttpServletRequest request, @PathVariable("transaction_id") Integer transaction_id)
			throws IOException {
		return keystone.ValidationGet(
				"https://horven.sumpahpalapa.com/api/transaction/electricity/" + transaction_id + ".json", "fuse",
				"oobo9gxI3Tx2Ycm3mZjAJcYXOsh5V2IBvoZQkONg1vk");
	}

	@ApiOperation(value = "测试接口", notes = "测试")
	@RequestMapping(value = { "/getString" }, method = { RequestMethod.GET })
	public String TestApi() {
		return "hello world!";
	}
}
