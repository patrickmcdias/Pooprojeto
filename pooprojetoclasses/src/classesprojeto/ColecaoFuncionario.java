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
	 * M�todo que adiciona objetos do tipo Funcionario no ArrayList Func
	 * Recebe como par�metro um objeto do tipo Funcionario e adiciona dentro do arraylist
	 * @param fu
	 * */
	public void adicionarFuncionario(Funcionario fu) {
		this.Func.add(fu);
	}

	/**
	 * 
	 * M�todo que faz a pesquisa dentro do ArrayList Func pelo atributo
	 * Matricula. Recebe como Par�metro uma String com a matr�cula do funcion�rio,
	 * Pesquisa e informa se existe ou n�o no arraylist. 
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
	 * M�todo que remove do ArrayList Func pelo atributo Matricula
	 * Recebe como par�metro uma String correspondente a matr�cula,
	 * ao fim de sua execu��o o arraylist esta decrementado desse
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
	 * M�todo que salva o ArrayList Func em um arquivo
	 * Pega o arraylist da cole��o, e salva em um arquivo .dat
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
	 * M�todo que carrega o arquivo com ArrayList Func
	 * Atrav�s do arquivo .dat obtem-se o arraylist correspondente ao 
	 * arquivo da cole��o. Ao fim da execu��o retorna um arraylist,
	 * do tipo Funcion�rio.
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
