package pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainPokemon {

	public static void pokedex() {

		Pokemon pokemon1 = new Pokemon();

		pokemon1.setName("Charmander");

		pokemon1.setSkills("tackle", 30);

		pokemon1.setSkills("burst", 20);

		pokemon1.setSkills("flamethrower", 30);

		Pokemon pokemon2 = new Pokemon();

		pokemon2.setName("Pikachu");

		pokemon2.setSkills("thunderbolt", 30);

		pokemon2.setSkills("thunderclap", 20);

		pokemon2.setSkills("tackle", 30);

		Pokemon pokemon3 = new Pokemon();

		pokemon3.setName("Bulbasaur");

		pokemon3.setSkills("tackle", 30);

		pokemon3.setSkills("vinewhip", 20);

		pokemon3.setSkills("razorleaf", 30);

		Pokemon pokemon4 = new Pokemon();

		pokemon4.setName("Squirtle");

		pokemon4.setSkills("waterball", 30);

		pokemon4.setSkills("watercanon", 20);

		pokemon4.setSkills("tackle", 30);

		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

		pokemons.add(pokemon1);

		pokemons.add(pokemon2);

		pokemons.add(pokemon3);

		pokemons.add(pokemon4);

		while (!(pokemons.get(0).getHitPoints() == 0 || pokemons.get(1).getHitPoints() == 0
				|| pokemons.get(2).getHitPoints() == 0 || pokemons.get(3).getHitPoints() == 0)) {

			System.out.println("\n");

			System.out.println(" **** POKEMON GAME **** ");

			System.out.println("\n");

			System.out.println("You have the choice between several pokemons : 1 ; 2 ; 3 and 4");

			System.out.println("\n");

			System.out.println("Please, make your choice by entering 1; 2; 3 or 4");

			Scanner sc = new Scanner(System.in);

			int choix = sc.nextInt();

			switch (choix) {
			case 1:

				System.out.println(" This is your pokemon :) ");
				showPokemon(pokemons.get(0));
				int tab[] = pokemons.get(0).getSkillPoints();
				System.out.println("\n");
				System.out.println("Which skill do you want to use to attack ?");
				System.out.println("\n");

				System.out.println("Please, make your choice by entering 1; 2 or 3");
				Scanner sc1 = new Scanner(System.in);
				int choix1 = sc1.nextInt();

				switch (choix1) {

				case 1:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 0) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tab[0]);
							System.out.println("Pokemon 1 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 2:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 0) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tab[1]);
							System.out.println("Pokemon 1 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 3:
					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 0) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tab[2]);
							System.out.println("Pokemon 1 attacked Pokemon " + (x + 1) + " !");
						}
					}
					break;
				default:

					System.out.println("Bad entry");

				}

				break;
			case 2:
				System.out.println(" This is your pokemon :) ");
				showPokemon(pokemons.get(1));
				int t[] = pokemons.get(1).getSkillPoints();
				System.out.println("\n");
				System.out.println("Which skill do you want to use to attack ?");
				System.out.println("\n");

				System.out.println("Please, make your choice by entering 1; 2 or 3");
				Scanner sc2 = new Scanner(System.in);
				int choix2 = sc2.nextInt();

				switch (choix2) {
				case 1:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 1) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(t[0]);
							System.out.println("Pokemon 2 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 2:
					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 1) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(t[1]);
							System.out.println("Pokemon 2 attacked Pokemon " + (x + 1) + " !");
						}
					}
					break;
				case 3:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 1) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(t[2]);
							System.out.println("Pokemon 2 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				default:

					System.out.println("Bad entry");
				}

				break;
			case 3:
				System.out.println(" This is your pokemon :) ");
				showPokemon(pokemons.get(2));

				int table[] = pokemons.get(2).getSkillPoints();
				System.out.println("\n");
				System.out.println("Which skill do you want to use to attack ?");
				System.out.println("\n");

				System.out.println("Please, make your choice by entering 1; 2 or 3");
				Scanner sc3 = new Scanner(System.in);
				int choix3 = sc3.nextInt();

				switch (choix3) {

				case 1:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 2) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(table[0]);
							System.out.println("Pokemon 3 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 2:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 2) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(table[1]);
							System.out.println("Pokemon 3 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 3:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 2) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(table[2]);
							System.out.println("Pokemon 3 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				default:

					System.out.println("Bad entry");

				}

				break;
			case 4:
				System.out.println(" This is your pokemon :) ");
				showPokemon(pokemons.get(3));

				int tabl[] = pokemons.get(3).getSkillPoints();
				System.out.println("\n");
				System.out.println("Which skill do you want to use to attack ?");
				System.out.println("\n");

				System.out.println("Please, make your choice by entering 1; 2 or 3");
				Scanner sc4 = new Scanner(System.in);
				int choix4 = sc4.nextInt();

				switch (choix4) {

				case 1:

					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 3) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tabl[0]);
							System.out.println("Pokemon 4 attacked Pokemon " + (x + 1) + " !");
						}
					}

					break;
				case 2:
					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 3) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tabl[1]);
							System.out.println("Pokemon 4 attacked Pokemon " + (x + 1) + " !");
						}
					}
					break;
				case 3:
					// Attacking other pokemons

					for (int x = 0; x < pokemons.size(); x++) {
						if (x != 3) {
							pokemons.get(x).isAttackedByAnotherPokemonSkillPoints(tabl[2]);
							System.out.println("Pokemon 4 attacked Pokemon " + (x + 1) + " !");
						}
					}
					break;
				default:

					System.out.println("Bad entry");

				}

				break;
			default:

				System.out.println("Bad entry");
			}
		}

		// ICI

		System.out.println("\n");

		System.out.println("Final hit points of pokemons ");

		int pokemonsHitPoints[] = new int[4];

		for (int y = 0; y < pokemons.size(); y++) {
			System.out.println("Pokemon " + (y + 1) + " ----> " + pokemons.get(y).getHitPoints());

			pokemonsHitPoints[y] = pokemons.get(y).getHitPoints();
		}

		int max = Arrays.stream(pokemonsHitPoints).max().getAsInt();

		ArrayList<Pokemon> winningPokemons = new ArrayList<Pokemon>();

		for (int y = 0; y < pokemons.size(); y++) {

			if (pokemons.get(y).getHitPoints() == max) {

				winningPokemons.add(pokemons.get(y));

			}

		}

		System.out.println("\n");

		if (winningPokemons.size() == 1) {

			System.out.println("THE WINNER IS :");

		} else {

			System.out.println("THE " + winningPokemons.size() + " WINNER(S) ARE :");

		}

		for (int y = 0; y < pokemons.size(); y++) {

			if (pokemons.get(y).getHitPoints() == max) {

				System.out.println("Pokemon " + (y + 1));

				showPokemon(pokemons.get(y));

			}

		}

		System.out.println(" **** POKEMON GAME ENDS **** ");

	}

	public static void showPokemon(Pokemon p) {
		System.out.println("\n\n");

		System.out.println(" name : " + p.getName());

		System.out.println("\n");

		System.out.println("Skills and Points ");

		System.out.println("\n");

		/*
		 * 
		 * for (Entry<String, Integer> entry : p.getSkills().entrySet()) {
		 * 
		 * System.out.println(entry.getKey() + "  ---->  " + entry.getValue());
		 * 
		 * }
		 */

		String tabSkills[] = p.getSkillNames();

		int tabPoints[] = p.getSkillPoints();

		for (int i = 0; i < tabSkills.length; i++) {
			System.out.println(tabSkills[i] + "  ---->  " + tabPoints[i]);
		}

		System.out.println("\n");

		System.out.println(" hit points : " + p.getHitPoints());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pokedex();

	}

}
