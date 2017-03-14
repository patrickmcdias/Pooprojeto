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
 * 
 */
public class ColecaoEquipamentos  {

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
	public int salvarDados(ArrayList Equipamentos ){
        try{
            
            FileOutputStream arquivo = new FileOutputStream("equipamentos.dat"); 
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(Equipamentos);
            out.close();
            return 0;
        }catch(Exception ex){
            return -1;
            
        }
    }
	 public ArrayList <Equipamentos> carregarDados() {
		 Equip = new ArrayList<Equipamentos>();
		 try {
		 	FileInputStream in= new FileInputStream ("equipamentos.dat");
		 	ObjectInputStream objIn = new ObjectInputStream(in);
		 	while (true) {
		 	Equipamentos e = (Equipamentos) objIn.readObject();	
		 	Equip.add(e);
		 	objIn.close();
		 	}
		 }
		 catch (FileNotFoundException e){
			 e.printStackTrace();
		 }
		 catch (IOException e){
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return Equip;
	 }

}
