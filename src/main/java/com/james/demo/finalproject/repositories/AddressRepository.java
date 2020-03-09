package com.james.demo.finalproject.repositories;


import com.james.demo.finalproject.models.Address;
import org.springframework.data.repository.Repository;

public interface AddressRepository extends Repository<Address, Integer> {


  Address save(Address order);
}
