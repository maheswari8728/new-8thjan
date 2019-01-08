package com.capgemini.salesmanagement.ul;

import java.util.Scanner;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.dao.IProductDraftDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class Client {
	
	static IProductDraftDAO productDraftDAO=null;
	static ProductDAO productDAO=null;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ProductBean product=new ProductBean();
		int option=0;
		while(true)
		{
			System.out.println("*******************BillingSoftware**************************");
			System.out.println("1.ProductDetails");
			System.out.println("2.SalesDetails");
			System.out.println("3.Exit");
			System.out.println("************************************************************");
			System.out.println("Please enter a choice");
			try {
				option=sc.nextInt();
				switch(option) {
				
				case 1:while(product==null) {
					product=populateProductBean();
				}
				}
				
			}catch(Exception exception) {
				
			}
		}
		
		
	}

	private static ProductBean populateProductBean() {
		
		ProductBean product=new ProductBean();
		System.out.println("Enter product code");
		product.setProductCode(sc.next());
		System.out.println("Enter product name");
		product.setProductName(sc.next());
		System.out.println("Enter product category");
		product.setProductCategory(sc.next());
		System.out.println("Enter product description");
		product.setProductDescription(sc.next());
		System.out.println("Enter product price");
		product.setProductPrice(sc.next());
		
		try {
			
		}catch(Exception e) {
			
		}
		return null;
	}

}
