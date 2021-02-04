/*package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "feedback_tbl")
@JsonInclude(Include.NON_DEFAULT)

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Integer feedbackId;
	
	@Column(length = 100)
	private String feedback;
	
	@ManyToOne
	private Pg pg_feedback;
	
	@OneToOne
	private Customer cust_feedback;

	public Feedback(Integer feedbackId, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
	}
	
	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Pg getPg_feedback() {
		return pg_feedback;
	}

	public void setPg_feedback(Pg pg_feedback) {
		this.pg_feedback = pg_feedback;
	}

	public Customer getCust_feedback() {
		return cust_feedback;
	}

	public void setCust_feedback(Customer cust_feedback) {
		this.cust_feedback = cust_feedback;
	}


	
	
}*/
