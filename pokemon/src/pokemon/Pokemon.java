package pokemon;

import java.util.HashMap;

public class Pokemon {

	private String name;

	private HashMap<String, Integer> skills = new HashMap<String, Integer>();

	private int hitPoints = 100;

	private int skillPoints[] = new int[3];

	private String skillNames[] = new String[3];

	/**
	 * @return the skillPoints
	 */
	public int[] getSkillPoints() {
		return skillPoints;
	}

	/**
	 * @param skillPoints
	 *            the skillPoints to set
	 */
	private void setSkillPoints(int i, int value) {
		this.skillPoints[i] = value;
	}

	/**
	 * @return the skillNames
	 */
	public String[] getSkillNames() {
		return skillNames;
	}

	/**
	 * @param skillNames
	 *            the skillNames to set
	 */
	private void setSkillNames(int i, String value) {
		this.skillNames[i] = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the skills
	 */
	public HashMap<String, Integer> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills and points to set
	 */
	public void setSkills(String skillsPokemon, int points) {

		this.skills.put(skillsPokemon, points);

		setSkillNames(this.skills.size() - 1, skillsPokemon);

		setSkillPoints(this.skills.size() - 1, points);

	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param skillPoint
	 *            attacked by another pokemon
	 */
	public void isAttackedByAnotherPokemonSkillPoints(int skillPoint) {
		this.hitPoints = this.hitPoints - skillPoint;

		if (this.hitPoints < 0) {
			this.hitPoints = 0;
		}
	}

}
