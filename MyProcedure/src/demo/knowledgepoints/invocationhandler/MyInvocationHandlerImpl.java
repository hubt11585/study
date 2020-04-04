package demo.knowledgepoints.invocationhandler;

public class MyInvocationHandlerImpl implements MyInvocationHandler {

    @Override
    public Object invoke() {
        System.out.println("===== MyInvocationHandlerImpl =====");
        return null;
    }
}
