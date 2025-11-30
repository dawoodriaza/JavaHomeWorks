package com.nbod;



import java.util.*;

abstract class AccountTransactions {

    private Double currentBalance = 0.0;


  public static Map<String, Integer> customers = new HashMap<>(
          Map.of("Dawood",50 ,"Hamza",250)
  );


  public S


    public static void main(String[] args) {




        System.out.println("customers = " + customers);
customers.forEach((name, amount) -> {
            System.out.println("name = " + name + " amount = " + amount);
        });
    }




}
