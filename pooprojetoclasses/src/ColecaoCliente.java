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
	            
	            FileOutputStream arquivo = new FileOutputStream("cliente.dat"); 
	            ObjectOutputStream out = new ObjectOutputStream(arquivo);
	            out.writeObject(Cliente);
	            out.close( );
	            return 0;
	        }catch(Exception ex){
	            return -1;
	            
	        }
	    }
	 public ArrayList <Cliente> carregarDados() {
		 Clien = new ArrayList<Cliente>();
		 try {
		 	FileInputStream in= new FileInputStream ("cliente.dat");
		 	ObjectInputStream objIn = new ObjectInputStream(in);
		 	while (true) {
		 		Cliente c = (Cliente) objIn.readObject();	
		 		Clien.add(c);
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
		 return Clien;
	 }
}
