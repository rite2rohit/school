package com.kstech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.kstech.model.Address;

@Component
public interface AddressDAO extends JpaRepository<Address, Long> {

}
