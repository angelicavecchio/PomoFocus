import java.time.LocalTime;

public class Timer implements Runnable{

    LocalTime timer;
/* 
    public Timer(int number){
        this.timer = number;
    }
*/
    public LocalTime getTimer(){
        return this.timer;
    }

    
   @Override
   public void run(){
       
    LocalTime now = LocalTime.now();

    try{

    Thread.sleep(1000);
    System.out.printf("\r%d:%d:%d",now.getHour(),now.getMinute(),now.getSecond());

    }catch(InterruptedException e){
        System.out.println(e.getMessage());
    }
    

   }






}
