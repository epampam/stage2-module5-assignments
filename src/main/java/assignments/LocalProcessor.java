package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringLinkedList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName.append(processorName);
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringLinkedList = stringLinkedList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        LinkedList<String> stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        LinkedList stringLinkedList = new LinkedList<String>(stringList);
        for (int i = 0; i < stringLinkedList.size(); i++) {
            processorName.append(stringList.get(i)).append(' ');
        }
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion += informationScanner.nextLine();
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }


    }
//    public void readFullProcessorName(File file) throws FileNotFoundException {
//        try {
//            informationScanner = new Scanner(file);
//            StringBuilder versionBuilder = new StringBuilder(processorVersion);
//
//            while (informationScanner.hasNextLine()) {
//                versionBuilder.append(informationScanner.nextLine());
//            }
//
//            processorVersion = versionBuilder.toString();
//        } catch (IOException e) {
//            throw new FileNotFoundException();
//        }
//    }
}
