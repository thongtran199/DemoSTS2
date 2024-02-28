package com.sgu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private int paymentID;

    @Column(name = "CardType")
    private String cardType;

    @Column(name = "CreditCard")
    private String creditCard;

    @Column(name = "CredExpMo")
    private Integer credExpMo;

    public Payment(int paymentID, String cardType, String creditCard, Integer credExpMo, Integer cardExpYr) {
		super();
		this.paymentID = paymentID;
		this.cardType = cardType;
		this.creditCard = creditCard;
		this.credExpMo = credExpMo;
		this.cardExpYr = cardExpYr;
	}
    public Payment() {
    	
    }

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Integer getCredExpMo() {
		return credExpMo;
	}

	public void setCredExpMo(Integer credExpMo) {
		this.credExpMo = credExpMo;
	}

	public Integer getCardExpYr() {
		return cardExpYr;
	}

	public void setCardExpYr(Integer cardExpYr) {
		this.cardExpYr = cardExpYr;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", cardType=" + cardType + ", creditCard=" + creditCard
				+ ", credExpMo=" + credExpMo + ", cardExpYr=" + cardExpYr + "]";
	}

	@Column(name = "CardExpYr")
    private Integer cardExpYr;
}