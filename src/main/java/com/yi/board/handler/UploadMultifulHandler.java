package com.yi.board.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.yi.board.mvc.CommandHandler;

public class UploadMultifulHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uploadPath = req.getRealPath("upload");
		File dir = new File(uploadPath);
		if(dir.exists()==false){
			dir.mkdirs();
		}
		
		int uploadSize = 10*1024*1024;//10M
		MultipartParser parser = new MultipartParser(req, uploadSize,true,true, "utf-8");
		
		Part part = null;
		ArrayList<String> arrFile = new ArrayList<>();
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		while((part = parser.readNextPart())!=null){
			
			if(part.isParam()){
				String name = part.getName();
				ParamPart paramPart = (ParamPart) part;
				String value = paramPart.getStringValue();
				req.setAttribute(name, value);
			}else if(part.isFile()){
				FilePart filePart = (FilePart) part;
				String fileName = filePart.getFileName();
				if(fileName != null){
					filePart.setRenamePolicy(policy);//파일rename정책 등록
					long size = filePart.writeTo(dir);//실제 upload가 되는 부분
					fileName = filePart.getFileName();//
					arrFile.add(fileName);
				}
			}
		}
		
		req.setAttribute("fileList", arrFile);
		
		return "uploadSuccess2.jsp";
	}

}

















