package tests;

import beans.Produto;
import beans.Usuario;
import dao.DaoProduto;
import dao.DaoUsuario;

public class conexao {

	public static void main(String[] args) {

		Usuario user = new Usuario();

		try {
			user.setId(2L);
			user.setName("Alex");
			user.setLogin("Alex");
			user.setEmail("alex@gmail.com");
			user.setStatus("Ativo");
			user.setPassword("123456");
		} catch (Exception e) {

		}
		//DaoUsuario dao = new DaoUsuario();

		// dao.save(user);

		//System.out.println(dao.hasLogin("3", "rodrigues.caio1985@gmail.cfom"));

		// System.out.println(dao.listar());

		// System.out.println(dao.buscar(2L));

		// System.out.println(dao.listar());
		
		Produto produto = new Produto();
		DaoProduto dao = new DaoProduto();
		try {
			produto.setNome("Macarrão");
			produto.setQuantidade(2);
			produto.setValor(23.00);
			produto.setId(1L);
			
			//dao.save(produto);
			//dao.update(produto);
			//dao.remove(2L);
			
			//System.out.println(dao.list());
			//System.out.println(dao.findById(1L));
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
		
	}
}
