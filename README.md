# codetest

Technical Test Problem Statement #1

Implement an in-memory caching library to store (key, value) objects for faster retrieval. Key requirements of the library are as follows:

	•	The Cache will have fixed capacity specified at initialization time to limit memory usage
	•	Storage and retrieval from Cache should be fast
	•	Cache should support efficient replacement based on configurable eviction policy (eg. LRU - Least Recently Used) when trying to insert in a full cache
	•	Support expiry of cache entries based on TTL (time to live in seconds) value specified at time of cache insert.


Technical Test Problem Statement #2

Assume that there is a lake with land. Assume number 0 represents water while positive numbers represent the land. The number represents the height of the land - so number 2 means the land is higher than number 1.

You mission, should you accept it, is to create a *square house* which has the largest area on that lake within the same land height.

Input : Two-dimensional array which represent the lake area.
Output: the biggest number represent the area of the house




Example1:
Input:
0	0	3	3	0,
0	1	3	3	0,
1	3	3	3	0,
0	0	2	1	0

should have output : 4

Example2:
Input:
0	3	3	3	0,
2	3	3	3	3,
1	3	3	3	2,
0	0	2	1	0

should have output : 9


Technical Test Problem Statement #3

Background:

There are N airport aprons numbered from 1..N, located in sequential, equidistant manner. Any apron can be either empty or already assigned. As aircraft is landed, apron will be assigned to aircraft. When aircraft takes off, corresponding apron will become empty. Post landing, aircraft can approach apron from two gates, Gate A entering from apron 1 and gate B entering from apron N.

With an assumption that, time required to reach gate A or gate B from landing station is same, apron assignment algorithm assigns a gate (either A or B) and empty apron number X (1 <= X <= N) to aircraft, such that, aircraft have to travel minimal distance to reach the apron (to save time for passengers). Apron assignment algorithm prefers Gate A over Gate B in case of collision. If all aprons are assigned, aircraft is redirected to other terminal.


Problem:

You will be given:
1. Number of airport aprons (N) on first line.
2. Sequence of events in a limited time frame, with each event on new line. Event is described with event ID and aircraft name separated by space. Event ID could be aircraft landing at the airport (L) or aircraft taking off from the airport (T). If all aprons are assigned, aircraft is redirected to other terminal.

You have to design and implement apron assignment algorithm using efficient data structures so that apron assignment is optimal. Based on the designed algorithm, for each landed aircraft, you have to output the gate and apron number (separated by a space, each on new line) assigned to aircraft. If all aprons are assigned, output "REDIRECT".

Notes:
You can read input from file.
Assume that all aprons are empty in the beginning.
"REDIRECT"ed aircrafts are not considered for further assignment.

Sample input/output:
Input:

10
L SGP-506
L HAN-278
L BKK-398
L HAN-279
L SGP-507
T HAN-278
L KLA-237
L DEL-346
T HAN-279
L DEL-347
L HAN-280
L BKK-399
L KLA-238
T HAN-280
T BKK-398
L SGP-508
L DEL-348
L KLA-239
L BKK-400
T SGP-506
L HAN-281

Output:
A 1
B 10
A 2
B 9
A 3
B 10
B 8
B 9
A 4
B 7
A 5
A 2
A 4
B 6
REDIRECT
A 1
