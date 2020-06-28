package sayant.springframeworkguru.sfgurubeerorderservice.domain;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
public class Customer extends BaseEntity {

    public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastUpdatedDate, String customerName, UUID apikey) {
        super(id, version, createdDate, lastUpdatedDate);
        this.customerName = customerName;
        this.apikey = apikey;
    }

    private String customerName;
    private UUID apikey;
}
