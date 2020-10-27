package it.contrader.controller;

import it.contrader.dto.AppDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Apptype;
import it.contrader.service.AppService;
import it.contrader.service.ApptypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class AppController  extends AbstractController<AppDTO>{

	@Autowired
	private AppService service;



	}
