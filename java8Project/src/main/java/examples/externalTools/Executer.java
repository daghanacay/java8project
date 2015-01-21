package examples.externalTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Executer {
  final Runtime rt = Runtime.getRuntime();

  public InputStream runCommand(final String cmd) throws IOException {
    return rt.exec(cmd).getInputStream();
  }

  public static String fromStream(final InputStream in) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    final StringBuilder out = new StringBuilder();
    final String newLine = System.getProperty("line.separator");
    String line;
    while ((line = reader.readLine()) != null) {
      out.append(line);
      out.append(newLine);
    }
    return out.toString();
  }
}
