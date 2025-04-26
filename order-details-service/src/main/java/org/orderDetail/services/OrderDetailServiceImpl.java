package org.orderDetail.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.orderDetail.dto.OrderDetailRequestDTO;
import org.orderDetail.dto.OrderDetailResponseDTO;
import org.orderDetail.entities.OrderCustoner;
import org.orderDetail.entities.OrderDetail;
import org.orderDetail.entities.Product;
import org.orderDetail.mappers.OrderDetailMappers;
//import org.orderDetail.openfeign.OrderDetailCustomerRestClient;
import org.orderDetail.openfeign.OrderDetailProductRestClient;
import org.orderDetail.openfeign.OrderDetailsOrderResClient;
import org.orderDetail.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
	private OrderDetailRepository orderDetailRepository;
 private OrderDetailMappers orderDetailMappers;
 private OrderDetailProductRestClient orderDetailProductRestClient;
 public OrderDetailsOrderResClient orderDetailsOrderResClient;
 
	public OrderDetailServiceImpl(OrderDetailMappers orderDetailMappers, 
			OrderDetailProductRestClient orderDetailProductRestClient,
			OrderDetailRepository orderDetailRepository,OrderDetailsOrderResClient orderDetailsOrderResClient) {
	super();
	this.orderDetailMappers = orderDetailMappers;
	this.orderDetailProductRestClient=orderDetailProductRestClient;
	this.orderDetailRepository=orderDetailRepository;
	this.orderDetailsOrderResClient=orderDetailsOrderResClient;
	
}

	@Override
	public OrderDetailResponseDTO save(OrderDetailRequestDTO orderDetailRequestDTO) throws Exception {
		OrderDetail orderDetail= orderDetailMappers.fromOrderDetailRequestDTO(orderDetailRequestDTO);
		Product product=orderDetailProductRestClient.getProduct(orderDetail.getProductId());
		OrderCustoner orderCustoner=orderDetailsOrderResClient.getOrderCustoner(orderDetail.getOrderId());
	    
		orderDetail.setId(UUID.randomUUID().toString());
		orderDetail.setOrderId(orderCustoner.getId());
		orderDetail.setProductId(product.getId());
		orderDetail.setPrice(product.getPrice());
		orderDetail.setQuantityOrder(orderCustoner.getQuantityOrder());
		
		OrderDetail saveOrderDetail= orderDetailRepository.save(orderDetail);
		saveOrderDetail.setProduct(product);
		saveOrderDetail.setOrderCustoner(orderCustoner);
		return orderDetailMappers.fromOrdertail(saveOrderDetail);
	}
	

	@Override
	public OrderDetailResponseDTO getDetail(String detailId) {
		OrderDetail orderDetail=orderDetailRepository.findById(detailId).get();
		Product product=orderDetailProductRestClient.getProduct(orderDetail.getProductId());
		OrderCustoner orderCustoner=orderDetailsOrderResClient.getOrderCustoner(orderDetail.getOrderId());
		orderDetail.setProduct(product);
		orderDetail.setOrderCustoner(orderCustoner);
		return orderDetailMappers.fromOrdertail(orderDetail);
	}

	@Override
	public List<OrderDetailResponseDTO> alldetails() {
		List<OrderDetail> orderDetails=orderDetailRepository.findAll();
		  for(OrderDetail detail: orderDetails) {
			  Product product=orderDetailProductRestClient.getProduct(detail.getProductId());
			  OrderCustoner orderCustoner=orderDetailsOrderResClient.getOrderCustoner(detail.getOrderId());
			   detail.setProduct(product);
			   detail.setOrderCustoner(orderCustoner);
		  }
		return orderDetails
				.stream()
				.map(odet->orderDetailMappers
				.fromOrdertail(odet))
				.collect(Collectors.toList());
	}


	@Override
	public List<OrderDetailResponseDTO> orderDetailByProductId(String productId) {
		List<OrderDetail> orderDetails=orderDetailRepository.findByProductId(productId);
		for(OrderDetail orderDetail: orderDetails) {
			Product product= orderDetailProductRestClient.getProduct(orderDetail.getProductId());
			orderDetail.setProduct(product);
		}
		return orderDetails
				.stream()
				.map(det->orderDetailMappers
				.fromOrdertail(det))
				.collect(Collectors.toList());
	}

	@Override
	public List<OrderDetailResponseDTO> allDetailByOrderId(String orderId) {
		List<OrderDetail> DetailOrders =orderDetailRepository.findByOrderId(orderId);
		for(OrderDetail ord: DetailOrders) {
			OrderCustoner orderCustoner=orderDetailsOrderResClient.getOrderCustoner(ord.getOrderId());
			 ord.setOrderCustoner(orderCustoner);
		}
		return DetailOrders.stream()
				.map(dets->orderDetailMappers
						.fromOrdertail(dets))
				.collect(Collectors.toList());
	}
	
 
	

}
