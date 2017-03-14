import java.io.Serializable;
/**
 * 
 * @author Patrick Muller e Neudson José
 *
 */


/**
 * 
 * Classe com o nome Switch que implementa a interface equipamentos
 */
public class Switch implements Equipamentos, Serializable {

	private String modelo;
	private String numserie;
	private int qtdportas;

	public Switch(String modelo, String numserie, int qtdportas) {
		this.modelo = modelo;
		this.numserie = numserie;
		this.qtdportas = qtdportas;
	}

	public Switch() {

	}

	public String getModelo() {
		return modelo;
	}

	public void setPatrimonio(String mod) {
		this.modelo = mod;
	}

	public String getNumSerie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public int getQtdportas() {
		return qtdportas;
	}

	public void setQtdportas(int qtdportas) {
		this.qtdportas = qtdportas;
	}

	public String toString() {
		return "Switch [Modelo=" + modelo + ", Número de série=" + numserie
				+ ", Quantidade de portas=" + qtdportas + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Switch other = (Switch) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (numserie == null) {
			if (other.numserie != null)
				return false;
		} else if (!numserie.equals(other.numserie))
			return false;
		if (qtdportas != other.qtdportas)
			return false;
		return true;
	}

}
