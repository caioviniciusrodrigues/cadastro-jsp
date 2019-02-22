package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.DaoUsuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsuarioServlet() {
	
	}

	public void atualizaTela(HttpServletRequest request, HttpServletResponse response, DaoUsuario dao)
			throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/usuarios.jsp");
		request.setAttribute("lista", dao.listar());
		r.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String id = !(request.getParameter("id") == null) ? request.getParameter("id") : "0";

		DaoUsuario dao = new DaoUsuario();

		if (acao.equalsIgnoreCase("excluir")) {
			dao.remove(Long.parseLong(id));
			request.setAttribute("sucesso", "Registro excluído");
			atualizaTela(request, response, dao);
		} 
		else if (acao.equalsIgnoreCase("editar")) {

			Usuario user = dao.buscar(Long.parseLong(id));

			RequestDispatcher r = request.getRequestDispatcher("/usuarios.jsp");
			request.setAttribute("user", user);
			r.forward(request, response);
		}
		else if (acao.equalsIgnoreCase("listAllUsers")) {
			atualizaTela(request, response, dao);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		Usuario user = new Usuario();
		DaoUsuario dao = new DaoUsuario();

		try {
			String id = request.getParameter("id");

			user.setId(!id.isEmpty() ? Long.parseLong(id) : 0L);
			user.setName(request.getParameter("name"));
			user.setLogin(request.getParameter("login"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setStatus(request.getParameter("status"));
			user.setFone(request.getParameter("fone"));

			if (id == null || id.isEmpty() || id.equals("0")) {  
								
				if(!dao.hasLogin(user.getLogin(), user.getEmail())) { 
					
					dao.save(user);
					request.setAttribute("sucesso", "Inserido com sucesso");					
					atualizaTela(request, response, dao);
															
				} else {
					request.setAttribute("erro", "Usuário ou e-mail já existem na base de dados!");		
					request.setAttribute("user", user);
					atualizaTela(request, response, dao);
				} 
			
			} 
			
			else {
				
				if(!dao.hasLoginUpdate(user.getLogin(), user.getEmail(), user.getId())) { 
					
					dao.update(user);
					request.setAttribute("sucesso", "Atualizado com sucesso");
					atualizaTela(request, response, dao);
															
				} else {
					request.setAttribute("erro", "Usuário ou e-mail já existem na base de dados!");
					request.setAttribute("user", user);
					atualizaTela(request, response, dao);
				}
				
			}
			
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			atualizaTela(request, response, dao);
		}

	}

}
