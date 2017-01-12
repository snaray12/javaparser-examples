package my_tests.mytests;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class SourceFileProcessor {
	private CompilationUnit sourceCompilatinUnit;
	private String sourceFileName;
	private String packageDeclaration;
	private String className;
	private Class srcClass;

	public void getConstructorList() {
		System.out.println("Getting constructor list");
		ConstructorVisitor cv = new ConstructorVisitor();
		if(null == this.sourceCompilatinUnit) {
			System.out.println("source compilation unit is null");
		} else {
			boolean val = this.sourceCompilatinUnit.accept(cv, null);
			System.out.println(val);
		}
	}

	public Class getSourceClass() {
		if(null == srcClass) {
			Object[] cidv = visitClassOrInterfaceDeclaration();
			srcClass = (Class) cidv[1];
		}
		return srcClass;
	}

	private Object[] visitClassOrInterfaceDeclaration() {
		ClassOrInterfaceDeclarationVisitor cidv = new ClassOrInterfaceDeclarationVisitor();
		return this.sourceCompilatinUnit.accept(cidv, null);
	}

	public String getClassName() {
		if(null == className) {
			Object[] cidv = visitClassOrInterfaceDeclaration();
			className = String.valueOf(cidv[0]);
		}
		return className;
	}

	public String getPackageDeclaration() {
		if(null == packageDeclaration) {
			packageDeclaration = sourceCompilatinUnit.getPackageDeclaration().get().getNameAsString();
		}
		return packageDeclaration;
	}

	public SourceFileProcessor(String fileName) {
		this.sourceFileName = fileName;
		this.createCompilationUnit(fileName);
	}

	public SourceFileProcessor(CompilationUnit cu) {
		this.sourceCompilatinUnit = cu;
	}


	private void createCompilationUnit(String fileName) {
			this.sourceCompilatinUnit = JavaParser.parse(fileName);

	}

	public static void main(String[] args) {
		SourceFileProcessor sfp = new SourceFileProcessor("class X { X() {} }");
		System.out.println(sfp.getClassName());
		sfp.getConstructorList();
	}
}
