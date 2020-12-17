package by.it._khmelov_.jd02_02;


class Buyer extends Thread implements IBuyer {

    private boolean isRunnable;

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        //Dispatcher.addBuyer(); - ERROR need <init>
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.add(this);
        System.out.println(this + " add to Queue");
        this.setRunnable(false);
        synchronized (this) {
            while (!this.isRunnable)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(this + " left the Queue");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the Market");
    }
}
