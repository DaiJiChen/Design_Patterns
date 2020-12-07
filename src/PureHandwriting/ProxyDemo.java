package PureHandwriting;

public class ProxyDemo {
    public static void main(String[] args) {
        Network proxy = new Proxy( new ConcreteNetwork() );
        proxy.browse();
    }
}





interface Network {
    void browse();
}

class ConcreteNetwork implements Network {
    @Override
    public void browse() {
        System.out.println("Browsing...");
    }
}

class Proxy implements Network {
    private Network network;

    Proxy(Network network) { this.network = network; }

    @Override
    public void browse() {
        check();
        network.browse();
    }

    public void check() {
        System.out.println("Checking...");
    }
}