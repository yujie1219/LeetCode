package solution;

import java.util.*;

public class LeetCode332 {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(createPair("EZE", "TIA"));
        tickets.add(createPair("EZE", "HBA"));
        tickets.add(createPair("AXA", "TIA"));
        tickets.add(createPair("JFK", "AXA"));
        tickets.add(createPair("ANU", "JFK"));
        tickets.add(createPair("ADL", "ANU"));
        tickets.add(createPair("TIA", "AUA"));
        tickets.add(createPair("ANU", "AUA"));
        tickets.add(createPair("ADL", "EZE"));
        tickets.add(createPair("ADL", "EZE"));
        tickets.add(createPair("EZE", "ADL"));
        tickets.add(createPair("AXA", "EZE"));
        tickets.add(createPair("AUA", "AXA"));
        tickets.add(createPair("JFK", "AXA"));
        tickets.add(createPair("AXA", "AUA"));
        tickets.add(createPair("AUA", "ADL"));
        tickets.add(createPair("ANU", "EZE"));
        tickets.add(createPair("TIA", "ADL"));
        tickets.add(createPair("EZE", "ANU"));
        tickets.add(createPair("AUA", "ANU"));

        new LeetCode332().findItinerary(tickets);
    }

    private static List<String> createPair(String a, String b) {
        List<String> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List> fromTo = new HashMap<>();
        Map<String, List> fromToUsedCopy = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (!fromTo.containsKey(from)) {
                fromTo.put(from, new ArrayList());
            }
            fromTo.get(from).add(to);
        }

        for (String key : fromTo.keySet()) {
            List<String> toPorts = fromTo.get(key);
            Collections.sort(toPorts);
            fromToUsedCopy.put(key, new ArrayList(toPorts));
        }

        String currentKey = "JFK";
        List<String> result = new ArrayList<>();
        result.add(currentKey);
        findRoute(fromTo, fromToUsedCopy, currentKey, result, tickets.size());

        return result;
    }

    private boolean findRoute(Map<String, List> fromTo, Map<String, List> fromToUsedCopy, String currentPort, List<String> result, int ticketNum) {
        if (ticketNum == 0) {
            return true;
        }

        if (fromTo.containsKey(currentPort)) {
            List<String> toPorts = fromTo.get(currentPort);

            for (String toPort : toPorts) {
                List<String> usedToPorts = fromToUsedCopy.get(currentPort);
                if (usedToPorts.contains(toPort)) {
                    result.add(toPort);
                    usedToPorts.remove(usedToPorts.indexOf(toPort));

                    if (findRoute(fromTo, fromToUsedCopy, toPort, result, ticketNum - 1)) {
                        return true;
                    }

                    result.remove(result.size() - 1);
                    usedToPorts.add(toPort);
                }
            }
        }

        return false;
    }
}
