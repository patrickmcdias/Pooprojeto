import java.util.ArrayList;
import java.util.Iterator;

public class ColecaoVendas {

	private ArrayList<Vendas> Vend;

	public ColecaoVendas() {
		Vend = new ArrayList<Vendas>();
	}

	public void adicionarVenda(Vendas ve) {
		this.Vend.add(ve);
	}
	
	public void pesquisarCompraDoCliente(String cpf){
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
	
	public void pesquisarVendaDoVendedor(String matri){
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
	
	public void removerVenda(String num, Vendedor vend){
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getNumserie()) && vend.equals(v.getVend().getMatricula())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não foi feita essa venda");
		}

	}
	public void removerCompra(String num, Cliente clien){
		int k = 0;
		Vendas v;
		for (Iterator<Vendas> i = Vend.iterator(); i.hasNext();) {
			v = i.next();
			if (num.equals(v.getNumserie()) && clien.equals(v.getClient().getCPF())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não foi feita essa compra");
		}

	}

}
