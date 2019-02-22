package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import beans.Produto;
import dao.DaoProduto;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdutoServlet() {
		super();
	}

	public void atualizaTela(HttpServletRequest request, HttpServletResponse response, DaoProduto dao)
			throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("/produtos.jsp");
		request.setAttribute("lista", dao.list());
		r.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoProduto dao = new DaoProduto();
		String acao = request.getParameter("acao");
		String id = !(request.getParameter("id") == null) ? request.getParameter("id") : "0";

		if (acao.equalsIgnoreCase("excluir")) {
			dao.remove(Long.parseLong(id));
			request.setAttribute("sucesso", "Registro excluído");
			atualizaTela(request, response, dao);
		} else if (acao.equalsIgnoreCase("editar")) {

			Produto produto = dao.findById(Long.parseLong(id));

			RequestDispatcher r = request.getRequestDispatcher("/produtos.jsp");
			request.setAttribute("produto", produto);
			r.forward(request, response);
		} else if (acao.equalsIgnoreCase("listAllProdutos")) {
			atualizaTela(request, response, dao);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Produto produto = new Produto();
		DaoProduto dao = new DaoProduto();

		try {
			String id = request.getParameter("id");

			produto.setId(!id.isEmpty() ? Long.parseLong(id) : 0L);
			produto.setNome(request.getParameter("nome"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

			DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
			Double d = f.parse(request.getParameter("valor")).doubleValue();
			
			produto.setValor(d.doubleValue());
			
			
			if (id == null || id.isEmpty() || id.equals("0")) {

				if (!dao.hasProduto(produto.getNome())) {

					dao.save(produto);
					request.setAttribute("sucesso", "Inserido com sucesso");
					atualizaTela(request, response, dao);

				} else {
					request.setAttribute("erro", "Produto já existe na base de dados!");
					request.setAttribute("produto", produto);
					atualizaTela(request, response, dao);
				}

			}

			else {

				if (!dao.hasProdutoUpdate(produto.getNome(), produto.getId())) {

					dao.update(produto);
					request.setAttribute("sucesso", "Atualizado com sucesso");
					atualizaTela(request, response, dao);

				} else {
					request.setAttribute("erro", "Produto já existe na base de dados!");
					request.setAttribute("produto", produto);
					atualizaTela(request, response, dao);
				}

			}

		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			System.out.println(ExceptionUtils.getStackTrace(e));
			atualizaTela(request, response, dao);
		}

	}
	
	
	public static void main(String[] args) {
		
		DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
		
		String valor = "2,00";
		
		try {
			
			Double double1 = f.parse(valor).doubleValue();

			System.out.println(double1);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
