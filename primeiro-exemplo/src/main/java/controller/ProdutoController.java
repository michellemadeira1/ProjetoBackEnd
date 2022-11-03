package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Produto;
import services.ProdutoService;

@RestController                               //-> Responsável por controlar as requisições indicando quem deve receber as requisições para quem deve responde-las.
@RequestMapping("/produto")             // -> É usada para mapear URLs como www. DNS_da_aplicação/cliente para toda uma classe ou para um método manipulador particular.
public class ProdutoController {

	@Autowired                              // -> Fornece controle sobre onde e como a ligação entre os beans deve ser realizada / para marcar os pontos de injeção dentro da sua classe.
	private ProdutoService produtoService;
	
	@GetMapping                             //->  Uma notação composta que atua como um atalho para @RequestMapping (method = RequestMethod. GET).
	public List<Produto> obterTodos(){
		return produtoService.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterPorId(@PathVariable Integer id){
		return produtoService.obeterPorId(id);
	}
	
	@PostMapping
	public Produto adicionar( @RequestBody Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Integer id) {
		produtoService.deletar(id);
		return "Produto com id: " + id + "foi deletado com sucesso!";
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@RequestBody Produto produto,@PathVariable Integer id) {
		return produtoService.atualizar(id, produto);
	}
}
