package it.contrader.controller;

import it.contrader.dto.AppDTO;
import it.contrader.dto.ApptypeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Apptype;
import it.contrader.service.AppService;
import it.contrader.service.ApptypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AppService service;
	@Autowired
	private ApptypeService apptypeservice;



	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {

		setAll(request);
		return "app";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "app";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {

		request.getSession().setAttribute("dto", service.read(id));
		return "updateapp";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("appname") String appname,
			@RequestParam("apptype") Apptype apptype) {

		AppDTO dto = new AppDTO();
		dto.setId(id);
		dto.setAppname(appname);
		dto.setApptype(apptype);
		service.update(dto);
		setAll(request);
		return "app";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("appname") String appname,
						 @RequestParam("apptype") Apptype apptype) {
		AppDTO dto = new AppDTO();
		dto.setAppname(appname);
		dto.setApptype(apptype);
		service.insert(dto);
		setAll(request);
		return "app";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		//request.getSession().setAttribute("list", service.findByApptype());
		return "readapp";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("tag", apptypeservice.findAll());
		//request.getSession().setAttribute("tag",apptypeservice.getAll());

	}

	}
