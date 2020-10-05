/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author timon
 */
public class CherryModel {

    final ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
    BigDecimal paiedIn = new BigDecimal("0");
    Random rand = new Random();
    boolean hold = false;
    boolean step = false;
    BigDecimal wonLastTime;
    BigDecimal safe = new BigDecimal("0");
    BigDecimal payInAmount = new BigDecimal("50");
    MOCK mock = new MOCK();

    public ArrayList<Integer> getOneDrum() {
        Collections.shuffle(numbers);

        return numbers;
    }

    public boolean checkIfWon(int drum1, int drum2, int drum3) {
        //Cherry check
        if (drum1 == 1 || drum2 == 1 || drum3 == 1) {
            System.out.println("Cherry detected");
            return true;
        }else if (drum1 == drum2 && drum1 == drum3) {
            return true;
        } else {
            return false;
        }
    }

    public void setPaiedIn(BigDecimal eingeworfen) {
        this.paiedIn = eingeworfen;
    }

    public void payIn(BigDecimal eingeworfen) {
        setPaiedIn(this.paiedIn.add(eingeworfen));
    }

    public BigDecimal getPaiedIn() {
        return paiedIn;
    }

    public void checkIfTwo(int drum1, int drum2, int drum3) {
        System.out.println("checkiftwo");

        if (drum1 == drum2 || drum1 == drum3 || drum2 == drum3) {
            if (rand.nextInt(10) >= 1) {
                hold = true;
                System.out.println("HOLD = TRUE");
            } else {
                step = true;
                System.out.println("STEP = TRUE");
            }
        } else {
            hold = false;
            step = false;
        }
    }

    public boolean isHold() {
        return hold;
    }

    public boolean isStep() {
        return step;
    }

    public int whichDrumDifferent(int drum1, int drum2, int drum3) {
        if (drum1 == drum2 && drum1 == drum3) {
            System.out.println("Fehler, alle sind gleich");
            return 0;
        } else if (drum1 == drum2) {
            return 3;
        } else if (drum1 == drum3) {
            return 2;
        } else if (drum2 == drum3) {
            return 1;
        } else {
            System.out.println("Fehler: Alle sind verschieden");
            return 0;
        }
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public void setStep(boolean step) {
        this.step = step;
    }

    public int checkWhatWon(int drum1, int drum2, int drum3) {
        System.out.println("Checkwhatwon" + drum1 + drum2 + drum3);

        if (drum1 == 1 || drum2 == 1 || drum3 == 1) {
            if (drum1 == 1 && drum2 == 1 || drum1 == 1 && drum3 == 1 || drum2 == 1 && drum3 == 1) {
                return 22;
            } else {
                return 21;
            }
        } else {
            return drum1;
        }
    }

    public void multiplyPaiedIn(BigDecimal multiplier) {
        paiedIn = paiedIn.multiply(multiplier);
        wonLastTime = paiedIn;
        System.out.println("You have:" + paiedIn);
        System.out.println("should multiply money by: " + multiplier);
        System.out.println(paiedIn);

    }

    public BigDecimal whatIsReward(int winningSymbol) {
        System.out.println("WHATISREWARD");
        BigDecimal Reward = new BigDecimal("0");
        double i = 50;
        switch (winningSymbol) {
            case 0:
                //Bell
                Reward = new BigDecimal("50");
                System.out.println(Reward);
                break;

            case 1:
                //Cherry
                Reward = new BigDecimal("20");
                System.out.println(Reward);
                break;

            case 2:
                //grape
                Reward = new BigDecimal("2");
                System.out.println(Reward);
                break;

            case 3:
                //kleeblatt
                Reward = new BigDecimal("5");
                System.out.println(Reward);
                break;

            case 4:
                //lemon
                Reward = new BigDecimal("5");
                System.out.println(Reward);
                break;

            case 5:
                //melon
                Reward = new BigDecimal("10");
                System.out.println(Reward);
                break;

            case 6:
                //orange
                Reward = new BigDecimal("2");
                System.out.println(Reward);
                break;

            case 7:
                //seven
                Reward = new BigDecimal("10");
                System.out.println(Reward);
                break;

            case 8:
                //star
                Reward = new BigDecimal("99");
                System.out.println(Reward);
                break;

            case 21:
                Reward = new BigDecimal("2");
                System.out.println(Reward);
                break;

            case 22:
                Reward = new BigDecimal("4");
                System.out.println(Reward);
                break;

            default:
                throw new AssertionError();
        }
        return Reward;
    }

    public BigDecimal bonus() {
        MathContext mc = new MathContext(1, RoundingMode.DOWN);
        BigDecimal bonus = getPaiedIn();
        bonus = bonus.divide(new BigDecimal("10"), mc);
        bonus = bonus.setScale(1, RoundingMode.DOWN);

        return bonus;
    }

    public BigDecimal getWonLastTime() {
        return wonLastTime;
    }

    public void safe() {
        System.out.println(paiedIn);
        if (paiedIn.intValue()- safe.intValue() >= 1) {
            BigDecimal s;
            s = paiedIn.divide(new BigDecimal("10"));
            System.out.println("SAFES: " + s);
            System.out.println("ADD =  ");
            safe = safe.add(s);
        }
        System.out.println("OFFIZIELLES SAFE ISCH:" + this.safe);

    }

    public void setSafe(BigDecimal safe) {
        this.safe = safe;
    }

    public void gambleWon() {
        paiedIn = paiedIn.subtract(safe).multiply(new BigDecimal("2"));
        paiedIn = paiedIn.add(safe);
    }

    public void mysterieWon(BigDecimal factor) {
        paiedIn = paiedIn.subtract(safe).multiply(factor);
        paiedIn = paiedIn.add(safe);

    }

    public BigDecimal getPayInAmount() {
        return payInAmount;
    }

    public void addPayInAmount(BigDecimal amount) {

        payInAmount = payInAmount.add(amount);
        
    }

    public void subPayInAmount(BigDecimal amount) {
        if (payInAmount.subtract(amount).compareTo(new BigDecimal("0")) == -1) {
            
        }else{
        payInAmount = payInAmount.subtract(amount);
        }
    }
}
