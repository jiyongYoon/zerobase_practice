package Structure;

public class MyArray {
    int[] arr;

    MyArray() {}
    MyArray(int size) {
        this.arr = new int[size];
    }

    public void insertData(int index, int data) {
        if(index < 0 || index > arr.length) {
            System.out.println("Error");
            return;
        }

        int[] arrDup = arr.clone();
        arr = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            arr[i] = arrDup[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = arrDup[i-1];
        }
        arr[index] = data;
    }

    public void removeData(int data) {
        int targetIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == data) {
                targetIdx = i;
                break;
            }
        }

        if(targetIdx == -1) {
            System.out.println("No data");
        } else {
            int[] arrDup = arr.clone();
            arr = new int[arr.length - 1];

            for (int i = 0; i < targetIdx; i++) {
                arr[i] = arrDup[i];
            }
            for (int i = targetIdx; i < arr.length; i++) {
                arr[i] = arrDup[i+1];
            }
        }
    }
}
