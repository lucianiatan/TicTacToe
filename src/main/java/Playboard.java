import java.util.Arrays;

public class Playboard {

    private Symbol[] [] matrix;

    public Playboard()
    {
        System.out.println("==========================================");
        matrix = new Symbol[3][3];

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                matrix[row] [col] = Symbol.SYMBOL_EMPTY;

            }

    }

    public boolean isEmpty(int[] coord)
    {
        int row = coord[0];
        int col = coord[1];
        return matrix[row][col] == Symbol.SYMBOL_EMPTY;


    }


    public void fill(int[] coord, Symbol symbol) {
        int row = coord[0];
        int col = coord[1];
        matrix[row][col] = symbol;
    }

    @Override
    public String toString() {
        String txt = "";

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                txt = txt + matrix[row][col] + "   ";
            }
            txt = txt + "\n" + "\n";

        } return txt;
    }

    Symbol getWinner() {
        if (matrix [0][0]==matrix [0][1]&&matrix[0][0]==matrix[0][2]&&matrix[0][0]!= Symbol.SYMBOL_EMPTY)
            return matrix[0][0];
        if (matrix [1][0]==matrix [1][1]&&matrix[1][0]==matrix[1][2]&&matrix[1][0]!= Symbol.SYMBOL_EMPTY )
            return matrix[1][0];
        if (matrix [2][0]==matrix [2][1]&&matrix[2][0]==matrix[2][2]&&matrix[2][0]!= Symbol.SYMBOL_EMPTY )
            return matrix[2][0];
        if (matrix [0][0]==matrix [1][0]&&matrix[0][0]==matrix[2][0]&&matrix[0][0]!= Symbol.SYMBOL_EMPTY )
            return matrix[0][0];
        if (matrix [0][1]==matrix [1][1]&&matrix[0][1]==matrix[2][1]&&matrix[0][1]!= Symbol.SYMBOL_EMPTY )
            return matrix[0][1];
        if (matrix [0][2]==matrix [1][2]&&matrix[0][2]==matrix[2][2]&&matrix[0][2]!= Symbol.SYMBOL_EMPTY )
            return matrix[0][2];
        if (matrix [0][0]==matrix [1][1]&&matrix[0][0]==matrix[2][2]&&matrix[0][0]!= Symbol.SYMBOL_EMPTY )
            return matrix[0][0];
        if (matrix [2][0]==matrix [1][1]&&matrix[2][0]==matrix[0][2]&&matrix[0][0]!= Symbol.SYMBOL_EMPTY )
            return matrix[2][0];
        return Symbol.SYMBOL_EMPTY;

    }

     boolean itsDraw(){
        boolean tie = false;
        int contor = 0;
        for (int i = 0; i < 3 ; i++)
        {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] != Symbol.SYMBOL_EMPTY){
                    contor++;
                }
            }

        }
        if (contor == 9) tie = true;
        return tie;
    }




}


