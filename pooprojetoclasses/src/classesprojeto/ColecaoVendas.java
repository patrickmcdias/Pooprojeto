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
 * Classe com o nome ColecaoVendas na qual coloca objetos do tipo Vendas em um
 * ArrayList
 */
public class ColecaoVendas {

	private ArrayList<Vendas> Vend;

	/**
	 * M�todo que instância o atributo Vend como ArrayList
	 */
	public ColecaoVendas() {
		Vend = new ArrayList<Vendas>();
	}

	/**
	 * 
	 * M�todo que adiciona objetos do tipo Vendas no ArrayList Vend Recebe como
	 * par�metro um objeto do tipo Vendas e adiciona dentro do arraylist
	 * */
	public void adicionarVenda(Vendas ve) {
		this.Vend.add(ve);
	}

	/**
	 * 
	 * M�todo que faz a pesquisa dentro do ArrayList Vend pelo atributo CPF do
	 * do objeto Cliente. No fim de sua execu��o informa quantas compras esse
	 * cliente possui.
	 * 
	 * @param cpf
	 */
	public void pesquisarCompraDoCliente(String cpf, String num) {
		int k = 0;
		for (Vendas ve : Vend) {
			if (ve.getClient().getCPF().equals(cpf)
					&& ve.getEquip().getNumSerie().equals(num)) {
				System.out.println("Compra: " + ve.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out.println("O cliente não fez nenhuma compra");
		}
	}

	/**
	 * 
	 * M�todo que faz a pesquisa dentro do ArrayList Vend pelo atributo
	 * Matricula do objeto Vendedor. Ao fim da execu��o informa quantas vendas o
	 * vendedor realizou.
	 * 
	 * @param matri
	 */

	public void pesquisarVendaDoVendedor(String matri, String num) {
		int k = 0;
		for (Vendas ve : Vend) {
			if (ve.getVend().getMatricula().equals(matri)
					&& ve.getEquip().getNumSerie().equals(num)) {
				System.out.println(ve.toString());
				k++;
			}
		}
		if (k == 0) {
			System.out.println("O vendedor n�o fez nenhuma venda");
		}
	}

	/**
	 * 
	 * M�todo que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo Matricula do objeto Vendedor. Ao fim da
	 * execu��o, o arraylist fica decrementado do objeto compat�vel.
	 * 
	 * @param num
	 * @param vend
	 */
	public void removerVenda(String num, String ve) {
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getEquip().getNumSerie())
					&& ve.equals(v.getVend().getMatricula())) {
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
	 * M�todo que remove do ArrayList Vend pelo atributo NumSerie da interface
	 * Equipamento e pelo atributo CPF do objeto Cliente. Ao fim da execu��o, o
	 * arraylist fica decrementado do objeto compat�vel.
	 * 
	 * @param num
	 * @param clien
	 */
	public void removerCompra(String num, String cl) {
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getEquip().getNumSerie())
					&& cl.equals(v.getClient().getCPF())) {
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
	 * M�todo que salva o ArrayList Vend em um arquivo Pega o arraylist da
	 * cole��o, e salva em um arquivo .dat
	 */
	public int salvarDados() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("vendas.dat"));
			out.writeObject(Vend);
			out.close();
			return 0;
		} catch (IOException e) {
			return -1;
		}
	}

	/**
	 * 
	 * M�todo que carrega o arquivo com ArrayList Vend Atrav�s do arquivo .dat
	 * obtem-se o arraylist correspondente ao arquivo da cole��o. Ao fim da
	 * execu��o retorna um arraylist, do tipo Funcion�rio.
	 * 
	 * @return Vend
	 */
	public ArrayList<Vendas> carregarDados() {
		Vend = new ArrayList();
		try {
			FileInputStream in = new FileInputStream("vendas.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			Vend = (ArrayList) objIn.readObject();
			objIn.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Vend;
	}

}
