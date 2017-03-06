/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plavaren;


/**
 *
 * @author erikpaller
 */
public class Ticket_Adult implements Ticket {

    private int amount;

    public Ticket_Adult() {
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
    @Override
    public double getPrice() {
        double price = 5;
        return price;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = this.amount + amount;
    }


}
