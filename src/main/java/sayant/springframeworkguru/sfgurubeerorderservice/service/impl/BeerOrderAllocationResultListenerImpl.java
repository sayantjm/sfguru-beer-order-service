package sayant.springframeworkguru.sfgurubeerorderservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.brewery.model.events.AllocateOrderResult;
import sayant.springframeworkguru.sfgurubeerorderservice.config.JmsConfig;
import sayant.springframeworkguru.sfgurubeerorderservice.service.BeerOrderManager;

/**
 * Created by sayantjm on 7/2/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderAllocationResultListenerImpl {
    private final BeerOrderManager beerOrderManager;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE)
    public void listen(AllocateOrderResult result) {
        if (!result.getAllocationError() && !result.getPendingInventory()) {
            // allocated normally
            beerOrderManager.beerOrderAllocationPassed(result.getBeerOrderDto());
        } else if (!result.getAllocationError() && result.getPendingInventory()) {
            // pending inventory
            beerOrderManager.beerOrderAllocationPendingInventory(result.getBeerOrderDto());
        } else if (result.getAllocationError()){
            // allocation error
            beerOrderManager.beerOrderAllocationFailed(result.getBeerOrderDto());
        }
    }
}
