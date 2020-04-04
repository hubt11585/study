package demo.knowledgepoints.invocationhandler;
import demo.knowledgepoints.invocationhandler.MyService;
import demo.knowledgepoints.invocationhandler.MyInvocationHandler;
public class $ProxyMy implements MyService{
	private MyService target;
	private MyInvocationHandler myInvocationHandler;
	public $ProxyMy (MyService target,MyInvocationHandler myInvocationHandler){
		this.target =target;
		this.myInvocationHandler = myInvocationHandler;
	}
	public void query() {
		myInvocationHandler.invoke();
		target.query();
	}
}