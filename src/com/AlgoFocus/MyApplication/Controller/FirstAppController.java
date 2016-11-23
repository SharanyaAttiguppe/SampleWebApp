package com.AlgoFocus.MyApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AlgoFocus.MyApplication.Model.AppDAO;
import com.AlgoFocus.MyApplication.Model.DAOFactory;

public class FirstAppController extends HttpServlet

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter output = resp.getWriter();
		resp.setContentType("text/html");

		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String password = req.getParameter("password");

		AppDAO adao = DAOFactory.getDAOInstance();
		boolean result = adao.firstAppInsert(fname, mname, password);

		if (result == true) {

			output.print("Successfully created");
		} else {
			output.print("Unable to Create");
		}
	}
}
