package edu.bicheva.patterns.abstractFactory;

import edu.bicheva.patterns.abstractFactory.factory.Impl.DbDataProcessesFactory;
import edu.bicheva.patterns.abstractFactory.factory.Impl.FileDataProcessesFactory;
import edu.bicheva.patterns.abstractFactory.factory.ProocessesFactory;

/**
 * @author Yulia Bycheva
 **/
public class AbstractFactoryTest {

    public static void main(String[] args) {

        ProocessesFactory factory1 = new FileDataProcessesFactory();
        ProcessRunner runner1 = new ProcessRunner(factory1);
        runner1.execute();

        ProocessesFactory factory2 = new DbDataProcessesFactory();
        ProcessRunner runner2 = new ProcessRunner(factory2);
        runner2.execute();
    }
}
