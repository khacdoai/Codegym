package ass4.baitap.lopStopWatch;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            double temp = Math.random() * 100 + 1;
            arr[i] = (int) temp;
        }
        System.out.println("A1:" + arr[1]);

        stopWatch stopWatch = new stopWatch();
        selectionSort(arr);
        stopWatch.stop();
        System.out.println("Start time: " + stopWatch.getStartTime());
        System.out.println("Stop time: " + stopWatch.getEndTime());
        System.out.println("Time execution of selection sort algorithm is " + stopWatch.getElapsedTime() + "  milli second");
    }

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
