import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // Base sentinel value
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset on zero: any product including this element will be 0
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        // If k >= n, a 0 was added within the last k numbers
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}