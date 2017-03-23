package main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public void Dialog(String text) {
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void Question(String Message, String Title) {
		JFrame frame = new JFrame();
		int answer = JOptionPane.showConfirmDialog(frame, Title, Message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		if (answer == JOptionPane.YES_OPTION){
			correct = "yes";
		}
		if (answer == JOptionPane.NO_OPTION) {
			correct = "no";
		}
	}
	public void TxtfileWrite(String writtentext) {
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showOpenDialog(this);
		if (selected == JFileChooser.APPROVE_OPTION){
				File file = filechooser.getSelectedFile();
					try{
						if (file.exists()){
							question("同名のファイルが存在します", "同じ名前のファイル" + file + "が存在します。上書きしますか?");
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
	}
	//public static void main(String[] args) {
/*		try {
			File file = new File("test.zip");
			zipping(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void zipping(/*File dir, *//*File zipfile) throws IOException {
		ZipOutputStream zipOutStream = new ZipOutputStream(
			new BufferedOutputStream(new FileOutputStream(zipfile)));
		{
			/* ディレクトリの作成 *//*
			ZipEntry entry = new ZipEntry("ABC/");
			entry.setMethod(ZipEntry.STORED);
			entry.setSize(0);
			entry.setCrc(0);
			zipOutStream.putNextEntry(entry);
			zipOutStream.closeEntry();
		}
		{
			ZipEntry entry = new ZipEntry("ABC/ABC.txt");
			zipOutStream.putNextEntry(entry);
			/* ファイルデータの書き込み *//*
			zipOutStream.write(
				new String("あいうえお").getBytes());
			zipOutStream.closeEntry();
		}
		{
			ZipEntry entry = new ZipEntry("ABC/DEF.txt");
			zipOutStream.putNextEntry(entry);
			zipOutStream.write(
				new String("かきくけこ").getBytes());
			zipOutStream.closeEntry();
		}
		{
			ZipEntry entry = new ZipEntry("GHI.txt");
			zipOutStream.putNextEntry(entry);
			zipOutStream.write(
				new String("さしすせそ").getBytes());
			zipOutStream.closeEntry();
		}
		zipOutStream.finish();
		zipOutStream.close();
	}*/
	//}
	
