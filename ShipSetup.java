import java.util.*;

public class ShipSetup extends Coordinate {
	public static ArrayList<Ship> compArray = new <Ship>ArrayList(); // NEW
	public static ArrayList<Ship> humArray = new <Ship>ArrayList(); // NEW
	public static ArrayList<Integer> compX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> compY = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humanX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humanY = new <Integer>ArrayList(); // NEW

	public ShipSetup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	boolean[][] board = new boolean[8][8];

	public static void computer() {
		Ship compShip = null;
		Random rand = new Random();
		int i = 0;
		while (i < 3) {
			int size = rand.nextInt(3) + 2;
			Coordinate c1 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
			compX.add(c1.getX());
			compY.add(c1.getY());
			Coordinate c2 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
			while (c2.equals(c1)) {
				c2 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
				compX.add(c2.getX());
				compY.add(c2.getY());
			}
			Coordinate c3 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
			while (c3.equals(c1) || c3.equals(c2)) {
				c3 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
				compX.add(c3.getX());
				compY.add(c3.getY());
			}
			Coordinate c4 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
			while (c4.equals(c1) || c4.equals(c2) || c4.equals(c3)) {
				c4 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
				compX.add(c4.getX());
				compY.add(c4.getY());
			}
			if (size == 2) {
				// for (int j = 0; j < compArray.size(); j++) {

				// }
				compShip = new TwoLengthShip(c1, c2);
			} else if (size == 3) {
				compShip = new ThreeLengthShip(c1, c2, c3);
			} else if (size == 4) {
				compShip = new FourLengthShip(c1, c2, c3, c4);
			}
			compArray.add(compShip);// NEW
			i++;
		}
	}

	public void humanSetupFor2Ship() {
		Scanner scan = new Scanner(System.in);
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		for (int i = 1; i < 3; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			humanX.add(xPoint);
			System.out.println("y: ");
			yPoint = scan.nextInt();
			humanY.add(yPoint);
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);

			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					humanX.add(xPoint);
					System.out.println("y: ");
					yPoint = scan.nextInt();
					humanY.add(yPoint);
					c2 = new Coordinate(xPoint, yPoint);
				}
			}
		}
		TwoLengthShip ship = new TwoLengthShip(c1, c2);
		humArray.add(ship);// NEW
	}

	public static void humanSetupFor3Ship() {
		Scanner scan = new Scanner(System.in);
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(0, 0);
		for (int i = 1; i < 4; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			humanX.add(xPoint);
			System.out.println("y: ");
			yPoint = scan.nextInt();
			humanY.add(yPoint);
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					humanX.add(xPoint);
					System.out.println("y: ");
					yPoint = scan.nextInt();
					humanY.add(yPoint);
					c2 = new Coordinate(xPoint, yPoint);
				}
			} else if (i == 3) {
				c3 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c3.getX() - c1.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
					while (Math.abs(c3.getX() - c2.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
						System.out.println("Please enter a third point next"
								+ "to the first one or second one. (1 within point of either)");
						System.out.println("x: ");
						xPoint = scan.nextInt();
						humanX.add(xPoint);
						System.out.println("y: ");
						yPoint = scan.nextInt();
						humanY.add(yPoint);
						c3 = new Coordinate(xPoint, yPoint);
					}
				}
			}
		}

		ThreeLengthShip ship = new ThreeLengthShip(c1, c2, c3);
		humArray.add(ship); // NEW
	}

	public static void humanSetupFor4Ship() {
		Scanner scan = new Scanner(System.in);
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(0, 0);
		Coordinate c4 = new Coordinate(0, 0);
		for (int i = 1; i < 5; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			humanX.add(xPoint);
			System.out.println("y: ");
			yPoint = scan.nextInt();
			humanY.add(yPoint);
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					humanX.add(xPoint);
					System.out.println("y: ");
					yPoint = scan.nextInt();
					humanY.add(yPoint);
					c2 = new Coordinate(xPoint, yPoint);
				}
			} else if (i == 3) {
				c3 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c3.getX() - c1.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
					while (Math.abs(c3.getX() - c2.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
						System.out.println("Please enter a third point next"
								+ "to the first one or second one. (1 within point of either)");
						System.out.println("x: ");
						xPoint = scan.nextInt();
						humanX.add(xPoint);
						System.out.println("y: ");
						yPoint = scan.nextInt();
						humanY.add(yPoint);
						c3 = new Coordinate(xPoint, yPoint);
					}
				}
			} else if (i == 4) {
				c4 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c4.getX() - c1.getX()) > 1 || Math.abs(c4.getY() - c2.getY()) > 1) {
					while (Math.abs(c4.getX() - c2.getX()) > 1 || Math.abs(c4.getY() - c2.getY()) > 1) {
						while (Math.abs(c4.getX() - c1.getX()) > 1 || Math.abs(c4.getY() - c1.getY()) > 1) {
							System.out.println("Please enter a fourth point next"
									+ "to the first second or third one. (1 within point of any)");
							System.out.println("x: ");
							xPoint = scan.nextInt();
							humanX.add(xPoint);
							System.out.println("y: ");
							yPoint = scan.nextInt();
							humanY.add(yPoint);
							c4 = new Coordinate(xPoint, yPoint);
						}
					}
				}
			}

		}

		FourLengthShip ship = new FourLengthShip(c1, c2, c3, c4);
		humArray.add(ship); // NEW
	}
}
