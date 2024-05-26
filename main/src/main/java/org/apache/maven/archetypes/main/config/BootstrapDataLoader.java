package org.apache.maven.archetypes.main.config;

import org.apache.maven.archetypes.main.dao.CustomerRepository;
import org.apache.maven.archetypes.main.dao.DivisionRepository;
import org.apache.maven.archetypes.main.entities.Customer;
import org.apache.maven.archetypes.main.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapDataLoader {

    @Bean
    public CommandLineRunner loadData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        return args -> {
            Division division1 = divisionRepository.findById(10L).orElse(null);
            Division division2 = divisionRepository.findById(20L).orElse(null);
            Division division3 = divisionRepository.findById(30L).orElse(null);
            Division division4 = divisionRepository.findById(60L).orElse(null);
            Division division5 = divisionRepository.findById(102L).orElse(null);

            if (division1 != null && division2 != null && division3 != null && division4 != null && division5 != null) {
                addSampleCustomer(customerRepository, "Alice", "Johnson", "32 Apple Rd", "43928", "(789) 456-5798", division1);
                addSampleCustomer(customerRepository, "Bob", "Jones", "423 Bake St", "79843", "(767) 679-7896", division2);
                addSampleCustomer(customerRepository, "Jane", "Smith", "23145 Crayon Ln", "78458", "(412) 354-2345", division3);
                addSampleCustomer(customerRepository, "Jim", "Brown", "544 Maple St", "M4B 1B3", "(878) 798-7868", division4);
                addSampleCustomer(customerRepository, "Harry", "Shoemaker", "9 High Ave", "SW1A 1AA", "+44 20 9878 7676", division5);
            } else {
                System.err.println("One or more required division were not found");
            }
        };
    }

    private void addSampleCustomer(CustomerRepository customerRepository,
                                   String firstName,
                                   String lastName,
                                   String address,
                                   String postalCode,
                                   String phone,
                                   Division division) {
        if(!customerRepository.existsByFirstNameAndLastName(firstName, lastName)) {
            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setPostal_code(postalCode);
            customer.setPhone(phone);
            customer.setDivision(division);
            customerRepository.save(customer);
        }
    }

}
