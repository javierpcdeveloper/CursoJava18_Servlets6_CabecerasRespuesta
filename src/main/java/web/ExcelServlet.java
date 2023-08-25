package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Excel")
public class ExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        //tipo de respuesta al navegador
        res.setContentType("application/vnd.ms-excel");
        res.setHeader("Content-Disposition","attachment;filename=excelEjemplo.xls");
        //para un uso más profesional de Excel, usar libería poi.apache.org
        
        //indicamos que no guarde cache
        res.setHeader("Pragma","no-cache");
        res.setHeader("Cache-Control","no-store");
        res.setDateHeader("Expires",-1);
        //mandar info al navegador
        PrintWriter out=res.getWriter();
        out.println("\tValores");
        out.println("\t3");
        out.println("\t5");
        out.println("\t7");
        out.print("Total\t=SUM(B2:B4)");//debe devolver 15
        out.close();
    }
}