import java.io.Serializable;

/**
 * 
 * @author Patrick Muller e Neudson José
 */
/**
 * Classe com nome Roteador que implementa a interface equipamentos
 */
public class Roteador implements Equipamentos, Serializable {
	private String modelo;
	private String numserie;
	private int qtdportasserial;
	private int qtdportasethernet;

	public Roteador(String modelo, String numserie, int qtdportasserial,
			int qtdportasethernet) {
		this.modelo = modelo;
		this.numserie = numserie;
		this.qtdportasserial = qtdportasserial;
		this.qtdportasethernet = qtdportasethernet;
	}

	public Roteador() {

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public int getQtdportasserial() {
		return qtdportasserial;
	}

	public void setQtdportasserial(int qtdportasserial) {
		this.qtdportasserial = qtdportasserial;
	}

	public int getQtdportasethernet() {
		return qtdportasethernet;
	}

	public void setQtdportasethernet(int qtdportasethernet) {
		this.qtdportasethernet = qtdportasethernet;
	}

	public String toString() {
		return "Roteador [Modelo=" + modelo + ", Número de série=" + numserie
				+ ", Quantidade de portas serial=" + qtdportasserial
				+ ", Quantidade de portas ethernet=" + qtdportasethernet + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roteador other = (Roteador) obj;
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
		if (qtdportasethernet != other.qtdportasethernet)
			return false;
		if (qtdportasserial != other.qtdportasserial)
			return false;
		return true;
	}

}
