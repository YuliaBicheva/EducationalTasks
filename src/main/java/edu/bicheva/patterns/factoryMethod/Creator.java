package edu.bicheva.patterns.factoryMethod;

/**
 * @author Yulia Bycheva
 **/
public class Creator {

    public static final String VERIFICATION_PARAM = "verification";
    public static final String INGESTION_PARAM = "ingestion";

    public static Process createProcess(String param) throws Exception {
        switch (param) {
            case VERIFICATION_PARAM:
                return new VerificationProcess();
            case INGESTION_PARAM:
                return new IngestionProcess();
            default:
                throw new Exception("Please, specify process type parameter!");
        }
    }
}
