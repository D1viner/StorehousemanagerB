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



@WebServlet("/storehouse/*")
public class StorehouseServlet extends HttpServlet {
	IStorehouseService service = new StorehouseServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json;charset=utf8");
		
		// 1. 获取参数
		String jsonStr = CommonUtils.getRequstBody(req);
		Storehouse st = JSON.parseObject(jsonStr,Storehouse.class);
		
		// 2. 调用下层
		boolean result = service.add(st);
		
		PrintWriter pw = resp.getWriter();
//		pw.print("{\"result\":"+result+"}");
		pw.print(JSON.toJSONString(ResultVO.success(result)));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json;charset=utf8");
		// 1.
		// delete http://locahost:9080/demo3/student/23
		
		String noStr = req.getPathInfo();
		String no = noStr.substring(1);
		
		// 2.
		boolean result=service.removeByNo(no);
		
		PrintWriter pw = resp.getWriter();
//		pw.print("{\"result\":"+result+"}");
		pw.print(JSON.toJSONString(ResultVO.success(result)));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf8");
		// 1. 获取参数
		String jsonStr = CommonUtils.getRequstBody(req);
		Storehouse st = JSON.parseObject(jsonStr,Storehouse.class);
		
		// 2. 调用下层
		boolean result = service.modify(st);
		
		// 3. 显示数据
		PrintWriter pw = resp.getWriter();
//		pw.print("{\"result\":"+result+"}");
		
		pw.print(JSON.toJSONString(ResultVO.success(result)));	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=utf8");
		PrintWriter pw = resp.getWriter();
		String no = req.getPathInfo();
		if(no.length()>1)
		{
			// 查询单个
			no = no.substring(1);
			int id = Integer.parseInt(no);
			
			// 2.
			Storehouse st= service.queryByNo(no);
			
			// 3.
			pw.print(JSON.toJSONString(st));
		}
		else
		{
			// 查询所有
			List<Storehouse> sts= service.queryAll();
			
			// 3.
			pw.print(JSON.toJSONString(ResultVO.success(sts)));
		}
		
	}
}
