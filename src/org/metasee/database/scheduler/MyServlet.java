package org.metasee.database.scheduler;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;
public class MyServlet extends HttpServlet{
	@Override  
    public void init() throws ServletException {  
        // TODO Auto-generated method stub  
        super.init();
        MultipleThreadRun  multipleThreadRun = new  MultipleThreadRun();
        multipleThreadRun.start();
    }  
}
