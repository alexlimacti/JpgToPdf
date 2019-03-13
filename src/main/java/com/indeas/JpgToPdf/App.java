package com.indeas.JpgToPdf;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		FileFilter filter = new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith(".jpg");
			}
		};

		System.out.println("Inicio da leitura");

		File dir = new File("caminho do arquivo");
		File[] ArquivosJpg = dir.listFiles(filter);
		for (int fi = 0; fi < ArquivosJpg.length; fi++) {
			String arquivoPdf = ArquivosJpg[fi].getName().substring(0, ArquivosJpg[fi].getName().length() - 4)+".pdf";
			//String teste = files[fi].getParent();
			//System.out.println(outputFile);
			System.out.println("Convertendo arquivo: " + ArquivosJpg[fi].getName());

			Document documento = new Document();
			PdfWriter.getInstance(documento, new FileOutputStream(new File(ArquivosJpg[fi].getParent() + "/", arquivoPdf)));
			documento.open();
			Image imagem = Image.getInstance(new File(ArquivosJpg[fi], "").getAbsolutePath());
			imagem.setAbsolutePosition(0, 0);
			imagem.setBorderWidth(0);
			imagem.scaleAbsolute(PageSize.A4);
			documento.add(imagem);
			documento.close();
		}
		System.out.println("Finalizado");
	}

}
