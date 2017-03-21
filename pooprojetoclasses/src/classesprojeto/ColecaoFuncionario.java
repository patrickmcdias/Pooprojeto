package classesprojeto;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 * @author Patrick Muller e Neudson José
 */

/**
 * Classe com o nome ColecaoFuncionario na qual coloca o objeto Funcionario
 * em um ArrayList
 */
public class ColecaoFuncionario {

	private ArrayList<Funcionario> Func;

	/**
	 * Método que instância o atributo Func como ArrayList
	 */
	public ColecaoFuncionario() {
		Func = new ArrayList<Funcionario>();
	}

	/**
	 * 
	 * Método que adiciona objetos do tipo Funcionario no ArrayList Func
	 * */
	public void adicionarFuncionario(Funcionario fu) {
		this.Func.add(fu);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Func pelo atributo
	 * Matricula
	 */
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

	/**
	 * 
	 * Método que remove do ArrayList Func pelo atributo Matricula
	 */
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

	/**
	 * 
	 * Método que salva o ArrayList Func em um arquivo
	 */
	public int salvarDados(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("funcionario.dat"));
            out.writeObject(Func);
            out.close();
            return 0;
        }catch(IOException e){
            return -1;
	}
}

	/**
	 * 
	 * Método que carrega o arquivo com ArrayList Func
	 */
	public ArrayList<Funcionario> carregarDados() {
		Func = new ArrayList<Funcionario>();
		try {
			FileInputStream in = new FileInputStream("funcionario.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			while (true) {
				Funcionario f = (Funcionario) objIn.readObject();
				Func.add(f);
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
		return Func;
	}

}
