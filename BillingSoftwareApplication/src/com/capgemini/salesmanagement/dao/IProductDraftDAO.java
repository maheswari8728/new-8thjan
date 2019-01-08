package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.ProductBean;

public interface IProductDraftDAO {
	
	ProductBean getProductDetails(int productCode);
	boolean insertSalesDetails(ProductBean product);

}
