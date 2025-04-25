public class App {
    public static void main(String[] args) throws Exception {
        

        System.out.println("------------------------------");
        System.out.println("Welcome to the Pomodoro Timer!");
        System.out.println("------------------------------");



        Thread thread = new Thread(new Timer());
        thread.start();





    }
}
