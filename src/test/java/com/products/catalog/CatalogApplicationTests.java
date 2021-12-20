package com.products.catalog;

import com.products.catalog.model.Product;
import com.products.catalog.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CatalogApplicationTests {

	@Autowired
	ProductService productService;

	@Test
	void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
		List<Product> productList = productService.getAll();
		Assert.assertEquals(3, productList.size());
	}
}
