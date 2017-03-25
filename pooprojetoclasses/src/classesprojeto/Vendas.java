package classesprojeto;

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

	private Equipamentos equip;
	private double valor;
	private Funcionario vend;
	private Cliente client;

	public Vendas() {
	}

	public Vendas(Equipamentos equip, Funcionario vend, double valor,
			Cliente client) {
		this.equip = equip;
		this.vend = vend;
		this.valor = valor;
		this.client = client;
	}

	public Equipamentos getEquip() {
		return equip;
	}

	public void setEquip(Equipamentos equip) {
		this.equip = equip;
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

	public Funcionario getVend() {
		return vend;
	}

	public void setVend(Vendedor vend) {
		this.vend = vend;
	}

	public String toString() {
		return "Venda [Equipameto = " + equip.toString() + ", Valor= " + valor
				+ vend.toString() + client.toString() + "]";
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
		if (equip == null) {
			if (other.equip != null)
				return false;
		} else if (!equip.equals(other.equip))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		if (vend == null) {
			if (other.vend != null)
				return false;
		} else if (!vend.equals(other.vend))
			return false;
		return true;
	}

}