package net.salesianos.launcher;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {

  private static String FILE_OUTPUT_ROUTE = "./net/salesianos/outputs/";
  private static String PROCESSES_ROUTE = "./net/salesianos/processes/";

  public static Process initMessagePrinter(String message, String outFileName) {
    Process newJavaProcess = null;
    ProcessBuilder processBuilder = new ProcessBuilder(
      "java", PROCESSES_ROUTE + "MessagePrinter.java", message
    );
    try {
      processBuilder.redirectOutput(new File(FILE_OUTPUT_ROUTE + outFileName));
      processBuilder.redirectError(new File(FILE_OUTPUT_ROUTE + "MessagePrinterError.txt"));
      newJavaProcess = processBuilder.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return newJavaProcess;
  }

  public static Process init(String route) {
    ProcessBuilder processBuilder = new ProcessBuilder(route);
    try {
      return processBuilder.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
