class MyComparator1 implements Comparator<String> {
    public int compare(String s1, String s2) {
        Integer x1 = Integer.parseInt(s1.substring(5, 8));
        Integer x2 = Integer.parseInt(s2.substring(5, 8));
        return x2.compareTo(x1);
    }
}
class MyComparator2 implements Comparator<String> {
    public int compare(String s1, String s2) {
        String slice1 = s1.substring(3, 5);
        String slice2 = s2.substring(3, 5);
        return slice2.compareTo(slice1);
    }
}
class MyComparator3 implements Comparator<String> {
    public int compare(String s1, String s2) {
        Integer x1 = Integer.parseInt(s1.substring(0, 3));
        Integer x2 = Integer.parseInt(s2.substring(0, 3));
        return x1.compareTo(x2);
    }
}
public int productIdSort(String s) {
    String res;
    String[] a = s.split(",");
    int len = a.length;
    MyComparator1 cmp1 = new MyComparator1();
    MyComparator2 cmp2 = new MyComparator2();
    MyComparator3 cmp3 = new MyComparator3();
    Arrays.sort(a, cmp1);
    Arrays.sort(a, cmp2);
    Arrays.sort(a, cmp3);
    for (int i = 0; i < len; i ++)
        System.out.println(a[i]);
    return 8;
}
