import java.util.ArrayList;
import java.util.Iterator;

public class ColecaoCliente {
	private ArrayList<Cliente> Clien;

	public ColecaoCliente() {
		Clien = new ArrayList<Cliente>();
	}

	public void adicionarCliente(Cliente cl) {
		this.Clien.add(cl);
	}

	public Cliente pesquisarPeloCPF(String n) {
		int k = 0;
		Cliente cl = null;
		for (Cliente cli : Clien) {
			if (cli.getCPF().equals(n)) {
				System.out.println("Cliente: " + cli.toString());
				cl = cli;
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos cliente com esse CPF");
		}
		return cl;
	}

	public void removerPeloCPF(String n) {
		int k = 0;
		Cliente clie;
		for (Iterator<Cliente> i = Clien.iterator(); i.hasNext();) {
			clie = i.next();
			if (n.equals(clie.getCPF())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos cliente com esse CPF");
		}

	}
}
