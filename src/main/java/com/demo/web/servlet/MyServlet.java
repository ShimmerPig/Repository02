package com.demo.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/my/servlet",asyncSupported=true)
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AsyncContext asyncContext=req.startAsync();
		asyncContext.start(()->{
			try {
				resp.getWriter().println("hello pig");
				asyncContext.complete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
