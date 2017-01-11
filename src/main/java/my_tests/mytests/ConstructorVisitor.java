package my_tests.mytests;

import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;

public class ConstructorVisitor extends GenericVisitorAdapter<Boolean, Void> {
	
	public ConstructorVisitor() {
		System.out.println("ConstructorVisitor constructor");
	}

	@Override
	public Boolean visit(ConstructorDeclaration n, Void arg0) {
		System.out.println("ConstructorVisitor");
		System.out.println(n.getDeclarationAsString());
		return true;
	}

}
