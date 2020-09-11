import com.sun.org.apache.xpath.internal.operations.Or

// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val products = customers.flatMap(Customer::getOrderedProducts).toSet()
    return customers.fold(products, {all, customer -> all.intersect(customer.getOrderedProducts())})
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)