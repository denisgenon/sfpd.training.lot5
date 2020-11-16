package io.hackages.learning.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName = "id")
	private Client client;

	@Column
	private LocalDate purchaseDate;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetail = new ArrayList<>();

	@OneToOne
	private Invoice invoice;


	public Order(Client client, ArrayList<Product> products, LocalDate purchaseDate) {
		this.client = client;
		this.purchaseDate = purchaseDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
