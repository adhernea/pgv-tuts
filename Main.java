
import net.salesianos.launcher.ProcessLauncher;

public class Main {
  public static void main(String[] args) {
    Process firstProcess = ProcessLauncher.initMessagePrinter("Mensaje a mostrar por consola", "MessPrintOut.txt");
    try {
      firstProcess.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ProcessLauncher.initMessagePrinter("Chacho, que fue?", "MessPrintOut.txt");
  }

  public static void launchWireshark() {
    String route = "C:\\Program Files\\Wireshark\\Wireshark.exe";
    ProcessLauncher.init(route);
    Process wiresharkProcess = ProcessLauncher.init(route);
    System.out.println(wiresharkProcess.pid());
    System.out.println(wiresharkProcess.info());
    wiresharkProcess.destroy();
  }
}
