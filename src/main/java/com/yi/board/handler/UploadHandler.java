package com.yi.board.handler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yi.board.mvc.CommandHandler;

public class UploadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String uploadPath = req.getRealPath("upload");
		
		File dir = new File(uploadPath);
		if(dir.exists()==false){//업로드 폴더가 없을때 만들어지도록
			dir.mkdirs();
		}
		
		try {
			MultipartRequest multi = new MultipartRequest(req,
														uploadPath,//서버측 업로드
														1024*1024*10,//10M
														new DefaultFileRenamePolicy()
														);
			
			String file1 = multi.getFilesystemName("file1");//file1의 키의 파일의 이름을 받아옴
			String file2 = multi.getFilesystemName("file2");
			String desc = multi.getParameter("desc");
			
			req.setAttribute("file1", file1);
			req.setAttribute("file2", file2);
			req.setAttribute("desc", desc);
			
			return "uploadSuccess.jsp";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}
