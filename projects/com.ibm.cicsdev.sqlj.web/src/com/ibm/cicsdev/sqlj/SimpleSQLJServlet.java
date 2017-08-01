package com.ibm.cicsdev.sqlj;

/* Licensed Materials - Property of IBM                               */
/*                                                                    */
/* SAMPLE                                                             */
/*                                                                    */
/* (c) Copyright IBM Corp. 2017 All Rights Reserved                   */
/*                                                                    */
/* US Government Users Restricted Rights - Use, duplication or        */
/* disclosure restricted by GSA ADP Schedule Contract with IBM Corp   */
/*                                                                    */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleSQLJServlet
 */
@WebServlet("/SimpleSQLJServlet")
public class SimpleSQLJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String currentTimeStamp;
		try {
			DoSQLJ sqlj = new DoSQLJ();
			currentTimeStamp = sqlj.getCurrentTimestamp();
			out.println("SimpleSQLJServlet: DB2 CurrentTimeStamp = " + currentTimeStamp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
