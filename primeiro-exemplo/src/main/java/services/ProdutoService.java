package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Produto;
import repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired            //-> fornece controle sobre onde e como a ligação entre os beans deve ser realizada / para marcar os pontos de injeção dentro da sua classe.
	private ProdutoRepository produtoRepository;
    
    // Metodo para retornar uma lista de produtos.
    
    public List<Produto> obterTodos(){
    	return produtoRepository.obterTodos();
    }
    
    // Metodo que retorna o produto encontrado pelo seu Id.
    
    public Optional<Produto> obeterPorId(Integer id){
    	return produtoRepository.obterPorId(id);
    }
    
    // Metodo para adicionar o produto na lista .
    
    public Produto adicionar(Produto produto) {
    	return produtoRepository.adicionar(produto);
    }
    
    // Metodod para deletar o produto por Id.
    
    public void deletar(Integer id) {  
    	produtoRepository.deletar(id);
    }
    
    // Metodo para atualizar o produto na lista.
    
    public Produto atualizar(Integer id ,Produto produto) {
    	produto.setId(id);
    	return produtoRepository.atualizar(produto);
    }
}


