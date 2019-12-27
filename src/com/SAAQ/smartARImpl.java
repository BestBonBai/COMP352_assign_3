package com.SAAQ;

import java.util.*;

public class smartARImpl<K,V> implements smartAR<K,V> {

    private int method;//method: 1 for sequence, 2 for Hashtable;
    private int length;//length is 6 to 12;
    private static char[] alphanum = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8',
            '9'};//for random license plate from A to Z and 0 to 9;
    private Map<K, List<V>> m1; //map with list<value> for method 1
    private List<K> allKey; //for all keys of method 1;
    private SortedMap<K,List<V>> m2;//map for method 2;
    private List<K> allTreeKey;// for all keys of method 2;

    //smartARImpl<K,V>
    public smartARImpl(){
        //method 1 uses Map, add/remove/get O(1);
        m1 = new LinkedHashMap<K,List<V>>();
        //method 2 uses TreeMap, O(log(n)); red & black tree structure;
        m2 = new TreeMap<K,List<V>>();


    }//constructor


    /**
     * This method set Threshold, and decide which data type should be used.
     * Condition: 100<=Threshold<=~500000.
     *
     * @param threshold
     */
    @Override
    public void setThreshold(int threshold) {
        if(threshold > 0 & threshold < 100){
            method = 1;
        }
        else if(threshold >= 100 & threshold <= 500000 ){
            method = 2;
        }
        else {
            System.out.println("the threshold is not correct!");
        }
    }

    /**
     * This method set key length, where 6<=length<=12
     * that defines the fixed string length of keys
     *
     * @param length
     */
    @Override
    public void setKeyLength(int length) {
        if( length >= 6 & length <= 12){
            this.length = length;
        }
        else {
            System.out.println("the length is not in range of [6 12].");
        }
    }

    /**
     * This method randomly generates a sequence
     * containing n new non-existing keys of alphanumeric characters.
     *
     * @param n
     */
    @Override
    public void generate(int n) {
        K licenPlate;// for store license plate keys;
        V demoValue;//demo values;
        boolean repeat = false;//use repeat to check whether the list includes same key;
        Random r = new Random();//for random values;
        if(method == 1) {
            for (int i = 0; i < n; i++) {
                licenPlate = (K) geneRandomAlphnum();
                //System.out.println("print random key");
                //System.out.println(licenPlate);
                repeat = m1.containsKey(licenPlate);
                //the method is to check if the key has existed in the map;
                while (repeat == true) {
                    licenPlate = (K) geneRandomAlphnum();
                    repeat = m1.containsKey(licenPlate);
                    System.out.println("repeat then random new one");
                }
                //set v is random years from[1900,2020]; if need, can modify any types;
                demoValue = (V) String.valueOf(r.nextInt(121)+1900);
                add(licenPlate,demoValue);
            }
        }
        else if(method == 2){
            for (int j = 0; j < n; j++){
                licenPlate = (K) geneRandomAlphnum();
                repeat = m2.containsKey(licenPlate);
                //the method is to check if the key has existed;
                while(repeat == true){
                    licenPlate = (K) geneRandomAlphnum();
                    repeat = m2.containsKey(licenPlate);
                    System.out.println("repeat ...then random new one key.");
                }
                //set v is random years from[1900,2020]; if need, can modify any types;
                demoValue = (V) String.valueOf(r.nextInt(121)+1900);
                add(licenPlate,demoValue);
            }
        }

    }

    /**
     * This method is to generate random alphanumeric characters
     * with length from setKeyLength
     *
     * @return a string key.
     */
    private String geneRandomAlphnum(){
        Random r = new Random();
        char[] templ;//template a random alphanumeric character;
        templ = new char[length];

        for(int i = 0; i < length; i++){
            //random a char of alphanum[], range is [0,alphanum[].length);
            int sub = r.nextInt(alphanum.length);
            templ[i] = alphanum[sub];
        }
        String result = String.valueOf(templ);
        return result;
    }



    /**
     * This method return all keys as a sorted sequence (lexicographic order).
     *
     * @return all keys as a sorted sequence
     */
    @Override
    public List<K> allKeys() {
        if(method == 1) {
            allKey = new ArrayList<K>(m1.keySet());//transfer set to list;
            allKey.sort(null);//sort sequence in lexicographic order;
            return allKey;
        }
        else if(method == 2){
            allTreeKey = new ArrayList<K>(m2.keySet());
            allTreeKey.sort(null);
            return allTreeKey;
        }
        return null;
    }

    /**
     * This method add an entry for the given key and value.
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        if(method == 1){
            if(key != null) {
                if (!m1.containsKey(key)) {
                    //create a new list
                    m1.put(key, new ArrayList<V>());
                }
                //add value to the List value with the same key;
                m1.get(key).add(value);
            }
        }
        else if(method == 2){
            if(key != null){
                if(!m2.containsKey(key)){
                    //create a new list<V>
                    m2.put(key, new ArrayList<V>());
                }
                //add value to the existed List<V> of the key;
                m2.get(key).add(value);
            }
        }
    }

    /**
     * This method remove the entry for the given key.
     *
     * @param key
     */
    @Override
    public void remove(K key) {
        if(method == 1){
            m1.remove(key);
        }
        else if (method == 2){
            m2.remove(key);
        }
    }

    /**
     * This method return the values of the given key.
     *
     * @param key
     * @return value
     */
    @Override
    public V getValues(K key) {
        List<V> newValue = new ArrayList<V>();
        if(method == 1){
            //get the lastest value of the key.
            newValue = m1.get(key);
            return newValue.get(newValue.size()-1);
        }
        else if(method == 2){
            //get the lastest value of the key.
            newValue = m2.get(key);
            return newValue.get(newValue.size()-1);
        }
        return null;
    }

    /**
     * This method return the key for the successor of key.
     *
     * @param key
     * @return the successor of key
     */
    @Override
    public K nextKey(K key) {
        if(method == 1){
            if(allKey.indexOf(key) == allKey.size()-1){
                System.out.println("no exist next key!");
                return null;
            }
            return allKey.get(allKey.indexOf(key)+1);
        }
        else if(method == 2){
            if(allTreeKey.indexOf(key) == allTreeKey.size()-1){
                System.out.println("no exist next key!!");
                return null;
            }
            return allTreeKey.get(allTreeKey.indexOf(key)+1);
        }
        return null;
    }

    /**
     * This method return the key for the predecessor of key.
     *
     * @param key
     * @return the predecessor of key
     */
    @Override
    public K prevKey(K key) {
        if(method == 1){
            if(allKey.indexOf(key) == 0){
                System.out.println("It is empty!");
                return null;
            }
            return allKey.get(allKey.indexOf(key) - 1);
        }
        else if(method == 2){
            if(allTreeKey.indexOf(key) == 0){
                System.out.println("It is empty!!");
                return null;
            }
            return allTreeKey.get(allTreeKey.indexOf(key)-1);
        }
        return null;
    }

    /**
     * This method returns a sequence (sorted in reverse chronological order)
     * of cars (previously) registered with the given key (license plate).
     *
     * @param key
     * @return a sequence ArrayList (except current value of the key).
     */
    @Override
    public List<V> previousCars(K key) {
        List preCarValues = new ArrayList();
        if(method == 1){
            preCarValues = m1.get(key);
            //except the current value of key;
            preCarValues = preCarValues.subList(0,preCarValues.size()-1);
            preCarValues.sort(Comparator.reverseOrder());
            return preCarValues;
        }
        else if(method == 2){
            preCarValues = m2.get(key);
            preCarValues = preCarValues.subList(0,preCarValues.size()-1);
            preCarValues.sort(Comparator.reverseOrder());
            return preCarValues;
        }
        System.out.println("no execute previousCars method!");
        return null;
    }
}
