/**
 * 
 * @author Patrick Muller e Neudson José
 *
 */

/**
 * 
 * Classe com o nome AccessPoint que implementa a interface equipamentos
 */
public class AccessPoint implements Equipamentos {
	private String modelo;
	private String numserie;
	private int qtdportas;
	private int qtdantenas;

	public AccessPoint(String modelo, String numserie, int qtdportas,
			int qtdantenas) {
		this.modelo = modelo;
		this.numserie = numserie;
		this.qtdportas = qtdportas;
		this.qtdantenas = qtdantenas;
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

	public int getQtdportas() {
		return qtdportas;
	}

	public void setQtdportas(int qtdportas) {
		this.qtdportas = qtdportas;
	}

	public int getQtdantenas() {
		return qtdantenas;
	}

	public void setQtdantenas(int qtdantenas) {
		this.qtdantenas = qtdantenas;
	}

	public String toString() {
		return "AccessPoint [Modelo=" + modelo + ", Númeor de série="
				+ numserie + ", Quantidade de portas=" + qtdportas
				+ ", Quantidade de antenas=" + qtdantenas + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessPoint other = (AccessPoint) obj;
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
		if (qtdantenas != other.qtdantenas)
			return false;
		if (qtdportas != other.qtdportas)
			return false;
		return true;
	}

}
