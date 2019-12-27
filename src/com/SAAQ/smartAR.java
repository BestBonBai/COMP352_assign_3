package com.SAAQ;

import java.util.List;
import java.util.Set;

/** This interface represents the "automobile registration listing".
     * which automatically adapts to the dynamic content that it operates on.
     *
     * @author H. BAI
     *
     * @version 2.0 (2019/12/01)
     */
    public interface smartAR<K,V> {  //<k,v> is general type.

        /** This method set Threshold, and decide which data type should be used.
         * Condition: 100<=Threshold<=~500000.
         * @param  threshold                                             */
        public void setThreshold(int threshold);

        /** This method set key length, where 6<=length<=12
         * that defines the fixed string length of keys
         * @param length
         *           */
        public void setKeyLength(int length);

        /** This method randomly generates a sequence
         * containing n new non-existing keys of alphanumeric characters.
         *
         * @param n
         *              */
        public void generate(int n);

        /** This method return all keys as a sorted sequence (lexicographic order).
         *
         * @return all keys as a sorted sequence                                */
        public List<K> allKeys();

        /** This method add an entry for the given key and value.
         *
         * @param key
         * @param value                */
        public void add(K key,V value);


        /** This method remove the entry for the given key.
         *
         * @param key
         *                */
        public void remove(K key);

        /** This method return the values of the given key.
         *
         * @param  key
         * @return value                                 */
        public V getValues(K key);

        /** This method return the key for the successor of key.
         *
         * @param  key
         * @return the successor of key                                  */
        public K nextKey( K key);

        /** This method return the key for the predecessor of key.
         *
         * @param  key
         * @return the predecessor of key                               */
        public K prevKey( K key);

        /**This method returns a sequence (sorted in reverse chronological order)
         * of cars (previously) registered with the given key (license plate).
         *
         * @param key
         * @return a sequence ArrayList
         */
        public List<V> previousCars( K key);


}
