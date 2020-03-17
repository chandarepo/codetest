package com.finco.apronallotment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Background:

    There are N airport aprons numbered from 1..N, located in sequential,
    equidistant manner. Any apron can be either empty or already assigned.
    As aircraft is landed, apron will be assigned to aircraft.
    When aircraft takes off, corresponding apron will become empty.
    Post landing, aircraft can approach apron from two gates,
    Gate A entering from apron 1 and gate B entering from apron N.

    With an assumption that, time required to reach gate A or gate B from
    landing station is same, apron assignment algorithm assigns a gate (either A or B)
    and empty apron number X (1 <= X <= N) to aircraft, such that, aircraft have to
    travel minimal distance to reach the apron (to save time for passengers).
    Apron assignment algorithm prefers Gate A over Gate B in case of collision.
    If all aprons are assigned, aircraft is redirected to other terminal.


Problem:

    You will be given:
    1. Number of airport aprons (N) on first line.
    2. Sequence of events in a limited time frame, with each event on new line.
    Event is described with event ID and aircraft name separated by space.
    Event ID could be aircraft landing at the airport (L) or aircraft taking off
    from the airport (T). If all aprons are assigned, aircraft is redirected to other terminal.

    You have to design and implement apron assignment algorithm using efficient data structures
    so that apron assignment is optimal. Based on the designed algorithm, for each landed aircraft,
    you have to output the gate and apron number (separated by a space, each on new line) assigned
    to aircraft. If all aprons are assigned, output "REDIRECT".

Notes:
    You can read input from file.
    Assume that all aprons are empty in the beginning.
    "REDIRECT"ed air crafts are not considered for further assignment.

Sample input/output:
Input:

10
L SGP-506   A1
L HAN-278   B10
L BKK-398   A2
L HAN-279   B9
L SGP-507   A3
T HAN-278   B10->null
L KLA-237   B10
L DEL-346   B8
T HAN-279   B9->null
L DEL-347   B9
L HAN-280   A4
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

 */
public interface Solution {

    public default List<String> getData(String fileName) throws IOException {
        File file = new File(
                Solution.class.getClassLoader().getResource(fileName).getFile()
        );
        if(!file.exists()){
            System.out.println("File Not found");
            return Collections.emptyList();
        }
        List<String> lines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line.trim());
                line = bufferedReader.readLine();
            }
        }catch (IOException ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
        return lines;
    }

}
