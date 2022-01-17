package com.chovietz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import com.chovietz.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

    
	Page<Order> findByShopID(String shopID, Pageable pageable);
}
