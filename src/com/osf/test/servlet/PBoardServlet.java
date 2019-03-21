package com.osf.test.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.osf.test.service.PBoardService;
import com.osf.test.service.impl.PBoardServiceImpl;

public class PBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String savePath = "D:\\study\\workspace\\osf-jsp\\WebContent\\upload";
	private PBoardService pbs = new PBoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace("/pboard/", "");
		if ("list".equals(uri)) {
			request.setAttribute("pBoardList", pbs.selectPBoardList());
			RequestDispatcher rd = request.getRequestDispatcher("/views/photo-board/list.jsp");
			rd.forward(request, response);
			return;
		} else {
			try {
				int pbNum = Integer.parseInt(uri);
				request.setAttribute("pBoard", pbs.selectPBoard(pbNum));
				RequestDispatcher rd = request.getRequestDispatcher("/views/photo-board/view.jsp");
				rd.forward(request, response);
				return;
				
//				System.out.println(pbs.selectPBoard(pbNum));
			
			} catch (NumberFormatException e) {
				throw new ServletException("상세조회는 번호조회만 가능합니다.");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace("/pboard/", "");
		if ("insert".equals(uri)) {
			DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
			// 위에거는 톰캣에있는 업로드를 쓰는게아니라 common업로드를 쓰는것이다.
			String tmpPath = System.getProperty("java.io.tmpdir");
			File tmpFile = new File(tmpPath);
			dfiFactory.setRepository(tmpFile);
			// 아래의 사이즈를 넘기시작하면 위에 다가 저장
//			dfiFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));	위 3줄을 한줄로 쓴것.
			dfiFactory.setSizeThreshold(10 * 1024 * 1024);

			ServletFileUpload sfu = new ServletFileUpload(dfiFactory);
			// 위에거는 톰캣에있는 업로드를 쓰는게아니라 common업로드를 쓰는것이다.

			sfu.setSizeMax(20 * 1024 * 1024);
			// 총 파일 사이즈
			sfu.setFileSizeMax(20 * 1024 * 1024);
			// 하나당 파일사이즈
			try {
				List<FileItem> fileList = sfu.parseRequest(request);
				Map<String, String> pBoard = new HashMap<>();
				for (int i = 0; i < fileList.size(); i++) {
					FileItem fi = fileList.get(i);
					if (fi.isFormField()) {
						pBoard.put(fi.getFieldName(), fi.getString("utf-8"));

					} else {
						String rFileName = fi.getName();
						String extName = rFileName.substring(rFileName.lastIndexOf(".") + 1);
						String fileName = System.currentTimeMillis() + "";
						File saveFile = new File(savePath + "\\" + fileName + "." + extName);
						pBoard.put("pb_real_path", rFileName);
						pBoard.put("pb_file_path", "/upload/" + fileName + "." + extName);

						fi.write(saveFile);
					}
//					System.out.println("name : " + fileList.get(i).getFieldName());
//					System.out.println("value : " + fileList.get(i).getString("utf-8"));
//					System.out.println(fileList.get(i).isFormField());
				}
				if (pbs.insertPBoard(pBoard) == 1) {
					request.setAttribute("msg", "집중");
					request.setAttribute("url", "/views/photo-board/insert.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("/views/result.jsp");
					rd.forward(request, response);
					return;
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if ("upeate".equals(uri)) {

		} else if ("delete".equals(uri)) {

		} else {

		}

	}

	public static void main(String[] args) {

//		for (int i = 0; i < 100000; i++) {
//			if (i % 1000 == 0) {
//				System.out.println(System.currentTimeMillis());
//			}
//		}

	}

}
