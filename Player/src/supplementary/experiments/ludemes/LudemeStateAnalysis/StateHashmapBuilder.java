package supplementary.experiments.ludemes.LudemeStateAnalysis;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.Map;

//this class does a tree search of what variables does a method need.
// returns a method name -> field name, descryptor
public class StateHashmapBuilder {
	
    // Upgraded: Method Name -> Map of <Field Name, Field Descriptor>
	public static Map<String, Map<String, String>> buildMethodToFieldMap(String classInternalName) {
		Map<String, Map<String, String>> dictionary = new HashMap<>();
		
		try {
			ClassReader reader = new ClassReader(classInternalName);
			ClassNode classNode = new ClassNode();
			
			reader.accept(classNode, 0);
			
			for (MethodNode method : classNode.methods) {
				// This replaces your Set. Now we store Name AND Type.
				Map<String, String> touchedFields = new HashMap<>();
				
				for (AbstractInsnNode instruction : method.instructions) {
					if (instruction.getType() == AbstractInsnNode.FIELD_INSN) {
						FieldInsnNode fieldNode = (FieldInsnNode) instruction;
						
						// Checking if reading or setting, and if it belongs to this class
						if ((fieldNode.getOpcode() == Opcodes.GETFIELD ||
							 fieldNode.getOpcode() == Opcodes.PUTFIELD) &&
							fieldNode.owner.equals(classNode.name)) {
							
							// Here is the magic. We grab the name AND the descriptor (.desc)
							touchedFields.put(fieldNode.name, fieldNode.desc);
						}
					}
				}
				
				if (!touchedFields.isEmpty()) {
					dictionary.put(method.name, touchedFields);
				}
			}
		
		} catch (Exception e) {
			System.err.println("Bytecode reading has failed. Standard.");
			e.printStackTrace();
		}
		return dictionary;
	}

	public static void main(String[] args) {
		String targetClass = "other/state/State";
		Map<String, Map<String, String>> dictionary = buildMethodToFieldMap(targetClass);
		
		System.out.println("--- NEW TYPE-AWARE DICTIONARY ---");
		dictionary.forEach((method, fields) -> {
			System.out.println("Method [" + method + "] requires:");
			fields.forEach((fieldName, fieldDesc) -> {
				System.out.println("    -> Variable: " + fieldName + " | JVM Type: " + fieldDesc);
			});
		});
	}
}