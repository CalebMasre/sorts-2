
public class Main {
	public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape rectangle2 = new Rectangle(6, 11);
        Shape rectangle3 = new Rectangle(5, 12);
        Shape circle = new Circle(7);
        
        Comparable[]shapes = {(Comparable) circle, (Comparable) rectangle3, (Comparable) rectangle, (Comparable) rectangle2};
        System.out.println("Shapes before sorting");
        printArray(shapes);
        HeapSort heapsort = new HeapSort();
        heapsort.sort(shapes);
       
        System.out.println("Shapes after sorting");
        printArray(shapes);
        
        System.out.println("Area Values of the Shape Array after sorting:");
        for(Comparable shape: shapes) {
        	Shape temp = (Shape) shape;
        	System.out.println(temp.getArea());
        }
  
        testArray(shapes);
        
    }
    
    public static <T> void printArray(T arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i].toString() + " ");
		System.out.println();
	}

	public static <T> void testArray(T arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (((Comparable<T>) arr[i]).compareTo(arr[i + 1]) > 0) {
				System.out.println("This array is NOT properly sorted");
				System.out.println();
				return;
			}
		}

		System.out.println("This array is properly sorted");
		System.out.println();

	}

}

//Define the interface
interface Shape  {
 double getArea();
 
}

//Implement the interface in two classes
class Rectangle implements Comparable, Shape {
 private double length;
 private double width;

 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 public double getArea() {
     return length * width;
 }

 public String toString() {
     return "Rectangle with length " + length + " and width " + width;
 }
 
 public int compareTo(Object shape) {
 	
		if(this.getArea() > ((Shape) shape).getArea()) {
			return 7;
		} else if(this.getArea() < ((Shape) shape).getArea()){
			return -7;
		} else {
			return 0;
		}
 }
}

class Circle implements Shape, Comparable {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 public double getArea() {
     return Math.PI * radius * radius;
 }

 public String toString() {
     return "Circle with radius " + radius;
 }
 
public int compareTo(Object shape) {
 	
		if(this.getArea() > ((Shape) shape).getArea()) {
			return 7;
		} else if(this.getArea() < ((Shape) shape).getArea()){
			return -7;
		} else {
			return 0;
		}
 }
}
