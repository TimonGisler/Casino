/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.math.BigDecimal;

/**
 *
 * @author timon
 */
public class MOCK {
    BigDecimal money = new BigDecimal("1000");
    String name = "Hans";

    public BigDecimal getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addMoney(BigDecimal amount){
        this.money.add(amount);
    }
    
    public void subMoney(BigDecimal amount){
        setMoney(this.money.subtract(amount));
    }
    
}
