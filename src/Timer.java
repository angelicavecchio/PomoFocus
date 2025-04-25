public class Timer implements Runnable {

    int minutes;
    int seconds;
    boolean running;

    public Timer(int minutes) {
        this.minutes = minutes;
        this.seconds = 0;
        this.running = true; // Timer avviato di default
    }

    @Override
    public void run() {
        while (running && (minutes > 0 || seconds > 0)) {
            try {
                System.out.printf("\rTime remaining = [%02d:%02d]\n", minutes, seconds);
                Thread.sleep(1000);
                decrement();

            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }

            if (minutes == 0 && seconds == 0) {
                System.out.println("Time's up! Take a break!\n");
            }
        }
    }

    public void decrement() {
        if (seconds == 0) {
            if (minutes > 0) {
                minutes--;
                seconds = 59;
            }
        } else {
            seconds--;
        }
    }

    public void reset(int minutes) {
        this.seconds = 0;
        this.minutes = minutes; // Reset to Pomodoro time
    }

    public void stop() {
        this.running = false; // Stop the timer
    }

    public boolean isRunning() {
        return running;
    }
}
