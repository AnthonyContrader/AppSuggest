package it.contrader.servlets;

import it.contrader.dto.ApptypeDTO;
import it.contrader.service.Service;
import it.contrader.service.ApptypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * Per dettagli vedi Guida sez Servlet
 * Verificato dal criceto
 * CRICETO APPROVED
 */
public class ApptypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApptypeServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ApptypeDTO> service = new ApptypeService();
		List<ApptypeDTO>listDTO = service.getAll();
		request.setAttribute("lista", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ApptypeDTO> service = new ApptypeService();
		String mode = request.getParameter("mode");
		ApptypeDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "APPTYPELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/apptype/apptypemanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/apptype/readapptype.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/apptype/updateapptype.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String tag = request.getParameter("tag").toString();
			dto = new ApptypeDTO (tag);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/apptype/apptypemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			tag = request.getParameter("tag");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ApptypeDTO (id,tag);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/apptype/apptypemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/apptype/apptypemanager.jsp").forward(request, response);
			break;
		}
	}
}