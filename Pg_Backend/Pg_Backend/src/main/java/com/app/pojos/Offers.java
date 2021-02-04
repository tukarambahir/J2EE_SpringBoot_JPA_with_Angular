/*package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "offers_tbl")
@JsonInclude(Include.NON_DEFAULT)

public class Offers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_id")
	private Integer offerId;
	
	private String offerDesc;
	
	private int offerAmount;
	
	@OneToMany
	private List<Customer> offeredCust = new ArrayList<>();
	
	@OneToMany
	private List<Pg> offeredPG = new ArrayList<>();
	
	
	public Offers(Integer offerId, String offerDesc, int offerAmount) {
		super();
		this.offerId = offerId;
		this.offerDesc = offerDesc;
		this.offerAmount = offerAmount;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public int getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}

	public List<Customer> getOfferedCust() {
		return offeredCust;
	}

	public void setOfferedCust(List<Customer> offeredCust) {
		this.offeredCust = offeredCust;
	}

	public List<Pg> getOfferedPG() {
		return offeredPG;
	}

	public void setOfferedPG(List<Pg> offeredPG) {
		this.offeredPG = offeredPG;
	}
	
	
	
}*/
