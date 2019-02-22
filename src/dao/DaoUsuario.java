package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConection();
	}

	public void save(Usuario user) {

		String sql = "insert into usuario (name, login, email, password, status, fone) values (?,?,?,?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getLogin());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getStatus());
			statement.setString(6, user.getFone());

			statement.execute();

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				e.printStackTrace();
				connection.rollback();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public boolean validarLogin(String login, String password) {

		String sql = "select * from usuario where login = '" + login + "' and password = '" + password + "'";

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

	public boolean hasLogin(String login, String email) {

		String sql = "select * from usuario where login = '" + login + "' or email = '" + email + "'";

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

	
	public boolean hasLoginUpdate(String login, String email, Long id) {

		String sql = "select * from usuario where (login = '" + login + "' or email = '" + email + "') and id <> " + id;

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

	
	public Usuario buscar(Long id) {

		String sql = "select * from usuario where id = " + id;

		Usuario user = null;

		try {

			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				user.setFone(rs.getString("fone"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public void update(Usuario user) {

		String sql = "update usuario set name = ?, login = ?,  email = ?, status = ?, password = ?, fone = ?  WHERE id = ?";

		try {

			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user.getName());
			st.setString(2, user.getLogin());
			st.setString(3, user.getEmail());
			st.setString(4, user.getStatus());
			st.setString(5, user.getPassword());
			st.setString(6, user.getFone());
			st.setLong(7, user.getId());
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

		String sql = "delete from usuario where id = " + id;

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();

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

	public List<Usuario> listar() {

		List<Usuario> list = new ArrayList<Usuario>();

		String sql = "select * from usuario";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Usuario user = new Usuario();

				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				user.setFone(rs.getString("fone"));

				list.add(user);

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ArrayList<>();
		}

		return list;
	}

}
