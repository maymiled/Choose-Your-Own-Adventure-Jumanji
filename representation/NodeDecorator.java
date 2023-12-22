package representation;

public abstract class NodeDecorator extends InnerNode implements Event {
    
	protected InnerNode innerNode;
	

    public NodeDecorator(InnerNode innerNode) {
    	super(innerNode.description);
        this.innerNode = innerNode;
    }
    
    public void display()
    {
    	innerNode.display();
    }
    
	public void addNextNodes(Node nextNode) {
		innerNode.addNextNodes(nextNode);		
	}
	

    public Node chooseNext()
    {
    	return innerNode.chooseNext();
    }
   
}