package com.rest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.mapper.CustomerMapper;
import com.rest.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerMapper mapper;

	@Override
	public ArrayList<Customer> selectAll() throws Exception {
		return mapper.selectAll();
	}

	@Override
	public Customer selectOne(String num) throws Exception {
		return mapper.selectOne(num);
	}

	@Override
	public void insert(Customer b) throws Exception {
		mapper.insert(b);		
	}

	@Override
	public int delete(String num) throws Exception {
		return mapper.delete(num);
	}

	@Override
	public void update(Customer b) throws Exception {
		mapper.update(b);
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) throws Exception {
		return mapper.findByAddress(address);
	}

}
