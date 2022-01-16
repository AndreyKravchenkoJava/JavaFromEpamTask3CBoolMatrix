package com.company;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Matrix {
    private int n, m;
    private boolean[][] firstMatrix, secondMatrix;

    Matrix(int nSize, int mSize) {
        n = nSize;
        m = mSize;
        firstMatrix = new boolean[n][m];
        secondMatrix = new boolean[n][m];
    }

    private void fillMatrixByRandom (boolean[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
    }

    private void printMatrix (boolean[][] matrix, String name) {
        System.out.println(name);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }

    private void inverseMatrix (boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = !matrix[i][j];
            }
        }
        System.out.println();
    }

    private boolean[][] foldMatrix (boolean[][] matrix, boolean[][] foldedMatrix) {
        boolean[][] foldResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                foldResult[i][j] = matrix[i][j] | foldedMatrix[i][j];
            }
        }
        System.out.println();
        return foldResult;
    }

    private void odinMatrix (boolean[][] matrix, String name) {
        System.out.println(name + " ");
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    private boolean[][] multiplyMatrix (boolean[][] matrix, boolean[][] multiplyByMatrix) {
        boolean[][] multiplyResult = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                multiplyResult[i][j] = matrix[i][j] & multiplyByMatrix[i][j];
            }
        }
        System.out.println();
        return multiplyResult;
    }

    void run() {
        fillMatrixByRandom(firstMatrix);
        printMatrix(firstMatrix, "Первая матрица");
        fillMatrixByRandom(secondMatrix);
        printMatrix(secondMatrix, "Вторая матрциа");
        inverseMatrix(firstMatrix);
        printMatrix(firstMatrix, "Первая матрциа после инверсии");
        inverseMatrix(secondMatrix);
        printMatrix(secondMatrix, "Вторая матрица после инверсии");
        printMatrix(foldMatrix(firstMatrix,secondMatrix), "Результат сложения двух инвертированых матриц");
        printMatrix(multiplyMatrix(firstMatrix, secondMatrix), "Результат умножение двух инвертированых матриц");
        odinMatrix(firstMatrix, "Единицы в первой матрцие");
    }
}
