package cn.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.test.bean.User;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@Controller
public class ItemController {
	@RequestMapping("/item")
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = User.class, notes = "根据用户名获取用户对象")
	public @ResponseBody User item(@RequestParam String name){
		User user = new User();
		user.setName("张三");
		user.setAge(12);
		user.setSex(1);
		return user;
	}
}
