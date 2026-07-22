package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	// Preço maior que X em ordem crescente (Asc)
    List<Produto> findByPrecoGreaterThanOrderByPrecoAsc(BigDecimal preco); //GreaterThan = Maior que

    // Preço menor que X em ordem decrescente (Desc)
    List<Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco); //LessThan = menor que
}
