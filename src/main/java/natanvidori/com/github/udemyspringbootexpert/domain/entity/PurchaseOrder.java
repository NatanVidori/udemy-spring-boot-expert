package natanvidori.com.github.udemyspringbootexpert.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrder {

    private Integer id;
    private BigDecimal total;
    private Client client;
    private LocalDate dateOrder;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

}
