package sayant.springframeworkguru.sfgurubeerorderservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    @Builder
    public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastUpdatedDate, String customerName, UUID apikey, Set<BeerOrder> beerOrders) {
        super(id, version, createdDate, lastUpdatedDate);
        this.customerName = customerName;
        this.apikey = apikey;
        this.beerOrders = beerOrders;
    }

    private String customerName;

    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)")
    private UUID apikey;

    @OneToMany(mappedBy = "customer")
    private Set<BeerOrder> beerOrders;
}
