package action.study

class MenuManagement {

    fun menuManagement() {
        var menuFlag = true
        while(menuFlag) {
            println("1. 메뉴 생성 2. 메뉴 조회 3. 메뉴 수정 4. 메뉴 삭제 5.나가기")
            when (readLine()!!.toInt()) {
                1 -> {
                    println("메뉴 이름, 메뉴 가격, 메뉴 수량을 입력해주세요.")
                    val name = readLine().toString()
                    val price = readLine()!!.toInt()
                    val stockQuantity = readLine()!!.toInt()
                    // 객체를 하나만 사용할 수 있도록
                    Item().createItem(name, price, stockQuantity)
                }
                2 -> {
                    println("메뉴를 조회합니다.")
                    Item().getItem()
                }
                3 -> {
                    println("수정할 메뉴 이름, 메뉴 가격, 메뉴 수량을 입력해주세요.")
                    val name = readLine().toString()
                    val price = readLine()!!.toInt()
                    val stockQuantity = readLine()!!.toInt()
                    Item().updateItem(name, price, stockQuantity)
                }
                4 -> {
                    println("삭제할 메뉴 이름을 입력해주세요.")
                    val name = readLine().toString()
                    Item().deleteItem(name)
                }
                5 -> {
                    menuFlag = false
                }
            }
        }
    }
}