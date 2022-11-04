package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import exception.ResourceNotFoundException;
import model.Produto;


@Repository
public class ProdutoRepository_old {
	

	private List<Produto> produtos= new ArrayList<Produto>();
	private Integer ultimoId = 0;
	
	
	// Metodo para retornar uma lista de produtos.
	
	public List<Produto> obterTodos(){
		return produtos;
	}
	
	
	// Metodo que retorna o produto encontrado pelo seu Id.
	
	public Optional<Produto> obterPorId(Integer id) {
		return produtos.stream().filter(produto -> produto.getId()== id).findFirst();
	}
	
	// Metodo para adicionar produto na lista. 
	
	public Produto adicionar (Produto produto) {
		ultimoId ++;
		produto.setId(ultimoId);
		produtos.add(produto);
		return produto;
	}
	
	// Metodo para deletar o produto por id.
	
	public void deletar(Integer id) {
		produtos.removeIf(produto -> produto.getId() == id);
	}
	
	//Metodo para atualizar o produto na lista.
	
	public Produto atualizar (Produto produto) {
		
		// Encontra o produto na lista.
		Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
		
		if(produtoEncontrado.isEmpty()) {
			throw new ResourceNotFoundException("Produto não encontrado");
		}
		
		// Remover o produto antigo da lista.
		deletar(produto.getId());
		
		// adicionar o produto atualizado na lista. 
		produtos.add(produto);
		
		return produto;
	}
}
