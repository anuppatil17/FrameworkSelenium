package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;

public class CleaningActivity {
	static String sResultFolders;
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	public static void ResultCleaning() {
		
		

		System.out.println("Result Cleaning Activity has been Started!!!!");
		String sProjectpath = System.getProperty("user.dir");
		String sResFolder = sProjectpath + "\\results";
		try {
			sResultFolders = getFolders(sResFolder);
			String[] aAllResFolder = sResultFolders.split("\\, ");

			for (int i = 0; i <= ((aAllResFolder.length) - 1); i++) {
				String sParFolder = sResFolder + "\\" + aAllResFolder[i];
				String sDeviceParentFolder = getFolders(sParFolder);
				String[] aResultFolder = sDeviceParentFolder.split("\\, ");

				for (int j = 0; j <= aResultFolder.length - 1; j++) {
					String sActResultFolder = sParFolder + "\\" + aResultFolder[j];
					String sScreenShot = getFolders(sActResultFolder);
					if (false == isSummaryFile(sActResultFolder)) {
						FileUtils.deleteDirectory(new File(sActResultFolder));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Result Cleaning Activity has been Done!!!!");

	}

	public static String getFolders1(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		String sAllResFolder = (Arrays.toString(directories));
		sAllResFolder = (((sAllResFolder.replace("[", "")).replace("]", ""))).trim();
		sAllResFolder = sAllResFolder.replace("]", "");
		sAllResFolder = sAllResFolder.trim();
		return sAllResFolder;

	}

	public static String getFolders(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		String sAllResFolder = (Arrays.toString(directories));
		sAllResFolder = (((sAllResFolder.replace("[", "")).replace("]", ""))).trim();
		sAllResFolder = sAllResFolder.replace("]", "");
		sAllResFolder = sAllResFolder.trim();
		return sAllResFolder;

	}

	public static void killDrivers() throws Exception {
		String processName = "geckodriver.exe|chromedriver.exe|IEDriverServer.exe";

		String[] aprocess = processName.split("\\|");
		for (int i = 0; i <= aprocess.length - 1; i++) {
			// System.out.print(isProcessRunning(processName));

			if (isProcessRunning(aprocess[i])) {

				killProcess(aprocess[i]);
			}

		}
	}

	public static boolean isProcessRunning(String serviceName) throws Exception {

		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {

			//System.out.println(line);
			if (line.contains(serviceName)) {
				return true;
			}
		}

		return false;

	}

	public static void killProcess(String serviceName) throws Exception {

		Runtime.getRuntime().exec(KILL + serviceName);

	}

	public static boolean isSummaryFile(String path) {
		boolean sSummaryFile = false;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				// System.out.println(file.getName());
				if (file.getName().contains("SummaryResults.html")) {
					sSummaryFile = true;
					return true;
				}
			}
		}

		return false;

	}

}
