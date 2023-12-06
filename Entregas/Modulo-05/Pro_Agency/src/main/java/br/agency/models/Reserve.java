package br.agency.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reserve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date_reserve;
	
	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date_travel;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "destiny_id", nullable = false)
	private Destiny destiny;
	
	public void setClientId(Long clientId) {
		if (client == null) {
			client = new Client();
		}
		client.setId(clientId);
	}
	
	public void setDestinyId(Long destinyId) {
		if (destiny == null) {
			destiny = new Destiny();
		}
		destiny.setId(destinyId);
	}
	
	public Reserve() {
		this.date_reserve = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate_reserve() {
		return date_reserve;
	}

	public void setDate_reserve(LocalDate date_reserve) {
		this.date_reserve = date_reserve;
	}

	public LocalDate getDate_travel() {
		return date_travel;
	}

	public void setDate_travel(LocalDate date_travel) {
		this.date_travel = date_travel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}
	
	
}
