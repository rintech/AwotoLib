package main;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Dialog {
	public Dialog(String text) {
		JLabel frame = new JLabel("frame");
		JOptionPane.showMessageDialog(frame, text);
	}

	public void Clipboard(String select) { // 構文コピーメソッド
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(select);
		clipboard.setContents(selection, selection);
	}
	public void BrowserOpen(String URL) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(URL);
			desktop.browse(uri);
		}
		catch (IOException String) {
		} catch (URISyntaxException e) {
		}
	}
}