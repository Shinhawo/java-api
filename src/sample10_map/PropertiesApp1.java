package sample10_map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp1 {
	public static void main(String[] args) throws IOException{
		
		/*
		 * Properties
		 *  - 프로퍼티 설정정보를 표현하는 객체다.
		 *  - .properties파일 혹은 
		 */
		
		// .properties 파일을 읽어서 설정정보를 로드하는 객체다.
		Properties prop = new Properties();
		
		// sample.properties파일을 읽어서 설정정보를 로딩한다.
//		prop.load(new FileInputStream("src/sample10_map/sample.properties"));
		prop.loadFromXML(new FileInputStream("src/sample10_map/sample.xml"));
		System.out.println(prop);
		
		// 로딩된 설정정보 조회하기
		String saveDirectory = prop.getProperty("file.upload.save.directory");
		System.out.println("첨부파일 저장경로 -> " +saveDirectory);
		
		long maxUploadFileSize = Long.parseLong(prop.getProperty("file.upload.maxuploadsize"));
		System.out.println("첨부파일 최대크기 -> "+ maxUploadFileSize);
		
		String encoding = prop.getProperty("file.upload.encoding");
		System.out.println("인코딩 방식 -> "+encoding);
	}
}