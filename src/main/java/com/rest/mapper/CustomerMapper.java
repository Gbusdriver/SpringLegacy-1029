package com.rest.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.rest.vo.Customer;

//Controller를 위한 인터페이스
@Mapper
public interface CustomerMapper {
	public ArrayList<Customer> selectAll()throws Exception;//모든 글정보
	public Customer selectOne(String num)throws Exception;//모든 글정보
	public void insert(Customer b)throws Exception;
	public int delete(String num)throws Exception;
	public void update(Customer b)throws Exception;
	public ArrayList<Customer> findByAddress(String address)throws Exception;
}
