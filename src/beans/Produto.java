package beans;

import exception.EmptyFieldException;

public class Produto {

	private Long id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	
	public Produto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws EmptyFieldException {		
		if(nome == null || nome.isEmpty())
			throw new EmptyFieldException("Nome");
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) throws EmptyFieldException  {
		if(quantidade == null || quantidade == 0)
			throw new EmptyFieldException("Quantidade");
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) throws EmptyFieldException { 		
		if(valor == null || valor.isNaN())
			throw new EmptyFieldException("Valor");
		this.valor = valor;
	}

		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
	
	
	
}
