package it.contrader.controller;


import it.contrader.dto.ApptypeDTO;
import it.contrader.service.ApptypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/apptype")
public class ApptypeController {

	@Autowired
	private ApptypeService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "apptype";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "apptype";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateapptype";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("tag") String tag) {

		ApptypeDTO dto = new ApptypeDTO();
		dto.setId(id);
		dto.setTag(tag);
		service.update(dto);
		setAll(request);
		return "apptype";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tag") String tag) {
		ApptypeDTO dto = new ApptypeDTO();
		dto.setTag(tag);
		service.insert(dto);
		setAll(request);
		return "apptype";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readapptype";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
