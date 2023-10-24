package Hash;

public class LazyString {
    private String source; // ссылка на исходную строку
    private int start, end; // границы нашей подстроки
    private int hash; // запоминаем хеш чтобы не пересчитывать

    private LazyString() {
    }

    public LazyString(String source, int start, int end) {
        this.source = source;
        this.start = start;
        this.end = end;
        for (int i = start; i < length(); i++){
            hash = source.charAt(i); //задал хеш
        }
    }

    public LazyString shiftRight() {
        LazyString shifted = new LazyString();
        shifted.source = source;
        shifted.start = start + 1;
        shifted.end = end + 1;
        //вычисление хеша для следующей подстроки
        shifted.hash = hash-source.charAt(shifted.start-1)+source.charAt(shifted.end);
        return shifted;
    }

    public int length() {
        return end - start;
    }

    public boolean equals(LazyString that) {
        // если не равны по длине, то не равны и вовсе
        if (length() != that.length()) {
            return false;
        }
        // перебираем и сравниваем на равенство все символы
        for (int i = 0; i < length(); i++) {
            char myChar = source.charAt(start + i);
            char thatChar = source.charAt(that.start + i);
            if (myChar != thatChar) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LazyString that = (LazyString) o;
        return this.equals(that);
    }
}
