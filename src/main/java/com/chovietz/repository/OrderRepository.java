package com.chovietz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import com.chovietz.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
	@Query("{shop.$_id:'?0'}")
	List<Order> findByID(String id);

	@Query("{customer.$_id:'?0'}")
	List<Order> findByCustomer(String id);

	@Query("{shipper.$_id:'?0'}")
	List<Order> findByShipper(String id);
    
	Page<Order> findByShopID(String shopID, Pageable pageable);
	Page<Order> findByCustomerID(String customerID, Pageable pageable);
	Page<Order> findByShipperID(String shipperID, Pageable pageable);
}
