package Hash;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {
        String source = "CACABABABCCCAABAC";

        System.out.println(hasRepeats(source, 4)); // true
        System.out.println(hasRepeats(source, 5)); // false
    }

    public static boolean hasRepeats(String source, int size) {
        Set<LazyString> slices = new HashSet<>(); // множество всех подстрок длины size
        LazyString prev = null; // переменная для сохранения предыдущей подстроки
        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
            LazyString slice; // вырезание подстроки
            if (prev == null) {
                slice = new LazyString(source,0,size-1);
            } else {
                slice = prev.shiftRight();
            }
            if (slices.contains(slice)) { // проверка на наличие повтора этой подстроки
                return true;
            } else {
                slices.add(slice);
            }
            prev = slice;
        }
        return false;
    }
}
