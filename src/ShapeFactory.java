import org.junit.Test;

interface Shape {
	void draw();
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println(" ----");
		System.out.println("|    |");
		System.out.println(" ----");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println(" ----");
		System.out.println("|    |");
		System.out.println("|    |");
		System.out.println(" ----");
	}
}

class Triangle implements Shape {
	public void draw() {
		System.out.println("  /\\");
		System.out.println(" /  \\");
		System.out.println("/____\\");
	}
}

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		switch (shapeType) {
		case "Square":
			return new Square();
		case "Triangle":
			return new Triangle();
		case "Rectangle":
			return new Rectangle();
		default:
			return null;
		}
	}

	@Test
	public void test() {
		ShapeFactory sf = new ShapeFactory();
		Shape shape = sf.getShape("Square");
		shape.draw();
		// >> ----
		// >> | |
		// >> | |
		// >> ----

		shape = sf.getShape("Triangle");
		shape.draw();
		// >> /\
		// >> / \
		// >> /____\

		shape = sf.getShape("Rectangle");
		shape.draw();
		// >> ----
		// >> | |
		// >> ----
	}
}
