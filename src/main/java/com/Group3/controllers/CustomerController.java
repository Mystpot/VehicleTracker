package com.Group3.controllers;

import com.Group3.domain.Customer;
import com.Group3.factories.CustomerFactory;
import com.Group3.services.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {


    @Autowired
    private CustomerServiceImpl customerService;

    //@Autowired
    //private InvoiceServiceImpl invoiceService;

    private Customer customer;

    //private Invoices invoices;


    @CrossOrigin
    //  http://localhost:8090/customer/addCustomer?name=watson&surname=ma&email=wat.matunhire&city=Cape+town&province=western+cape&complex=delft&street=Erjihouet&houseNumber=44&postalCode=7100
    //@GetMapping(path = "/{invoiceId}/addCustomer")
    @PostMapping(path = "/addCustomer")
    public
    @ResponseBody
    ResponseEntity addCustomer(@RequestBody Customer customer/*@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                               @RequestParam String city, @RequestParam String province, @RequestParam String complex,
                               @RequestParam String street, @RequestParam String password, @RequestParam String role,
                               @RequestParam int houseNumber, @RequestParam int postalCode*/)
    {
      /*  Map<String, String> stringValues = new HashMap<String, String>();
        Map<String, Integer> intValues = new HashMap<String, Integer>();
        stringValues.put("name", name);
        stringValues.put("surname", surname);
        stringValues.put("email", email);
        stringValues.put("city", city);
        stringValues.put("province", province);
        stringValues.put("complex", complex);
        stringValues.put("street", street);
        stringValues.put("password", password);
        stringValues.put("role", role);
        intValues.put("houseNumber", houseNumber);
        intValues.put("postalCode", postalCode); */


       // customer = CustomerFactory.getCustomer(stringValues, intValues);

        customerService.create(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @CrossOrigin
    //http://localhost:8090/customer/findCustomerByID?customerID=1
    @GetMapping(path = "/findCustomerByID")
    public
    @ResponseBody
    ResponseEntity findCustomerByID(long customerID) {


        Optional<Customer> cust = customerService.read(customerID);

        if(!cust.isPresent())
        {
            return new ResponseEntity("No customer found for customer" + customerID, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cust, HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping(path = "/updateCustomer")
    public
    @ResponseBody
    Customer updateCustomer(@RequestParam long customerId, @RequestParam String name, @RequestParam String surname, @RequestParam String email,
                            @RequestParam String city, @RequestParam String province, @RequestParam String complex,
                            @RequestParam String street, @RequestParam int houseNumber, @RequestParam int postalCode,
                            @RequestParam String password, @RequestParam String role) {


        //customerService.read(customerId);
        Customer customerUpdate = new Customer.Builder()
                .id(customerId)
                .name(name)
                .surname(surname)
                .email(email)
                .city(city)
                .province(province)
                .complex(complex)
                .street(street)
                .houseNumber(houseNumber)
                .postalCode(postalCode)
                .password(password)
                .role(role)
                .build();

        return customerService.update(customerUpdate);
    }

    @CrossOrigin
    @GetMapping(path = "/deleteCustomer")
    public
    @ResponseBody
    void deleteCustomer(@RequestParam Customer customerID) {
        customerService.delete(customerID);
    }

    @CrossOrigin
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<Customer> getAllCustomers()
    {
        return customerService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/findByEmail/{email}")
    public @ResponseBody Customer availableEmail(@PathVariable("email")String email)
    {
        return customerService.availableEmail(email);
    }


}
