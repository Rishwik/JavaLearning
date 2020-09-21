import java.util.Scanner;


public class BattleShips {

    public static void main(String[] args) {

        int[][] battleShips=new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,0,0,1}};

        int[][] battleShipsClone=cloneBattleShips(battleShips);

        int count=0;

        for(int[] battleShip:battleShips)
        {
            for(int missile:battleShip)
            {
                if(missile==1) count++;
            }
        }

        int newCount=count;
        boolean flag=true;
        while(flag)
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the coordinate i,j to send missile into ");
            String input=scanner.next();
            String[] arr=input.split(",");
            boolean res=battleShips(battleShips,Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
            if(res) count--;
            if(count==0)
            {
                System.out.println("You won the game");
                System.out.println("Do you want play another game");
                String wantToPlay=scanner.next();
                if(wantToPlay.equalsIgnoreCase("yes")) count=newCount;
                else flag=false;
                battleShips=cloneBattleShips(battleShipsClone);
            }

        }
       
    }

    private static boolean battleShips(int[][] battles,int i, int j)
    {
        if(battles[i][j]==1) {battles[i][j]=2; return true;}
        return false;
    }

    private static int[][] cloneBattleShips(int[][] input)
    {

        int rows=input.length,cols=input[0].length;

        int[][] res=new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                res[i][j]=input[i][j];
            }
        }

        return res;

    }

}
