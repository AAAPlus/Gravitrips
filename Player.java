
public abstract class Player{
	
	private String figure = "";
		
	public String getFigure() {
		return figure;
	}
	
	public void setFigure(String figure) {
		this.figure = figure;
	}
	
	public abstract int getHit();
	
}
