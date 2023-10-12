package q1282;

import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
	    List<List<Integer>> peopleGroups = new ArrayList<>();
	    Map<Integer, List<Integer>> groupTracker = new HashMap<>();

	    for (int i = 0; i < groupSizes.length; i++) {
			int currentGroupSize = groupSizes[i];
			if (groupTracker.containsKey(currentGroupSize) && groupTracker.get(currentGroupSize).get(1) < currentGroupSize) {
				int groupIndex = groupTracker.get(currentGroupSize).get(0);
				peopleGroups.get(groupIndex).add(i);
				int newSize = groupTracker.get(currentGroupSize).get(1) + 1;
				groupTracker.get(currentGroupSize).set(1, newSize);
			} else {
				List<Integer> newGroup = new ArrayList<>(Arrays.asList(i));
				peopleGroups.add(newGroup);
				int groupIndex = peopleGroups.size() - 1;
				groupTracker.put(currentGroupSize, new ArrayList<>(Arrays.asList(groupIndex, 1)));
			}
		}
	    return peopleGroups;
	}
}
