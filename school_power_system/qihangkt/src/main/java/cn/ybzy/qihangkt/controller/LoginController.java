package cn.ybzy.qihangkt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ybzy.qihangkt.model.Resource;
import cn.ybzy.qihangkt.model.Role;
import cn.ybzy.qihangkt.model.User;
import cn.ybzy.qihangkt.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	/**
	 * 登录页面显示出来的方法
	 */
	@RequestMapping(value="/login.html",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login.html",method=RequestMethod.POST)
	public String loginPost(String userInfo,String password,HttpSession session) {
		//将参数转发到service层去判断登录成功否
		User user = userService.login(userInfo,password);
		session.setAttribute("loginUser", user);
		//判断一下登录成功的用户是不是超级管理员
		List<Role> loginUserRoles = user.getRoles(); //登录用户关联的角色信息
		boolean isadmin = false; //是：true，不是：false
		List<Resource> loginUserRes = null;
		List<String> loginUserPathes = new ArrayList<>();
		for(Role role:loginUserRoles) {
			if("admin".equals(role.getCode())) {
				isadmin = true;
				break; 
			}
			//不是超级管理员的情况下，我们要把登录成功的用户，关联的所有权限标记，取出来
			loginUserRes = role.getResources();
			for(Resource res:loginUserRes) {
				loginUserPathes.add(res.getPath()); //loginUserPathes:存放了当前登录用户所拥有的path路径
			}
		}
		session.setAttribute("isAdmin", isadmin);
		//循环完毕后，loginUserPathes：包括了登录成功的用户，所拥有的所有权限的标记
		session.setAttribute("loginUserAllPath", loginUserPathes);
		
		return "redirect:/admin/admin.html";
	}

}
