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
import java.util.Optional;

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

	@Test
	void whenSelectProductBySku_thenRetrieveCorrect(){
		Optional<Product> productSelected = this.productService.findBySku("FAL-8406270");
		Assert.assertNotNull(productSelected.get());
		Assert.assertEquals("500 Zapatilla Urbana Mujer", productSelected.get().getName());
	}

	@Test
	void whenSelectProductBySku_thenRetrieveEmpty(){
		Optional<Product> productSelected = this.productService.findBySku("FAL-12345");
		Assert.assertTrue(productSelected.isEmpty());
	}

	@Test
	void whenUpdateProduct_thenReturnUpdated(){
		Optional<Product> productSelected = this.productService.findBySku("FAL-881952283");

		Assert.assertEquals("JEEP", productSelected.get().getBrand());
		productSelected.get().setBrand("CAT");
		Product productUpdated = this.productService.update(productSelected.get());
		Assert.assertEquals("CAT", productUpdated.getBrand());
	}
}
