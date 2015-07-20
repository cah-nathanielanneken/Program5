import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;

/**
 * Extends Rectangle and, in addition, supplies methods to find this rectangle's
 * perimeter, find the area, check to see if a line segment is within this
 * rectangle, and to double the size of this rectangle. BetterRectangle
 * overrides Rectangle's toString and equals method. Tester is supplied in the
 * main to randomly generate a given number of BetterRectangles, print their
 * contents, double the sizes, and check which rectangles contain a given line
 * segment.
 * 
 * @author Nathan Anneken
 * @version 1.0
 */
public class BetterRectangle extends Rectangle {

	/**
	 * Constructs a BetterRectangle with a given upper left origin, a given
	 * width, and a given height
	 * 
	 * @param x
	 *            The x-coordinate of the upper left bound of this rectangle
	 * @param y
	 *            The y-coordinate of the upper left bound of this rectangle
	 * @param width
	 *            The width of this rectangle
	 * @param height
	 *            The height of this rectangle
	 */
	public BetterRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * Constructs a BetterRectangle with an upper left bound of (0,0) and a
	 * height and width of one
	 */
	public BetterRectangle() {
		super(0, 0, 1, 1);
	}

	/**
	 * Gets the perimeter of this rectangle
	 * 
	 * @return The perimeter of this rectangle
	 */
	public int getPerimeter() {
		return (2 * height) + (2 * width);
	}

	/**
	 * Gets the area of this rectangle
	 * 
	 * @return The area of this rectangle
	 */
	public int getArea() {
		return height * width;
	}

	/**
	 * Determines of a given line segment lies within the bounds of this
	 * rectangle(returns false if the line segment lies on or outside of the
	 * bounds of this rectangle)
	 * 
	 * @param a
	 *            An endpoint to the line segment
	 * @param b
	 *            An endpoint to the line segment
	 * @return
	 */
	public boolean containsSegment(Point a, Point b) {
		// Determines if line segment is outside or on the rectangle
		if (contains(a.x, a.y) && contains(b.x, b.y) && x != a.getX()
				&& x != b.getX() && y != a.getY() && y != b.getY()
				&& (x + width) != a.getX() && (x + width) != b.getX()
				&& (y + height) != a.getY() && (y + height) != b.getY())
			return true;
		else
			return false;

	}

	/**
	 * Doubles the width and height of this rectangle
	 */
	public void doubleSize() {
		width = width * 2;
		height = height * 2;
	}

	/**
	 * Creates a string by calling on Rectangle's toString method, then adds the
	 * area and perimeter of this rectangle
	 * 
	 * @return A string represenation of this rectangle
	 */
	public String toString() {
		String s;
		s = super.toString() + " Area=" + getArea() + ", Perimeter="
				+ getPerimeter();
		return s;
	}

	/**
	 * Determines of this rectangle is equal to a given object
	 * 
	 * @return True if this rectangle equals another rectangle, else false
	 */
	public boolean equals(Object that) {
		if (that instanceof BetterRectangle)
			return super.equals(that);
		else
			return false;
	}

	/**
	 * A tester for the BetterRectangle class, creating a number of
	 * BetterRectangles, printing their contents, doubling their contents, then
	 * checking to see if a given line segment lies within this rectangle's area
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 0, y = 0, width = 0, height = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("How many rectangles? ");
		int number = input.nextInt();
		BetterRectangle[] a = new BetterRectangle[number];
		for (int z = 0; z < a.length; z++) {
			do {
				x = (int) (Math.random() * 10);
			} while (x == 0);
			do {
				y = (int) (Math.random() * 10);
			} while (y == 0);
			do {
				width = (int) (Math.random() * 10);
			} while (width == 0);
			do {
				height = (int) (Math.random() * 10);
			} while (height == 0);
			a[z] = new BetterRectangle(x, y, width, height);
		}
		System.out.println("\n" + number + " random rectangles...");
		for (BetterRectangle b : a) {
			System.out.println(b.toString());
		}
		System.out.println("\nafter doubling sizes...");
		for (BetterRectangle b : a) {
			b.doubleSize();
			System.out.println(b.toString());
		}
		System.out.print("\nEnter x- and y-coordinates for start: ");
		int startX = input.nextInt();
		int startY = input.nextInt();
		Point point1 = new Point(startX, startY);
		System.out.print("Enter x- and y-coordinates for end: ");
		int endX = input.nextInt();
		int endY = input.nextInt();
		Point point2 = new Point(endX, endY);
		System.out
				.println("\nHere are the rectangles that contain your sement:");
		for (BetterRectangle b : a) {
			if (b.containsSegment(point1, point2))
				System.out.println(b.toString());
		}
	}
}
