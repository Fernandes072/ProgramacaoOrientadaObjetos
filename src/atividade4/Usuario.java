package atividade4;

public class Usuario {

	private String nome;
	private String nomeUsuario;
	private String senha;

	public Usuario(String nome, String nomeUsuario, String senha) {
		setNome(nome);
		setNomeUsuario(nomeUsuario);
		setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		if (nome.length() == 0) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		this.nome = nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	private void setNomeUsuario(String nomeUsuario) {
		if (nomeUsuario.length() == 0) {
			throw new IllegalArgumentException("Nome de usuário não pode ser vazio!");
		}
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		if (senha.length() == 0) {
			throw new IllegalArgumentException("Senha não pode ser vazia!");
		}
		this.senha = senha;
	}
	
	public void login(String senha) {
		if (!senha.equals(this.senha)) {
			throw new RuntimeException("Senha incorreta!");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Usuario) {
			if (this.nomeUsuario == ((Usuario) obj).getNomeUsuario()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " | Usuário: " + nomeUsuario;
	}

}
