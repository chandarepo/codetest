package com.finco.apronallotment;

import java.io.IOException;
import java.util.List;

public class AirportApronAllotment implements Solution {

    private int apronSize;
    private List<String> flightRecord;

    private CommandProcessor commandProcessor;

    public static void main(String[] args) throws IOException {

        AirportApronAllotment allotment = new AirportApronAllotment();

        List<String> inputData = allotment.getData("SampleInput.txt");

        if(inputData != null && inputData.size()>0){

            String apronSize_str = inputData.remove(0);

            allotment.apronSize = Integer.valueOf(apronSize_str.trim());
            allotment.flightRecord = inputData;

            allotment.commandProcessor = new CommandProcessorImpl(allotment.apronSize );

            for(String line: allotment.flightRecord){
                allotment.commandProcessor.process(line);
            }

        }
    }
}
