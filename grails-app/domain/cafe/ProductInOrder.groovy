package cafe

class ProductInOrder {
    String product;
    int quantity;
    double price
    static belongsTo = [order: Order]


    static constraints = {
    }

    static mapping = {
        table "products_in_order"
    }
}
