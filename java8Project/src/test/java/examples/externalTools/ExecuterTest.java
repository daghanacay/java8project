package examples.externalTools;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class ExecuterTest {
  final String jsScript = "function f() {return 1;};print( f() + 1 );";

  @Test
  public void testJavaScriptEngineCommand() throws IOException {
    new Executer().runCommand("jjs " + jsScript);
  }

  @Test
  public void testJavaScriptEngine() throws ScriptException {
    final ScriptEngineManager manager = new ScriptEngineManager();
    final ScriptEngine engine = manager.getEngineByName("JavaScript");

    System.out.println(engine.getClass().getName());
    System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
  }

  @Test
  public void testDependency() throws IOException {
    final String result = Executer.fromStream(new Executer().runCommand("jdeps rt.jar"));
    System.out.println(result);
  }
}
