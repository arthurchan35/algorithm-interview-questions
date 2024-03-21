package course.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/*
 * 
 * 			|______	6
 * 			|		|
 * 			5		|
 * 			|______	4
 * 			|		|
 * 			3		|
 * 			|______	2
 * 			|		|
 * 			1		|
 * 			|		|
 * 				0
 */
class Solution {
	private boolean canFinish(
		int course,
		HashMap<Integer, ArrayList<Integer>> deps,
		HashSet<Integer> pathDups,
		HashMap<Integer, Boolean> dp) { // dp is used for storing previously calculated results

		Boolean calculatedResult = dp.get(course);

		if (calculatedResult != null) {
			return calculatedResult;
		}

		var nextCourses = deps.get(course);

		if (nextCourses == null) {
			dp.put(course, true);
			return true;
		}

		if (pathDups.contains(course)) {
			dp.put(course, false);
			return false;
		}

		pathDups.add(course);

		for (var nextCourse : nextCourses) {
			boolean canFinish = canFinish(nextCourse, deps, pathDups, dp);

			if (canFinish == false) {
				dp.put(course, false);
				return false;
			}
		}

		pathDups.remove(course);
		dp.put(course, true);
		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (prerequisites == null || prerequisites.length < 1) {
			return true;
		}

		HashMap<Integer, ArrayList<Integer>> deps =
			new HashMap<>(prerequisites[0].length);

		HashSet<Integer> pathDups =
			new HashSet<>(prerequisites[0].length);

		HashMap<Integer, Boolean> dp =
			new HashMap<>(prerequisites[0].length);

		for (int i = 0; i < prerequisites.length; ++i) {
			var list = deps.computeIfAbsent(prerequisites[i][1], key -> new ArrayList<>());
			list.add(prerequisites[i][0]);
		}

		for (int course = 0; course < numCourses; ++course) {
			boolean canFinish = canFinish(course, deps, pathDups, dp);

			if (!canFinish) {
				return false;
			}
		}

		return true;
	}
}