import java.util.ArrayList;
import java.util.List;

class Fancy {

    private List<Integer> numbers;   
    private long mulFactor;          
    private long addFactor;         
    private int MOD;

    public Fancy() {
        numbers = new ArrayList<>();
        mulFactor = 1;   
        addFactor = 0;
        MOD = 1000000007;  
    }

    public void append(int val) {


        long temp = val;

       
        temp = (temp - addFactor) % MOD;
        if (temp < 0) temp += MOD;   

      
        long inverse = modInverse(mulFactor);

        temp = (temp * inverse) % MOD;

        numbers.add((int) temp);

      
    }

    public void addAll(int inc) {
        
        addFactor = (addFactor + inc) % MOD;
    }

    public void multAll(int m) {

       
        mulFactor = (mulFactor * m) % MOD;

        addFactor = (addFactor * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx < 0 || idx >= numbers.size()) {
            return -1;
        }

        long baseVal = numbers.get(idx);

       
        long result = (baseVal * mulFactor) % MOD;
        result = (result + addFactor) % MOD;

        return (int) result;
    }

    private long modInverse(long value) {

        long power = MOD - 2;
        long result = 1;

        value %= MOD;

        while (power > 0) {

            if ((power & 1) == 1) {   
                result = (result * value) % MOD;
            }

            value = (value * value) % MOD;
            power >>= 1;   
        }

        return result;
    }

}