package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository  customerRepository) {
        this.customerRepository  = customerRepository;
    }

    private static CustomerDto mapToCustomer(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setEmail(customerEntity.getEmail());

        return customerDto;
    }


    @Transactional
    public List<CustomerDto> getCustomers(String lastName) {
        List<CustomerDto> cus = new LinkedList<>();
        for (CustomerEntity c1 : customerRepository.findAll()) {
            CustomerDto c2 = mapToCustomer(c1);
            cus.add(c2);
        }
        return cus;
    }

    @Transactional
    public CustomerDto getCustomer(Long customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {
            return mapToCustomer(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setEmail(customerDto.getEmail());

        this. customerRepository.save( customerEntity);

        return  customerEntity.getId();

    }

    @Transactional
    public void updateCustomer(int customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()) {

            byId.get().setFirstName(customerDto.getFirstName());
            byId.get().setLastName(customerDto.getLastName());
            byId.get().setEmail(customerDto.getEmail());

        }
    }

    @Transactional
    public void deleteCustomer(int customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if (byId.isPresent()) {
            customerRepository.delete(byId.get());
        }
    }
}

