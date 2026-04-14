package supplementary.experiments.ludemes.LudemeStateAnalysis;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashSet;
import java.util.Set;

//this class scans the singular ludeme 
public class LudemeMethodScanner {
	
		public static Set<String> findStateMethodCalls(String ludemeClassName) {
			Set<String> allMethods = new HashSet<>();
			String currentClass = ludemeClassName;
			while(currentClass !=null &&
					!currentClass.equals("java/lang/Object")) {
				allMethods.addAll(scanSingleClass(currentClass));
				currentClass = getSuperClassName(currentClass);
			}
			
			return allMethods;
			
		}
	
		private static String getSuperClassName(String currentClass) {
			try {
				ClassReader reader = new ClassReader(currentClass);
				ClassNode classNode = new ClassNode();
				reader.accept(classNode, 0);
//				return classNode.getClass().getSuperclass().descriptorString();
				return classNode.superName;
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		private static Set<String> scanSingleClass(String ludemeClassName){
			Set<String> calledStateMethods = new HashSet<>();
			try {
				ClassReader reader = new ClassReader(ludemeClassName);
				ClassNode classNode = new ClassNode();
				reader.accept(classNode, 0);
				
				for(MethodNode method : classNode.methods) {
					for(AbstractInsnNode instruction: method.instructions) {
						if(instruction.getType()==AbstractInsnNode.METHOD_INSN) {
							MethodInsnNode methodNode = (MethodInsnNode) instruction;
							if(methodNode.owner.equals("other/state/State")) {
								calledStateMethods.add(methodNode.name);
							}
						}
					}
				}
			}catch (Exception e) {
				System.err.println("problem accessing the ludeme: "+ ludemeClassName);
				e.printStackTrace();
			}
			return calledStateMethods;
		}
		
		
		public static void main(String[] args) {
//			String targetLudeme = "game/rules/play/moves/nonDecision/effect/Add";
			String targetLudeme = "game/rules/end/Result";

			System.out.println("The ludeme being disected is the: "+ targetLudeme );
			Set<String> stateMethodUsed = findStateMethodCalls(targetLudeme);
			for(String method : stateMethodUsed) {
	            System.out.println("-> " + method);
	        }
			System.out.println("Finished ");

		}
		
}
