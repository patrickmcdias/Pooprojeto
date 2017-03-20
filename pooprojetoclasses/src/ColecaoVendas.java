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
 * Classe com o nome ColecaoVendas na qual coloca objetos do tipo Vendas em um
 * ArrayList
 */
public class ColecaoVendas {

	private ArrayList<Vendas> Vend;

	/**
	 * Método que instância o atributo Vend como ArrayList
	 */
	public ColecaoVendas() {
		Vend = new ArrayList<Vendas>();
	}

	/**
	 * 
	 * Método que adiciona objetos do tipo Vendas no ArrayList Vend
	 * */
	public void adicionarVenda(Vendas ve) {
		this.Vend.add(ve);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Vend pelo atributo CPF do
	 * do objeto Cliente
	 */
	public void pesquisarCompraDoCliente(String cpf) {
		int k = 0;
		for (Vendas ve : Vend) {
			if (ve.getClient().getCPF().equals(cpf)) {
				System.out.println("Compra(s) " + ve.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out.println("O cliente não fez nenhuma compra");
		}
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Vend pelo atributo
	 * Matricula do objeto Vendedor
	 */

	public void pesquisarVendaDoVendedor(String matri) {
		int k = 0;
		for (Vendas ve : Vend) {
			if (ve.getVend().getMatricula().equals(matri)) {
				System.out.println("Venda(s) " + ve.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out.println("O cliente não fez nenhuma compra");
		}
	}

	/**
	 * 
	 * Método que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo Matricula do objeto Vendedor
	 */
	public void removerVenda(String num, Vendedor vend) {
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getNumserie())
					&& vend.equals(v.getVend().getMatricula())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não foi feita essa venda");
		}

	}

	/**
	 * 
	 * Método que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo CPF do objeto Cliente
	 */
	public void removerCompra(String num, Cliente clien) {
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getNumserie())
					&& clien.equals(v.getClient().getCPF())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não foi feita essa compra");
		}

	}

	/**
	 * 
	 * Método que salva o ArrayList Vend em um arquivo
	 */
	public int salvarDados(){
        try{
        	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vendas.dat"));
            out.writeObject(Vend);
            out.close();
            return 0;
        }catch(IOException e){
            return -1;
            
        }
    }

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Vend
	 */
	public ArrayList<Vendas> carregarDados() {
		Vend = new ArrayList<Vendas>();
		try {
			FileInputStream in = new FileInputStream("vendas.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			while (true) {
				Vendas v = (Vendas) objIn.readObject();
				Vend.add(v);
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
		return Vend;
	}

}
