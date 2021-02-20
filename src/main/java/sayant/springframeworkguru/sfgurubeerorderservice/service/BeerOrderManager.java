package sayant.springframeworkguru.sfgurubeerorderservice.service;

import sayant.springframeworkguru.brewery.model.BeerOrderDto;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;

import java.util.UUID;

/**
 * Created by sayantjm on 6/2/21
 */
public interface BeerOrderManager {
    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean isValid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrderDto);

    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrderDto);

    void beerOrderAllocationFailed(BeerOrderDto beerOrderDto);

    void beerOrderPickerUp(UUID id);

    void cancelOrder(UUID id);
}
