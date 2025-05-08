package shapes;

public class Square extends Shape {
	double side;
	
	public Square() {
		shapeType="Square";
	}
	
	public Square(String shapetype,String shapeID) {
		super(shapetype,shapeID);
	}
	
	@Override
	public void getInput() {
		getShapeID();
		System.out.println("Enter the Side length: ");
		side = in.nextDouble();
		CalculateArea();
		
	}

	@Override
	public void CalculateArea() {
		//calculate area
		SurfaceArea = side * side;
		System.out.println(SurfaceArea);
		
	}
	@Override
	public String toCSVString() {
		String out = String.format("%s,%s,%f,%f",shapeType,shapeID,SurfaceArea,side);
		return out;
	}
	
	@Override
	public String toString() {
		String out = String.format("%-10s %-10s %10.2f Side:%-10.2f",shapeType,shapeID,SurfaceArea,side);
		return out;
	}
	
	public void deserialize(String csv) {
		super.deserialize(csv);
		String tokan[]=csv.split(",");
		side=Double.parseDouble(tokan[3]);
		tokan=null;
		
	}
}
