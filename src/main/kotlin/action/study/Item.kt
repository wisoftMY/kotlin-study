package action.study

class Item() {
    var name: String = ""
    var price: Int = 0
    var stockQuantity: Int = 0

    fun addStock(quantity: Int) {
        this.stockQuantity += quantity;
    }

    fun removeStock(quantity: Int) {
        val restStock = this.stockQuantity - quantity
        if (restStock < 0) {
            println("수량이 부족합니다. 현재 수량: ${stockQuantity}")
        }
        this.stockQuantity = restStock;
    }

    fun createItem(name: String, price: Int, stockQuantity: Int) {
        val item = Item()
        item.name = name
        item.price = price
        item.stockQuantity = stockQuantity

        ITEM_MAP[name] = item
    }

    fun getItem() {
        for (value in ITEM_MAP.values) {
            println("--------------------------")
            println("메뉴 이름: ${value.name}")
            println("메뉴 가격: ${value.price}")
            println("메뉴 수량: ${value.stockQuantity}")
        }
        println()

        println("메뉴 조회가 완료되었습니다.")
        println()
    }

    fun updateItem(name: String, price: Int, stockQuantity: Int) {
        val item = Item()
        item.name = name
        item.price = price
        item.stockQuantity = stockQuantity

        ITEM_MAP[name] = item

        println("메뉴 정보가 변경되었습니다.")
    }

    fun deleteItem(name: String) {
        ITEM_MAP.remove(name)

        println("메뉴가 삭제되었습니다.")
    }

}