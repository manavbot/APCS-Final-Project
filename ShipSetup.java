import java.util.*;

public class ShipSetup extends Coordinate {
	public static ArrayList<Ship> compArray = new <Ship>ArrayList(); // NEW
	public static ArrayList<Ship> humArray = new <Ship>ArrayList(); // NEW

	public ShipSetup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	boolean[][] board = new boolean[8][8];

	public static void computer() {
		Ship compShip = null;
		Random rand = new Random();
		int i = 0;
		boolean repeat = false;
		while (i < 3) {
			int size = rand.nextInt(3) + 2;
			int coin = rand.nextInt(2);
			int xcoord;
			int ycoord;
			if (coin == 1) {
				xcoord = rand.nextInt(8);
				ycoord = rand.nextInt(8 - size);
			} else {
				xcoord = rand.nextInt(8 - size);
				ycoord = rand.nextInt(8);
			}
			Coordinate c1;
			Coordinate c2;
			Coordinate c3;
			Coordinate c4;
			if (coin == 1) {
				c1 = new Coordinate(xcoord, ycoord);
				c2 = new Coordinate(xcoord, ycoord + 1);
				c3 = new Coordinate(xcoord, ycoord + 2);
				c4 = new Coordinate(xcoord, ycoord + 3);
			} else {
				c1 = new Coordinate(xcoord, ycoord);
				c2 = new Coordinate(xcoord + 1, ycoord);
				c3 = new Coordinate(xcoord + 2, ycoord);
				c4 = new Coordinate(xcoord + 3, ycoord);
			}
			if (size == 2) {
				compShip = new TwoLengthShip(c1, c2);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1  = (((TwoLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((TwoLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2  = (((TwoLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((TwoLengthShip) compArray.get(j)).getC2());
						if (compShipC1.equals(arrayShipC1) && compShipC2.equals(arrayShipC2)) {
							 repeat = true;
							 break;
						} else {
							continue;
						}
					}
				}
				
				if(!repeat) {
					compArray.add(compShip);
				}

			} else if (size == 3) {
				compShip = new ThreeLengthShip(c1, c2, c3);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1  = (((ThreeLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((ThreeLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2  = (((ThreeLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((ThreeLengthShip) compArray.get(j)).getC2());
						Coordinate compShipC3  = (((ThreeLengthShip) compShip).getC3());
						Coordinate arrayShipC3 = (((ThreeLengthShip) compArray.get(j)).getC3());
						if (compShipC1.equals(arrayShipC1) && compShipC2.equals(arrayShipC2) && compShipC3.equals(arrayShipC3)) {
							 repeat = true;
							 break;
						} else {
							continue;
						}
					}
				}
				
				if(!repeat) {
					compArray.add(compShip);
				}
			} else if (size == 4) {
				compShip = new FourLengthShip(c1, c2, c3, c4);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1  = (((FourLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((FourLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2  = (((FourLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((FourLengthShip) compArray.get(j)).getC2());
						Coordinate compShipC3  = (((FourLengthShip) compShip).getC3());
						Coordinate arrayShipC3 = (((FourLengthShip) compArray.get(j)).getC3());
						Coordinate compShipC4  = (((FourLengthShip) compShip).getC4());
						Coordinate arrayShipC4 = (((FourLengthShip) compArray.get(j)).getC4());
						if (compShipC1.equals(arrayShipC1) && compShipC2.equals(arrayShipC2) && compShipC3.equals(arrayShipC3) && compShipC4.equals(arrayShipC4)) {
							 repeat = true;
							 break;
						} else {
							continue;
						}
					}
				}
				
				if(!repeat) {
					compArray.add(compShip);
				}
			}
			if(!repeat) {
				i++;
			}
			else {
				i = i + 0;
			}
		}
	}

	public static Ship humanSetupFor2Ship() {
		Scanner scan = new Scanner(System.in);
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		for (int i = 1; i < 3; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
					c2 = new Coordinate(xPoint, yPoint);
				}
			}
		}
		TwoLengthShip ship = new TwoLengthShip(c1, c2);
		humArray.add(ship);// NEW
		return ship;
	}

	public static Ship humanSetupFor3Ship() {
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
			System.out.println("y: ");
			yPoint = scan.nextInt();
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
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
						System.out.println("y: ");
						yPoint = scan.nextInt();
						c3 = new Coordinate(xPoint, yPoint);
					}
				}
			}
		}

		ThreeLengthShip ship = new ThreeLengthShip(c1, c2, c3);
		humArray.add(ship); // NEW
		return ship;
	}

	public static Ship humanSetupFor4Ship() {
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
			System.out.println("y: ");
			yPoint = scan.nextInt();
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
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
						System.out.println("y: ");
						yPoint = scan.nextInt();
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
							System.out.println("y: ");
							yPoint = scan.nextInt();
							c4 = new Coordinate(xPoint, yPoint);
						}
					}
				}
			}

		}

		FourLengthShip ship = new FourLengthShip(c1, c2, c3, c4);
		humArray.add(ship); // NEW
		return ship;
	}
}
