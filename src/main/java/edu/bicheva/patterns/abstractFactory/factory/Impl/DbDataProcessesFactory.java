package edu.bicheva.patterns.abstractFactory.factory.Impl;

import edu.bicheva.patterns.abstractFactory.factory.ProocessesFactory;
import edu.bicheva.patterns.abstractFactory.processes.Impl.DbDataIngestion;
import edu.bicheva.patterns.abstractFactory.processes.Impl.DbDataVerification;
import edu.bicheva.patterns.abstractFactory.processes.IngestionProcess;
import edu.bicheva.patterns.abstractFactory.processes.VerificationProcess;

/**
 * @author Yulia Bycheva
 **/
public class DbDataProcessesFactory implements ProocessesFactory {
    @Override
    public VerificationProcess createVerificationProcess() {
        return new DbDataVerification();
    }

    @Override
    public IngestionProcess createIngestionProcess() {
        return new DbDataIngestion();
    }
}
