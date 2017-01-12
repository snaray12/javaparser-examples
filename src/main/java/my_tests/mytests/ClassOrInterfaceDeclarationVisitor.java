package my_tests.mytests;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;

public class ClassOrInterfaceDeclarationVisitor extends GenericVisitorAdapter<Object[], Void> {

	public String className;
	public Class thisClass;
	
	@Override
	public Object[] visit(ClassOrInterfaceDeclaration cid, Void arg) {
		System.out.println("class or interface declaration visitor");
		className = cid.getNameAsString();
		thisClass = cid.getClass();
		// You could (ab)use JavaParser's Pair class here.
		return new Object[]{className, thisClass};
	}
}
