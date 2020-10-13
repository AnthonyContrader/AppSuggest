package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.AppDTO;
import it.contrader.service.Service;
import it.contrader.service.AppService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<AppDTO> service = new AppService();
		List<AppDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<AppDTO> service = new AppService();
		String mode = request.getParameter("mode");
		AppDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "APPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/app/appmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/app/readapp.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/app/updateapp.jsp").forward(request, response);
			
			break;
/*
		case "INSERT":
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			dto = new AppDTO (username,password,usertype);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new AppDTO (id,username, password, usertype);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break; */
		}
	}
}