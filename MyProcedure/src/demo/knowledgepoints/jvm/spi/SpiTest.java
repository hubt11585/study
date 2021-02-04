package demo.knowledgepoints.jvm.spi;

import sun.misc.Service;
import java.util.Iterator;

public class SpiTest {
    public static void main(String[] args) {
        Iterator<ServerSPI> providers = Service.providers(ServerSPI.class);

        while(providers.hasNext()) {
            ServerSPI ser = providers.next();
            ser.execMethod();
        }
    }
}
