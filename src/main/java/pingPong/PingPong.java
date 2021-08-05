package pingPong;



public class PingPong {
    public PingPong() {
    }
    private static synchronized void play(String s, int i) {
        while (true) {
            System.out.println(s+" "+i);
            try {
                PingPong.class.notify();
                if (--i == 0){
                    break;
                } else {
                    PingPong.class.wait();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int i=10;
        new Thread(()->play("ping",i)).start();
        new Thread(()->play("pong",i)).start();
    }
}




