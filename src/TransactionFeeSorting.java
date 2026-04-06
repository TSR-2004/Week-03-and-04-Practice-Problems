import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }
}

public class TransactionFeeSorting {

    static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee &&
                            list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    static ArrayList<Transaction> getHighFee(ArrayList<Transaction> list) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction t : list) {
            if (t.fee > 50) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        System.out.println("Bubble Sort (fees):");
        for (Transaction t : list) {
            System.out.println(t.id + ":" + t.fee);
        }

        insertionSort(list);
        System.out.println("Insertion Sort (fee + timestamp):");
        for (Transaction t : list) {
            System.out.println(t.id + ":" + t.fee + "@" + t.timestamp);
        }

        ArrayList<Transaction> high = getHighFee(list);
        System.out.println("High-fee outliers:");
        if (high.size() == 0) {
            System.out.println("none");
        } else {
            for (Transaction t : high) {
                System.out.println(t.id + ":" + t.fee);
            }
        }
    }
}