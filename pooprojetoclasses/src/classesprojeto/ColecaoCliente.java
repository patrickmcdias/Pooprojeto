package classesprojeto;
import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

/**
 * 
 * @author Patrick Muller e Neudson José
 * 
 */
/**
 * Classe com o nome ColecaoCliente na qual coloca o objeto Cliente em um
 * ArrayList
 * 
 */

public class ColecaoCliente {
	private ArrayList<Cliente> Clien;

	/**
	 * Método que instância o atributo Clien como ArrayList
	 */
	public ColecaoCliente() {
		Clien = new ArrayList<Cliente>();
	}

	/**
	 * 
	 * Método que adiciona o objeto Cliente no ArrayList Clien
	 * */
	public void adicionarCliente(Cliente cl) {
		this.Clien.add(cl);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Clien pelo atributo CPF do
	 * objeto Cliente
	 */
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

	/**
	 * 
	 * Método que remove do ArrayList Clien pelo atributo CPF do objeto Cliente
	 */

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

	/**
	 * 
	 * Método que que salva o ArrayList Clien do objeto Cliente em um arquivo
	 */

	public int salvarDados(ArrayList Cliente) {
		try {

			FileOutputStream arquivo = new FileOutputStream("cliente.dat");
			ObjectOutputStream out = new ObjectOutputStream(arquivo);
			out.writeObject(Cliente);
			out.close();
			return 0;
		} catch (Exception ex) {
			return -1;

		}
	}

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Clien do objeto Cliente
	 */

	public ArrayList<Cliente> carregarDados() {
		Clien = new ArrayList<Cliente>();
		try {
			FileInputStream in = new FileInputStream("cliente.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			while (true) {
				Cliente c = (Cliente) objIn.readObject();
				Clien.add(c);
				objIn.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Clien;
	}
}
