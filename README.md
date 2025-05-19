Ana Aleksova 221145

Control Flow Graph
![si_lab2](https://github.com/user-attachments/assets/8d0d7a7e-7fc5-4619-a37a-99e2f2b1f5f4)

Цикломатска комплексност
Цикломатската комплексност на овој код е 9, ја пресметав со помош на формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=8, па цикломатската комплексност изнесува 9.


Тест случаи според критериумот Every statement
1. allItems==null
checkCart(null, "1234567812345678"); 
2. Invalid item
List<Item> items = List.of(new Item(null, 100, 0, 1.0));
checkCart(items, "1234567812345678");
3. Valid input, no discount, valid card
List<Item> items = List.of(new Item("Book", 5, 100, 0.0));
String cardNumber = "1234567812345678";
checkCart(items, cardNumber);
4. Item with discount and high price
List<Item> items = List.of(new Item("Laptop", 2, 500, 0.1));
String cardNumber = "1111222233334444";
checkCart(items, cardNumber);
5. Invalid cardnumber
List<Item> items = List.of(new Item("Pen", 10, 0, 1.0));
checkCart(items, null);
6. Invalid character in card number
List<Item> items = List.of(new Item("Pen", 10, 0, 1.0));
checkCart(items, "1234abcd5678ABCD");

Тест случаи според критериумот Multiple Condition за условот
if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
TC1: price=100, discount=0.0, quantity=1 → F F F 
TC2: price=100, discount=0.0, quantity=15 → F F T 
TC3: price=100, discount=0.2, quantity=1 → F T F 
TC4: price=100, discount=0.2, quantity=15 → F T T 
TC5: price=400, discount=0.0, quantity=1 → T F F
TC6: price=400, discount=0.0, quantity=15 → T F T 
TC7: price=400, discount=0.2, quantity=1 → T T F 
TC8: price=400, discount=0.2, quantity=15 → T T T 

Објаснување на напишаните unit tests

Функцијата testEveryStatementCases() ги покрива сите тест случаи според Every Statement критериумот 
Функцијата testPriceDiscountQuantityCombinations() го покрива условот if (item.getPrice() > 300  item.getDiscount() > 0  item.getQuantity() > 10) според Multiple Condition критериумот



