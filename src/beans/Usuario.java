package beans;

import java.io.Serializable;

import exception.EmptyFieldException;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String login;
	private String email;
	private String password;
	private String status;
	private String fone;
	
	public Usuario() {
	
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws EmptyFieldException {
		
		if (name == null  || name.isEmpty())
			throw new EmptyFieldException("Nome");
		
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) throws EmptyFieldException {
				
		if (login == null  || login.isEmpty())
			throw new EmptyFieldException("Login");
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws EmptyFieldException {
		
		if (email == null  || email.isEmpty())
			throw new EmptyFieldException("E-mail");
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", login=" + login + ", email=" + email + ", password="
				+ password + ", status=" + status + "]";
	}
	
	
}
