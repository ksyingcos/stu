package org.stu.spring.boot.jodconverter.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hibernate.validator.constraints.URL;
import org.jodconverter.DocumentConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.document.DocumentFormat;
import org.jodconverter.office.OfficeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@RestController
public class ConverterController {

  @Resource
  private DocumentConverter documentConverter;

  @RequestMapping(value = "/convert", method = RequestMethod.GET)
  public void convert(@RequestParam("docUrl") @URL String docUrl,
      HttpServletResponse response) {
    PrintWriter out = null;
    CloseableHttpClient httpClient = null;
    try {
      // 根据URL后缀获取文件扩展名
      String docExtension = null;
      if (docUrl.contains(".")) {
        docExtension = docUrl.substring(docUrl.lastIndexOf(".") + 1)
            .toLowerCase();
      }
      if (null == docExtension) {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        out = response.getWriter();
        out.print("文件后缀名不能为空");
        out.flush();
      } else {
        DocumentFormat documentFormat = DefaultDocumentFormatRegistry
            .getInstance().getFormatByExtension(docExtension);
        if (null == documentFormat) {
          response.setHeader("Content-Type", "application/json;charset=UTF-8");
          response.setContentType("application/json;charset=UTF-8");
          out = response.getWriter();
          out.print("文件类型不支持");
          out.flush();
        } else {
          // 获取文件流
          httpClient = HttpClients.createDefault();
          //HttpGet httpGet = new HttpGet("http://10.86.130.16:8080/BOP/MANUAL/OIS/4321/BX11/CM01/ZZ/ZZ01/T02/2131231-123123123.doc");
          HttpGet httpGet = new HttpGet(docUrl);
          HttpResponse httpResponse = httpClient.execute(httpGet);
          InputStream inputStream = httpResponse.getEntity().getContent();
          documentConverter.convert(inputStream).as(documentFormat)
              .to(response.getOutputStream())
              .as(DefaultDocumentFormatRegistry.PDF).execute();
        }
      }
    } catch (OfficeException e) {
      throw new RuntimeException(e);
    } catch (ClientProtocolException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      // 关闭连接,释放资源
      try {
        if (null != httpClient) {
          httpClient.close();
        }
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
