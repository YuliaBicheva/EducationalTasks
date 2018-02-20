package edu.bicheva.patterns.factoryMethod;

import java.util.List;

import static edu.bicheva.patterns.factoryMethod.Creator.INGESTION_PARAM;
import static edu.bicheva.patterns.factoryMethod.Creator.VERIFICATION_PARAM;

/**
 * @author Yulia Bycheva
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {
        String[] paramters = {VERIFICATION_PARAM, INGESTION_PARAM, "bullshit"};
        for (String param: paramters) {
            try {
                Creator.createProcess(param).execute();
            } catch (Exception e) {
                System.out.println("Cannot execute process with paramter " + param);
            }
        }
    }
}
