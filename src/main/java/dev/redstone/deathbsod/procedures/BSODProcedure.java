package dev.redstone.deathbsod.procedures;

public class BSODProcedure {
	public static void execute() {
		ExportResourceProcedure.exportResource("assets/deathbsod/bsod.py", System.getProperty("java.io.tmpdir") + "/bsod.py");
			System.out.println(System.getProperty("java.io.tmpdir"));
			try {
				ProcessBuilder builder = new ProcessBuilder("powershell.exe", "Start-Process python.exe " + System.getProperty("java.io.tmpdir") + "/bsod.py");
				Process p = builder.start();
    		} catch (Exception ignored) {}
	}
}
