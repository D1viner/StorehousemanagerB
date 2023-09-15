package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.pojo.User;
import com.service.UserServiceImpl;
import com.service.IUserService;
import com.vo.ResultVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("application/json;charset=utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		User ur = userService.login(username, password,role);
		
		PrintWriter pw = resp.getWriter();
		if(ur!=null) 
		{
			pw.print(JSON.toJSONString(ResultVO.success(ur)));
		}
		else
		{	
			pw.print(JSON.toJSONString(ResultVO.fail(1, "µÇÂ½Ê§°Ü")));
		}
	}
	
}


// {
//   "code":0,
//   "message":"Ö´ÐÐ³É¹¦",
//   "data":
// }