package com.example.supplychain;

public class Order {
    public static boolean placeSingleOrder(Product product, String customerEmail){
        String orderQuery = String.format("INSERT  INTO orders (quantity, customer_id, product_id, status) VALUES(1, (SELECT cid FROM customer WHERE email = '%s'), %s, 'ORDERED')",
        customerEmail, product.getId()
                );
        DatabaseConnections dbConn = new DatabaseConnections();
        if(dbConn.insertData(orderQuery)>=1){
            return true;
        }

        System.out.println(orderQuery);

        return false;
    }
}
