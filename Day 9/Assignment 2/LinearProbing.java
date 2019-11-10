import java.util.Arrays;
public class LinearProbing<Key, Value> {
    Key[] keys;
    Value[] values;

    public LinearProbing(Key[] ks, Value[] vs) {
        keys = (Key[]) new Object[ks.length * 100];
        values = (Value[]) new Object[ks.length * 100];
        createDict(ks, vs);
    }

    public int hash(Key k) {
        return ((k.hashCode() & 0x7fffffff) % (keys.length));
    }

    public void put(Key k, Value v) {
        if (k == null) {
            return;
        }
        int index = hash(k);
        int i;
        for(i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                values[i] = v;
                return;
            }
        }
        keys[i] = k;
        values[i] = v;
    }

    public Value get(Key k) {
        if (k == null) {
            return null;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key k) {
        if (k == null) {
            return;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                keys[i] = null;
                values[i] = null;
                for (int j = i + 1; keys[j] != null; j = (j + 1) % keys.length) {
                    if (hash(keys[j]) != index) {
                        return;
                    }
                    put(keys[j], values[j]);
                    keys[j] = null;
                    values[j] = null;
                }
                return;
            }
        }
    }

    public void createDict(Key[] k, Value[] v) {
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public void display() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null){
            System.out.println(keys[i] + ", " + values[i]);
            }
        }
        System.out.println("==================");
    }

    public static void main(String[] args) {
        String str = "I am Vivek I am this I know dash";
        String[] test1_keys = str.split(" ");
        System.out.println(Arrays.toString(test1_keys));
        Integer[] test1_vals = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(test1_vals));
        LinearProbing<String, Integer> lp1 = new LinearProbing(test1_keys, test1_vals);
        lp1.display();
    }
}
