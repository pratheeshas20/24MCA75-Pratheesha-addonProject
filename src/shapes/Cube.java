package shapes;

public class Cube extends Shape {
	double length,breadth,height;

	public Cube() {
		shapeType ="Cube";
	}
	
	public Cube(String shapetype,String shapeID) {
		super(shapetype,shapeID);
	}
	
	@Override
	public void getInput() {
		getShapeID();
		System.out.println("Enter Length: ");
		length = in.nextDouble();
		System.out.println("Enter Breadth: ");
		breadth = in.nextDouble();
		System.out.println("Enter Height: ");
		height = in.nextDouble();
		CalculateArea();
	}

	@Override
	public void CalculateArea() {
		SurfaceArea =2 * (length*breadth +breadth*height +length*height);
		System.out.println(SurfaceArea);
		
	}
	
	public String toCSVString() {
		String out = String.format("%s,%s,%f,%f",shapeType,shapeID,SurfaceArea,length,breadth,height);
		return out;
	}

	@Override
	public String toString() {
		String out = String.format("%-10s %-10s %10.2f Length:%-10.2f Breadth:%-10.2f Height:%-10.2f",shapeType,shapeID,SurfaceArea,length,breadth,height);
		return out;
	}

}
