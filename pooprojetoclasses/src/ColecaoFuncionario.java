import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ColecaoFuncionario {

	private ArrayList<Funcionario> Func;

	public ColecaoFuncionario() {
		Func = new ArrayList<Funcionario>();
	}

	public void adicionarFuncionario(Funcionario fu) {
		this.Func.add(fu);
	}

	public Funcionario pesquisarPelaMatricula(String n) {
		int k = 0;
		Funcionario funcio = null;
		for (Funcionario fu : Func) {
			if (fu.getMatricula().equals(n)) {
				System.out.println("Funcionário " + fu.toString());
				funcio = fu;
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos funcionário com essa matrícula");
		}
		return funcio;
	}

	public void removerPelaMatricula(String n) {
		int k = 0;
		Funcionario fu;
		for (Iterator<Funcionario> i = Func.iterator(); i.hasNext();) {
			fu = i.next();
			if (n.equals(fu.getMatricula())) {
				i.remove();
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Não temos funcionário com essa matrícula");
		}

	}
	public int salvarDados(ArrayList Func ){
        try{
            
            FileOutputStream arquivo = new FileOutputStream("funcionario.dat"); 
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(Func);
            out.close();
            return 0;
        }catch(Exception ex){
            return -1;
            
        }
    }
	 public ArrayList <Funcionario> carregarDados() {
		 Func = new ArrayList<Funcionario>();
		 try {
		 	FileInputStream in= new FileInputStream ("funcionario.dat");
		 	ObjectInputStream objIn = new ObjectInputStream(in);
		 	while (true) {
		 		Funcionario f = (Funcionario) objIn.readObject();	
		 		Func.add(f);
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
		 return Func;
	 }

}
