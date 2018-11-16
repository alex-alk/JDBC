package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaaaaaaa");
		request.setAttribute("obiectDAO", new ObiectDAO());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(id!=null) {
			ObiectDAO.deleteObiect(id);
		}
		request.setAttribute("obiectDAO", new ObiectDAO());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
