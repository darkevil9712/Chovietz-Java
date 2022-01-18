package com.chovietz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.chovietz.model.Order;
import com.chovietz.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllOrderByShop(@PathVariable("id") String id,
	@RequestParam(required = false) int page,@RequestParam(required = false) int size,@RequestParam(defaultValue = "created_date") String sortBy,@RequestParam(defaultValue = "1") int asc) {
		try {   
			List<Order> orderlst = new ArrayList<Order>();
			if(page < 0 || size < 0){
				orderlst = orderRepository.findByShop(id); 
				if (orderlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				Map<String, Object> response = new HashMap<>();
				response.put("orders", orderlst);
				response.put("currentPage", 1);
				response.put("totalItems", orderlst.size());
				response.put("totalPages", 1);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Pageable paging = PageRequest.of(page,size, Sort.by("_id").descending());
			
			Page<Order> pageTuts = orderRepository.findByShopID(id, paging);
				
			orderlst = pageTuts.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("orders", orderlst);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
                System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllOrderByCustomer(@PathVariable("id") String id,
	@RequestParam(required = false) int page,@RequestParam(required = false) int size,@RequestParam(defaultValue = "created_date") String sortBy,@RequestParam(defaultValue = "1") int asc) {
		try {   
			List<Order> orderlst = new ArrayList<Order>();
			if(page < 0 || size < 0){
				orderlst = orderRepository.findByCustomer(id);  
				if (orderlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				Map<String, Object> response = new HashMap<>();
				response.put("orders", orderlst);
				response.put("currentPage", 1);
				response.put("totalItems", orderlst.size());
				response.put("totalPages", 1);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Pageable paging = PageRequest.of(page,size, Sort.by("_id").descending());
			
			Page<Order> pageTuts = orderRepository.findByCustomerID(id, paging);
				
			orderlst = pageTuts.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("orders", orderlst);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
                System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping("/shipper/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllOrderByShipper(@PathVariable("id") String id,
	@RequestParam(required = false) int page,@RequestParam(required = false) int size,@RequestParam(defaultValue = "created_date") String sortBy,@RequestParam(defaultValue = "1") int asc) {
		try {   
			List<Order> orderlst = new ArrayList<Order>();
			if(page < 0 || size < 0){
				orderlst = orderRepository.findByShipper(id); 
				if (orderlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				Map<String, Object> response = new HashMap<>();
				response.put("orders", orderlst);
				response.put("currentPage", 1);
				response.put("totalItems", orderlst.size());
				response.put("totalPages", 1);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Pageable paging = PageRequest.of(page,size, Sort.by("_id").descending());
			
			Page<Order> pageTuts = orderRepository.findByShipperID(id, paging);
				
			orderlst = pageTuts.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("orders", orderlst);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
                System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
