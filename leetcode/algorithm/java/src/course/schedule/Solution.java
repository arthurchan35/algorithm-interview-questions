package course.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	private boolean canFinish(int course, HashMap<Integer, ArrayList<Integer>> deps, HashSet<Integer> pathDups) {

		var nextCourses = deps.get(course);

		if (nextCourses == null) {
			return true;
		}

		if (pathDups.contains(course)) {
			return false;
		}

		pathDups.add(course);

		for (var nextCourse : nextCourses) {
			boolean canFinish = canFinish(nextCourse, deps, pathDups);

			if (canFinish == false) {
				return false;
			}
		}

		pathDups.remove(course);

		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (prerequisites == null || prerequisites.length < 1) {
			return true;
		}

		HashMap<Integer, ArrayList<Integer>> deps =
			new HashMap<>(prerequisites.length * prerequisites[0].length);

		HashSet<Integer> pathDups =
		new HashSet<>(prerequisites.length * prerequisites[0].length);

		for (int i = 0; i < prerequisites.length; ++i) {
			var list = deps.computeIfAbsent(prerequisites[i][1], key -> new ArrayList<>());
			list.add(prerequisites[i][0]);
		}

		for (int course = 0; course < numCourses; ++course) {
			boolean canFinish = canFinish(course, deps, pathDups);

			if (!canFinish) {
				return false;
			}
		}

		return true;
	}
}