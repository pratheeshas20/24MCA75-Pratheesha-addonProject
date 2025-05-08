package shapes;

public class Rectangle extends Shape {
	
double length,breadth;

	public Rectangle() {
		shapeType = "Rectangle";
	}

public Rectangle(String shapetype,String shapeID) {
	super(shapetype,shapeID);
}
	
	@Override
	public void getInput() {
		
		getShapeID();
		System.out.println("Enter Length: ");
		length = in.nextDouble();
		System.out.println("Enter Breadth: ");
		breadth = in.nextDouble();
		CalculateArea();
	}


	@Override
	public void CalculateArea() {
		SurfaceArea = length * breadth;
		System.out.println(SurfaceArea);
		
	}
	
	public String toCSVString() {
		String out = String.format("%s,%s,%f,%f",shapeType,shapeID,SurfaceArea,length,breadth);
		return out;
	}

	@Override
	public String toString() {
		String out = String.format("%-10s %-10s %10.2f Length:%-10.2f Breadth:%-10.2f",shapeType,shapeID,SurfaceArea,length,breadth);
		return out;
	}
	

}
