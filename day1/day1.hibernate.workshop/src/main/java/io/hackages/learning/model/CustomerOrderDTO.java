package io.hackages.learning.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerOrderDTO {

	private Integer id;

	private String description;

	private String invoiceId;

	private LocalDateTime purchasedAt;

	public CustomerOrderDTO() {}

	public CustomerOrderDTO(CustomerOrder entity) {
		this.description = entity.getDescription();
		this.id = entity.getId();
		this.invoiceId = entity.getInvoiceId();
		this.purchasedAt = entity.getPurchasedAt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDateTime getPurchasedAt() {
		return purchasedAt;
	}

	public void setPurchasedAt(LocalDateTime purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
}
