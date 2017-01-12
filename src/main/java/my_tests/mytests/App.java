package my_tests.mytests;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

/**
 * Hello world!
 *
 */
public class App 
{
	public App() throws IOException {
    	CompilationUnit sourceCompilatinUnit = JavaParser.parse("class X { public X() {} }");
    	CustomVisitor cidv = new CustomVisitor();
    	sourceCompilatinUnit.accept(cidv, null);
    	ConstructorVisitor cv = new ConstructorVisitor();
    	boolean val = sourceCompilatinUnit.accept(cv, null);
    	System.out.println(val);
	}
    public static void main( String[] args ) throws IOException
    {
    	new App();
    }
}
