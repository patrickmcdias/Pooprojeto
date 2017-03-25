/**
 * 
 * @author Patrick Muller e Neudson José
 */
/**
 * Classe na qual tem o nome Vendedor que vai herdar da Classe pai Funcionario
 * 
 */
package classesprojeto;

public class Vendedor extends Funcionario {

	public Vendedor(String nome, String matricula) {
		super(nome, matricula);
	}

	public String toString() {
		return "Vendedor [Nome = " + getNome() + ", Matricula = "
				+ getMatricula() + ", Salario = " + getSalarioBase() + "]";
	}

}
