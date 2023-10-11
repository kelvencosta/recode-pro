package principal;

import java.sql.Date;

public class Reserva {
	private int cod;
	private Date dataReserva;
	private Date dataViagem;
	private Cliente cliente;
	private Destino destino;
	
	public Reserva(int cod, Date dataReserva, Date dataViagem, Cliente cliente, Destino destino) {
		super();
		this.cod = cod;
		this.dataReserva = dataReserva;
		this.dataViagem = dataViagem;
		this.cliente = cliente;
		this.destino = destino;
	}
	
	public Reserva(){
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(java.util.Date date) {
		this.dataReserva = (Date) date;
	}

	public Date getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(java.util.Date dataViagem) {
		this.dataViagem = (Date) dataViagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
}