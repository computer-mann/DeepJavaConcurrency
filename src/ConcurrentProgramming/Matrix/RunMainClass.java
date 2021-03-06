package ConcurrentProgramming.Matrix;

import BasicThreading.MatrixGenerator;
import BasicThreading.SerialMatrix;
import ConcurrentProgramming.Matrix.Group.ParallelGroupMultiplier;
import ConcurrentProgramming.Matrix.Individual.ParallelIndividualMultiplier;
import ConcurrentProgramming.Matrix.Row.ParallelRowMultiplier;

import java.util.Date;

public class RunMainClass {
    public static void main(String[] args) {
     //  RunMainClass.Group(); //72,647
      //  RunMainClass.Individual(); //852,492
        RunMainClass.Row(); //76434
    }

    private static void Individual(){
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] resultSerial = new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }

    private static void Group(){
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] resultSerial = new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelGroupMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }

    private static void Row(){
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] resultSerial = new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelRowMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }
}
