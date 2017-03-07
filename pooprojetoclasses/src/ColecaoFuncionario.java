import java.util.ArrayList;
import java.util.Iterator;

public class ColecaoFuncionario {

	private ArrayList<Funcionario> Func;

	public ColecaoFuncionario() {
		Func = new ArrayList<Funcionario>();
	}

	public void adicionarFuncionario(Funcionario fu) {
		this.Func.add(fu);
	}

	public Funcionario pesquisarPelaMatricula(String n) {
		int k = 0;
		Funcionario funcio = null;
		for (Funcionario fu : Func) {
			if (fu.getMatricula().equals(n)) {
				System.out.println("Funcionário " + fu.toString());
				funcio = fu;
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos funcionário com essa matrícula");
		}
		return funcio;
	}

	public void removerPelaMatricula(String n) {
		int k = 0;
		Funcionario fu;
		for (Iterator<Funcionario> i = Func.iterator(); i.hasNext();) {
			fu = i.next();
			if (n.equals(fu.getMatricula())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos funcionário com essa matrícula");
		}

	}

}
