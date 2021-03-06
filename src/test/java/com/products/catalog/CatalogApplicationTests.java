package com.products.catalog;

import com.products.catalog.model.Product;
import com.products.catalog.model.ProductImage;
import com.products.catalog.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	void whenCreateProduct_thenReturnCreated(){

		Set<ProductImage> images = new HashSet<>();
		images.add(new ProductImage(true, "url1"));
		images.add(new ProductImage(false, "url2"));
		images.add(new ProductImage(false, "url3"));

		Product product = new Product("FAL-SkuTest", "name prod", "brand prod", "L", 123.45f, images);

		Product productCreated = this.productService.create(product);
		Assert.assertEquals("brand prod", productCreated.getBrand());
	}

	@Test
	void whenUpdateProduct_thenReturnUpdated(){
		Optional<Product> productSelected = this.productService.findBySku("FAL-8406270");

		Assert.assertEquals("NEW BALANCE", productSelected.get().getBrand());
		productSelected.get().setBrand("ADIDAS");
		Product productUpdated = this.productService.update(productSelected.get());
		Assert.assertEquals("ADIDAS", productUpdated.getBrand());
	}

	@Test
	void whenDeleteProductNySku_thenRemoveInDB(){
		List<Product> productList = productService.getAll();
		Assert.assertEquals(3, productList.size());

		productService.deleteBySku("FAL-881952283");

		List<Product> productListAfterDelete = productService.getAll();
		Assert.assertEquals(2, productListAfterDelete.size());

		String skuProductFirstInDB = productListAfterDelete.get(0).getSku();
		String skuProductSecondInDB = productListAfterDelete.get(1).getSku();
		Assert.assertTrue((skuProductFirstInDB.equalsIgnoreCase("FAL-8818985")) ||
				(skuProductFirstInDB.equalsIgnoreCase("FAL-8406270")));
		Assert.assertTrue((skuProductSecondInDB.equalsIgnoreCase("FAL-8818985")) ||
				(skuProductSecondInDB.equalsIgnoreCase("FAL-8406270")));
	}
}
