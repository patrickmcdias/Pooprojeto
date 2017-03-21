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
 * @author Patrick Muller e Neudson JosÃ©
 */

/**
 * Classe com o nome ColecaoVendas na qual coloca objetos do tipo Vendas em um
 * ArrayList
 */
public class ColecaoVendas {

	private ArrayList<Vendas> Vend;

	/**
	 * Método que instÃ¢ncia o atributo Vend como ArrayList
	 */
	public ColecaoVendas() {
		Vend = new ArrayList<Vendas>();
	}

	/**
	 * 
	 * Método que adiciona objetos do tipo Vendas no ArrayList Vend
	 * Recebe como parâmetro um objeto do tipo Vendas e adiciona dentro do arraylist
	 * */
	public void adicionarVenda(Vendas ve) {
		this.Vend.add(ve);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Vend pelo atributo CPF do
	 * do objeto Cliente. 
	 * No fim de sua execução informa quantas compras esse cliente possui.
	 * @param cpf
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
			System.out.println("O cliente nÃ£o fez nenhuma compra");
		}
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Vend pelo atributo
	 * Matricula do objeto Vendedor.
	 * Ao fim da execução informa quantas vendas o vendedor realizou.
	 * @param matri
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
			System.out.println("O vendedor não fez nenhuma venda");
		}
	}

	/**
	 * 
	 * Método que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo Matricula do objeto Vendedor. Ao fim da execução,
	 * o arraylist fica decrementado do objeto compatível.
	 * @param num 
	 * @param vend
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
			System.out.println("NÃ£o foi feita essa venda");
		}

	}

	/**
	 * 
	 * Método que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo CPF do objeto Cliente. Ao fim da execução,
	 * o arraylist fica decrementado do objeto compatível.
	 * @param num
	 * @param clien
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
			System.out.println("NÃ£o foi feita essa compra");
		}

	}

	/**
	 * 
	 * Método que salva o ArrayList Vend em um arquivo
	 * Pega o arraylist da coleção, e salva em um arquivo .dat
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
	 * Através do arquivo .dat obtem-se o arraylist correspondente ao 
	 * arquivo da coleção. Ao fim da execução retorna um arraylist,
	 * do tipo Funcionário.
	 * @return Vend
	 */
	public ArrayList<Vendas> carregarDados() {
		Vend = new ArrayList();
		try {
			FileInputStream in = new FileInputStream("vendas.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			Vend =(ArrayList) objIn.readObject();
			objIn.close();
	
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
