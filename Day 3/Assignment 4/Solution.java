import java.util.*;
/**
 * This is the solution class for making a leader broard.
 */
class Solution {
	/**
	 * This method is to sort thw teams with the help of
	 * helper class insertion sort.
	 *
	 * @param teams input array of teams.
	 * @return Sorted array of teams.
	 */
	public Team[] sort(final Team[] teams) {
		// your code goes here
		InsertionSort.sort(teams);
		return teams;
	}
}

/**
 * We are implmenting Comparable interface to Team class.
 */
class Team implements Comparable<Team> {
	/**
	 * Field holds the team name.
	 */
	String teamName;
	/**
	 * Field holds no of wins.
	 */
	int noOfWins;
	/**
	 * Field holds no of losses.
	 */
	int noOfLosses;
	/**
	 * Field holds no of Draws
	 */
	int noOfDraws;

	/**
	 * Defining a parameterized constructer 
	 * with the following parameters
	 *
	 * @param name   Name of the team
	 * @param wins   Number of wins
	 * @param losses Number of losses
	 * @param draws  Number of Draws
	 */
	Team(final String name, final int wins, final int losses, final int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	/**
	 * Here the compareTo() method compares the two objects
	 * based on wins, losses, draws of the teams.
	 * @param that Team object
	 * @return -1 if less than, 0 if equal, 1 if greater.
	 */
	public int compareTo(final Team t) {
		if (this.noOfWins - t.noOfWins < 0) {
			return -1;
		} else if (this.noOfWins == t.noOfWins) {
			if (this.noOfLosses - t.noOfLosses > 0) {
				return -1;
			} else if (this.noOfLosses == t.noOfLosses) {
				if (this.noOfDraws - t.noOfDraws < 0) {
					return -1;
				} else if (this.noOfDraws == t.noOfDraws) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * toString() method returns the output format.
	 * @return string format of the values in Teams.
	 */
	public String toString() {
		return this.teamName + ", " + this.noOfDraws + ", " + this.noOfLosses + ", " + this.noOfWins;
	}
}
