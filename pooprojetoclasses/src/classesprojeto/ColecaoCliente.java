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
	 * Método que adiciona o objeto Cliente no ArrayList Clien Recebe como
	 * parâmetro um objeto do tipo Cliente
	 * 
	 * @param c1
	 * */
	public void adicionarCliente(Cliente cl) {
		this.Clien.add(cl);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Clien pelo atributo CPF do
	 * Objeto Cliente e retorna se existe ou não o cliente no arraylist.
	 * 
	 * @param n
	 */
	public Cliente pesquisarPeloCPF(String n) {
		int k = 0;
		Cliente cl = null;
		for (Cliente cli : Clien) {
			if (cli.getCPF().equals(n)) {
				System.out.println(cli.toString());
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
	 * Recebe uma string correspondente ao CPF compara e remove. Ao fim da
	 * execução a coleção esta decrementada do objeto correspondente.
	 * 
	 * @param n
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
	 * Método que que salva o ArrayList Clien do objeto Cliente em um arquivo.
	 * Pega o arraylist da coleção, e salva em um arquivo .dat
	 */

	public int salvarDados() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("cliente.dat"));
			out.writeObject(Clien);
			out.close();
			return 0;
		} catch (IOException e) {
			return -1;
		}
	}

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Clien do objeto Cliente.
	 * Através do arquivo .dat obtem-se o arraylist correspondente ao arquivo da
	 * coleção. Ao fim da execução retorna um arraylist, do tipo Equipamentos.
	 * 
	 * @return Clien
	 */

	public ArrayList<Cliente> carregarDados() {
		Clien = new ArrayList();
		try {
			FileInputStream in = new FileInputStream("cliente.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			Clien = (ArrayList) objIn.readObject();
			objIn.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Clien;
	}
}
