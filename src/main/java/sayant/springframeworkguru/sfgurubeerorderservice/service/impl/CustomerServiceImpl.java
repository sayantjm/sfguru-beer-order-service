package sayant.springframeworkguru.sfgurubeerorderservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sayant.springframeworkguru.brewery.model.CustomerPagedList;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.Customer;
import sayant.springframeworkguru.sfgurubeerorderservice.mapper.CustomerMapper;
import sayant.springframeworkguru.sfgurubeerorderservice.repository.CustomerRepository;
import sayant.springframeworkguru.sfgurubeerorderservice.service.CustomerService;

import java.util.stream.Collectors;

/**
 * Created by sayantjm on 27/2/21
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPagedList listCustomers(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        return new CustomerPagedList(customerPage
                .stream()
                .map(customerMapper::customerToDto)
                .collect(Collectors.toList()),
                PageRequest.of(customerPage.getPageable().getPageNumber(),
                        customerPage.getPageable().getPageSize()),
                        customerPage.getTotalElements());
    }
}
