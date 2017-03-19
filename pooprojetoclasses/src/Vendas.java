import java.io.*;

/**
 * 
 * @author Patrick Muller e Neudson José
 */
/**
 * Classe na qual tem o nome Vendas que utiliza atributos dos objetos Cliente,
 * Vendedor e da interface Equipamentos
 * 
 */
public class Vendas implements Serializable {

	private String modelo;
	private String numserie;
	private Double valor;
	private Vendedor vend;
	private Cliente client;

	public Vendas() {
	}

	public Vendas(String modelo, String numserie, Vendedor vend, Double valor,
			Cliente client) {
		this.modelo = modelo;
		this.vend = vend;
		this.valor = valor;
		this.client = client;
		this.numserie = numserie;
	}

	public String getNumserie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Vendedor getVend() {
		return vend;
	}

	public void setVend(Vendedor vend) {
		this.vend = vend;
	}

	public String toString() {
		return "Vendas [Modelo= " + modelo + ", Número de série = " + numserie
				+ ", Valor = " + valor + ", Vendedor = " + vend
				+ ", Cliente = " + client + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
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
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (vend == null) {
			if (other.vend != null)
				return false;
		} else if (!vend.equals(other.vend))
			return false;
		return true;
	}

}