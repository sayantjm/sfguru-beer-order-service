package sayant.springframeworkguru.sfgurubeerorderservice.domain.enums;

/**
 * Created by sayantjm on 28/6/20
 */
public enum BeerOrderStatusEnum {
    NEW, VALIDATED, VALIDATION_PENDING, VALIDATION_EXCEPTION, ALLOCATION_PENDING, ALLOCATED, ALLOCATION_EXCEPTION, CANCELLED, PENDING_INVENTORY, PICKED_UP, DELIVERED, DELIVERY_EXCEPTION
}