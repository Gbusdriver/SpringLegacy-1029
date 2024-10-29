package com.rest.service;

import java.util.ArrayList;

import com.rest.vo.Customer;

//Controller를 위한 인터페이스
public interface CustomerService {
	public ArrayList<Customer> selectAll()throws Exception;//모든 글정보
	public ArrayList<Customer> findByAddress(String address)throws Exception;//모든 글정보
	public Customer selectOne(String num)throws Exception;//모든 글정보
	public void insert(Customer b)throws Exception;
	public void update(Customer b)throws Exception;
	public int delete(String num)throws Exception;
	
}
