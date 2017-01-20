package cn.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.test.bean.User;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 因为Jackson-core和Jackson-databind中的版本不一致会导致某种方法找不到，
 * @author John
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/item")
	@ResponseBody 
	@ApiOperation(value = "根据用户名获取用户对象1212value", httpMethod = "GET", response = User.class, notes = "根据用户名获取用户对象notes")
	public User item(@RequestParam(required=false) @ApiParam(value="需要查询的用户名字",allowableValues="zhangsan,lisi") String name){
		/**
		 * 因为ItemsQueryVo也是Page的之类，而这里测试，并没有设置当前页数和数量，error
		 */
		ItemsQueryVo vo = new ItemsQueryVo();
		Items items = new Items();
		items.setName(name);
		vo.setItems(items);
		List<ItemsCustom> list = null;
		try {
//			list = itemsService.findItemsList(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = new User();
		user.setAge(12);
		user.setName("aa");
		user.setSex(1);
		return user;
	}
	
	@RequestMapping("/itemList")
	@ResponseBody
	@ApiOperation(httpMethod="GET",response=ItemsCustom.class,notes="分页获取商品列表",value="分页获取商品列表")
	public  List<ItemsCustom> itemList(@RequestParam(required=false) @ApiParam(value="商品名称") String name,@RequestParam(required=false) @ApiParam("第几页")Integer page){
		ItemsQueryVo vo = new ItemsQueryVo();
		Items items = new Items();
		items.setName(name);
		vo.setItems(items);
		vo.setRows(2);
		vo.setPage(page);
		List<ItemsCustom> list = null;
		try {
			list = itemsService.findItemsListPage(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
