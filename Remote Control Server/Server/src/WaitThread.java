
import java.io.IOException;

import javax.microedition.io.*;
import javax.bluetooth.*;

public class WaitThread extends Thread {

	Boolean connection = false;
	ProcessConnectionThread processorThread;

	public WaitThread() {
	}

	@Override
	public void run() {
		waitForConnection();
	}

	public Boolean checkConnection() {
		return connection;
	}

	private void waitForConnection() {
		LocalDevice localdev;
		StreamConnectionNotifier notifier = null;
		StreamConnection conn = null;
		String myServiceName = "RemoteNotifier";
		UUID uuid = new UUID("0f2b61c18be240e6ab90e735818da0a7", false);
		System.out.println(uuid.toString());
		String url = "btspp://localhost:" + uuid.toString() + ";" + "name="
				+ myServiceName;
		try {
			localdev = LocalDevice.getLocalDevice();
			localdev.setDiscoverable(DiscoveryAgent.GIAC);
			notifier = (StreamConnectionNotifier) Connector.open(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		while (true) {
			try {
				Thread.sleep(100);
				if (!connection) {
					System.out.println("Waiting for the Connection");
					conn = notifier.acceptAndOpen();

					processorThread = new ProcessConnectionThread(conn);
					connection = true;
					processorThread.start();
				} else
				if (processorThread.disconnect()) {
					connection = false;
					processorThread.stop();}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
