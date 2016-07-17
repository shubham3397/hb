
package hollywoodbollywood;
import java.util.Scanner;

class timer extends Thread{
    static int cl;
    public void run(){
         for(cl=30;cl>=0;cl--){       
             try{
                  Thread.sleep(1000);
             }catch(InterruptedException e){System.out.println(e);}
             System.out.println(cl);
            }
        }
    }

class questionCheck{
        void run(){
        HollywoodBollywood h=new HollywoodBollywood();
        String ans[];
        ans=h.getAns();
        if(ans[h.quesNumber]==h.que[h.quesNumber]){
            System.out.println("you have won");
        }
        else
            System.out.println("oops you failed...");
    }
    
}

class typeAns extends Thread{
    HollywoodBollywood h=new HollywoodBollywood();
    Scanner sc=new Scanner(System.in);
    questionCheck q = new questionCheck();
    char[] guess=new char[1];
    String  ans[]=h.getAns();
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("enter your guess letter");
            guess[0]=sc.next().charAt(0);
            //System.out.println(ans[h.quesNumber].length());
            for(int j=0;j<ans[h.quesNumber].length();j++){
                if(guess[0]==ans[h.quesNumber].charAt(j)){
                    h.que[h.quesNumber]=ans[h.quesNumber].substring(j,j);
                    System.out.println(h.que[h.quesNumber]);
                }
            }
        }
        q.run();
    }
}

public class HollywoodBollywood {
    String que[]={"_A_A_ A__U_","___EE I_IO__"};
    private final String ans[]={"KARAN ARJUN","THREE IDIOTS"};
    static int quesNumber;

    public String[] getAns() {
        return ans;
    }
    void ask()
    {
        System.out.println(que[quesNumber]);
    }
    public static void main(String[] args) {
        HollywoodBollywood h=new HollywoodBollywood();
        h.ask();
        timer t=new timer();
        //t.start();                 //run clock
        typeAns ty=new typeAns();
        ty.start();                   //get guesses  
       
    }
}
