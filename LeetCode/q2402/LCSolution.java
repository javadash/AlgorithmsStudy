package q2402;

import java.util.Arrays;
import java.util.PriorityQueue;

class LCSolution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));
        // {endTime, room}

        //Initializes an array `roomCount` of size `n` to keep track of the number of meetings booked in each room.
        int[] roomCount = new int[n]; // number of meeting of the room
        int result = 0;

        for (int i = 0; i < n; i++)
            queue.add(new long[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0]; // new meeting start time

            while (queue.peek()[0] < time) // order all available room by room index
                queue.add(new long[] { time, queue.poll()[1] });

            long[] current = queue.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]); // current room endTime + this meeting duration
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) // update result
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            queue.add(new long[] { meetingEndTime, curRoom });
        }

        return result;
    }
	public static void main(String[] args) {
		int meetings[][] = new int[10][10];
		int[][] aListOfMtgs = {{0,10},{7,9},{6,12},{9,14},{1,5},{2,7},{3,4}};
		int[][] testMtgs = {{0,10},{1,5},{2,7},{3,4}};
		
		int[][] testMtgs2 = {{1,20},{2,10},{3,5},{4,9}, {6,8}};
		int[][] testMtgs3 = {{0,10},{1,2},{12,14},{13,15}};
		LCSolution mtnRooms = new LCSolution();
		
		int result = mtnRooms.mostBooked(3, testMtgs2);
		result = mtnRooms.mostBooked(2, testMtgs2);
		System.out.println(String.format("The meeting that held the most meetings is Room: %d", result));
	}

}


/*
 * Certainly! This solution is an implementation of the meeting rooms problem using a PriorityQueue (min heap) and an array to keep track of the number of meetings booked in each room. Let's break down the code step by step:

1. `Arrays.sort(meetings, (a, b) -> a[0] - b[0])`: Sorts the `meetings` array based on the start times of the meetings in ascending order. This is done so that we process meetings in chronological order.

2. `PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> ...)`:
   - Initializes a priority queue named `queue` that will hold arrays of long values.
   - The comparator `(a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0])` sorts based on two criteria:
     - If two meetings have the same start time (`a[0] == b[0]`), they are sorted by the room index in ascending order (`(int) (a[1] - b[1])`).
     - If two meetings have different start times, they are sorted based on start times in ascending order (`(int) (a[0] - b[0])`).

3. `int[] roomCount = new int[n];`: Initializes an array `roomCount` of size `n` to keep track of the number of meetings booked in each room.

4. Loop through all rooms and add them to the queue initially, as each room is available from the start.

5. Loop through each meeting in chronological order:
   - `while (queue.peek()[0] < time)`: Checks if there are available rooms whose end time is before the start time of the current meeting. Pops these rooms from the queue and re-inserts them with the current meeting's start time to order them by room index.
   - `long[] current = queue.poll();`: Pops the room with the earliest available time.
   - `long meetingEndTime = current[0] + (item[1] - item[0]);`: Calculates the end time of the current meeting in the popped room.
   - `roomCount[curRoom]++;`: Increments the count of meetings booked in the current room.
   - Checks if the current room's meeting count is greater or equal to the meeting count of the `result` room. If so, updates the `result` room index.
   - `queue.add(new long[] { meetingEndTime, curRoom });`: Adds the current room back to the queue with the new end time after the meeting.

6. After processing all meetings, the code returns the `result` room index, which corresponds to the room with the maximum number of booked meetings.

This solution efficiently keeps track of available rooms using a min heap and optimally assigns meetings to rooms while also updating the room with the maximum bookings.
 */