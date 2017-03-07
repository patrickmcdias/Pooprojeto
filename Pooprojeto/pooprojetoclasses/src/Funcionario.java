public class Funcionario {

	private String nome;
	private String matricula;
	private Double SalarioBase;

	public Funcionario(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		SalarioBase = 1500.00;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}

	public String toString() {
		return "Funcionario [Nome=" + nome + ", Matricula=" + matricula + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (SalarioBase == null) {
			if (other.SalarioBase != null)
				return false;
		} else if (!SalarioBase.equals(other.SalarioBase))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
