package sayant.springframeworkguru.sfgurubeerorderservice.service.testcomponents;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.brewery.model.events.ValidateOrderRequest;
import sayant.springframeworkguru.brewery.model.events.ValidateOrderResult;
import sayant.springframeworkguru.sfgurubeerorderservice.config.JmsConfig;

/**
 * Created by sayantjm on 13/2/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(Message msg) {

        ValidateOrderRequest request = (ValidateOrderRequest) msg.getPayload();

        System.out.println("########### BeerOrderValidationListener RAN ########");

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(true)
                        .orderId(request.getBeerOrderDto().getId())
                        .build());
    }
}
