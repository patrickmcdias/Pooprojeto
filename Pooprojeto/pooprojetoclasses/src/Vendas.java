public class Vendas {

	private String modelo;
	private Double valor;
	private Vendedor vend;
	private Cliente client;

	public Vendas() {
	}

	public Vendas(String modelo, Vendedor vend, Double valor, Cliente client) {
		this.modelo = modelo;
		this.vend = vend;
		this.valor = valor;
		this.client = client;
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
		return "Vendas [Modelo = " + modelo + ", Valor= " + valor
				+ ", Vendedor =" + vend + ", Cliente = " + client + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
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
