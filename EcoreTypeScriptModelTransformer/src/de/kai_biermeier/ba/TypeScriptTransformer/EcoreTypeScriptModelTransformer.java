package de.kai_biermeier.ba.TypeScriptTransformer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class EcoreTypeScriptModelTransformer {

	public static void main(String[] args) {
		EcoreTypeScriptModelTemplate gen=new EcoreTypeScriptModelTemplate();
		File output = new File("./output" /*+ LocalDateTime.now().toString().replace(":", "_")*/);
		output.mkdir();
		gen.generate(output.getPath());
	}

}
