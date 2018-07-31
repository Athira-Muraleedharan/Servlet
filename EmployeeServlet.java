package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("emp_name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		String grade=request.getParameter("grade");
		double bonus=0.0;
		if(salary>100000 && grade.equals("A"))
			bonus=salary*0.05;
		else if(salary<=100000 && salary>=50000 && grade.equals("B"))
			bonus=salary*0.07;
		else if(salary<50000 && grade.equals("C"))
			bonus=salary*0.20;
		
		double tax=salary*0.25;
		
		double net_salary=salary+bonus-tax;
		
		PrintWriter pw=response.getWriter();
		
		//pw.println("Employee Name:"+name+"<BR>");
		//pw.println("Basic Salary :"+salary+"<BR>");
		//pw.println("Bonus        :"+bonus+"<BR>");
		//pw.println("Tax          :"+tax+"<BR>");
		//pw.println("Net Salary   :"+net_salary+"<BR>");
		
		String str="<table border=1>"+"<tr><th>Name</th>"+"<th>Salary</th>"+"<th>Bonus</th>"+"<th>Grade</th>"+"<th>Tax</th>"+"<th>Net Salary</th>"+"</TR>";
		
		String str2="<tr>"+"<td>"+name+"</td>"+
				"<td>"+salary+"</td>"+
				"<td>"+bonus+"</td>"+
				"<td>"+grade+"</td>"+
				"<td>"+tax+"</td>"+
				"<td>"+net_salary+"</td>"+
				"</tr"+"/table>";
		
		pw.print(str+str2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
