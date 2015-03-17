package bptree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implements Comparator for sorting keys.
 */
public class Key implements Comparator<Long[]> {

    /**
     * Given two long[]'s, which represent the keys, compare them.
     * @param a key
     * @param b key
     * @return a negative integer, zero, or a positive integer if the first argument is less than, equal to, or greater than the second.
     */
    public int compare(Long[] a, Long[] b) {

        if(a.length != b.length){ return a.length - b.length; }
        long temp;
        for (int i = 0; i < a.length; i++) {
            temp = a[i] - b[i];
            if (temp != 0) {
                return a[i].compareTo(b[i]);
            }
        }
        return 0;
    }
    public int prefixCompare(Long[] search_key, Long[] key) {
        long temp;
        for (int i = 0; i < search_key.length; i++) {
            temp = search_key[i] - key[i];
            if (temp != 0) {
                return search_key[i].compareTo(key[i]);
            }
        }
        return 0;
    }

    /**
     * Given to keys a, b, determines if a is a valid prefix of b.
     * @param a prefix to check. Your search key
     * @param b full key to compare to. Your value in the index.
     * @return
     */
    public boolean validPrefix(Long[] a, Long[] b){

        if((a.length > b.length) || a.length == 0){ //The empty prefix should match nothing. You must specify atleast the path, so give me at least one item.
            return false;
        }
        for(int i = 0; i < a.length; i++){
            if(!a[i].equals(b[i])){
                return false;
            }
        }
        return true;

    }

    public static String asString(Long[] key){
        return Arrays.toString(key);
    }
}
