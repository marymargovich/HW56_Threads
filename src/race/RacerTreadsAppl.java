package race;

import java.util.*;

public class RacerTreadsAppl{
    public static void main(String[] args) throws InterruptedException {

        int numberOfRacers = 5;
        int distance = 50;
        race(numberOfRacers, distance);
    }

    private static void race(int numberOfRacers, int distance) throws InterruptedException {
        Racer[] racers = new Racer[numberOfRacers];
        for (int i = 0; i < numberOfRacers; i++) {
            racers[i] = new Racer(distance, " racer "+ (i+1));
            racers[i].start();
        }
        for (Racer r : racers) {
            r.join();
        }

        //compare(r1.getRaceTime(), r2.getRaceTime());
        List<Racer> finishedRacers = Arrays.stream(racers)
                .sorted(Comparator.comparing(Racer::getRaceTime))
                .toList();

        System.out.println("place\tthread-number\ttime(ms)");
        System.out.println();
        for (int i = 0; i < finishedRacers.size(); i++) {
            Racer racer = finishedRacers.get(i);
            System.out.println((i + 1) + "\t    " + racer.getName() + "\t     " + racer.getRaceTime());
        }








    }


}
