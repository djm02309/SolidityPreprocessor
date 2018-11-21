package kr.ac.cnu.plas;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class testMain {
	 public static void main( String[] args) throws Exception 
	    {
		 	SolidityLexer lexer = new SolidityLexer(new ANTLRFileStream("test"));

	        CommonTokenStream tokens = new CommonTokenStream(lexer);

	        SolidityParser parser = new SolidityParser(tokens);
	        ParseTree tree = parser.sourceUnit(); 
	        
	        new SolidityPrintVisitor().visit(tree);
	    }
}
