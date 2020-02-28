package practiceCoding;
import java.util.*;

import javax.print.attribute.HashAttributeSet;


public class TopNBuzzwords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
        
        int numCompetitors = 6;
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        int numReviews = 6;
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "i am proud to have fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery afshion"};

        /*
        intuition: Top N frequently used words
        - store the competitors into map, along with their frequent count
        - loop through reviews
            - convert the review to lowercase, and split by space
            - if a word is not a competitor then avoid
            - if a word is being used already for a review then avoid
            - else increase the count of the competitor
        - Create a PriorityQueue to find the N top elements, and provided logic to sort
        - Create an array, and fill up with the N top elements
        */
                
        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);
        
        System.out.println(result);
	}

	private static List<String> getTopCompetitors(int numCompetitors, int topNCompetitors, String[] competitors,
			int numReviews, String[] reviews) {
		
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String competitor : competitors) {
			map.put(competitor.toLowerCase(), 0);
		}
		
		for(String review : reviews) {
			String[] words = review.toLowerCase().split(" ");
			
			Set<String> used = new HashSet<>();
			for(String word : words) {
				if(map.containsKey(word) && used.contains(word))
					map.getOrDefault(word, map.get(word) + 1);
			}
		}
		
		PriorityQueue<Map.Entry<String, Integer>> topN = new PriorityQueue<>((a, b) -> 
																				(a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : 
																					a.getValue() - b.getValue() ));
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			topN.offer(entry);
			if(topN.size() > topNCompetitors) {
				topN.poll();
			}
		}
		
		String[] result = new String[topNCompetitors];
        for(int i=topNCompetitors-1; i>=0 && !topN.isEmpty(); i--) {
            Map.Entry<String, Integer> entry = topN.poll();
            result[i] = entry.getKey();
        }
        
        ArrayList<String> r = new ArrayList<>();
        for(String d: result) {
            r.add(d);
        }
        return r;
		
	}

}
