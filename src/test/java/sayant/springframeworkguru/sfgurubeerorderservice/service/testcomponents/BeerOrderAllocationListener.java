package sayant.springframeworkguru.sfgurubeerorderservice.service.testcomponents;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.brewery.model.events.AllocateOrderRequest;
import sayant.springframeworkguru.brewery.model.events.AllocateOrderResult;
import sayant.springframeworkguru.sfgurubeerorderservice.config.JmsConfig;

/**
 * Created by sayantjm on 14/2/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderAllocationListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(Message msg) {
        boolean pendingInventory = false;
        boolean allocationError = false;
        boolean sendResponse = true;

        AllocateOrderRequest request = (AllocateOrderRequest) msg.getPayload();

        if (request.getBeerOrderDto().getCustomerRef() != null) {
            // set allocation error
            if ("fail-allocation".equals(request.getBeerOrderDto().getCustomerRef())){
                allocationError = true;
            } else if ("partial-allocation".equals(request.getBeerOrderDto().getCustomerRef())) {
                // set pending inventory
                pendingInventory = true;
            } else if ("dont-allocate".equals(request.getBeerOrderDto().getCustomerRef())) {
                sendResponse = false;
            }
        }


        boolean finalPendingInventory = pendingInventory;
        request.getBeerOrderDto().getBeerOrderLines().forEach(beerOrderLineDto -> {
            if (finalPendingInventory) {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity() - 1);
            } else {
                beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
            }

        });

        if(sendResponse) {
            jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                    AllocateOrderResult.builder()
                            .beerOrderDto(request.getBeerOrderDto())
                            .pendingInventory(pendingInventory)
                            .allocationError(allocationError)
                            .build()
            );
        }
    }
}
