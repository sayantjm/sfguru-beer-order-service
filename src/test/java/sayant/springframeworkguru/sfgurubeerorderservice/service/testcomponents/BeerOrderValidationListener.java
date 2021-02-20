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
        boolean isValid = true;
        boolean sendResponse = true;

        ValidateOrderRequest request = (ValidateOrderRequest) msg.getPayload();
        //condition to fail validation
        if (request.getBeerOrderDto().getCustomerRef() != null) {
            if ("fail-validation".equals(request.getBeerOrderDto().getCustomerRef()) ) {
                isValid = false;
            } else if ("dont-validate".equals(request.getBeerOrderDto().getCustomerRef())) {
                sendResponse = false;
            }
        }

        if(sendResponse) {
            jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                    ValidateOrderResult.builder()
                            .isValid(isValid)
                            .orderId(request.getBeerOrderDto().getId())
                            .build());
        }
    }
}
