/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

//https://hashblogeando.wordpress.com/2013/09/07/agregar-imagenes-a-documentos-pdf-con-itext/

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;



public class GenerarReporte {

    String fechaInicio;
    String fechaFin;
    int paramLote,paramPersEncargada,paramFecha,paramCosto;
    String organizar;

    public GenerarReporte(String fechaInicio, String fechaFin, int paramLote, int paramPersEncargada, int paramFecha, int paramCosto, String organizar) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.paramLote = paramLote;
        this.paramPersEncargada = paramPersEncargada;
        this.paramFecha = paramFecha;
        this.paramCosto = paramCosto;
        this.organizar = organizar;
    }

    public GenerarReporte() {
        this.fechaInicio = "";
        this.fechaFin = "";
        this.paramLote = 0;
        this.paramPersEncargada = 0;
        this.paramFecha = 0;
        this.paramCosto = 0;
        this.organizar = "";
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getParamLote() {
        return paramLote;
    }

    public void setParamLote(int paramLote) {
        this.paramLote = paramLote;
    }

    public int getParamPersEncargada() {
        return paramPersEncargada;
    }

    public void setParamPersEncargada(int paramPersEncargada) {
        this.paramPersEncargada = paramPersEncargada;
    }

    public int getParamFecha() {
        return paramFecha;
    }

    public void setParamFecha(int paramFecha) {
        this.paramFecha = paramFecha;
    }

    public int getParamCosto() {
        return paramCosto;
    }

    public void setParamCosto(int paramCosto) {
        this.paramCosto = paramCosto;
    }

    public String getOrganizar() {
        return organizar;
    }

    public void setOrganizar(String organizar) {
        this.organizar = organizar;
    }
    
    
    /*

    private static String FILE = "C:/pdf/FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
    
    

    public static void main(String[] args) {
            try {
                    Document document = new Document(PageSize.LETTER , 30, 30, 30, 30);
                    PdfWriter.getInstance(document, new FileOutputStream(FILE));
                    document.open();
                    //addMetaData(document);
                    String fechai = "enero";
                    String fechaf = "marzo";
                    addTitlePage(document,fechai, fechaf);
                    addContent(document);
                    document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    /*
    private static void addMetaData(Document document) {
            document.addTitle("My first PDF");
            document.addSubject("Using iText");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Lars Vogel");
            document.addCreator("Lars Vogel");
    }
    
    
    
    

    private static void addTitlePage(Document document, String fechaInicioo, String fechaFinn) throws DocumentException, IOException {
        //Paragraph preface = new Paragraph();
        // We add one empty line
        //addEmptyLine(preface, 1);
        // Lets write a big header
        //imagen.setAlignment(Element.ALIGN_LEFT);
        Image imagen = Image.getInstance("logo.png");
        imagen.setAbsolutePosition(0f, 650f);
        document.add(imagen);
        Paragraph parrafo1 = new Paragraph("REPORTE");
        parrafo1.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(parrafo1, 1);
        document.add(parrafo1);
        
               
        Paragraph parrafo3 = new Paragraph( "Este documento describe las actividades realizadas entre  ", smallBold);
        parrafo3.setAlignment(Element.ALIGN_CENTER);
        //addEmptyLine(parrafo3, 1);
        document.add(parrafo3);    
                
        Paragraph parrafo4 = new Paragraph("" + fechaInicioo + " y " + fechaFinn, smallBold);
        parrafo4.setAlignment(Element.ALIGN_CENTER);
        //addEmptyLine(parrafo4, 1);
        document.add(parrafo4);
        
        Paragraph parrafo2 = new Paragraph("Este reporte fue creado por: " + System.getProperty("user.name") + ", " + new Date(), smallBold);
        parrafo2.setAlignment(Element.ALIGN_CENTER);
        //addEmptyLine(parrafo2, 1);
        document.add(parrafo2);
        
        //preface = new Paragraph("REPORTE", catFont);
        //preface.setAlignment(Element.ALIGN_CENTER);
        //addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        //preface.add(new Paragraph("Este reporte fue creado por: " + System.getProperty("user.name") + ", " + new Date(), smallBold));
        //preface.setAlignment(Element.ALIGN_CENTER);
        //addEmptyLine(preface, 3);
        //document.newPage();
    }
    
    private static void addContent(Document document) throws DocumentException {
            Anchor anchor = new Anchor("First Chapter", catFont);
            anchor.setName("First Chapter");

            // Second parameter is the number of the chapter
            Chapter catPart = new Chapter(new Paragraph(anchor), 1);

            Paragraph subPara = new Paragraph("Subcategory 1", subFont);
            Section subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("Hello"));

            subPara = new Paragraph("Subcategory 2", subFont);
            subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("Paragraph 1"));
            subCatPart.add(new Paragraph("Paragraph 2"));
            subCatPart.add(new Paragraph("Paragraph 3"));

            // add a list
            createList(subCatPart);
            Paragraph paragraph = new Paragraph();
            addEmptyLine(paragraph, 5);
            subCatPart.add(paragraph);

            // add a table
            createTable(subCatPart);

            // now add all this to the document
            document.add(catPart);

            // Next section
            anchor = new Anchor("Second Chapter", catFont);
            anchor.setName("Second Chapter");

            // Second parameter is the number of the chapter
            catPart = new Chapter(new Paragraph(anchor), 1);

            subPara = new Paragraph("Subcategory", subFont);
            subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("This is a very important message"));

            // now add all this to the document
            document.add(catPart);

    }

    private static void createTable(Section subCatPart)
                    throws BadElementException {
            PdfPTable table = new PdfPTable(3);

            // t.setBorderColor(BaseColor.GRAY);
            // t.setPadding(4);
            // t.setSpacing(4);
            // t.setBorderWidth(1);

            PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Table Header 2"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Table Header 3"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            table.addCell("1.0");
            table.addCell("1.1");
            table.addCell("1.2");
            table.addCell("2.1");
            table.addCell("2.2");
            table.addCell("2.3");

            subCatPart.add(table);

    }

    private static void createList(Section subCatPart) {
            List list = new List(true, false, 10);
            list.add(new ListItem("First point"));
            list.add(new ListItem("Second point"));
            list.add(new ListItem("Third point"));
            subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
            for (int i = 0; i < number; i++) {
                    paragraph.add(new Paragraph(" "));
            }
    }
    */
} //Fin Clase Generar Reporte

/*
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarReporte {
        private static String FILE = "PositionPdf.pdf";

        public static void main(String[] args) {
                try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        // Left
                        Paragraph paragraph = new Paragraph("This is right aligned text");
                        paragraph.setAlignment(Element.ALIGN_RIGHT);
                        document.add(paragraph);
                        // Centered
                        paragraph = new Paragraph("This is centered text");
                        paragraph.setAlignment(Element.ALIGN_CENTER);
                        document.add(paragraph);
                        // Left
                        paragraph = new Paragraph("This is left aligned text");
                        paragraph.setAlignment(Element.ALIGN_LEFT);
                        document.add(paragraph);
                        // Left with indentation
                        paragraph = new Paragraph(
                                        "This is left aligned text with indentation");
                        paragraph.setAlignment(Element.ALIGN_LEFT);
                        paragraph.setIndentationLeft(50);
                        document.add(paragraph);

                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

}
*/