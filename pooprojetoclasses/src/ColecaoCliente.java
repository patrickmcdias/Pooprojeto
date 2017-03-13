import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

public class ColecaoCliente {
	private ArrayList<Cliente> Clien;

	public ColecaoCliente() {
		Clien = new ArrayList<Cliente>();
	}

	public void adicionarCliente(Cliente cl) {
		this.Clien.add(cl);
	}

	public Cliente pesquisarPeloCPF(String n) {
		int k = 0;
		Cliente cl = null;
		for (Cliente cli : Clien) {
			if (cli.getCPF().equals(n)) {
				System.out.println("Cliente: " + cli.toString());
				cl = cli;
				k++;
			}
		}
		if (k == 0) {
			System.out.println("NÃ£o temos cliente com esse CPF");
		}
		return cl;
	}

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
			System.out.println("NÃo temos cliente com esse CPF");
		}

	}
	 public int salvarDados(ArrayList Cliente ){
	        try{
	            
	            FileOutputStream arquivo = new FileOutputStream("cliente.dat"); //tanto faz o nome do arquivo
	            ObjectOutputStream out = new ObjectOutputStream(arquivo);
	            out.writeObject(Cliente); //referencia a estrutura que se quer armazenar
	            out.close( );
	            return 0;
	        }catch(Exception ex){
	            return -1;
	            
	        }
	    }
	 public Object carregarDados() {
		 ObjectInputStream in = null;
		 try {
		 	in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("cliente.dat")));
		 	Clien = new ArrayList<Cliente>();
		 	Cliente c = new Cliente();
		 	try {
		 		while (true) {
		 			try{
		 				c=(Cliente)in.readObject();
		 				Clien.add(c);
		 			}
		 			catch(EOFException e){
		 				break;
		 			}
		 		}
		 	} 
		 	catch (IOException e){
		 	}
		 	return Clien;
		 } 
		 finally {
		 	in.close();
		 }
	 }
}
