package springboot.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class indexController {
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init() {
		return new ResponseEntity("Olá Usuário IndexController, Deu certo aqui!", HttpStatus.OK);
	}
}