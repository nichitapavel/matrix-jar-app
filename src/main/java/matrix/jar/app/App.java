/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package matrix.jar.app;

import matrix.lib.*;

import java.util.Map;


public class App {
    public static void main(String[] args) {
        Map parsedArgs = Parser.parse(args);

        int size = (int) parsedArgs.get("size");
        int module = (int) parsedArgs.get("module");

        boolean print = (boolean) parsedArgs.get("print");

        TimeController timeCon = new TimeController();
        HTTPData req = new HTTPData(parsedArgs.get("http_endpoint").toString());
        req.setName(
                new HostInfo().getName()
        );
        StringBuilder message = new StringBuilder();
        message.append(
                String.format("Input data:\nMatrix size: %d\t Matrix module: %d\t Matrix print: %b\n", size, module, print)
        );

        AMatrix matrix_a = new MatrixFloat(size);
        timeCon.setName("Matrix fill A");
        timeCon.snapStart();
        req.setData(timeCon.getStart(), Operation.AS);
        req.sendData();
        matrix_a.fill(module);
        timeCon.snapFinish();
        req.setData(timeCon.getFinish(), Operation.AF);
        req.sendData();

        message.append(timeCon);

        AMatrix matrix_b = new MatrixFloat(size);
        timeCon.setName("Matrix fill B");
        timeCon.snapStart();
        req.setData(timeCon.getStart(), Operation.BS);
        req.sendData();
        matrix_b.fill(module);
        timeCon.snapFinish();
        req.setData(timeCon.getFinish(), Operation.BF);
        req.sendData();

        message.append(timeCon);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeCon.setName("Matrix compute");
        timeCon.snapStart();
        req.setData(timeCon.getStart(), Operation.XS);
        req.sendData();
        AMatrix matrix_computed = matrix_a.multiply(matrix_b);
        timeCon.snapFinish();
        req.setData(timeCon.getFinish(), Operation.XF);
        req.sendData();

        message.append(timeCon);

        System.out.println(message);

        if (print) {
            System.out.println("Matrix A");
            System.out.println(matrix_a);
            System.out.println("Matrix B");
            System.out.println(matrix_b);
            System.out.println("Computed matrix");
            System.out.println(matrix_computed);
        }
    }

}
