package bills_payment_db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cards")
public class CreaditCard extends BasicBillingDetail{
    private String cardType;
    private Date expirationDate;

    public CreaditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_date")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
