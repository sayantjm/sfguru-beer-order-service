package sayant.springframeworkguru.sfgurubeerorderservice.service;

import org.springframework.data.domain.Pageable;
import sayant.springframeworkguru.brewery.model.BeerOrderDto;
import sayant.springframeworkguru.brewery.model.BeerOrderPagedList;

import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
public interface BeerOrderService {
    BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);
}
