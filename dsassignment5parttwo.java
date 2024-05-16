// Name: Chidera Anamege



import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class dsassignment5parttwo {
    public static void main(String[] args) {
        final int num_checkOutLineIndex = 5;
        Queue<Integer>[] checkOutLineIndex = new ArrayDeque[num_checkOutLineIndex];
        Random random = new Random();

        // initialize checkout lines
        for (int i = 0; i < num_checkOutLineIndex; i++) {
            checkOutLineIndex[i] = new ArrayDeque<>();
        }

        // generate list of checkout line indices and shuffle them
        List<Integer> checkout_line_indices = new ArrayList<>();
        for (int i = 0; i < num_checkOutLineIndex; i++) {
            checkout_line_indices.add(i);
        }
        Collections.shuffle(checkout_line_indices, random);

        // generate customers and enqueue them in the shuffled checkout lines
        for (int customer_id = 1; customer_id <= 5; customer_id++) {
            int shortest_line = checkout_line_indices.get(customer_id - 1); // get the index from shuffled list
            checkOutLineIndex[shortest_line].offer(customer_id);
            System.out.println("customer " + customer_id + " entered queue " + shortest_line);
            toSimulateTransaction();
        }

        // dequeue customers from all checkout lines in their original order
        for (int customer_id = 1; customer_id <= 5; customer_id++) {
            int shortest_line = checkout_line_indices.get(customer_id - 1); // get the index from shuffled list
            if (!checkOutLineIndex[shortest_line].isEmpty()) {
                int dequeued_customer_id = checkOutLineIndex[shortest_line].poll();
                System.out.println("customer " + dequeued_customer_id + " exited queue " + shortest_line);
            }
        }
    }

    // simulate transaction time
    private static void toSimulateTransaction() {
        try {
            Thread.sleep(new Random().nextInt(3000) + 1000); // random transaction time between 1 to 4 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
