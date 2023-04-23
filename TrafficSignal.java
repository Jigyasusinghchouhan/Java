public class TrafficSignal implements Runnable {
    public enum Color {RED, ORANGE, GREEN}

    private Color color;

    private static volatile Color previous = Color.ORANGE;

    public TrafficSignal(Color color) {
        this.color = color;
    }

    public synchronized void display() throws InterruptedException {
        switch (color) {
            case RED:
                while (previous != Color.ORANGE) wait();
                break;

            case ORANGE:
                while (previous != Color.GREEN) wait();
                break;

            case GREEN:
                while (previous != Color.RED) wait();
                break;
        }

        System.out.println(this.color);
        Thread.sleep(1000);
        previous = color;
        notifyAll();
    }

    @Override
    public void run() {
        while (true) {
            try {
                display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TrafficSignal(TrafficSignal.Color.GREEN)).start();
        new Thread(new TrafficSignal(TrafficSignal.Color.ORANGE)).start();
        new Thread(new TrafficSignal(TrafficSignal.Color.RED)).start();
    }
}