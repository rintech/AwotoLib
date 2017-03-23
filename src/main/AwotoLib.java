package main;
/*
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
	
	
	}*/
	
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
	
