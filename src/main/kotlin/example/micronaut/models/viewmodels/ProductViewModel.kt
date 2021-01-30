package example.micronaut.models.viewmodels

import example.micronaut.models.Product

class ProductViewModel(
    val id:String,
    val name:String
)
{
    companion object{
        fun parse(product:Product): ProductViewModel{
            return ProductViewModel(product.id.toString(), product.name)
        }

        fun parseAll(productList:List<Product>):List<ProductViewModel>{
            return productList.map { parse(it) }
        }
    }
}