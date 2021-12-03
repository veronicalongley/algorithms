
public class Edge {

	public Vertex from;
	public Vertex to;
	private int weight;
	
	public Edge()
	{
		weight = 0; 
		from = new Vertex();
		to = new Vertex(); 
	}//Edge
	
	public Edge(Vertex newFrom, Vertex newTo, int newWeight)
	{
		from = newFrom;
		to = newTo;
		weight = newWeight; 
	}//Edge
	
	public int getToID()
	{
		return to.getid();
	}//getToID
	
	public int getFromID()
	{
		return from.getid();
	}//getFromID
	
	public Vertex getTo()
	{
		return to;
	}//getTo
	
	public Vertex getFrom()
	{
		return from;
	}//getFrom
	
	public int getWeight()
	{
		return weight; 
	}//get weight
	
	public int getFromDist()
	{
		return from.getDist();
	}//getFromDistance
	
	public int getToDistance()
	{
		return to.getDist();
	}//getFromDistance
}
