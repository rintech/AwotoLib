package main;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Dialog {
	
	public static void Clipboard(String select) { // 構文コピーメソッド
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(select);
		clipboard.setContents(selection, selection);
	}
	public static void BrowserOpen(String URL) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(URL);
			desktop.browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void Question(String Message, String Title, String correct) {
		JFrame frame = new JFrame();
		int answer = JOptionPane.showConfirmDialog(frame, Title, Message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (answer == JOptionPane.YES_OPTION){
			correct = "yes";
		}
		if (answer == JOptionPane.NO_OPTION) {
			correct = "no";
		}
	}
	public static void TxtfileWrite(Component parent, String writtentext, String correct) {
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showOpenDialog(parent);
		if (selected == JFileChooser.APPROVE_OPTION){
				File file = filechooser.getSelectedFile();
					try{
						if (file.exists()){
							Question("同名のファイルが存在します", "同じ名前のファイル" + file + "が存在します。上書きしますか?", correct);
								if(correct == "yes") {
									file.createNewFile();
									FileWriter filewriter = new FileWriter(file);
									filewriter.write(writtentext);
									filewriter.close();
									showDialog("書き込みが完了しました"); 
								}else{
									showDialog("書き込みを中止しました");
								}
						}else{
							file.createNewFile();
							FileWriter filewriter = new FileWriter(file);
							filewriter.write(writtentext);
							filewriter.close();
							showDialog("書き込みが完了しました"); 
						}
						}catch(IOException e){
						showDialog("エラー:" + e);
					}
					
			}else if (selected == JFileChooser.CANCEL_OPTION){
				showDialog("キャンセルされました");
			}else if (selected == JFileChooser.ERROR_OPTION){
				showDialog("エラー又は取消しがありました");
			}
	}
	public static void showDialog(String text) {
		JLabel frame = new JLabel("frame");
		JOptionPane.showMessageDialog(frame, text);
	}
}
