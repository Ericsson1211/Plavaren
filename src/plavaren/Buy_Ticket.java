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
public class Buy_Ticket {
    Ticket_Adult ticket_adult = new Ticket_Adult();
    Ticket_Children ticket_children = new Ticket_Children();
    Ticket_Senior ticket_senior = new Ticket_Senior();
    Ticket_Student ticket_student = new Ticket_Student();
    public Buy_Ticket() {

    }

    public void Byuing_Ticket_Method(String type, int intAmount){
        switch (type){
            case "Adlt":
                ticket_adult.setAmount(intAmount);
                break;
            case "Chld":
                ticket_children.setAmount(intAmount);
                break;
            case "Sen":
                ticket_senior.setAmount(intAmount);
                break;
            case "Std":
                ticket_student.setAmount(intAmount);
                break;
        }

    }

}
