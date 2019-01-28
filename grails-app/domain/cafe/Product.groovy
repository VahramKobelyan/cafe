package cafe

class Product {
    String name
    double price


    static constraints = {
        name unique: true
        price validator: { if (it <= 0) return ['validation.priceErrorMessage'] }
    }

    static mapping = {
        table "products"
    }
}
