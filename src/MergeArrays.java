

public class MergeArrays {

    public int[] MergeArrays(int[] a, int[] b) {
        int [] c = mergeIt(a,b);
        int [] d = removeIt(c);
        int [] e = sortIt(d);
        return e;
    }

    private int[] mergeIt(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int k=0;
        for (int n : a) c[k++]=n;
        for (int n : b) c[k++]=n;
        return c;
    }

    private int[] removeIt(int[] c) {
        int len=c.length;
        for (int i=0;i<len-1;i++)
            for (int j=i+1;j<len;j++)
                if (c[i] == c[j]) {
                    for (int k=j;k<len-1;k++)
                        c[k]=c[k+1];
                    --len;
                }
        int [] r = new int[len];
        for (int i=0;i<r.length;i++)
            r[i]=c[i];
        return r;
    }

    private int[] sortIt(int[] a) {
        for(int index=0; index<a.length-1; index++)
            for(int i=index+1; i<a.length; i++)
                if(a[index] > a[i]){
                    int temp = a[index];
                    a[index] = a[i];
                    a[i] = temp;
                }
        return a;
    }

    public void printIt(int[] a) {
        System.out.print("[");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if (i!=a.length-1) System.out.print(",");
            else System.out.print("]");
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 8, 100, 4, 65, 9, 7};
        int[] b = {5, 6, 43, 8, 39, 74, 9, 100};

        MergeArrays array = new MergeArrays();
        int [] r = array.MergeArrays(a, b);
        array.printIt(r);
    }
}
