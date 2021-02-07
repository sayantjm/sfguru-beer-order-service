package sayant.springframeworkguru.sfgurubeerorderservice.statemachine.actions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.sfgurubeerorderservice.config.JmsConfig;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.enums.BeerOrderEventEnum;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.enums.BeerOrderStatusEnum;
import sayant.springframeworkguru.sfgurubeerorderservice.mapper.BeerOrderMapper;
import sayant.springframeworkguru.sfgurubeerorderservice.repository.BeerOrderRepository;
import sayant.springframeworkguru.sfgurubeerorderservice.service.impl.BeerOrderManagerImpl;

import java.util.UUID;

/**
 * Created by sayantjm on 7/2/21
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    private final JmsTemplate jmsTemplate;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {

        String beerOderId = (String) stateContext.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOderId));

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE, beerOrderMapper.beerOrderToDto(beerOrder));

        log.debug("Sent Allocation request to queue(validate-order) for order id:{}", beerOderId);
    }
}
