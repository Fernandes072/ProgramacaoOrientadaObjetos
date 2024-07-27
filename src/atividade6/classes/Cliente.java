package atividade6.classes;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String email;
	
	public Cliente(String cpf, String nome, String email) {
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
	}
	
	public Cliente(String cpf) {
		this(cpf, "nada", "nada");
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		if (cpf == null) {
			throw new NullPointerException("CPF não pode ser vazio!");
		}
		if (cpf.length() == 0) {
			throw new IllegalArgumentException("CPF não pode ser vazio!");
		}
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser vazio!");
		}
		if (nome.length() == 0) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		if (email == null) {
			throw new NullPointerException("Email não pode ser vazio!");
		}
		if (email.length() == 0) {
			throw new IllegalArgumentException("Email não pode ser vazio!");
		}
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Cliente) {
			return this.cpf.equals(((Cliente) obj).getCpf());
		}
		return false;
	}

	@Override
	public String toString() {
		return "CPF: " + cpf + " | Nome: " + nome + " | Email: " + email;
	}
	
	

}
