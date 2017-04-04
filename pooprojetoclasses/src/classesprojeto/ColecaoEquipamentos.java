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
	 * M�todo que instancia o atributo Equip como ArrayList
	 */
	public ColecaoEquipamentos() {
		Equip = new ArrayList<Equipamentos>();
	}

	/**
	 * 
	 * M�todo que adiciona objetos da interface Equipamento no ArrayList Equip
	 * Recebe como par�metro um objeto do tipo Equipamentos.
	 * @param eq
	 * */
	public void adicionarEquipamento(Equipamentos eq) {
		this.Equip.add(eq);
	}

	/**
	 * 
	 * M�todo que faz a pesquisa dentro do ArrayList Equip.
	 * Recebe a String NumSerie correspondente ao n�mero de s�rie, compara,
	 * e se encontra algum objeto correspondente exibe ele na tela.
	 * @param n
	 */
	public Equipamentos pesquisarPeloNumSerie(String n) {
		int k = 0;
		Equipamentos y=null;
		for (Equipamentos eq : Equip) {
			if (eq.getNumSerie().equals(n)) {
				System.out.println( eq.toString());
				k++;
				y=eq;
			}
		}
		if (k == 0) {
			System.out
					.println("Não temos equipamento com esse número de série em estoque");
		}
		return y;
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Equip pelo atributo Modelo
	 * Compara e conta quantos elementos daquele modelo existe. No final da 
	 * execução exibe a quantidade de modelos correspondente ao parâmetro passado.
	 * @param mod
	 */
	public void pesquisarPeloModelo(String mod) {
		int k = 0;
		for (Equipamentos eq : Equip) {
			if (eq.getModelo().equals(mod)) {
				System.out.println( eq.toString());
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
	 * Método que remove do ArrayList Equip pelo atributo NumSerie.
	 * Recebe o número de série que deseja remover do arraylist, e remove do array.
	 * @param n
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
	 * Método que remove do ArrayList Equip pelo atributo Modelo.
	 * Recebe o modelo do equipamento como parâmetro e remove do arraylist.
	 * @param m
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
	 * Método que salva o ArrayList Equip em um arquivo.
	 * Pega o arraylist da coleção, e salva em um arquivo .dat
	 */
	public int salvarDados(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipamentos.dat"));
            out.writeObject(Equip);
            out.close();
            return 0;
        }catch(IOException e){
            return -1;
	}
}

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Equip.
	 * Através do arquivo .dat obtem-se o arraylist correspondente ao 
	 * arquivo da coleção. Ao fim da execução retorna um arraylist,
	 * do tipo Equipamentos.
	 * @return Equip
	 */
	public ArrayList<Equipamentos> carregarDados() {
		Equip = new ArrayList();
		try {
			FileInputStream in = new FileInputStream("equipamentos.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);	
			Equip =(ArrayList) objIn.readObject();
			objIn.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Equip;
	}

}
