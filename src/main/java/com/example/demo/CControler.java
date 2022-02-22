package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class CControler {
        private List<Customer> customers;

        public void CController(){
            this.customers = init();
        }

        private List<Customer> init(){
            List<Customer> customers = new ArrayList<>();
            Customer customer = new Customer();
            customer.setCustomer("Jožko", "Mrkvička");
            customers.add(customer);

            Customer customer2 = new Customer();
            customer2.setCustomer("Hanka","Nová");
            customers.add(customer2);
            return customers;
        }

        @GetMapping("/api/customers")
        public List<Customer> getCustomers(@RequestParam(required = false) String Customer){
            if (Customer == null){
                return this.customers;
            }
            List<Customer> filteredCustomers = new ArrayList<>();

            for(Customer customer : customers){
                if (customer.getCustomer().equals(Customer)){
                    filteredCustomers.add(customer);
                }
            }
            return filteredCustomers;

        }
        @GetMapping("/api/customers/{customerId}")
        public Customer getCustomer(@PathVariable Integer customerId){
            return this.customers.get(customerId);

        }

        @PostMapping("/api/customers")
        public Integer createCustomer(@RequestBody Customer customer){
            this.customers.add(customer);

            return this.customers.size() -1;
        }
        @DeleteMapping("/api/customers{customerId}")
        public void deleteCustomer(@PathVariable Integer customerId){
            this.customers.remove(this.customers.get(customerId));

        }
        @PutMapping("/api/customers{customerId}")
        public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer){
            this.customers.get(customerId).setCustomer(customer.getCustomer());
        }
    }


