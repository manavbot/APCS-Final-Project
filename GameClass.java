import java.util.*;

public class GameClass extends ShipSetup {

	public static ArrayList<Integer> compGuessesX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> compGuessesY = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humGuessesX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humGuessesY = new <Integer>ArrayList(); // NEW
	
	public GameClass(int x, int y) {
		super(x, y);
	}

	Random rand = new Random();

	Scanner scan = new Scanner(System.in);

	public void game() {
		boolean isGame = false;
		computer();
		ArrayList<Integer> xPoints = new <Integer>ArrayList();
		ArrayList<Integer> yPoints = new <Integer>ArrayList();
		for (int i = 0; i > 8; i++) {
			xPoints.add(i);
			yPoints.add(i);
		}
		Ship cship1 = compArray.get(0);
		Ship cship2 = compArray.get(1);
		Ship cship3 = compArray.get(2);
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		int size1 = scan.nextInt();
		while (size1 != 2 && size1 != 3 && size1 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size1 = scan.nextInt();
		}
		System.out.println("Select how big your second battleship is: 2,3,4?");
		int size2 = scan.nextInt();
		while (size2 != 2 && size2 != 3 && size2 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size2 = scan.nextInt();
		}
		System.out.println("Select how big your third battleship is: 2,3,4?");
		int size3 = scan.nextInt();
		while (size3 != 2 && size3 != 3 && size3 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size3 = scan.nextInt();
		}
		System.out.println("Now pick coordinates to place your ship.");
		if (size1 == 2) {
			humanSetupFor2Ship();
		}
		if (size2 == 2) {
			humanSetupFor2Ship();
		}
		if (size3 == 2) {
			humanSetupFor2Ship();
		}
		if (size1 == 3) {
			humanSetupFor3Ship();
		}
		if (size2 == 3) {
			humanSetupFor3Ship();
		}
		if (size3 == 3) {
			humanSetupFor3Ship();
		}
		if (size1 == 4) {
			humanSetupFor4Ship();
		}
		if (size2 == 4) {
			humanSetupFor4Ship();
		}
		if (size3 == 4) {
			humanSetupFor4Ship();
		}
		while (isGame == false) {
			int round = 1;
			Ship humShip1 = humArray.get(0);
			Ship humShip2 = humArray.get(1);
			Ship humShip3 = humArray.get(2);
			/**
			 * Human guessing portion
			 */
			System.out.println("Guess a point!");
			System.out.println("x: ");
			int xGuess = scan.nextInt();
			System.out.println("y: ");
			int yGuess = scan.nextInt();
			// goes through the x's and y's to check if the coordinates were guessed
			// beforehand
			for (int i = 0; i < round - 1; i++) {
				while (humGuessesX.get(i) == xGuess && humGuessesY.get(i) == yGuess) {
					System.out.println("You already guesses this point, pick again");
				}
			}
			if ((xGuess == compX.get(0) && yGuess == compY.get(0))) {
				Coordinate c = new Coordinate(compX.get(0), compY.get(0));
				System.out.println("Hit!");
				c.setDamage(true);
			} else if (xGuess == compX.get(1) && yGuess == compY.get(2)) {
				Coordinate c = new Coordinate(compX.get(1), compY.get(1));
				System.out.println("Hit!");
				c.setDamage(true);
			} else {
				System.out.println("You missed");
			}
			/**
			 * Computer guessing portion
			 */
			int compGuessX = rand.nextInt(8);
			int compGuessY = rand.nextInt(8);
			if (compGuessX == humanX.get(0) && compGuessY == humanY.get(0)) {
				Coordinate c = new Coordinate(humanX.get(0), humanY.get(0));
				System.out.println("The computer has got a hit!");
				c.setDamage(true);
			} else if (compGuessX == humanX.get(1) && compGuessY == humanY.get(2)) {
				Coordinate c = new Coordinate(humanX.get(1), humanY.get(1));
				System.out.println("The computer has got a hit!");
				c.setDamage(true);
			}
		}
	}

	protected static int shipChoice;

	// NEW METHOD
	public String updateStatus(ArrayList<Ship> arr, int low, int high) {
		int damageCount = 0;
		int aliveCount = 0;
		int deadCount = 0;
		low = 0;
		high = arr.size() - 1;
		String s = "";
		if (low > high) {
			s += "Alive: " + aliveCount + "\n" + "Dead: " + deadCount + "\n" + "Damaged: " + damageCount + "\n";
			return s;
		} else {
			if (arr.get(low).isAlive()) {
				aliveCount++;
			}
			if (arr.get(low).isDamaged()) {
				damageCount++;
			}
			if (!arr.get(low).isDamaged()) {
				deadCount++;
			}
			if (arr.get(high).isAlive()) {
				aliveCount++;
			}
			if (arr.get(high).isDamaged()) {
				damageCount++;
			}
			if (!arr.get(high).isDamaged()) {
				deadCount++;
			}

			return updateStatus(arr, ++low, --high);
		}

	}

	public static void main(String[] args) {
		new BattleshipDriver();
		GameClass b = new GameClass(0, 0);
		b.game();
	}

	

}