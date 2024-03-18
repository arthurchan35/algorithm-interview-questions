package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {

	List<List<Integer>> results = new ArrayList<>();
	List<Integer> result = new ArrayList<>();

	private void combinationSum(int[] candidates, int target, int s) {
		for (int i = s; i > -1; --i) {
			if (candidates[i] > target) {
				continue;
			}
			if (candidates[i] == target) {
				result.add(candidates[i]);
				results.add(List.copyOf(result));
				result.remove(result.size() - 1);
				continue;
			}

			result.add(candidates[i]);

			combinationSum(candidates, target - candidates[i], i);

			result.remove(result.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);

		combinationSum(candidates, target, candidates.length  - 1);

		return results;
	}
}