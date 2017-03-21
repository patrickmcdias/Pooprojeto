package classesprojeto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Patrick Muller e Neudson José 
 */

/**
 * Classe com o nome ColecaoEquipamentos na qual coloca objetos da interface
 * Equipamento em um ArrayList
 */
public class ColecaoEquipamentos {

	private ArrayList<Equipamentos> Equip;

	/**
	 * Método que instância o atributo Equip como ArrayList
	 */
	public ColecaoEquipamentos() {
		Equip = new ArrayList<Equipamentos>();
	}

	/**
	 * 
	 * Método que adiciona objetos da interface Equipamento no ArrayList Equip
	 * */
	public void adicionarEquipamento(Equipamentos eq) {
		this.Equip.add(eq);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Equip pelo atributo
	 * NumSerie
	 */
	public void pesquisarPeloNumSerie(String n) {
		int k = 0;
		for (Equipamentos eq : Equip) {
			if (eq.getNumSerie().equals(n)) {
				System.out.println("Equipamento: " + eq.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out
					.println("Não temos equipamento com esse número de série em estoque");
		}
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Equip pelo atributo Modelo
	 */
	public void pesquisarPeloModelo(String mod) {
		int k = 0;
		for (Equipamentos eq : Equip) {
			if (eq.getModelo().equals(mod)) {
				System.out.println("Equipamento: " + eq.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out
					.println("Não temos este modelo de equipamento em estoque");
		} else {
			System.out.println("Quantidade deste modelo " + mod
					+ "em estoque: " + k);
		}
	}

	/**
	 * 
	 * Método que remove do ArrayList Equip pelo atributo NumSerie
	 */
	public void removerPeloNumSerie(String n) {
		int k = 0;
		Equipamentos eq;
		for (Iterator<Equipamentos> i = Equip.iterator(); i.hasNext();) {
			eq = i.next();
			if (n.equals(eq.getNumSerie())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out
					.println("Não temos equipamento com esse número de série em estoque");
		}

	}

	/**
	 * 
	 * Método que remove do ArrayList Equip pelo atributo Modelo
	 */
	public void removerTodoModelo(String m) {
		int k = 0;
		Equipamentos eq;
		for (Iterator<Equipamentos> i = Equip.iterator(); i.hasNext();) {
			eq = i.next();
			if (m.equals(eq.getModelo())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos esse modelo em estoque");
		}

	}

	/**
	 * 
	 * Método que salva o ArrayList Equip em um arquivo
	 */
	public int salvarDados(ArrayList Equipamentos) {
		try {

			FileOutputStream arquivo = new FileOutputStream("equipamentos.dat");
			ObjectOutputStream out = new ObjectOutputStream(arquivo);
			out.writeObject(Equipamentos);
			out.close();
			return 0;
		} catch (Exception ex) {
			return -1;

		}
	}

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Equip
	 */
	public ArrayList<Equipamentos> carregarDados() {
		Equip = new ArrayList<Equipamentos>();
		try {
			FileInputStream in = new FileInputStream("equipamentos.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			while (true) {
				Equipamentos e = (Equipamentos) objIn.readObject();
				Equip.add(e);
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
		return Equip;
	}

}
