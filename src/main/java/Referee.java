import sun.invoke.empty.Empty;

import java.util.Random;

public class Referee {

    private Playable pX;
    private Playable p0;
    private Playboard board;

    public Referee(Playboard board, Playable a, Playable b) {
        this.board = board;

        Random r = new Random();
        if (r.nextBoolean()) {

            this.pX = a;
            a.setSymbol(Symbol.SYMBOL_X);

            this.p0 = b;
            b.setSymbol(Symbol.SYMBOL_0);
        } else {
            this.pX = b;
            b.setSymbol(Symbol.SYMBOL_X);

            this.p0 = a;
            a.setSymbol(Symbol.SYMBOL_0);

        }
    }

    public Symbol start() {
        Playable currentPlayer = pX;
        while (board.getWinner() == Symbol.SYMBOL_EMPTY && board.itsDraw() == false) {
            System.out.println(board);
            System.out.println(currentPlayer + "este la rand");
            int[] coord = currentPlayer.getCoord();
            //Arbitrul valideaza mutarea cu respect fata de incapsulare, nu se uita abuziz in matrice, intreaba matricea daca e libera casuta

            boolean validCoord = false;
            while (validCoord==false){
                if (board.isEmpty(coord)) {
                    board.fill(coord, currentPlayer.getSymbol());
                    validCoord=true;
                    if (currentPlayer == pX) {
                        currentPlayer = p0;
                    } else {
                        currentPlayer = pX;
                    }
                    // System.out.println(board);
                }
                else{
                    System.out.println("Please select other coordinates as the one you've selected are already used");
                    coord=currentPlayer.getCoord();
                }
                }
            }
        System.out.println(board);
        System.out.println("The winner is: " + board.getWinner());
        if (board.getWinner() == Symbol.SYMBOL_EMPTY) {
            System.out.println("It's draw! Play one more time if you dare!");
        }
return board.getWinner();
    }

    }

