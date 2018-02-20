package edu.bicheva.patterns.abstractFactory.factory.Impl;

import edu.bicheva.patterns.abstractFactory.factory.ProocessesFactory;
import edu.bicheva.patterns.abstractFactory.processes.Impl.FileDataIngestion;
import edu.bicheva.patterns.abstractFactory.processes.Impl.FileDataVerification;
import edu.bicheva.patterns.abstractFactory.processes.IngestionProcess;
import edu.bicheva.patterns.abstractFactory.processes.VerificationProcess;

/**
 * @author Yulia Bycheva
 **/
public class FileDataProcessesFactory implements ProocessesFactory {
    @Override
    public VerificationProcess createVerificationProcess() {
        return new FileDataVerification();
    }

    @Override
    public IngestionProcess createIngestionProcess() {
        return new FileDataIngestion();
    }
}
