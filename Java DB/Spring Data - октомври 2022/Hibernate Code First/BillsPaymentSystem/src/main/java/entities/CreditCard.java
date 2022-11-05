package entities;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    @Enumerated(EnumType.STRING)
    @Column(name = "billing_type")
    private final BillingType billingType;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private Month expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private Year expirationYear;

    public CreditCard() {
        this.billingType = BillingType.CREDIT_CARD;
    }

    public CreditCard(String cardType, Month expirationMonth, Year expirationYear) {

        this.cardType = cardType;

        this.expirationMonth = expirationMonth;

        this.expirationYear = expirationYear;

        this.billingType = BillingType.CREDIT_CARD;

    }

    public BillingType getBillingType() {

        return billingType;

    }

    public String getCardType() {

        return cardType;

    }

    public void setCardType(String cardType) {

        this.cardType = cardType;

    }

    public Month getExpirationMonth() {

        return expirationMonth;

    }

    public void setExpirationMonth(Month expirationMonth) {

        this.expirationMonth = expirationMonth;

    }

    public Year getExpirationYear() {

        return expirationYear;

    }

    public void setExpirationYear(Year expirationYear) {

        this.expirationYear = expirationYear;

    }

}
