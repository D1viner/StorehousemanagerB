package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dao.*;
import com.pojo.*;
import com.service.*;
import com.utils.*;
import com.vo.ResultVO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	IUserService service = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=utf8");

		// 1. 获取参数
		String jsonStr = CommonUtils.getRequstBody(req);
		User ur = JSON.parseObject(jsonStr, User.class);

		// 2. 调用下层
		boolean result = service.register(ur);

		PrintWriter pw = resp.getWriter();
		// pw.print("{\"result\":"+result+"}");
		pw.print(JSON.toJSONString(ResultVO.success(result)));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=utf8");
		// 1.
		// delete http://locahost:9080/demo3/student/23

		String usernameStr = req.getPathInfo();
		String username = usernameStr.substring(1);

		// 2.
		boolean result = service.removeByUsername(username);

		PrintWriter pw = resp.getWriter();
		// pw.print("{\"result\":"+result+"}");
		pw.print(JSON.toJSONString(ResultVO.success(result)));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf8");
		// 1. 获取参数
		String jsonStr = CommonUtils.getRequstBody(req);
		User ur = JSON.parseObject(jsonStr, User.class);

		// 2. 调用下层
		boolean result = service.modify(ur);

		// 3. 显示数据
		PrintWriter pw = resp.getWriter();
		// pw.print("{\"result\":"+result+"}");

		pw.print(JSON.toJSONString(ResultVO.success(result)));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=utf8");
		PrintWriter pw = resp.getWriter();
		String usernameStr = req.getPathInfo();
		String username = usernameStr.substring(1);
		if (username.length() > 1) {
			// 查询单个
			username = username.substring(1);

			// 2.
			User ur = service.queryByUsername(username);

			// 3.
			pw.print(JSON.toJSONString(ur));
		} else {
			// 查询所有
			List<User> urs = service.queryAll();

			// 3.
			pw.print(JSON.toJSONString(ResultVO.success(urs)));
		}

	}
}
