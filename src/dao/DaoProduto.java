package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import connection.SingleConnection;

public class DaoProduto {

	private Connection connection;

	public DaoProduto() {
		connection = SingleConnection.getConection();
	}

	public void save(Produto produto) {

		String sql = "INSERT INTO produto(nome, quantidade, valor) VALUES (?, ?, ?);";

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, produto.getNome());
			st.setInt(2, produto.getQuantidade());
			st.setDouble(3, produto.getValor());
			st.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void update(Produto produto) {

		String sql = "update produto set nome = ?,  quantidade = ?, valor = ? where id = ?;";

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, produto.getNome());
			st.setInt(2, produto.getQuantidade());
			st.setDouble(3, produto.getValor());
			st.setLong(4, produto.getId());
			st.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void remove(Long id) {
		
		String sql = "delete from produto where id = " + id;

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			st.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public Produto findById(Long id) {
		
		Produto produto = null;
		
		String sql = "select * from produto where id = " + id;

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getDouble("valor"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return produto;
	}

	public List<Produto> list() {
		
		List<Produto> list = new ArrayList<Produto>();
		
		Produto produto = null;
		
		String sql = "select * from produto";

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				produto = new Produto();
				
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				
				list.add(produto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return list;
	}

	public boolean hasProduto(String nome) {

		String sql = "select * from produto where nome = '" + nome + "'";

		try {
			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean hasProdutoUpdate(String nome, Long id) {
		
		String sql = "select * from produto where nome = '" + nome + "' and id <> " + id;

		try {
			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
