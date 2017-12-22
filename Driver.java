class Driver {
    public static void main (String[] args) {
        GUI window = GUI.getGUI();
        System.out.println ("Welcome to the BlackJack table!");
        System.out.println ("Best of Luck! :) ");
        System.out.println ("");
        int purse = 100;
        window.setPurse(purse);
        Dealer dealer = new Dealer();
        Player player = new Player(purse);
        //System.out.println("");
        boolean some = player.playAgain();
        while (some) {
            int get = player.bet(purse);
            //player.bet(purse);
            if (get <= purse) {
                //System.out.println (get);
                System.out.println ("Dealer's Hand");
                System.out.println ("****************");
                dealer.initDeal();
                System.out.println ("Dealer's value = " + dealer.getHandValue());
                window.setDealerDisplay("Dealer's value = " + dealer.getHandValue(),false);
                System.out.println ("Player's Hand");
                System.out.println ("****************");
                player.initDeal();
                System.out.println ("Hand Value = " + player.getHandValue());
                window.setPlayerDisplay("Hand Value = " + player.getHandValue(),false);
                if (player.getHandValue() < dealer.getHandValue()) {
                    purse = purse - get;
                } else if (player.getHandValue() > dealer.getHandValue()) {
                    purse = purse + get;
                } else if (player.getHandValue() == dealer.getHandValue()) {
                    purse = purse;
                }
                player.playHand();
                System.out.println ("Hand Value = " + player.getHandValue());
                window.setPlayerDisplay("Hand Value = " + player.getHandValue(),false);
                dealer.playHand();
                System.out.println ("Dealer's value = " + dealer.getHandValue());
                window.setDealerDisplay("Dealer's value = " + dealer.getHandValue(),false);
                player.compareHands(dealer.getHandValue());
            } else {
                System.out.println("");
            }
            System.out.print ("Purse = ");
            System.out.println (purse);
            window.setPurse(purse);
            System.out.println ("");
            some = player.playAgain();
            dealer = new Dealer();
            System.out.print("\f");
            window.setPlayerDisplay("",true);
            window.setDealerDisplay("",true);
            //player.playAgain();
        }
        System.out.println ("See you Bro!");
        System.exit(0);
    } //end main method
} //end class
