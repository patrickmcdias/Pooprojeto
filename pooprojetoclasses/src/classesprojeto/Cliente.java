package classesprojeto;

import java.io.*;

/**
 * 
 * @author Patrick Muller e Neudson José
 *
 */
/**
 * Classe com o nome Cliente na qual irá ser utilizada para o cadastro de vários
 * clientes na ColecaoCliente
 */

public class Cliente implements Serializable {

	private String nome;
	private String CPF;

	public Cliente(String nome, String cPF) {
		this.nome = nome;
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String toString() {
		return "Cliente [Nome=" + nome + ", CPF=" + CPF + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
