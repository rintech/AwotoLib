package main;

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
	
	public void Question(String Message, String Title, String correct) {
		JFrame frame = new JFrame();
		int answer = JOptionPane.showConfirmDialog(frame, Title, Message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (answer == JOptionPane.YES_OPTION){
			correct = "yes";
		}
		if (answer == JOptionPane.NO_OPTION) {
			correct = "no";
		}
	}
	public void TxtfileWrite(String writtentext, String correct) {
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showOpenDialog(this);
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
									Dialog("書き込みが完了しました"); 
								}else{
									Dialog("書き込みを中止しました");
								}
						}else{
							file.createNewFile();
							FileWriter filewriter = new FileWriter(file);
							filewriter.write(writtentext);
							filewriter.close();
							Dialog("書き込みが完了しました"); 
						}
						}catch(IOException e){
						Dialog("エラー:" + e);
					}
					
			}else if (selected == JFileChooser.CANCEL_OPTION){
				Dialog("キャンセルされました");
			}else if (selected == JFileChooser.ERROR_OPTION){
				Dialog("エラー又は取消しがありました");
			}
	}
	public Dialog(String text) {
		JLabel frame = new JLabel("frame");
		JOptionPane.showMessageDialog(frame, text);
	}
	}
