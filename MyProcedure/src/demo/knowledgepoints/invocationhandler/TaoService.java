package demo.knowledgepoints.invocationhandler;

public class TaoService implements MyService {
    @Override
    public void query() {
        System.out.println("========= start TaoService ========");
    }
}
