package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.CustomerService;
import com.rest.vo.Customer;
//@RestController: @Controller + @ResponseBody(java -> json)

// 외부에서 리소스를 요청할 때, 해당 url에 대한 요청에 대해서만 리소스 접근을 허락.

/* 다른 url에서 리소스를 요청해도 리소스를 보내주지만, 
웹 브라우저가 Header를 분석하여 origin이 false로 되어 있을 경우 데이터를 사용하지 않는다. */

@CrossOrigin("http://127.0.0.1:5500")
// @CrossOrigin("*") 모든 요청에 대해 resoure 사용 허용.
@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	
	
	// http://localhost:8080/rest/customers	
	@GetMapping("customers")
	public List<Customer> selectAll() throws Exception {
		List<Customer> list = service.selectAll();
		System.out.println("selectAll()");
		System.out.println(list.size());
		return list;//data
	}
	
	//ResponseEntity:작업한 결과 데이터와 함께 http 상태코드를 제어할 수 있는 객체
	/*
	 * @GetMapping("customers") public ResponseEntity<List<Customer>>selectAll()
	 * throws Exception { List<Customer> list = service.selectAll();
	 * 
	 * ResponseEntity<List<Customer>> re = new ResponseEntity<List<Customer>>(list,
	 * HttpStatus.OK);
	 * 
	 * //new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * return re;//data }
	 */

	// http://localhost:8080/rest/customers/123
	@GetMapping("customers/{num}")
	public Customer selectOne(@PathVariable("num") String num) throws Exception {
		Customer c = service.selectOne(num);
		return c;
	}

	@DeleteMapping("customers/{num}")
	public Map<String, String> delete(@PathVariable("num") String num) throws Exception {
		int c = service.delete(num);

		Map<String, String> map = new HashMap<>();
		if (c >= 1)
			map.put("msg", "삭제성공");
		return map;
	}

	@PostMapping("customers")
	public ResponseEntity<String> insert(@RequestBody Customer c) throws Exception {//json ->java object
		System.out.println("insert");
		System.out.println(c);
		service.insert(c);
		
		return new ResponseEntity<String>("insert success!!!", HttpStatus.OK);
	}

	@PutMapping("customers")
	public Map<String, String> update(@RequestBody Customer c) throws Exception {// json ->java object
		service.update(c);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "수정성공");
		return map;
	}

	// Get:: http://localhost:8080/rest/customers/{condition}/{value}
	//public List<Customer> findByAddress(@PathVariable String condition,@PathVariable String value )
	// Get:: http://localhost:8080/rest/customers/address/seoul
	@GetMapping("customers/address/{address}")
	public List<Customer> findByAddress(@PathVariable("address") String address) throws Exception {
		List<Customer> list = service.findByAddress(address);
		System.out.println(list.size());
		return list;
	}

}







