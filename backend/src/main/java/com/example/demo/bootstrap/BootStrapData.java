package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    public BootStrapData(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() < 2) {
            Customer customer1 = new Customer(null, "53 9th Street", "Henry", "King", "(893)563-5555", "12345", null);
            customerRepository.save(customer1);

            Customer customer2 = new Customer(null, "563 Grand Avenue", "Jimmy", "Smith", "(935)555-5300", "67890", null);
            customerRepository.save(customer2);

            Customer customer3 = new Customer(null, "12 Plaza Drive", "David", "John", "(155)665-5565", "36598", null);
            customerRepository.save(customer3);

            Customer customer4 = new Customer(null, "365 Iowa Street", "Anna", "Huff", "(335)577-1159", "56974", null);
            customerRepository.save(customer4);

            Customer customer5 = new Customer(null, "369 Forest Lane", "Lily", "Ford", "(995)565-3355", "99654", null);
            customerRepository.save(customer5);
        }
    }
}


