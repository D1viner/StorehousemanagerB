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
import com.pojo.Admin;
import com.service.AdminServiceImpl;
import com.service.IAdminServcie;
import com.vo.ResultVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	IAdminServcie adminService = new AdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("application/json;charset=utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Admin a = adminService.login(username, password);
		
		PrintWriter pw = resp.getWriter();
		if(a!=null) 
		{
			pw.print(JSON.toJSONString(ResultVO.success(a)));
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