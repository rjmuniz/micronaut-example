package example.micronaut.controllers

import example.micronaut.models.viewmodels.ProductViewModel
import example.micronaut.services.ProductService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/product")
class ProductController(private  val productService: ProductService) {

    @Get(uri="/", produces=["application/json"])
    fun index(): List<ProductViewModel> {
        return productService.getAll();
    }
}