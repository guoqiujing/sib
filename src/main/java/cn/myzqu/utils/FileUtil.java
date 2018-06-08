package cn.myzqu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 保存文件到服务器
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(MultipartFile file,HttpServletRequest request) throws Exception{
		
		String result = "";
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/upload/");
			//获取上传原文件名
			String fileName = file.getOriginalFilename();
			//获取原文件的后缀
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//生成随机文件名称
			String newFileName = KeyUtil.getUUID() + suffix;
			File filepath = new File(path, newFileName);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + newFileName));
			result = path + File.separator + newFileName;
			logger.info("上传文件成功:"+ result);
		} else {
			logger.info("上传文件失败");
		}
		return result;	
	}

	public static String saveFile(String path){
		return null;
	}
}
