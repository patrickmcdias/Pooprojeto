import java.util.ArrayList;

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

}
