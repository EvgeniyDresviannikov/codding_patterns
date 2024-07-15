package hash.maps;

import java.util.HashMap;

public class RequestLogger {

    private int timeLimit;
    private HashMap<String, Integer> messages;

    public RequestLogger(int timeLimit) {
        this.timeLimit = timeLimit;
        this.messages = new HashMap<>();
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        if (messages.containsKey(request)) {
            int diff = timestamp - messages.get(request);
            if (diff < this.timeLimit) {
                return false;
            }
        }

        messages.put(request, timestamp);

        return true;
    }

}
