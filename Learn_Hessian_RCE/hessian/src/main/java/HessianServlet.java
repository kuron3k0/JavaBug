import com.caucho.hessian.io.HessianInput;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import static java.lang.System.out;

public class HessianServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        OutputStream os = response.getOutputStream();
        os.write("testaaaa".getBytes());
        HessianInput hessianInput = null;
        try {
            hessianInput = new HessianInput(request.getInputStream());
            hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
