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

        AllocateOrderRequest request = (AllocateOrderRequest) msg.getPayload();

        System.out.println("########### BeerOrderAllocationListener RAN ########");

        request.getBeerOrderDto().getBeerOrderLines().forEach(beerOrderLineDto -> {
            beerOrderLineDto.setQuantityAllocated(beerOrderLineDto.getOrderQuantity());
        });

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                AllocateOrderResult.builder()
                        .beerOrderDto(request.getBeerOrderDto())
                        .pendingInventory(false)
                        .allocationError(false)
                        .build()
                );
    }
}
