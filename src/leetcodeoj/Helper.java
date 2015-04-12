package leetcodeoj;

public final class Helper {

    public static <T> void print1DArray(T[] array) {
        System.out.println("Printing 1D array");
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                System.out.print(array[i] + " ");
            }else {
                System.out.println(array[i]);
            }
        }
        System.out.println("Done");
    }

    public static <T> void print2DArray(T[][] array) {
        System.out.println("Printing 2D array");
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Done");
    }
}
