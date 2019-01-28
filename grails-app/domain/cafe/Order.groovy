package cafe

class Order {
    OrderStatus orderStatus
    Table cafeTable;

    static constraints = {
    }

    static hasMany = [productsInOrder: ProductInOrder]

    static mapping = {
        table "orders"
        cafeTable column: "cafe_table"
        productsInOrder cascade: 'all-delete-orphan'
    }

}
