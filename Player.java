import java.util.Scanner;
import javax.swing.JOptionPane;
class Player {
    private Hand playerHand = new Hand();
    private static int index;
    private int value;
    private GUI window;
    Scanner sc = new Scanner(System.in);
    /**
     * @para 1 int fine
     * Prints card in player's hand
     */
    public Player (int fine) {
        this.value = fine;
        window=GUI.getGUI();
        //System.out.println ("Player's Hand");
        //System.out.println ("****************");
        //initDeal();
    }

    /**
     * method to recognize cards in player's hand
     * evaluate the value of the cards in player's hand
     */
    public void initDeal() {
        playerHand.initialDeal();
        playerHand.printHand();
        playerHand.evaluateHand();
    }

    /**
     * returns the integer value of the cards in player's hand
     */
    public int getHandValue () {
        return playerHand.evaluateHand();
    }

    /**
     * para@1 dealer's hand value
     * compare the values of cards in player's and dealer's hand
     */
    public void compareHands(int dealerHandValue) {
        int playerHandValue = getHandValue();
        if (playerHandValue > dealerHandValue && playerHandValue <= 21) {
            System.out.println ("*** Player Wins");
            JOptionPane.showMessageDialog(null,"Player Wins");
        } else if ( playerHandValue < dealerHandValue && dealerHandValue <= 21) {
            System.out.println ("*** Dealer Wins");
            JOptionPane.showMessageDialog(null,"Dealer Wins");
        } else if (playerHandValue == dealerHandValue) {
            System.out.println ("*** That's a Tie");
            JOptionPane.showMessageDialog(null,"That's a Tie");
        }
    }

    public boolean playAgain () {
        System.out.print ("Would you like to play? [y/n]: ");
        window.setQues("Would you like to play?");
        //String option = sc.next();
        String option = window.getResponse();
        System.out.println(option);
        boolean out = (option.equals("y"));
        if (option.equals("n")) {
            System.out.println("No");
            return false;
        } else {
            System.out.println("Yes");
            return true;
        }
    }

    public boolean hasPurse(int purse) {
        if (purse > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int bet(int purse) {
        int ok = 0;
        System.out.print("Purse = ");
        System.out.println(purse);
        window.setPurse(purse);
        System.out.print ("How much would you like to bet? ");
        window.setQues("How much would you like to bet? ");
        //int bet = sc.nextInt();
        int bet = window.getInput();
        if (bet <= purse) {
            ok = bet;
        } else {
            ok = bet;
            System.out.println ("Don't have enough purse value");
            JOptionPane.showMessageDialog(null,"Don't have enough purse value");
        }
        return ok;
    }

    public void playHand() {
        System.out.print ("Would you like to draw another card? ");
        window.setQues("Would you like to draw another card? ");
        String cOption = window.getResponse();//sc.next();
        System.out.println(cOption);
        if (cOption.equals("n")) {
            //compareHands(dealer.getHandValue());
            System.out.println("No");
        } else {
            System.out.println("Yes");
            int handCount = 0;
            for (int i = 0; i < playerHand.hand.length; i++) {
                if (playerHand.hand[i] != null) {
                    handCount++;
                }
            }
            playerHand.hand[handCount] = playerHand.deal();
        }
    }
}
