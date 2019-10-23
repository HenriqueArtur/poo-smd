package app;

/**
 * ErroArray
 */
public class ErroArray {
    int[] array = new int[10];

    ErroArray(){}
    
    void addInArrayPossition(int value, int pos) throws ArrayIndexOutOfBoundsException {
        if(pos > array.length || pos < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid Position You Dumb Bitch!!!");
        }
        array[pos] = value;
    }

    void printArray(){
        String text = "";
        for (int i = 0; i < array.length; i++) {
            text += (array[i] + " ");
        }
        System.out.println(text);
    }

    void printArrayPos(int value, int pos) throws ArrayIndexOutOfBoundsException {
        if(pos > array.length || pos < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid Position You Dumb Bitch!!!");
        }
        System.out.println("Value = " + value + " Pos = " + pos);
    }
}