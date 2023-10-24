package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        int[] copyPrices = prices;
        if (copyPrices[0] > money) return prices.length;
        if (copyPrices[copyPrices.length - 1] < money) return 0;

        var left = 0;
        var right = copyPrices.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (copyPrices[middle] > money && copyPrices[middle - 1] <= money) return copyPrices.length - middle;
            if (copyPrices[middle] <= money) {
                left = middle + 1;
            }
            if (copyPrices[middle] > money) {
                right = middle - 1;
            }
        }
        if (copyPrices[left] > money) return 1;
        return 0;
    }
}
