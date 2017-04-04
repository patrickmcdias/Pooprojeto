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
	 * Recebe como parâmetro um objeto do tipo Funcionario e adiciona dentro do arraylist
	 * @param fu
	 * */
	public void adicionarFuncionario(Funcionario fu) {
		this.Func.add(fu);
	}

	/**
	 * 
	 * Método que faz a pesquisa dentro do ArrayList Func pelo atributo
	 * Matricula. Recebe como Parâmetro uma String com a matrícula do funcionário,
	 * Pesquisa e informa se existe ou não no arraylist. 
	 * @param n
	 * @return funcio
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
	 * Recebe como parâmetro uma String correspondente a matrícula,
	 * ao fim de sua execução o arraylist esta decrementado desse
	 * objeto.
	 * @param n
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
	 * Pega o arraylist da coleção, e salva em um arquivo .dat
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
	 * Através do arquivo .dat obtem-se o arraylist correspondente ao 
	 * arquivo da coleção. Ao fim da execução retorna um arraylist,
	 * do tipo Funcionário.
	 * @return Func
	 */
	public ArrayList<Funcionario> carregarDados() {
		Func = new ArrayList();
		try {
			FileInputStream in = new FileInputStream("funcionario.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			Func =(ArrayList) objIn.readObject();
			objIn.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Func;
	}

}
