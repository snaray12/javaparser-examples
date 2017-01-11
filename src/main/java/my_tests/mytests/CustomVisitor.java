package my_tests.mytests;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CustomVisitor extends VoidVisitorAdapter<Void> {

	public String className;
	public Class thisClass;
	
	@Override
	public void visit(ClassOrInterfaceDeclaration cid, Void arg) {
		System.out.println("class or interface declaration visitor");
		className = cid.getName().getIdentifier();
		thisClass = cid.getClass();
	}
}
