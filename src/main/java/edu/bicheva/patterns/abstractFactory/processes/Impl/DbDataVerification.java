package edu.bicheva.patterns.abstractFactory.processes.Impl;

import edu.bicheva.patterns.abstractFactory.processes.IngestionProcess;
import edu.bicheva.patterns.abstractFactory.processes.VerificationProcess;

/**
 * @author Yulia Bycheva
 **/
public class DbDataVerification implements VerificationProcess {
    @Override
    public void interact(IngestionProcess a) {
        System.out.println(this.getClass().getName() + " interacts with " + a.getClass().getName());
    }
}
