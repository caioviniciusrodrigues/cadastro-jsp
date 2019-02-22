package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns= {"/*"}) 
public class FilterConnection implements javax.servlet.Filter {

	private static Connection connection;
	
	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterch)
			throws IOException, ServletException {
		
		try {
						
			connection.commit();
			filterch.doFilter(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection = SingleConnection.getConection();
		
	}

}
