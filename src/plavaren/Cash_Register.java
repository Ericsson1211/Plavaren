/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plavaren;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erikpaller
 */

public class Cash_Register {


    private Buy_Ticket buy_ticket = new Buy_Ticket() ;
    private Ticket_Adult ticket_adult = new Ticket_Adult();
    private Ticket_Children ticket_children = new Ticket_Children();
    private Ticket_Senior ticket_senior = new Ticket_Senior();
    private Ticket_Student ticket_student = new Ticket_Student();
    private int actual_capacity = 0;
    private List<Double> types_of_tickets= new ArrayList<>();
    double balance;
    public Cash_Register(){
        capacity_count_at_start();
    }
    public void Run_Cash_Register(){
        Buying_Ticket_Method_Register();
    }

    private void Buying_Ticket_Method_Register(){
        System.out.println("Momentalny stav kapacity je: " + actual_capacity);
        if ((actual_capacity >= 0) & (actual_capacity < 200)) {
            System.out.println("Pre kupu listok pouzite nasledujuci format: pocet + Adlt || Chld || Sen || Std (Adlt-Dospeli, Chld-Deti,Sen-Dochodcova,Std-Studenti) ");
            System.out.println("Pre uzavierku napiste pismeno X, pre ukoncenie programu stlacte Z");
            System.out.println("Zadajte vstup: ");
            Scanner scanner = new Scanner(System.in);

                if(scanner.hasNext("[x,X]")) {
                    show_balance();
                    Buying_Ticket_Method_Register();
                }
            if(scanner.hasNext("[z,Z]")) {
                show_balance();
                System.exit(0);
            }
                if(scanner.hasNextInt()) {
                    String amount = scanner.next();
                    int intAmount = Integer.valueOf(amount);
                    String type = scanner.next();
                    if((type.equals("Adlt")) || (type.equals("Chld")) || (type.equals("Sen")) || (type.equals("Std"))){//scanner.hasNext("[Adlt, Chld, Sen, Std]")) {

                        if (actual_capacity + intAmount < 200) {
                            buy_ticket.Byuing_Ticket_Method(type, intAmount);
                            System.out.println("Zakupili ste: " + intAmount + " " + type + " " + "listkov");
                            for(int i = actual_capacity ; i <= intAmount - 1; i++){
                                switch(type) {
                                    case "Adlt" : types_of_tickets.add(ticket_adult.getPrice());
                                        break;
                                    case "Chld" : types_of_tickets.add(ticket_children.getPrice());
                                        break;
                                    case "Sen" : types_of_tickets.add(ticket_senior.getPrice()) ;
                                        break;
                                    case "Std" : types_of_tickets.add(ticket_student.getPrice());
                                        break;
                                        }

                            }
                            actual_capacity = types_of_tickets.size();
                            Buying_Ticket_Method_Register();
                        } else {
                            System.out.println("Nemozete zakupit " + intAmount + " listkov, kvoli nedostatku kapacity");
                        }
                    }
                    else{
                        System.out.println("Zly zadany vstup, skus znova.");
                        Buying_Ticket_Method_Register();
                    }

            } else {
            System.out.println("Zly zadany vstup, skus znova.");
            Buying_Ticket_Method_Register();

            }
        } else {
            System.out.println("Dosiahli sme kapacitu plavarne, mate smolu. Skuste nabuduce.");
        }
    }

    private void show_balance() {
        for(int i = 0; i<= actual_capacity - 1;i++){
            balance += types_of_tickets.get(i);
        }
        System.out.println("Stav pokladnice je " + balance + " €");

    }
    private void capacity_count_at_start(){
        actual_capacity = ticket_adult.getAmount()+ticket_children.getAmount()+ticket_student.getAmount()+ticket_senior.getAmount();
}
}
