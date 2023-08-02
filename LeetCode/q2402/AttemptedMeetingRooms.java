package q2402;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttemptedMeetingRooms {
	public class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		int duration;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
			this.duration = this.end - this.start;
		}
		@Override
		public int compareTo(Meeting o) {
			return (this.start - o.start);
		}
		
		@Override
		public String toString() {
			return String.format("The meeting starts %d, ends %d and lasts for %d.", this.start , this.end , this.duration);
		}
	}
	
	
	public int mostBooked(int n, int[][] meetings) {
        List<Meeting> meetingsList = new ArrayList<>(); // Localize the list to the method
        for (int[] meet : meetings) {
            meetingsList.add(new Meeting(meet[0], meet[1]));
        }
        Collections.sort(meetingsList);

        List<Integer> noOfMeetings = new ArrayList<>();
        List<Integer> whenNextFree = new ArrayList<>();
        int numOfAvailableRooms = n;

        for (Meeting mtg : meetingsList) {
            if (numOfAvailableRooms > 0) {
                numOfAvailableRooms--;
                whenNextFree.add(mtg.end);
                noOfMeetings.add(1);
            } else {
                int nextAvailableRoomIn = Collections.min(whenNextFree);
                int roomNo = whenNextFree.indexOf(nextAvailableRoomIn);

                int currNoOfMeetingsHeld = noOfMeetings.get(roomNo);
                noOfMeetings.set(roomNo, currNoOfMeetingsHeld + 1);
                whenNextFree.set(roomNo, nextAvailableRoomIn + mtg.duration);
            }
        }

        return noOfMeetings.indexOf(Collections.max(noOfMeetings));
    }
	
	
	public static void main(String[] args) {
		int meetings[][] = new int[10][10];
		int[][] aListOfMtgs = {{0,10},{7,9},{6,12},{9,14},{1,5},{2,7},{3,4}};
		int[][] testMtgs = {{0,10},{1,5},{2,7},{3,4}};
		
		int[][] testMtgs2 = {{1,20},{2,10},{3,5},{4,9}, {6,8}};
		AttemptedMeetingRooms mtnRooms = new AttemptedMeetingRooms();
		
		int result = mtnRooms.mostBooked(3, testMtgs2);
		result = mtnRooms.mostBooked(2, aListOfMtgs);
		System.out.println(String.format("The meeting that held the most meetings is Room: %d", result));
	}
}
