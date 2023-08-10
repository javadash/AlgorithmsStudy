package q2402;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
	public int mostBooked(int n, int[][] meetings) {
		
		int[] roomIndex = new int[n];
		int result = 0;
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<long[]> meetingQueue = new PriorityQueue<>(
				(a, b) -> a[1] == b[1] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]) );
		
		// We initialize the meeting rooms with duration 0 and keep the index
		for(int i = 0; i < n; i++) {
			meetingQueue.add(new long[] {i, 0});
		}
		
		// Loop through available meeting rooms
		
		for(int[] mtg : meetings) {
			int time = mtg[0];
			
			// check if any has ended or just ended update the meeting rooms with the new start time
			while( meetingQueue.peek()[1] < time) {
				meetingQueue.add(new long[] {meetingQueue.poll()[0], time});
			}
			
			long[] currentRoom = meetingQueue.poll();
			long newEndingTime = currentRoom[1] + (mtg[1] - mtg[0]);
			int currRoom = (int)currentRoom[0];
			meetingQueue.add(new long[] {currRoom, newEndingTime});
			roomIndex[currRoom]++;
			
			if(roomIndex[currRoom] > roomIndex[result]) {
				result = currRoom;
			} else if(roomIndex[currRoom] == roomIndex[result]) {
				result = Math.min(currRoom, result);
			}
		}

		return result;
	}
	public static void main(String[] args) {
		int meetings[][] = new int[10][10];
		int[][] aListOfMtgs = {{0,10},{7,9},{6,12},{9,14},{1,5},{2,7},{3,4}};
		int[][] testMtgs = {{0,10},{1,5},{2,7},{3,4}};
		
		int[][] testMtgs2 = {{1,20},{2,10},{3,5},{4,9}, {6,8}};
		int[][] testMtgs3 = {{0,10},{1,2},{12,14},{13,15}};
		MeetingRooms mtnRooms = new MeetingRooms();
		
		int result = mtnRooms.mostBooked(3, testMtgs2);
		result = mtnRooms.mostBooked(2, testMtgs2);
		System.out.println(String.format("The meeting that held the most meetings is Room: %d", result));
	}

}
