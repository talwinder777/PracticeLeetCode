package practiceCoding;

import java.util.HashMap;
/*Problem Statement
 * https://leetcode.com/discuss/interview-question/421787/                  Google
 * 
 * */
public class MostBookedHotelRoom {
	public static void main(String args[]) {
		
		String[] hotelRooms = {"+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E","+2A", "-2A", "+2A", "-2A", "+2A", "-2A", "+2A", 
				"-2A","+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B"};
		System.out.println(getMostBookedRoom(hotelRooms));
	}

	private static String getMostBookedRoom(String[] hotelRooms) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int maxBook = 0;
		String maxBookRoom = "";
		
		for(int i = 0; i < hotelRooms.length; i++) {
			
			if(hotelRooms[i].charAt(0) == '-')
				continue;
			//inserting the values in map
			map.put(hotelRooms[i], map.getOrDefault(hotelRooms[i], 0) + 1);
			
			if(map.get(hotelRooms[i]) > maxBook) {
				maxBook = map.get(hotelRooms[i]);
				maxBookRoom = hotelRooms[i];
			}
			else if(map.get(hotelRooms[i]) ==  maxBook) {
				maxBookRoom = maxBookRoom.compareTo(hotelRooms[i]) < 0 ? maxBookRoom : hotelRooms[i];
			}
		}
		return maxBookRoom.substring(1);
	}
}
