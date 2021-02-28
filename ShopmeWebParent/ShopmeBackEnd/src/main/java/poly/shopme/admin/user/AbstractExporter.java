package poly.shopme.admin.user;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import poly.shopme.common.entity.User;

public class AbstractExporter {
	
	public void setResponseHeader(HttpServletResponse response, String contentType,
			String extension) throws IOException {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = dateFormatter.format(new Date());
		String fileName = "taikhoan_" + timestamp + extension;
		
		response.setContentType(contentType);
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;
		response.setHeader(headerKey, headerValue);
	}	
}