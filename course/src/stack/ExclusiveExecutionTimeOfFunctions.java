package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Task {
    int taskNumber;
    String startOrEnd;
    int timestamp;

    public Task(int taskNumber, String startOrEnd, int timestamp) {
        this.taskNumber = taskNumber;
        this.startOrEnd = startOrEnd;
        this.timestamp = timestamp;
    }
}

public class ExclusiveExecutionTimeOfFunctions {

    public static void main(String[] args) {
        System.out.println(exclusiveTime(2, List.of("0:start:0", "1:start:6", "1:end:6", "0:end:7")));
    }

    public static List<Integer> exclusiveTime(int n, List<String> logs) {

        Stack<Task> stack = new Stack<>();
        int[] res = new int[n];
        int prevStartTime = 0;

        for (int i = 0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            Task task = new Task(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            if (task.startOrEnd.equals("start")) {
                if (!stack.isEmpty()) {
                    Task prevTask = stack.peek();
                    res[prevTask.taskNumber] += task.timestamp - prevStartTime;
                }
                stack.push(task);
                prevStartTime = task.timestamp;
            } else {
                Task prev = stack.pop();
                res[prev.taskNumber] += task.timestamp - prevStartTime + 1;
                prevStartTime = task.timestamp + 1;
            }
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
