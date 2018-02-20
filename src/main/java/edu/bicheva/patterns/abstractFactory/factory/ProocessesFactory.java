package edu.bicheva.patterns.abstractFactory.factory;

import edu.bicheva.patterns.abstractFactory.processes.IngestionProcess;
import edu.bicheva.patterns.abstractFactory.processes.VerificationProcess;

/**
 * @author Yulia Bycheva
 **/
public interface ProocessesFactory {
    VerificationProcess createVerificationProcess();
    IngestionProcess createIngestionProcess();
}
