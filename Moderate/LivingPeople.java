/*
 *Given a list of people with their birth and death years, 
 *implement a method to compute the year with the most number of people alive. 
 *You may assume that all people were born between 1900 and 2000 (inclusive). 
 *If a person was alive during any portion of that year, they should be included in that year's count. 
 *For example, Person (birth =1908, death =1909) is included in the counts for both 1908 and 1909.
 *
 *i/p:
 *Person(int birth, int death)  people
 *
 *o/p:
 *int maxAliveYear
 *
 *Mtd:			Time		Space
 *Brute Force	O(R * P)	O(1)
 *Sorting		O(PlogP)	O(1)
 *Linear		O(R + P)	O(1)
 *
 */


import java.io.*;
import java.util.*;

class LivingPeople {
	static class Person {
		int birth, death;	

		Person(int b, int d) {
			birth = b;
			death = d;	
		}

		public String toString() {
			return "[" + birth + ", " + death + "]";	
		}
	}

    public static void main(String args[]) {
		int startYear = 1900;
		int endYear = 2000;
		Random rand = new Random();
		Person[] people = new Person[rand.nextInt(20) + 1];
		for (int i = 0; i < people.length; i++) {
			int birth = rand.nextInt(endYear - startYear + 1) + startYear;
			int death = rand.nextInt(endYear - birth + 1) + birth;
			people[i] = new Person(birth, death);
		}
		
		for (Person person : people)	System.out.println(person);

		System.out.println(bruteForceMtd(people, startYear, endYear));
		System.out.println(sortingMtd(people, startYear, endYear));
		System.out.println(linearMtd(people, startYear, endYear));
    }

	private static int bruteForceMtd(Person[] people, int startYear, int endYear) {
		int maxPop = 0, maxPopYear = -1;
		for (int year = startYear; year <= endYear; year++) {
			int pop = 0;
			for (Person person : people) {
				if (person.birth <= year && year <= person.death)	pop++;	
			}	
			if (pop > maxPop) {
				maxPop = pop;
				maxPopYear = year;	
			}
		}
		return maxPopYear;	
	}

	private static int[] getYears(Person[] people, boolean copyBirthYear) {
		int[] res = new int[people.length];
		for (int i = 0; i < people.length; i++) {
			res[i] = (copyBirthYear) ? people[i].birth : people[i].death;	
		}	
		return res;
	}

	private static int sortingMtd(Person[] people, int startYear, int endYear) {
		int[] birth = getYears(people, true);
		int[] death = getYears(people, false);

		Arrays.sort(birth);
		Arrays.sort(death);

		int i = 0, j = 0;
		int pop = 0, maxPop = -1, maxPopYear = -1;

		while (i < birth.length) {
			if (birth[i] <= death[j]) {
				pop++;
				if (pop > maxPop) {
					maxPop = pop;
					maxPopYear = birth[i];	
				}	
				i++;
			}
			else {
				pop--;
				j++;	
			}	
		}

		return maxPopYear;
	}

	private static int linearMtd(Person[] people, int startYear, int endYear) {
		int[] popDelta = new int[endYear - startYear + 2];

		for (Person person : people) {
			popDelta[person.birth - startYear]++;
			popDelta[person.death + 1 - startYear]--;
		}

		int pop = 0, maxPop = -1, maxPopYear = -1;
		for (int i = 0; i < popDelta.length; i++) {
			pop += popDelta[i];
			if (pop > maxPop) {
				maxPop = pop;
				maxPopYear = i + startYear;	
			}	
		}
		
		return maxPopYear;
	}
}

