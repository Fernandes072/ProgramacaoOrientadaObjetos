package atividade4;

import java.util.ArrayList;
import java.util.List;

public class ControleUsuario {
	
	private List<Usuario> usuarios;

	public ControleUsuario() {
		usuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		if (usuarios.contains(usuario)) {
			throw new RuntimeException("Usuário já existe!");
		}
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String nomeUsuario) {
		int posicao = usuarios.indexOf(new Usuario(nomeUsuario));
		if (posicao == -1) {
			throw new RuntimeException("Usuário não existe!");
		}
		return usuarios.get(posicao);
	}
	
	public boolean login(String nomeUsuario, String senha) {
		int posicao = usuarios.indexOf(new Usuario(nomeUsuario));
		if (posicao == -1) {
			throw new RuntimeException("Usuário/Senha incorreto!");
		}
		if (!usuarios.get(posicao).getSenha().equals(senha)) {
			throw new RuntimeException("Usuário/Senha incorreto!");
		}
		return true;
	}
}
