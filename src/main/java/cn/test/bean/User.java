package cn.test.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("个人用户信息")
public class User {
	@ApiModelProperty(value="用户名",required=true)
	private String name;
	@ApiModelProperty(value="用户年龄",required=false)
	private Integer age;
	@ApiModelProperty(value="用户性别",required=false)
	private Integer sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
