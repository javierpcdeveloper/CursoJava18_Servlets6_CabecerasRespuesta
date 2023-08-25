package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Hora")
public class HoraServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("refresh", "1");
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("HH:mm:ss");
        String hora=formatoFecha.format(fecha);
        PrintWriter out=res.getWriter();
        out.print("Hora:"+hora);
        out.close();
    }
}