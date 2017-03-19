/**
 * 
 * @author Patrick Muller e Neudson José
 */
/**
 * Classe na qual tem o nome Gerente que vai herdar da Classe pai Funcionario
 * 
 */
public class Gerente extends Funcionario {

	private Double salario;

	public Gerente(String nome, String matricula, Double salario) {
		super(nome, matricula);
		this.salario = super.getSalarioBase() * 3;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String toString() {
		return "Gerente [Salario=" + salario + " Nome: " + super.getNome()
				+ " Matricula: " + super.getMatricula() + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gerente other = (Gerente) obj;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

}
