package challange.expedition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Expedition {

    public static void main(String[] args)  {

        String inputFile="expedition.txt";
        Scanner sc= new Scanner(Expedition.class.getResourceAsStream(inputFile));

        int energy=0;
        LinkedList<Integer> energies=new LinkedList<>();
        while(sc.hasNext()){
            String data=sc.nextLine();
            if(!data.isEmpty()){
                energy=energy+Integer.parseInt(data);
            }else {
                energies.add(energy);
                energy=0;
            }

        }

        energies.sort(Comparator.comparing(Integer::intValue).reversed());

        System.out.println("highest: "+energies.getFirst());
        System.out.println("top 3: "+(energies.getFirst()+energies.get(1)+energies.get(2)));

    }

}
