package edu.bicheva.patterns.abstractFactory;

import edu.bicheva.patterns.abstractFactory.factory.ProocessesFactory;
import edu.bicheva.patterns.abstractFactory.processes.IngestionProcess;
import edu.bicheva.patterns.abstractFactory.processes.VerificationProcess;

/**
 * @author Yulia Bycheva
 **/
public class ProcessRunner {

    private VerificationProcess verificationProcess;
    private IngestionProcess ingestionProcess;

    public ProcessRunner(ProocessesFactory abstractFactory) {
        verificationProcess = abstractFactory.createVerificationProcess();
        ingestionProcess = abstractFactory.createIngestionProcess();
    }

    void execute() {
        ingestionProcess.interact(verificationProcess);
    }
}
