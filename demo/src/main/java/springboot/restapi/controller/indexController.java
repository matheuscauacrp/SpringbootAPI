package springboot.restapi.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.restapi.model.Usuario;
import springboot.restapi.repository.UsuarioRepository;

@RestController /* Arquiterura REST */
@RequestMapping(value = "/usuario")
public class indexController {
	
	
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	/* SERVIÇO RESTFUL */
	
	/* Geraria um relatório em pdf*/
	
	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "id") Long id ,@PathVariable(value = "venda") Long venda) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		/* O retorno seria um relatório */
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	
	
	/* Consulta por ID */
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	
	
	/*Consulta TODOS no banco*/
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario(){
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		
	}
	
	/*Salvando no banco de dados*/
	@PostMapping(value = "/cadastro", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	@PutMapping(value = "/atualizar", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/deletar/{id}", produces="application/json")
	public String deletar(@PathVariable(value = "id") Long id) {
		usuarioRepository.deleteById(id);
		
		return "Ok";
	}
}