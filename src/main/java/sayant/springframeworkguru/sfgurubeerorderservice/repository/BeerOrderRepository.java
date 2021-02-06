package sayant.springframeworkguru.sfgurubeerorderservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.Customer;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.enums.BeerOrderStatusEnum;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
    Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    List<BeerOrder> findAllByOrderStatus(BeerOrderStatusEnum beerOrderStatusEnum);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BeerOrder findOneById(UUID id);
}
