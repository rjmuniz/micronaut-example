package example.micronaut.services

import example.micronaut.models.Product
import example.micronaut.models.viewmodels.ProductViewModel
import javax.inject.Singleton

@Singleton
class ProductService {


    fun getAll(): List<ProductViewModel> {
        return ProductViewModel.parseAll(productList)
    }

    fun insert(product: Product) {
        productList.add(product)
    }
    
    companion object {
        private val productList: MutableList<Product> = mutableListOf(
            Product(123, "objeto 1", "objeto 1")
        )
    }

}