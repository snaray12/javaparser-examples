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
	public App(String path) throws IOException {
		Path p = Paths.get(path);
    	BufferedReader reader = Files.newBufferedReader(p, StandardCharsets.UTF_8);
    	CompilationUnit sourceCompilatinUnit = JavaParser.parse(reader);
    	CustomVisitor cidv = new CustomVisitor();
    	sourceCompilatinUnit.accept(cidv, null);
    	ConstructorVisitor cv = new ConstructorVisitor();
    	boolean val = sourceCompilatinUnit.accept(cv, null);
    	System.out.println(val);
	}
    public static void main( String[] args ) throws IOException
    {
    	new App(args[0]);
    }
}
