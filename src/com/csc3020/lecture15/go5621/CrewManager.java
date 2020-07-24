package com.csc3020.lecture15.go5261;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrewManager {
    private final static String FILENAME = "D:\\CrewMemberPool.txt";

    private static CrewMember[] pool;
    static {
        try {
            FileReader oFileReader = new FileReader(FILENAME);
            BufferedReader oBufferedReader = new BufferedReader(oFileReader);
            String line = null;
            int index = 0;
            pool = new CrewMember[10];
            while((line = oBufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                FlightCrewJob job = FlightCrewJob.valueOf(parts[0]);
                pool[index] = new CrewMember(job);
                pool[index].setName(parts[1]);
                index++;
            }
        } catch (NullPointerException oException) {
            System.out.println("Error: Not Implemented Exception");

        } catch (FileNotFoundException oException) {
            System.out.println("Error: Not Implemented Exception");

        } catch (IOException oException) {
            System.out.println("Error: Not Implemented Exception");


        } catch (Exception oException) {
            System.out.println("Error: Not Implemented Exception");

        }
    }

    public static CrewMember FindAvailable(FlightCrewJob job) {
        CrewMember oCrewMember = null;
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null && pool[i].getJob() == job) {
                oCrewMember = pool[i];
                pool[i] = null;
                break;
            }
        }
    return oCrewMember;
    }

    public static CrewMember[] List() {
        return pool;
    }
}
