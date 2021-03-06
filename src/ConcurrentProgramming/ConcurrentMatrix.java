package ConcurrentProgramming;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentMatrix implements  Runnable{

    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int row;
    private final int column;

    public ConcurrentMatrix(double[][] result, double[][]
            matrix1, double[][] matrix2,
                                    int i, int j) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = i;
        this.column = j;
    }
    @Override
    public void run() {
        result[row][column] = 0;
        for (int k = 0; k < matrix1[row].length; k++) {
            result[row][column] += matrix1[row][k] * matrix2[k][column];
        }
    }
}
class ParallelIndividualMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result) {
        List<Thread> threads=new ArrayList<>();
        int rows1=matrix1.length;
        int rows2=matrix2.length;
        for (int i=0; i<rows1; i++) {
            for (int j=0; j<rows2; j++) {
                ConcurrentMatrix task=new ConcurrentMatrix
                        (result, matrix1, matrix2, i, j);
                Thread thread=new Thread(task);
                thread.start();
                threads.add(thread);
                if (threads.size() % 10 == 0) {
                    waitForThreads(threads);
                }
            }
        }
    }
    private static void waitForThreads(List<Thread> threads){
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}