package org.orderDetail.web;



import java.util.List;

import org.orderDetail.dto.OrderDetailRequestDTO;
import org.orderDetail.dto.OrderDetailResponseDTO;
import org.orderDetail.services.OrderDetailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OrderDetailController {
	private OrderDetailService orderDetailService;
	
	public OrderDetailController(OrderDetailService orderDetailService) {
		super();
		this.orderDetailService = orderDetailService;
	}

	@GetMapping(path="/orderdetails/{id}")
	public OrderDetailResponseDTO getDetailResponseDTOs(@PathVariable(name="id")  String detailId){
		return orderDetailService.getDetail(detailId);
		
	}
	
    @PostMapping(path="/orderdetails")
	public OrderDetailResponseDTO save(@RequestBody OrderDetailRequestDTO orderDetailRequestDTO) throws Exception {
		return orderDetailService.save(orderDetailRequestDTO);
		
	}
    @GetMapping(path="/products/{productId}")
     List<OrderDetailResponseDTO> getallDetailResponseDTOs(@PathVariable String productId){
    	 
		return orderDetailService.orderDetailByProductId(productId);
    	 
     }
    
    @GetMapping(path="/orders/{orderId}")
    List<OrderDetailResponseDTO> getallDetailsorders(@PathVariable String orderId){
   	 
		return orderDetailService.allDetailByOrderId(orderId);
		
		
   	 
    }
    
      @GetMapping(path="/orderdetails")
    public List<OrderDetailResponseDTO> getAllDetails(){
    	return orderDetailService.alldetails();
    }
      @GetMapping(path="/products/{id}")
       public List<OrderDetailResponseDTO> allByProductId(@PathVariable(name="id") String productId){
    	   return orderDetailService.orderDetailByProductId(productId);
       }
      
     
      @GetMapping(path="/orders/{id}")
      public List<OrderDetailResponseDTO> allByOrders(@PathVariable(name="id") String orderId){
   	   return orderDetailService.allDetailByOrderId(orderId);
      }
}
