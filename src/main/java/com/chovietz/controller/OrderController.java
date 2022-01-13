package com.chovietz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.chovietz.model.Order;
import com.chovietz.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/order")
@CrossOrigin(origins= "*", maxAge=3600)
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody Order orderReq){
        System.out.println(orderReq);
        try {
                Order requestOrder = new Order(orderReq.getId(), orderReq.getCustomer(), orderReq.getDelivery_address(),orderReq.getStatus(), orderReq.getShop(),
                orderReq.getShipper(), orderReq.getPayment_type(), orderReq.getIs_paid(), orderReq.getProduct());
                Order order = orderRepository.save( requestOrder);
              return new ResponseEntity<>(order, HttpStatus.CREATED);
        	} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
	@PutMapping("/status/{id}")
	public ResponseEntity<Order> CapNhatNhanVien(@PathVariable("id") String id, @RequestBody Order request) {
		Optional<Order> orderData = orderRepository.findById(id);
		if (orderData.isPresent()) {
			Order _order = orderData.get();
			_order.setStatus(request.getStatus());
			return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping("/shop/{id}")
	public ResponseEntity<List<Order>> getAllOrderByShop(@PathVariable("id") String id) {
		try {
         
			List<Order> orderlst = new ArrayList<Order>();
			orderRepository.findAll().forEach(orderlst::add);
            
			if (orderlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orderlst, HttpStatus.OK);
		} catch (Exception e) {
                System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
