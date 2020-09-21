import java.util.Scanner;

public class TicTacToe {
    static boolean xTurn=true;
    static char[][] ticTacToeBoard=new char[3][3];
    static int[] row=new int[3];
    static int[] col=new int[3];
    static int diag=0,antiDiag=0;
   static boolean win=false;
    public static void main(String[] args) {

        for(int i=0;i<9;i++)
        {
              int[] coord=null;

              while(coord==null)
              {
                  coord=insertCoordinates(xTurn);
              }
              printGrid(ticTacToeBoard);
              char currTurn=xTurn?'X':'O';
              if(currTurn=='X')
              {
                  row[coord[0]]++;
                  col[coord[1]]++;

                  if(coord[0]==coord[1])
                  {
                      diag++;
                  }
                  if(coord[0]+coord[1]-1==2)
                  {
                      antiDiag++;
                  }
              }
              else
              {
                  row[coord[0]]--;
                  col[coord[1]]--;
                  if(coord[0]==coord[1])
                  {
                      diag--;
                  }
                  if(coord[1]+coord[0]==2)
                  {
                      antiDiag--;
                  }
              }

              if(row[0]==3||row[1]==3||row[2]==3||col[0]==3||col[1]==3||col[2]==3||diag==3||antiDiag==3)
              {
                  System.out.println("Finished! Player X is the Winner!");
                  win=true;
                  break;
              }
              if(row[0]==-3||row[1]==-3||row[2]==-3||col[0]==-3||col[1]==-3||col[2]==-3||diag==-3||antiDiag==-3)
              {
                  System.out.println("Finished! Player O is the Winner!");
                  win=true;
                  break;
              }
              xTurn=!xTurn;
        }

      if(!win)
      {
          System.out.println("Draw");
      }


    }

    private static void printGrid(char[][] ticTacToeBoard) {

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                char board=ticTacToeBoard[i][j];
                if(board=='\0')
                {
                    System.out.print(" ,");
                }
                else
                {
                    System.out.print(board+",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    private static int[] insertCoordinates(boolean turn)
    {
        Scanner scanner=new Scanner(System.in);
        char currentTurn=turn?'X':'O';
        System.out.println("Please enter "+currentTurn+" co-ordinate separated By comma's ");
        String coord=scanner.next();
        String[] coordArray=coord.split(",");
        int[] actualCoords=new int[]{Integer.parseInt(coordArray[0]),Integer.parseInt(coordArray[1])};
        if(!checkValidPosition(actualCoords,ticTacToeBoard))
        {
           return null;
        }
        ticTacToeBoard[actualCoords[0]][actualCoords[1]]=currentTurn;
        return actualCoords;
    }

    private static boolean checkValidPosition(int[] coordinates,char[][] moves)
    {
        if(coordinates[0]<0 || coordinates[0]>2 || coordinates[1]<0 || coordinates[1]>2)
        {
            System.out.println("Invalid coordinated please enter with in the board");
            return false;
        }
        boolean check=moves[coordinates[0]][coordinates[1]]==Character.MIN_VALUE;
        if(!check)
        {
            System.out.println("Position already occupied please enter different coordinates");
        }
        return check;
    }
}
