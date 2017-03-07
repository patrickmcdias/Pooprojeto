import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Patrick Muller e Neudson José
 * 
 */
public class ColecaoEquipamentos {

	private ArrayList<Equipamentos> Equip;

	public ColecaoEquipamentos() {
		Equip = new ArrayList<Equipamentos>();
	}

	public void adicionarEquipamento(Equipamentos eq) {
		this.Equip.add(eq);
	}

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

}
