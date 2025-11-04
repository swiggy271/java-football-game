import java.util.Scanner;
import java.util.Random;
public class TextAdventure {
    public static void main(String[] args) {

        // object setup, var initialization
        Scanner sc = new Scanner(System.in);
        Random randPerc = new Random(); // randPerc.nextInt(101)
        boolean running = true, interception = false, possesion;
        int yds, scrmYds, down, change;
        int Dchoice = 0;
        int Ochoice = 0;
        int p1Score = 0;
        int p2Score = 0;
        
        // repeating the game as many times as the user wants
        while(running)
        {
            while (Ochoice != 1)
            {
                System.out.print("\n\n\nWelcome to swiggys two player football game!!\n\nOptions:\n1. Play!!!\n2. HELP!!\n\nEnter choice: ");

                // menu options & help
                Ochoice = sc.nextInt();
                switch (Ochoice)
                {
                    case 1:
                        break;
                    case 2:
                        System.out.print("\n\nThis is swiggys two player football game, a football text game. \nYou will be given choices for which play to run, and your goal is to make successful plays that work against your opponents strategy to score touchdowns. \nGet to the line of scrimmage for your down counter to reset. If it passes 4, turnover! Now go go go!!!!!");
                }
            }

            // 2 halves per game
            for(int h = 0; h < 2; h++) {
                // reset the game
                yds = 50;
                scrmYds = 10;
                down = 1;


                // possesion = true ---- player 1 possesses the ball, p2 starts in the second half
                if (h == 0)
                {
                    possesion = true;
                }
                else
                {
                    possesion = false;
                }
                for (int i = 0; i < 15; i++) {
                    // game stats
                    System.out.print("\n\n\nPlays left in half:" + (15 - i) + "\nYds to LoS: " + scrmYds + "\nYds to TD: " + yds + "\nDown (/4): " + down + "\np1 score: " + p1Score + "\np2 score: " + p2Score + "\n\nPLAYER 1:");
                    interception = false;
                    change = 0;

                    // p1 choices
                    if (possesion) {
                        // play choices
                        System.out.print("\nYou have the ball. Choices:\n1. Long forward pass\n2. Short forward pass\n3. RB through middle\n4. RB through edges\n5. FG Attempt\n\nEnter choice: ");
                        Ochoice = sc.nextInt();
                    } else {
                        // defense choices
                        System.out.print("\nYou DO NOT have the ball. Choices:\n1. Central defense\n2. Spread defense\n3. Long defense\n\nEnter choice: ");
                        Dchoice = sc.nextInt();
                    }

                    // p2 choices
                    // wall of text blocks p2 from viewing p1 choice
                    for (int j = 0; j < 35; j++) {
                        System.out.print("\nP2 PLAY NOW DO NOT SCROLL UP CHEATER!!!");
                    }

                    // game stats
                    System.out.print("\n\n\nPlays left in half:" + (15 - i) + "\nYds to LoS: " + scrmYds + "\nYds to TD: " + yds + "\nDown (/4): " + down + "\np1 score: " + p1Score + "\np2 score: " + p2Score + "\n\nPLAYER 2:");


                    if (!possesion) {
                        // play choices
                        System.out.print("\nYou have the ball. Choices:\n1. Long forward pass\n2. Short forward pass\n3. RB through middle\n4. RB through edges\n5. FG Attempt\n\nEnter choice: ");
                        Ochoice = sc.nextInt();
                    } else {
                        // defense choices
                        System.out.print("\nYou DO NOT have the ball. Choices:\n1. Central defense\n2. Spread defense\n3. Long defense\n\nEnter choice: ");
                        Dchoice = sc.nextInt();
                    }


                    // wall of text blocks p1 from viewing p2 choice
                    for (int j = 0; j < 35; j++) {
                        System.out.print("\nBOTH PLAYERS LOOK NOW!!");
                    }

                    // shows both players choices
                    System.out.print("\n\nOffense chose: " + Ochoice+ "\nDefense chose: " + Dchoice);
                    
                    // calculate yardage gain or other change
                    switch (Ochoice) {
                        case 1: {
                            // long passing play - high reward but high risk as well
                            switch (Dchoice) {
                                case 1: {
                                    if (randPerc.nextInt(101) < 65) {
                                        System.out.print("\nSACKED!!");
                                        change = 0;                          
                                    } else {
                                        change = 15;
                                    }
                                    break;
                                }
                                case 2: {
                                    if (randPerc.nextInt(101) < 33) {
                                        System.out.print("\nSACKED!!");
                                        change = 0;
                                    } else if (randPerc.nextInt(101) < 35) {
                                        change = 9;
                                    } else {
                                        change = 15;
                                    }
                                    break;
                                }
                                case 3: {
                                    if (randPerc.nextInt(101) < 50) {
                                        System.out.print("\nIncomplete");
                                        change = 0;
                                    } else if (randPerc.nextInt(101) < 33) {
                                        interception = true;
                                    } else {
                                        change = 10;
                                    }
                                    break;
                                }
                            }

                        }
                        break;

                        // short passing play
                        case 2: {
                            if (Dchoice != 3) {
                                if (randPerc.nextInt(101) < 50) {
                                    System.out.print("\nIncomplete");
                                    change = 0;
                                } else if (randPerc.nextInt(101) < 20) {
                                    interception = true;
                                } else if (randPerc.nextInt(101) < 25) {
                                    change = 10;
                                } else {
                                    change = 3;
                                }
                            } else {
                                if (randPerc.nextInt(101) < 25) {
                                    change = 20;
                                } else if (randPerc.nextInt(101) < 50) {
                                    System.out.print("\nIncomplete");
                                    change = 0;
                                } else {
                                    change = 9;
                                }
                            }
                        }
                        break;

                        // RB through center, high confidence low gain
                        case 3: {
                            if (Dchoice != 3) {
                                if (randPerc.nextInt(101) < 50) {
                                    change = 4;
                                } else if (randPerc.nextInt(101) < 25) {
                                    change = 2;
                                } else {
                                    change = 7;
                                }
                            } else {
                                change = 6;
                            }
                        }
                        break;

                        // RB through edges, riskier but chance of decent gain
                        case 4: {
                            if (randPerc.nextInt(101) < 60) {

                                change = 3;
                            } else if (randPerc.nextInt(101) < 65) {
                                change = 0;
                            } else {
                                change = 9;
                            }
                        }
                        break;
                    }

                    // debug
                    // System.out.print("\n\n\n\nDEBUG:\nCHANGE:" + change);

                    // output & calculate gain
                    if (Ochoice != 5) {

                        if (interception) {

                            System.out.print("\nINTERCEPTION!!!");
                            yds = 100 - yds;
                            scrmYds = 10;
                            down = 1;
                            possesion = !possesion;
                        } else {
                            if (yds - change < 1) {
                                // touchdown
                                System.out.print("\nTOUCHDOWN!!!");
                                if (possesion) {
                                    p1Score += 6;
                                } else {
                                    p2Score += 6;
                                }
                                possesion = !possesion;
                                yds = 50;
                                scrmYds = 10;
                                down = 1;
                            } else {
                                if (scrmYds - change < 1) {
                                    // scrimmage passed; first down
                                    System.out.print("\nGOOD FOR FIRST!!! YDS GAINED: " + change);
                                    yds -= change;
                                    scrmYds = 10;
                                    down = 1;
                                } else {
                                    if (down > 3) {
                                        // exceeds down limit
                                        System.out.print("\nTURNOVER!!");
                                        possesion = !possesion;
                                        yds = 100 - yds;
                                        scrmYds = 10;
                                        down = 1;
                                    }
                                    // nothing special just 0+ yds gained
                                    System.out.print("\n" + change + " yds gained");
                                    yds -= change;
                                    scrmYds -= change;
                                    down++;
                                }
                            }
                        }
                    } else {
                        // if punting, scales by distance/2
                        if (randPerc.nextInt(101) < (100 - (yds / 2))) {
                            System.out.print("\nGOOD!");
                            if (possesion) {
                                p1Score += 3;
                            } else {
                                p2Score += 3;
                            }
                            possesion = !possesion;
                            yds = 50;
                            scrmYds = 10;
                            down = 1;
                        } else {
                            System.out.print("\nDOINK!! YIKES!!!!!");
                            possesion = !possesion;
                            yds = 100 - yds;
                            scrmYds = 10;
                            down = 1;
                        }
                    }
                }
            }
            
            // to repeat
            System.out.print("\n\n\nGAME END!!!\nSCORE:\np1: " + p1Score + "\np2: " + p2Score + "\n\nPlay again? y/n: ");
            if (sc.next() == "n")
            {
                running = false;
            }
        }
    }
}



