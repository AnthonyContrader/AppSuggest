package it.contrader.controller;


import it.contrader.dto.ApptypeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ApptypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/apptype")
@CrossOrigin(origins = "http://localhost:4200")
public class ApptypeController  extends AbstractController<ApptypeDTO>{

	@Autowired
	private ApptypeService service;

}
