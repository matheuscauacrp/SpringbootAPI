package springboot.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController/*Arquiterura REST*/
@RequestMapping(value = "/usuario")
public class indexController {
	/* SERVIÇO RESTFUL */
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init(@RequestParam (value = "nome") String nome) {
		System.out.println("Parametro " +nome);
		return new ResponseEntity("Olá Usuário: "+nome+" IndexController, Deu certo aqui!", HttpStatus.OK);
	}
}
