package com.finco.cache;

/*
Technical Test Problem Statement #1

Implement an in-memory caching library to store (key, value) objects for faster retrieval.
Key requirements of the library are as follows:

	•	The Cache will have fixed capacity specified at initialization time to limit memory usage
	•	Storage and retrieval from Cache should be fast
	•	Cache should support efficient replacement based on configurable eviction policy
	    (eg. LRU - Least Recently Used) when trying to insert in a full cache
	•	Support expiry of cache entries based on TTL (time to live in seconds)
	    value specified at time of cache insert.

 */
public interface Solution<K, V, Integer> {
    public V put(K k, V v, Integer time);
}
