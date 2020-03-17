package com.finco.apronallotment;


import java.util.HashMap;
import java.util.Map;

public class CommandProcessorImpl implements CommandProcessor{

    private int size;
    private Map<String,Integer> apronAeroplaneMap = new HashMap<>();
    private String[] apronArray;
    private int aOffSet = 0;
    private int bOffSet = 0;

    public CommandProcessorImpl (int n) {
        this.apronArray = new String[n+1];
        this.size = n;
    }

    @Override
    public synchronized void process (String line) {
       if(line == null) return;
        String[] commands = line.trim().split(" ");
        if("L".equalsIgnoreCase(commands[0])){
            //new Thread(() -> {
                allocateApron(commands[1]);
           // }).start();
        }else if("T".equalsIgnoreCase(commands[0])){
           // new Thread(() -> {
                deAllocateApron(commands[1]);
           // }).start();
        }
    }

    // O(n/2) worst case
    public synchronized String allocateApron (String aeroplane){
        if(apronAeroplaneMap.size() == size) {
            System.out.println("REDIRECT");
            return "REDIRECT";
        }
         //aOffSet = size/2;
         //bOffSet = size/2;

        //Find open apron from A terminal
        for(int i =1; i <= size/2; i++){
            if(apronArray[i]==null){
                aOffSet=i;
                break;
            }
        }
        //Find open apron from B terminal
        for(int i =size; i > size/2; i--){  // O(n/2) worst case
            if(apronArray[i]==null){
                bOffSet=i;
                break;
            }
        }

        if(aOffSet <= (size +1 -bOffSet) ){
            if(apronArray[aOffSet]== null) {
                apronArray[aOffSet] = "A" + aOffSet;
                apronAeroplaneMap.put(aeroplane, aOffSet);
                System.out.println(apronArray[aOffSet]);
            }else{
                apronAeroplaneMap.put(aeroplane,bOffSet );
                apronArray[bOffSet] = "B"+bOffSet;
                System.out.println(apronArray[bOffSet]);
            }
        }else{
            apronAeroplaneMap.put(aeroplane,bOffSet );
            apronArray[bOffSet] = "B"+bOffSet;
            System.out.println(apronArray[bOffSet]);
        }
        return null;
    }

    //O(1)
    public synchronized String deAllocateApron (String aeroplane){
        if(apronAeroplaneMap.size() == 0) return "";
        int offset = apronAeroplaneMap.remove(aeroplane);
        apronArray[offset] = null;
        return null;
    }



}
