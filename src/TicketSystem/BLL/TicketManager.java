package TicketSystem.BLL;

import TicketSystem.BE.Event;
import TicketSystem.BE.Ticket;
import com.itextpdf.barcodes.Barcode2D;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class TicketManager {

    public  static void printTicket(Event event, Ticket ticket) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(ticket.getID()+".pdf"));
        Document document = new Document(pdf);



        document.add(new Paragraph(
                event.getName() +"\r\n"+
                        event.getDate() +"\r\n"+
                        event.getEventStart()+"\r\n"
        ));
        document.add(new Paragraph(
                "Billet ID: " + ticket.getID()+ "\r\n+"
        ));
        document.close();
        Desktop.getDesktop().open(new File(ticket.getID()+".pdf"));
    }
}
