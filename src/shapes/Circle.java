package shapes;

public class Circle extends Shape {
	
	double radius;
	
	public Circle() {
		shapeType = "Circle";
	}
	
	public Circle(String shapetype,String shapeID) {
		super(shapetype,shapeID);
	}
		
		@Override
	public void getInput() {	
	getShapeID();
	System.out.println("Enter radius: ");
    radius = in.nextDouble();
    CalculateArea();
}
		@Override
		public void CalculateArea() {
			SurfaceArea = (22.0/7)* radius * radius;
			//System.out.println(SurfaceArea);
		}
		
		@Override
		public String toCSVString() {
			// TODO Auto-generated method stub
			String out=String.format( "%s, %s, %s,%f",shapeType,shapeID,SurfaceArea,radius);
			return out;
			
		}

		@Override
		public String toString() {			
				String out = String.format("%-10s %-10s %10.2f radius:%-10.2f",shapeType,shapeID,SurfaceArea,radius);
				return out;
			
		}
	}
