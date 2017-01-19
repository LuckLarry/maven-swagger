package cn.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.test.bean.User;

import com.sun.org.glassfish.gmbal.Description;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
public class ItemController {
	@RequestMapping("/item")
	@ApiOperation(value = "根据用户名获取用户对象1212value", httpMethod = "GET", response = User.class, notes = "根据用户名获取用户对象notes")
	public @ResponseBody User item(@RequestParam(required=false) @ApiParam(value="需要查询的用户名字",allowableValues="zhangsan,lisi") String name){
		User user = new User();
		user.setName("张三");
		user.setAge(12);
		user.setSex(1);
		return user;
	}
}
