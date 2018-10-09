package com.Group3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password("{noop}test").roles("USER").and()
                .withUser("root").password("{noop}root").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("**/car/addCar").hasRole("ADMIN")
                .antMatchers("**/car/readCar").hasRole("ADMIN")
                .antMatchers("**/car/updateCar").hasRole("ADMIN")
                .antMatchers("**/car/deleteCar").hasRole("ADMIN")
                .antMatchers("**/car/readAllCars").hasRole("ADMIN")
                .antMatchers("**/category/read").hasRole("ADMIN")
                .antMatchers("**/category/addCategory").hasRole("ADMIN")
                .antMatchers("**/category/read").hasRole("ADMIN")
                .antMatchers("**/category/readAll").hasRole("ADMIN")
                .antMatchers("**/customer/addCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/updateCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/findCustomerByID").hasRole("ADMIN")
                .antMatchers("**/customer/findAll").hasRole("ADMIN")
                .antMatchers("**/customer/deleteCustomer").hasRole("ADMIN")
                .antMatchers("**/customer/findByEmail").hasRole("ADMIN")
                .antMatchers("**/history/{invoiceId}/{rentId}/addHistory").hasRole("ADMIN")
                .antMatchers("**/history/findHistoryItem").hasRole("ADMIN")
                .antMatchers("**/history/{invoiceId}/{rentId}/updateHistory").hasRole("ADMIN")
                .antMatchers("**/history/deleteHistory").hasRole("ADMIN")
                .antMatchers("**/history/findAll").hasRole("ADMIN")
                .antMatchers("**/history/{invoiceId}/findAllRentalBasedInvoice").hasRole("ADMIN")
                .antMatchers("**/invoice/{customerId}/addInvoice").hasRole("ADMIN")
                .antMatchers("**/invoice/{customerId}/findInvoice").hasRole("ADMIN")
                .antMatchers("**/invoice/{customerId}/updateInvoice").hasRole("ADMIN")
                .antMatchers("**/invoice//deleteInvoice").hasRole("ADMIN")
                .antMatchers("**/order/{customerId}/addOrder").hasRole("ADMIN")
                .antMatchers("**/order/{customerId}/findOrder").hasRole("ADMIN")
                .antMatchers("**/order/{customerId}/updateOrder").hasRole("ADMIN")
                .antMatchers("**/order/deleteOrder").hasRole("ADMIN")
                .antMatchers("**/rent/{orderId}/{carId}/rentCar").hasRole("ADMIN")
                .antMatchers("**/rent/findRentedItem").hasRole("ADMIN")
                .antMatchers("**/rent/{orderId}/{carId}/updateRent").hasRole("ADMIN")
                .antMatchers("**/rent/deleteRent").hasRole("ADMIN")
                .antMatchers("**/rent/findAllRentedCars").hasRole("ADMIN")
                .antMatchers("**/user/addUser").hasRole("ADMIN")
                .antMatchers("**/user/findByUserID").hasRole("ADMIN")
                .antMatchers("**/user/findAllUsers").hasRole("ADMIN")
                .antMatchers("**/user/updateUser").hasRole("ADMIN")
                .antMatchers("**/user/deleteUser").hasRole("ADMIN")
                .antMatchers("**/user/findByName").hasRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
