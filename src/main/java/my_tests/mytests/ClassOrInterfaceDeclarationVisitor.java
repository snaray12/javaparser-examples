package my_tests.mytests;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;

public class ClassOrInterfaceDeclarationVisitor extends GenericVisitorAdapter<Object[], Void> {

	public String className;
	public Class thisClass;
	
	@Override
	public Object[] visit(ClassOrInterfaceDeclaration cid, Void arg) {
		Object[] obj = new Object[2];
		System.out.println("class or interface declaration visitor");
		className = cid.getName().getIdentifier();
		thisClass = cid.getClass();
		obj[0] = className;
		obj[1] = thisClass;
		return obj;
	}
}
