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
public class Ticket_Children implements Ticket{

    private int amount;

    public Ticket_Children(){
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public double getPrice() {
        double price = 0;
        return price;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = this.amount + amount;
    }

}
